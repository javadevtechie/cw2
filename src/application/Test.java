package application;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Test extends Application {
   static Stage printDialog;
   public static void main(String[] args) {
      Application.launch(Test.class, args);
   }//from w w w.j a v a2s .  c o  m
   private static Stage createPrintDialog(Stage parent, boolean modal, Canvas node) {
      if (printDialog != null) {
         printDialog.close();
      }
      // Create a copy of the current canvas
      WritableImage wim = new WritableImage(300, 300);
      node.snapshot(null, wim);
      ImageView iv = new ImageView();
      iv.setImage(wim);
      return new PrintDialog(parent, modal, "Printing Menu", iv);
   }

   @Override
   public void start(Stage primaryStage) {

      StackPane root = new StackPane();
      Canvas canvas = new Canvas(300, 300);
      final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

      final Button printButton = new Button("Print");
      final BooleanProperty printingProperty = new SimpleBooleanProperty(false);
      printButton.setOnAction(actionEvent -> {
         printingProperty.set(true);
         if (printDialog == null) {
            printDialog = createPrintDialog(primaryStage, true, canvas);
         }
         printDialog.sizeToScene();
         printDialog.show();
      });
      printButton.setTranslateX(3);

      HBox buttonBox = new HBox();
      buttonBox.getChildren().addAll(printButton);

      initDraw(graphicsContext, canvas.getLayoutX(), canvas.getLayoutY());

      BorderPane container = new BorderPane();
      container.setTop(buttonBox);

      container.setCenter(canvas);

      root.getChildren().add(container);
      Scene scene = new Scene(root, 400, 400);
      primaryStage.setTitle("Printing from JavaFX");
      primaryStage.setScene(scene);
      primaryStage.show();
   }

   private void initDraw(GraphicsContext gc, double x, double y) {
      double canvasWidth = gc.getCanvas().getWidth();
      double canvasHeight = gc.getCanvas().getHeight();

      gc.fill();
      gc.strokeRect(x, // x of the upper left corner
            y, // y of the upper left corner
            canvasWidth, // width of the rectangle
            canvasHeight); // height of the rectangle

      gc.setFill(Color.RED);
      gc.setStroke(Color.BLUE);
      gc.setLineWidth(1);
      gc.fillOval(0, 0, 200, 200);

   }
}

class PrintDialog extends Stage {

   public PrintDialog(Stage owner, boolean modality, String title, Node printNode) {
      super();
      initOwner(owner);
      Modality m = modality ? Modality.APPLICATION_MODAL : Modality.NONE;
      initModality(m);
      setOpacity(.90);
      setTitle(title);
      Group root = new Group();
      Scene scene = new Scene(root, 450, 150, Color.WHITE);
      setScene(scene);

      GridPane gridpane = new GridPane();
      gridpane.setPadding(new Insets(5));
      gridpane.setHgap(5);
      gridpane.setVgap(5);
      Label printerLabel = new Label("Printer: ");
      gridpane.add(printerLabel, 0, 1);

      Label layoutLabel = new Label("Layout: ");
      gridpane.add(layoutLabel, 0, 2);

      final Printer selectedPrinter = Printer.getDefaultPrinter();

      ChoiceBox printerChooser = new ChoiceBox(FXCollections.observableArrayList(Printer.getAllPrinters()));
      printerChooser.getSelectionModel().selectFirst();

      gridpane.add(printerChooser, 1, 1);

      ChoiceBox layoutChooser = new ChoiceBox(FXCollections.observableArrayList("Portait", "Landscape"));
      layoutChooser.getSelectionModel().selectFirst();

      layoutChooser.getSelectionModel().selectedIndexProperty().addListener((ChangeListener) (ov, old, newval) -> {
         Number idx = (Number) newval;
         switch (idx.intValue()) {
         case 0:
            selectedPrinter.createPageLayout(Paper.A0, PageOrientation.PORTRAIT, Printer.MarginType.EQUAL);
            break;
         case 1:
            selectedPrinter.createPageLayout(Paper.A0, PageOrientation.LANDSCAPE, Printer.MarginType.EQUAL);
            break;

         default:
            selectedPrinter.createPageLayout(Paper.A0, PageOrientation.PORTRAIT, Printer.MarginType.EQUAL);
            break;
         }
      });
      gridpane.add(layoutChooser, 1, 2);
      Button printButton = new Button("Print");
      printButton.setOnAction((ActionEvent event) -> {
         print(printNode, selectedPrinter);
      });
      gridpane.add(printButton, 0, 3);

      GridPane.setHalignment(printButton, HPos.RIGHT);
      root.getChildren().add(gridpane);
   }

   public void print(final Node node, Printer printer) {
      PrinterJob job = PrinterJob.createPrinterJob();
      job.setPrinter(printer);
      if (job != null) {
         boolean success = job.printPage(node);
         if (success) {
            job.endJob();
         }
      }
   }
}