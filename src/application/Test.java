package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test extends Application {
   protected Button btStart = new Button("Start");
   protected Button btClear = new Button("Clear");
   public static void main(String[] args) {
		launch(args);
	}
   @Override//from  w w w .  j av a 2 s . c o  m
   public void start(Stage primaryStage) {
	   StackPane root = new StackPane();  
	    ProgressBar progress = new ProgressBar();  
	    progress.setProgress(1.0f);
	    root.getChildren().add(progress);  
	    Scene scene = new Scene(root,300,200);  
	    primaryStage.setScene(scene);  
	    primaryStage.setTitle("Progress Bar Example");  
	    primaryStage.show();  
   }
}
