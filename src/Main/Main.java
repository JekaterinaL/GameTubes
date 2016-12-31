package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Optional;

public class Main extends Application {

    //Globalaalsed muutujad, mis kasutatakse ainult selle klassi sees
    private GridPane Field = new GridPane();
    Image cpipe = new Image("Main/img/c-pipe.png");
    Image ipipe = new Image("Main/img/i-pipe.png");
    Image tpipe = new Image("Main/img/t-pipe.png");
    Image xpipe = new Image("Main/img/x-pipe.png");
    ImagePattern cpipefill = new ImagePattern(cpipe);
    ImagePattern ipipefill = new ImagePattern(ipipe);
    ImagePattern tpipefill = new ImagePattern(tpipe);
    ImagePattern xpipefill = new ImagePattern(xpipe);

    @Override
    public void start(Stage primaryStage) {
        //informatsiooni akna loomine tekstiga
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("New game");
        alert.setHeaderText("Welcome to GameTubes!");
        alert.setContentText("Please press 'Start' to start first level or 'Exit' to exit the application.");

        //Next ja Exit nupude loomine aknas
        ButtonType buttonNext = new ButtonType("Next");
        ButtonType buttonExit = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonNext, buttonExit);

        //vajutades nupule Next avaneb mänguväli
        //vajutades nupule Exit programm pannakse kinni
        Optional<ButtonType> result = alert.showAndWait(); //(result on muutuja)
        if (result.isPresent() && result.get() == buttonNext){
            setupField ();
            setupPipes ();
            eventOnClick ();
        } else if (result.isPresent() && result.get() == buttonExit){
            System.out.println("Exit");
        }
    }

    private void setupField() {
        //mänguvälja loomine
        Field = new GridPane();
        Scene scene = new Scene(Field, 600, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Game Tubes");
    }

    private void eventOnClick() {
        Field.setOnMouseClicked(event -> {
            Rectangle Pane = (Rectangle) event.getTarget();
            Pane.setRotate(90);                             //should rotate on every click
            System.out.println("click");
        });
    }

    private void setupPipes() {
        for (int i = 0; i < 3; i++) {                       //field 3x3
            for (int j = 0; j < 3; j++) {
                Rectangle pane = new Rectangle(200, 200);
                byte[][] map = {
                        {22, 33, 23},                       //number means special pipe
                        {32, 40, 34},
                        {21, 31, 24},
                };

                if (map[j][i] == 40){
                    pane.setFill(xpipefill);
                } else if (map[j][i] == 11){
                    pane.setFill(ipipefill);
                } else if (map[j][i] == 12){
                    pane.setFill(ipipefill);
                } else if (map[j][i] == 21){
                    pane.setFill(cpipefill);
                } else if (map[j][i] == 22){
                    pane.setFill(cpipefill);
                } else if (map[j][i] == 23){
                    pane.setFill(cpipefill);
                } else if (map[j][i] == 24){
                    pane.setFill(cpipefill);
                } else {
                    pane.setFill(tpipefill);
                }
                Field.add(pane, i, j);

            }
        }
    }

    public static void main(String args[]) {
        launch(args);
    }
}
