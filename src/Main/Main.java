package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    GridPane Field;
    Rectangle pane;
    Image cpipe = new Image("c-pipe.png");
    Image ipipe = new Image("i-pipe.png");
    Image tpipe = new Image("t-pipe.png");
    Image xpipe = new Image("x-pipe.png");
    ImagePattern cpipefill = new ImagePattern(cpipe);
    ImagePattern ipipefill = new ImagePattern(ipipe);
    ImagePattern tpipefill = new ImagePattern(tpipe);
    ImagePattern xpipefill = new ImagePattern(xpipe);

    @Override
    public void start(Stage primaryStage) throws Exception {
        setupField ();
        setupPipes ();
        eventOnClick ();
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
                pane = new Rectangle(200, 200);
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

    private void setupField() {
        Field = new GridPane();
        Scene scene = new Scene(Field, 600, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Game Tubes");
    }
    public static void main(String args[]) {
        launch(args);
    }
}
