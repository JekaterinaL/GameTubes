package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
        eventOnKlick ();
    }

    private void eventOnKlick() {
        Field.setOnMouseClicked(event -> {
            Rectangle Pane = (Rectangle) event.getTarget();
            System.out.println("klick");
            Pane.setRotate(90);
        });
    }

    private void setupPipes() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pane = new Rectangle(200, 200);
                int random = (int) (Math.random() * 4);
                if (random == 0){
                    pane.setFill(ipipefill);
                } else if (random == 1){
                    pane.setFill(cpipefill);
                } else if (random == 2){
                    pane.setFill(tpipefill);
                } else {
                    pane.setFill(xpipefill);
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
    }
}
