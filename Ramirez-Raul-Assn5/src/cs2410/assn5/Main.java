package cs2410.assn5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.abs;

public class Main extends Application implements EventHandler<ActionEvent> {
    private EventHandler<ActionEvent> handler;
    private ArrayList<Ellipse> ellipses = new ArrayList<Ellipse>();
    private StackPane rootPane = new StackPane();
    private Pane drawPane = new Pane();
    private Pane btnPane = new Pane();
    private Scene scene1 = new Scene(rootPane, 500, 600);
    private Color[] carr = {Color.RED, Color.GOLD, Color.GREEN};
    private Button b1;
    private Button b2;


    public void start(Stage primaryStage) throws Exception {
        b1 = new Button("Draw");
        b1.setPrefWidth(100);
        b1.setLayoutX(75);
        b1.setLayoutY(25);
        b2 = new Button("Erase");
        b2.setPrefWidth(100);
        b2.setLayoutX(325);
        b2.setLayoutY(25);
        b1.setOnAction(this);
        b2.setOnAction(this);

        primaryStage.setTitle("Draw Ellipses");
        Rectangle border = new Rectangle(0,100,500,500);
        drawPane.setClip(border);
        btnPane.getChildren().addAll(b1, b2);
        btnPane.setPrefSize(500, 100);
        drawPane.setPrefSize(500, 500);
        rootPane.getChildren().addAll(btnPane, drawPane);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public void handle(ActionEvent event) {
        Object pressed = event.getSource();
        if (pressed == b1) {
            drawPane.setOnMousePressed(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    Ellipse ep = new Ellipse(10, 10);
                    ellipses.add(ep);
                    ep.setCenterX(event.getX());
                    ep.setCenterY(event.getY());
                    ep.setStrokeWidth(3);
                    ep.setStroke(carr[ThreadLocalRandom.current().nextInt(0, 3)]);
                    ep.setFill(carr[ThreadLocalRandom.current().nextInt(0, 3)]);
                    drawPane.getChildren().add(ep);
                    drawPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            double x = abs(ep.getCenterX() - event.getX());
                            double y = abs(ep.getCenterY() - event.getY());
                            ep.setRadiusX(x);
                            ep.setRadiusY(y);
                        }
                    });
                }
            });
        }

        if (pressed == b2) {
            drawPane.setOnMousePressed(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    event.getTarget();
                }
            });
            drawPane.setOnMouseReleased(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    drawPane.getChildren().remove(event.getTarget());
                }
            });
        }
    }

    public static void main(String args[]){
        launch(args);
    }
}
