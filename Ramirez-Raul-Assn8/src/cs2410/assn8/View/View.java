package cs2410.assn8.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Raul on 12/7/2016.
 */
public class View extends Application {

    private Button startButton = new Button("Reset");

    private HBox toolBar = new HBox();

    private VBox bombCount = new VBox();

    private Scoreboard board = new Scoreboard();



    private BorderPane myPane = new BorderPane();


    public void start(Stage primaryStage){
        int height = 25;
        int width = 50;
        double difficulty = .25;

        Scene myScene = new Scene(myPane, width*20, (height*20)+50);

        primaryStage.setTitle("Minesweeperish");
        primaryStage.setScene(myScene);

        bombCount.getChildren().add(new Text("Bombs"));
        bombCount.getChildren().;

        toolBar.getChildren().add(new Text("Bombs"));
        toolBar.getChildren().add(startButton);
        toolBar.getChildren().add(new Text("Timer"));
        toolBar.setSpacing(20);
        toolBar.setAlignment(Pos.CENTER);
        toolBar.setPadding(new Insets(5,5,5,5));
        toolBar.setPrefHeight(50);

        startButton.setLineSpacing(5);

        myPane.setTop(toolBar);
        myPane.setAlignment(toolBar, Pos.CENTER);


        board.setSize(height,width,difficulty);
        myPane.setCenter(board);

        primaryStage.setMinHeight(height*20);
        primaryStage.setMinWidth(width*20);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
