package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
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

	private Text timer;
	private Text value;
	static double ii = 0;
	private static final Integer STARTTIME = 500;
	private Timeline timeline;
	private Timeline timeline1;
	private Text timerLabel = new Text();
	private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME * 100);

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

		VBox vbox1 = new VBox();
		Rectangle r2 = new Rectangle(150, 150);
		r2.setFill(Color.AQUA);
		Pane pane1 = new Pane(r2, time, time1, timer);
		Pane pane2 = returnRect("heart rate", 20, "beats/min", 45, "93", 80);
		Pane pane3 = effortLevel("effort level", 40);
		vbox1.getChildren().addAll(pane1, pane2, pane3);
		vbox1.setPadding(new Insets(2, 2, 2, 2));
		vbox1.setSpacing(2);
		VBox vbox2 = new VBox();
		vbox2.setPadding(new Insets(2, 2, 2, 2));

		Pane pane4 = returnRect("calories", 20, "kcal", 45, "571", 80);
		Pane pane5 = timeProgress("time", 20, "min:sec", 45);
		vbox2.getChildren().addAll(pane4, pane5);
		vbox2.setSpacing(2);

		///vbox2.getChildren().add(pane4,);

		HBox hbox = new HBox();
		hbox.getChildren().addAll(vbox, vbox1, vbox2);
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

	public Pane timeProgress(String s, int setY, String sub, int setsubY) {
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

		timerLabel.textProperty().bind(timeSeconds.divide(100).asString());
		timerLabel.setFill(Color.RED);

		ProgressBar progressBar = new ProgressBar();
		progressBar.progressProperty().bind(timeSeconds.divide(STARTTIME * 100.0).subtract(1).multiply(-1));

		if (timeline1 != null) {
			timeline1.stop();
		}
		timeSeconds.set((STARTTIME + 1) * 100);
		timeline1 = new Timeline();
		timeline1.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME + 1), new KeyValue(timeSeconds, 0)));
		timeline1.playFromStart();


		double widthprogress = rect.getWidth();
		double width2progress = progressBar.getLayoutBounds().getWidth();
		progressBar.setLayoutX(((widthprogress - width2progress) / 2) - 50);
		progressBar.setLayoutY(80);

		
		Text timeText = new Text("20:00");
		timeText.setBoundsType(TextBoundsType.VISUAL);
		timeText.setFont(Font.font("Verdana", 20));
		timeText.setTextAlignment(TextAlignment.CENTER);
		timeText.setTextOrigin(VPos.CENTER);

		double widthtimeText = rect.getWidth();
		double width2timeText = timeText.getLayoutBounds().getWidth();
		timeText.setX((widthtimeText - width2timeText) / 2);
		timeText.setY(120);
		
		Pane pane = new Pane(rect, text, subText, progressBar,timeText);
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
		decrementButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
		decrementButton.setMaxSize(3, 3);
		// decrementButton.setBorder(null);
		// decrementButton.setBackground(null);
		decrementButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		double widthdecrementButton = rect.getWidth();
		double width2decrementButton = decrementButton.getLayoutBounds().getWidth();
		decrementButton.setLayoutX(((widthdecrementButton - width2decrementButton) / 2) - 60);
		decrementButton.setLayoutY(90);

		decrementButton.setOnAction(event -> {
			if (value.getText() != "") {
				String text2 = value.getText();
				int parseInt = Integer.parseInt(text2);
				if (parseInt > 0) {
					--parseInt;
				}

				value.setText(String.valueOf(parseInt));
			} else {
				value.setText("0");
			}
		});

		Button incrementButton = new Button("+");
		//Background background = new Background();
		incrementButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		incrementButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
		// incrementButton.setMaxWidth(100);
		incrementButton.setMaxSize(3, 3);
		//incrementButton.setBorder(null);
		//incrementButton.setBackground(null);
		double widthincrementButton = rect.getWidth();
		double width2incrementButton = incrementButton.getLayoutBounds().getWidth();
		incrementButton.setLayoutX((widthincrementButton - width2incrementButton) / 2);
		incrementButton.setLayoutY(90);

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

		Pane pane = new Pane(rect, text, value, decrementButton, incrementButton);
		return pane;
	}

	public void setTime() {

		if (seconds == 0) {
			seconds = 59;
			minutes--;
		}

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