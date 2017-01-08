package Main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class Main extends Application {

    //Globalaalsed muutujad, mis kasutatakse ainult selle klassi sees
    private MouseHandler mouseHandler;
    private Pipe[][] pipeMap;
    private final double pipeWidth = 50;
    private final double gridPadding = 20;
    private Stage stage;
    private Integer[] availableWidths;
    private int currentWidth;
    private StopWatch sw;
    private ArrayList<ResultTime> resultTimes;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        mouseHandler = new MouseHandler();
        primaryStage.setTitle("Game Tubes");
        primaryStage.show();
        availableWidths = PresetMaps.getAvailableWidths().toArray(new Integer[0]);
        currentWidth = availableWidths[0];
        sw = new StopWatch();
        resultTimes = new ArrayList<>(availableWidths.length);

        //informatsiooni akna loomine tekstiga
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("New game");
        alert.setHeaderText("Welcome to GameTubes!");
        alert.setContentText("Please press 'Start' to start first level or 'Exit' to exit the application.");

        //Start ja Exit nupude loomine aknas
        ButtonType buttonStart = new ButtonType("Start");
        ButtonType buttonExit = new ButtonType("Exit");
        alert.getButtonTypes().setAll(buttonStart, buttonExit);

        //vajutades nupule Start avaneb mänguväli
        //vajutades nupule Exit programm pannakse kinni
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonStart){
            setupField ();
        } else if (result.isPresent() && result.get() == buttonExit){
            Platform.exit();
        }
    }

    private void setupField() {
        //mänguvälja saamine
        pipeMap = PresetMaps.getPreset(currentWidth);

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(gridPadding));

        fillPane(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);

        setStageSize();
        calculateFill();
        sw.start();
    }

    private void setStageSize(){
        double stageWidth = pipeWidth *(pipeMap.length + 2) + gridPadding * 2 + 20;
        double stageHeight = pipeWidth * pipeMap.length + gridPadding * 2 + 40;
        stage.setWidth(stageWidth);
        stage.setHeight(stageHeight);
        stage.centerOnScreen();
        }

    public void fillPane(GridPane pane){
        for (int row = 0; row < pipeMap.length; row++){
            for (int col = 0; col < pipeMap[row].length; col++){
                Pipe pipe = pipeMap[row][col];
                if (pipe == null){
                    continue;
                }

                pipe.setPosition(col, row);
                pipe.setOnMouseClicked(mouseHandler);
                pipe.setMinWidth(pipeWidth);
                pipe.setMinHeight(pipeWidth);

                pane.add(pipe, col, row);
            }
        }
    }

    public static void main(String args[]) {
        launch(args);
    }

    public void calculateFill (){
        ArrayList<Pipe> checklist = new ArrayList<>(currentWidth * currentWidth);
        //taastakse täitmise kontroll
        for (Pipe[] pipeRow : pipeMap){
            for (Pipe item : pipeRow){
                if (item != null){
                    item.flowChecked = false;
                }
            }
        }

        checklist.add(pipeMap[0][0]);

        //Täitmise kontroll
        for (int i = 0; i < checklist.size(); i++){
            Pipe item = checklist.get(i);
            item.setFlow(true);

            Pipe top = (item.y() - 1) >= 0 ? pipeMap[item.y() - 1][item.x()] : null;
            if (top != null && !top.flowChecked && item.T && top.B && !checklist.contains(top)){
                checklist.add(top);
            }

            Pipe right = (item.x() + 1) < (currentWidth + 2) ? pipeMap[item.y()][item.x() + 1] : null;
            if (right != null && !right.flowChecked && item.R && right.L && !checklist.contains(right)){
                checklist.add(right);
            }

            Pipe bottom = (item.y() + 1) < currentWidth ? pipeMap[item.y() + 1][item.x()] : null;
            if (bottom != null && !bottom.flowChecked && item.B && bottom.T && !checklist.contains(bottom)){
                checklist.add(bottom);
            }

            Pipe left = (item.x() - 1) >= 0 ? pipeMap[item.y()][item.x() - 1] : null;
            if (left != null && !left.flowChecked && item.L && left.R && !checklist.contains(left)){
                checklist.add(left);
            }

            item.flowChecked = true;
        }

        for (Pipe[] pipeMap1 : pipeMap){
            for (Pipe item : pipeMap1){
                if (item != null && !item.flowChecked){
                    item.setFlow(false);            //jäänud elemendid on false
                }
            }
        }

        if (pipeMap[currentWidth - 1][currentWidth + 1].hasFlow()       //kontrollitakse nurkade täitmist
                //&& pipeMap[currentWidth - 1][1].hasFlow()
                //&& pipeMap[1][currentWidth - 1].hasFlow()
            ){
            sw.stop();
            String elapsedTime = sw.getElapsedTime();
            resultTimes.add(new ResultTime(currentWidth, elapsedTime));
            setNextWidth();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Level completed!");
            alert.setHeaderText("Your level completion time: " + elapsedTime);

            ButtonType buttonExit = new ButtonType("Exit");
            ButtonType buttonNext = null;

            if (currentWidth == 0){
                String results = "";
                for(int i = 0; i < resultTimes.size(); i++){
                    ResultTime resultTime = resultTimes.get(i);
                    results += "\n" + (i + 1) + " level (width: " + resultTime.Width + ") time: " + resultTime.Time;
                    }

                alert.setContentText("You have completed all the levels!\nYour results:" + results);
                alert.getButtonTypes().setAll(buttonExit);
            }else{
                alert.setContentText("Please press 'Next' to proceed to next level or 'Exit' to exit the application.");

                buttonNext = new ButtonType("Next");
                alert.getButtonTypes().setAll(buttonNext, buttonExit);
            }

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == buttonNext){
                setupField();
            }else if(result.isPresent() && result.get() == buttonExit){
                Platform.exit();
            }
        }
    }

    private void setNextWidth(){
        for(int i = 0; i < availableWidths.length; i++){
            if(availableWidths[i] == currentWidth){
                if(i + 1 == availableWidths.length){
                    currentWidth = 0;
                }else{
                    currentWidth = availableWidths[i + 1];
                }
                break;
            }
        }
    }

    //torudele vajutamine parema või vasaku klõpsuga
    public class MouseHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            Pipe pipe = (Pipe)event.getSource();
            MouseButton mouseButton = event.getButton();

            if(mouseButton == MouseButton.PRIMARY){
                pipe.rotateClockwise();
            }else if(mouseButton == MouseButton.SECONDARY){
                pipe.rotateCounterClockwise();
            }

            calculateFill();
        }

    }

}