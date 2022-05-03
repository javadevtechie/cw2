package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test extends Application {

	private static final Integer STARTTIME = 15;
	private Timeline timeline;
	private Text timerLabel = new Text();
	private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME * 100);

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("FX Timer Binding/ProgressBar");
		Group root = new Group();
		Scene scene = new Scene(root, 300, 250);

		// Bind the timerLabel text property to the timeSeconds property
		timerLabel.textProperty().bind(timeSeconds.divide(100).asString());
		timerLabel.setFill(Color.RED);
		timerLabel.setStyle("-fx-font-size: 4em;");

		ProgressBar progressBar = new ProgressBar();
		progressBar.progressProperty().bind(timeSeconds.divide(STARTTIME * 100.0).subtract(1).multiply(-1));

	
		if (timeline != null) {
			timeline.stop();
		}
		timeSeconds.set((STARTTIME + 1) * 100);
		timeline = new Timeline();
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME + 1), new KeyValue(timeSeconds, 0)));
		timeline.playFromStart();
		Button button = new Button();
		button.setText("Start Timer");
		button.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

			}
		});

		VBox vb = new VBox(20); // gap between components is 20
		vb.setAlignment(Pos.CENTER); // center the components within VBox

		vb.setPrefWidth(scene.getWidth());
		vb.getChildren().addAll(button, timerLabel, progressBar);
		vb.setLayoutY(30);

		root.getChildren().add(vb);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}