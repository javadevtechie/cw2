package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FxCSSExample7 extends Application {

	private int minutes;
	private int seconds;
	private Timeline timeline;
	private Text timer;
	private int counter;
	private Text value;

	public FxCSSExample7() {
		minutes = 19;
		seconds = 59;
	}

	@Override
	public void start(Stage stage) {

		Rectangle r1 = new Rectangle(150, 100);
		r1.setFill(Color.AQUA);
		Text text = new Text("Carl");
		text.setBoundsType(TextBoundsType.VISUAL);
		text.setFont(new Font(20));
		text.setTextAlignment(TextAlignment.LEFT);
		text.setTextOrigin(VPos.CENTER);
		text.setX(10);
		text.setY(20);

		VBox vbox = new VBox();
		Pane pane = new Pane(r1, text);
		vbox.getChildren().add(pane);
		vbox.setPadding(new Insets(2, 2, 2, 2));

		Text time = new Text("time");
		time.setBoundsType(TextBoundsType.VISUAL);
		time.setFont(new Font(20));
		time.setTextAlignment(TextAlignment.CENTER);
		time.setTextOrigin(VPos.CENTER);

		double width = r1.getWidth();
		double width2 = time.getLayoutBounds().getWidth();
		time.setX((width - width2) / 2);
		time.setY(10);

		Text time1 = new Text("min:sec");
		time1.setBoundsType(TextBoundsType.VISUAL);
		time1.setFont(new Font(20));
		time1.setTextAlignment(TextAlignment.CENTER);
		time1.setTextOrigin(VPos.CENTER);

		double widthTime = r1.getWidth();
		double widthTime2 = time1.getLayoutBounds().getWidth();
		time1.setX((widthTime - widthTime2) / 2);
		time1.setY(28);

		timer = new Text();
		timer.setBoundsType(TextBoundsType.VISUAL);
		timer.setFont(new Font(40));
		timer.setTextAlignment(TextAlignment.CENTER);
		timer.setTextOrigin(VPos.CENTER);

		double widthtimer = r1.getWidth();
		double widthtimer2 = time1.getLayoutBounds().getWidth();
		timer.setX(((widthtimer - widthtimer2) / 2) - 12);
		timer.setY(60);

		KeyFrame kf = new KeyFrame(Duration.millis(1000), e -> {
			seconds--;
			setTime();
		});
		timeline = new Timeline(kf);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

		// Rectangle r2 = new Rectangle(150, 100);

		VBox vbox1 = new VBox();
		Rectangle r2 = new Rectangle(150, 150);
		r2.setFill(Color.AQUA);
		vbox1.setPadding(new Insets(2, 2, 10, 2));
		vbox1.setSpacing(2);
		Pane pane1 = new Pane(r2, time, time1, timer);

		vbox1.getChildren().add(pane1);
		Rectangle r3 = new Rectangle(150, 150);
		r3.setFill(Color.AQUA);

		Pane pane2 = returnRect("heart rate", 20, "beats/min", 45, "93", 80);
		Pane pane3 = effortLevel("effort level", 40);

		vbox1.getChildren().addAll(pane2, pane3);
		HBox hbox = new HBox();
		hbox.getChildren().addAll(vbox, vbox1);
		stage.setScene(new Scene(hbox, 700, 700, Color.BLACK));

		stage.show();
	}

	public Pane returnRect(String s, int setY, String sub, int setsubY, String val, int valsetY) {
		Rectangle rect = new Rectangle(150, 150);
		rect.setFill(Color.AQUA);

		Text text = new Text(s);
		text.setBoundsType(TextBoundsType.VISUAL);
		text.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
		text.setTextAlignment(TextAlignment.CENTER);
		text.setTextOrigin(VPos.CENTER);

		double widthheartRate = rect.getWidth();
		double width2heartRate = text.getLayoutBounds().getWidth();
		text.setX((widthheartRate - width2heartRate) / 2);
		text.setY(setY);

		Text subText = new Text(sub);
		subText.setBoundsType(TextBoundsType.VISUAL);
		subText.setFont(new Font(20));
		subText.setTextAlignment(TextAlignment.CENTER);
		subText.setTextOrigin(VPos.CENTER);

		double widthsubText = rect.getWidth();
		double width2subText = subText.getLayoutBounds().getWidth();
		subText.setX((widthsubText - width2subText) / 2);
		subText.setY(setsubY);

		Text value = new Text(val);
		value.setBoundsType(TextBoundsType.VISUAL);
		value.setFont(new Font(40));
		value.setTextAlignment(TextAlignment.CENTER);
		value.setTextOrigin(VPos.CENTER);

		double widthvalue = rect.getWidth();
		double width2value = value.getLayoutBounds().getWidth();
		value.setX((widthvalue - width2value) / 2);
		value.setY(valsetY);

		Pane pane = new Pane(rect, text, subText, value);
		return pane;
	}

	public Pane effortLevel(String s, int setY) {
		Rectangle rect = new Rectangle(150, 150);
		rect.setFill(Color.AQUA);

		Text text = new Text(s);
		text.setBoundsType(TextBoundsType.VISUAL);
		text.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
		text.setTextAlignment(TextAlignment.CENTER);
		text.setTextOrigin(VPos.CENTER);

		double widthheartRate = rect.getWidth();
		double width2heartRate = text.getLayoutBounds().getWidth();
		text.setX((widthheartRate - width2heartRate) / 2);
		text.setY(setY);

		value = new Text("0");
		value.setBoundsType(TextBoundsType.VISUAL);
		value.setFont(new Font(60));
		value.setTextAlignment(TextAlignment.CENTER);
		value.setTextOrigin(VPos.CENTER);

		double widthvalue = rect.getWidth();
		double width2value = value.getLayoutBounds().getWidth();
		value.setX((widthvalue - width2value) / 2);
		value.setY(80);

		
		Button decrementButton = new Button("-");
		decrementButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 40));
		// incrementButton.setMaxWidth(100);
		decrementButton.setMaxSize(4, 4);
		decrementButton.setBorder(null);
		decrementButton.setBackground(null);
		double widthdecrementButton = rect.getWidth();
		double width2decrementButton = decrementButton.getLayoutBounds().getWidth();
		decrementButton.setLayoutX(((widthdecrementButton - width2decrementButton) / 2)-70);
		decrementButton.setLayoutY(80);

		decrementButton.setOnAction(event -> {
			if (value.getText() != "") {
				String text2 = value.getText();
				int parseInt = Integer.parseInt(text2);
				if(parseInt>0) {
					--parseInt;
				}
				
				
				value.setText(String.valueOf(parseInt));
			} else {
				value.setText("0");
			}
			// System.out.println("Hi");
		});
		
		
		
		
		Button incrementButton = new Button("+");
		incrementButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 40));
		// incrementButton.setMaxWidth(100);
		incrementButton.setMaxSize(4, 4);
		incrementButton.setBorder(null);
		incrementButton.setBackground(null);
		double widthincrementButton = rect.getWidth();
		double width2incrementButton = incrementButton.getLayoutBounds().getWidth();
		incrementButton.setLayoutX((widthincrementButton - width2incrementButton) / 2);
		incrementButton.setLayoutY(80);

		incrementButton.setOnAction(event -> {
			if (value.getText() != "") {
				String text2 = value.getText();
				int parseInt = Integer.parseInt(text2);
				++parseInt;
				value.setText(String.valueOf(parseInt));
			} else {
				value.setText("0");
			}
			// System.out.println("Hi");
		});

		Pane pane = new Pane(rect, text, value, decrementButton,incrementButton);
		return pane;
	}

	public void setTime() {
		// flip 60 seconds over to a minute
		double mi = counter++;
		// System.out.println((mi * 60) + seconds);
		double res = mi / ((mi * 60) + seconds);
		// System.out.println(res);
		if (seconds == 0) {
			seconds = 59;
			minutes--;
		}

		// flip 60 minutes over to an hour
		if (minutes == 0) {
			timeline.stop();
		}

		String m = minutes >= 10 ? String.valueOf(minutes) : "0" + String.valueOf(minutes);
		String s = seconds >= 10 ? String.valueOf(seconds) : "0" + String.valueOf(seconds);

		timer.setText(m + ":" + s);
	}

	public static void main(String[] args) {
		launch(args);
	}
}