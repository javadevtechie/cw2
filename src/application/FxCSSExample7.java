package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Popup;
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
	private Popup popup = new Popup();

	public FxCSSExample7() {
		minutes = 19;
		seconds = 59;
	}

	@Override
	public void start(Stage stage) {
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.setOnCloseRequest(e -> e.consume());

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
		Pane pane6 = returnPauseOrStop(stage);
		Pane pane7 = returnCoolDown();
		vbox2.getChildren().addAll(pane4, pane5, pane6, pane7);
		vbox2.setSpacing(2);

		VBox vbox3 = new VBox();
		Pane pane8 = returnRect("distance", 20, "km", 45, "1.51", 80);
		Pane pane9 = returnRect("Power", 20, "watts", 45, "216", 80);
		Pane pane10 = returnRect("Speed", 20, "spm", 45, "94", 80);
		vbox3.getChildren().addAll(pane8, pane9, pane10);
		vbox3.setSpacing(2);
		vbox3.setPadding(new Insets(2, 2, 2, 2));

		VBox vbox4 = new VBox();
		Pane pane11 = returnRectPane("TV",
				"C:\\Users\\U6054040\\OneDrive - Clarivate Analytics\\Documents\\cw2\\cw2\\src\\application\\download.png");
		Pane pane12 = returnRectPane("TV",
				"C:\\Users\\U6054040\\OneDrive - Clarivate Analytics\\Documents\\cw2\\cw2\\src\\application\\download.png");

		Pane pane13 = returnRectPane("TV",
				"C:\\Users\\U6054040\\OneDrive - Clarivate Analytics\\Documents\\cw2\\cw2\\src\\application\\download.png");

		vbox4.getChildren().addAll(pane11, pane12, pane13);
		vbox4.setSpacing(2);
		vbox4.setPadding(new Insets(2, 2, 2, 2));

		HBox hbox = new HBox();
		hbox.getChildren().addAll(vbox, vbox1, vbox2, vbox3, vbox4);
		stage.setScene(new Scene(hbox, 800, 500, Color.BLACK));

		stage.show();
	}

	public Pane returnRectPane(String s, String imagePath) {

		Rectangle rect = new Rectangle(150, 150);
		rect.setFill(Color.AQUA);

		Text text = new Text(s);
		text.setBoundsType(TextBoundsType.VISUAL);
		text.setFont(Font.font("Verdana", 20));
		text.setTextAlignment(TextAlignment.CENTER);
		text.setTextOrigin(VPos.CENTER);

		text.setX(10);
		text.setY(15);
		Rectangle imageRect = new Rectangle(50, 50);
		imageRect.setFill(Color.RED);

		FileInputStream input;
		ImageView imageView = null;
		try {
			input = new FileInputStream(imagePath);
			Image image = new Image(input);
			imageView = new ImageView(image);
			imageView.setFitWidth(50);
			imageView.setFitHeight(50);
			imageView.setX(0);
			imageView.setY(100);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pane pane = new Pane(rect, text, imageView);
		return pane;

	}

	public Pane returnPauseOrStop(Stage s) {
		Rectangle rect = new Rectangle(150, 74);
		rect.setFill(Color.RED);
		Button b = new Button();
		b.setText("Pause\nStop");
		b.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
		b.setBackground(null);
		b.setBorder(null);
		b.setMaxHeight(500);
		b.maxWidth(1000);
		b.setLayoutX(12);
		b.setLayoutY(10);
		Pane popupPane = getPopupPane(s);
		b.setOnAction(event -> {
			if (!popup.isShowing()) {
				popup.show(s);
				s.requestFocus();
				pause();
			} else
				popup.hide();
		});

		Pane pane = new Pane(rect, b);
		return pane;
	}

	public Pane getPopupPane(Stage s) {

		HBox hb = new HBox();
		VBox vbox = new VBox();
		new Popup();
		popup.setWidth(2000);
		popup.setHeight(2000);
		Pane popUpPane = new Pane();

		Button restartButton = new Button("Restart");
		Button stopButton = new Button("Stop");
		restartButton.setLayoutX(10);
		restartButton.setLayoutY(20);
		HBox h = new HBox();
		// h.setPadding(new Insets(4, 5, 6, 6));
		h.getChildren().addAll(stopButton, restartButton);
		Text t = new Text("The Exercise is temporarily\nsuspended");
		t.setFont(new Font(20));
		t.setFill(Color.WHITE);
		// t.setTextAlignment(Alignment.);
		t.setTextAlignment(TextAlignment.CENTER);
		vbox.getChildren().addAll(t, h);
		hb.getChildren().addAll(vbox);
		popUpPane.getChildren().addAll(hb);
		restartButton.setOnAction(event -> {
			restart();
			popup.hide();
		});

		stopButton.setOnAction(event -> {
			s.close();
		});

		popup.getContent().addAll(new Rectangle(0, 0, 300, 300), popUpPane);

		return h;

	}

	public Pane returnCoolDown() {
		Rectangle rect = new Rectangle(150, 74);
		rect.setFill(Color.LIGHTBLUE);
		Text text = new Text("COOL DOWN");
		text.setBoundsType(TextBoundsType.VISUAL);
		text.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
		text.setTextAlignment(TextAlignment.CENTER);
		text.setTextOrigin(VPos.CENTER);

		double widthheartRate = rect.getWidth();
		double width2heartRate = text.getLayoutBounds().getWidth();
		text.setX((widthheartRate - width2heartRate) / 2);
		text.setY(40);

		Pane pane = new Pane(rect, text);
		return pane;

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

		Pane pane = new Pane(rect, text, subText, progressBar, timeText);
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
		// Background background = new Background();
		incrementButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		incrementButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
		// incrementButton.setMaxWidth(100);
		incrementButton.setMaxSize(3, 3);
		// incrementButton.setBorder(null);
		// incrementButton.setBackground(null);
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

	public void restart() {
		timeline.playFromStart();
		timeline1.playFromStart();
	}

	public void pause() {
		timeline.pause();
		timeline1.pause();
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