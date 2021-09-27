import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	Circle purpleCircle = new Circle(10);

	// YOU ASKED FOR IT DEAN
	Circle HoTpInKcIrClE = new Circle(10);
	Rectangle ground [] = new Rectangle[20];
	Manager manager = new Manager();
	Font newFont = new Font("TimesRoman", 18);
	Pane pane = new Pane();

	//Scaling the scene
	Scene scene = new Scene(pane , (2000 / 4), (2500 / 4));
	Text text = new Text();


public void start(Stage primaryStage) {

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.show();

		Button randomGround = new Button("Randomize Plateus");
		randomGround.setLayoutX(150);
		randomGround.setLayoutY(150);
		randomGround.setPrefSize(200, 50);
		randomGround.setFont(newFont);
		randomGround.setOnAction(e->{
			manager.randomG();
		});

		Button loadGround = new Button("Load from File");
		loadGround.setLayoutX(150);
		loadGround.setLayoutY(200);
		loadGround.setPrefSize(200, 50);
		loadGround.setFont(newFont);
		loadGround.setOnAction(e->{
			manager.loadG();
		});

		Button okButton = new Button("Start the game!");
		okButton.setLayoutX(150);
		okButton.setLayoutY(250);
		okButton.setPrefSize(200, 50);
		okButton.setFont(newFont);
		okButton.setOnAction(e->{
			pane.getChildren().clear();
			startGame();
		});

		pane.getChildren().addAll(randomGround, loadGround, okButton);
}

public void startGame() {

	manager.determineMethod();
	text.setVisible(false);
	text.setLayoutX(50);
	text.setLayoutY(100);

		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		KeyFrame keyframe = new KeyFrame(Duration.millis(100), action ->{

			if (! manager.hareStop()) {
			manager.Hare.moveHare();
			purpleCircle.setLayoutX(manager.Hare.getXdisplacement()/4);
			purpleCircle.setLayoutY((2500 - manager.Hare.getYdisplacement())/4);
			}

			else if (! manager.houndStop()) {
			manager.Hound.setXHound();
			manager.Hound.setYHound();
			HoTpInKcIrClE.setLayoutX(manager.Hound.getXdisplacement()/4);
			HoTpInKcIrClE.setLayoutY((2500 - manager.Hound.getYdisplacement())/4);
			}

			if (manager.houndStop()) {
				manager.calculateDistance();
				text.setText("THE WINNER IS: "+ manager.winner + "\nAbsolute distance = " + manager.distance + "meters");
				text.setFont(newFont);
				text.setVisible(true);
				timeline.stop();
				saveAction();
				}
			});

		timeline.getKeyFrames().add(keyframe);
		timeline.play();

		Button burnFuel = new Button("Burn Fuel");
		burnFuel.setLayoutX(300);
		burnFuel.setLayoutY(20);
		burnFuel.setPrefSize(120, 40);
		burnFuel.setFont(newFont);
		burnFuel.setOnAction(e->{
			manager.Hound.fuelburn();
		});

		for (int i = 0; i < 20; i++) {
		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(100 / 4);
		rectangle.setHeight((manager.ground[i]) / 4);
		rectangle.setLayoutY((2500 / 4) - ((manager.ground[i]) / 4));
		rectangle.setLayoutX((i*100) / 4);
		pane.getChildren().add(rectangle);

		}
		purpleCircle.setLayoutX(2000/ 4);
		purpleCircle.setLayoutY(2500 / 4);
		purpleCircle.setFill(Color.PURPLE);
		HoTpInKcIrClE.setLayoutX(0);
		HoTpInKcIrClE.setLayoutY(2100 / 4);
		HoTpInKcIrClE.setFill(Color.DEEPPINK);
		pane.getChildren().addAll(purpleCircle, HoTpInKcIrClE, burnFuel, text);


}

	public void saveAction() {
		Button save = new Button("Save new Random Ground");
		save.setLayoutX(200);
		save.setLayoutY(200);
		save.setPrefSize(150, 50);
		save.setFont(newFont);
		pane.getChildren().add(save);
		save.setOnAction(e->{
			manager.saveScore();
			manager.exitHell();
		});

	}

	public static void main(String[] args) {
	launch(args);
	}
}
