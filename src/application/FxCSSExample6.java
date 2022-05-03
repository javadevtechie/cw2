package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxCSSExample6 extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Paint boxColor = Color.DARKOLIVEGREEN;
		double width = 150;
		double height = 150;
		VBox vbox = new VBox();
		Rectangle r = new Rectangle(width, height, boxColor);

		Text text = new Text("Test sample");
		
		text.setX(10);
		text.setY(10);
		text.setFill(Color.WHITE);

		Rectangle r1 = new Rectangle(width, height, boxColor);
		r1.
		vbox.getChildren().addAll(r, r1);
		// vbox.setPadding(new Insets(5, 5, 5, 5));
		vbox.setPadding(new Insets(2, 2, 2, 2));
		vbox.setSpacing(2);

		VBox vbox1 = new VBox();
		Rectangle r2 = new Rectangle(width, height, boxColor);

		Rectangle r3 = new Rectangle(width, height, boxColor);
		Rectangle r4 = new Rectangle(width, height, boxColor);
		vbox1.getChildren().addAll(r2, r3, r4);
		vbox1.setPadding(new Insets(2, 2, 2, 2));
		vbox1.setSpacing(2);

		VBox vbox2 = new VBox();
		Rectangle r5 = new Rectangle(width, height, boxColor);
		Rectangle r6 = new Rectangle(width, height, boxColor);
		Rectangle r7 = new Rectangle(width, 74, boxColor);
		Rectangle r14 = new Rectangle(width, 74, boxColor);
		vbox2.getChildren().addAll(r5, r6, r7, r14);
		vbox2.setPadding(new Insets(2, 2, 2, 2));
		vbox2.setSpacing(2);

		VBox vbox3 = new VBox();
		Rectangle r8 = new Rectangle(width, height, boxColor);
		Rectangle r9 = new Rectangle(width, height, boxColor);
		Rectangle r10 = new Rectangle(width, height, boxColor);
		vbox3.getChildren().addAll(r8, r9, r10);
		vbox3.setPadding(new Insets(2, 2, 2, 2));
		vbox3.setSpacing(2);

		VBox vbox4 = new VBox();
		Rectangle r11 = new Rectangle(width, height, boxColor);
		Rectangle r12 = new Rectangle(width, height, boxColor);
		Rectangle r13 = new Rectangle(width, height, boxColor);
		vbox4.getChildren().addAll(r11, r12, r13);
		vbox4.setPadding(new Insets(2, 2, 2, 2));
		vbox4.setSpacing(2);

		HBox hbox = new HBox();
		hbox.getChildren().addAll(vbox, vbox1, vbox2, vbox3, vbox4);

		Scene scene = new Scene(hbox, 770, 500);
		primaryStage.setScene(scene);
		scene.setFill(Color.BLACK);
		primaryStage.show();
	}

}