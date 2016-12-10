package cs2410.assn6;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import static java.lang.Math.abs;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 * @Author Raul Ramirez
 * @Version 1
 */
public class Main extends Application {
    private ToolPane tp;
    private Ellipse ell;
    private Rectangle rect;
    private Path free;
    private Pane drawPane;
    double x1;
    double y1;
    double x2;
    double y2;
    double radx;
    double rady;
    Shape cshape; //shape last clicked on
    boolean isclicked  = false;

    /**
     * Setting the drawing pane up.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        tp = new ToolPane();
        BorderPane borderPane = new BorderPane();
        Scene mainScene = new Scene(borderPane);
        primaryStage.setScene(mainScene);
        drawPane = new Pane();
        drawPane.setPrefHeight(500);
        drawPane.setPrefWidth(500);
        Rectangle clip = new Rectangle(500, 500);
        clip.heightProperty().bind(drawPane.heightProperty());
        clip.widthProperty().bind(drawPane.widthProperty());
        drawPane.setClip(clip);
        paneHandler(drawPane);
        borderPane.setTop(tp);
        tp.setAlignment(Pos.CENTER);
        borderPane.setCenter(drawPane);
        toolsHandler();
        primaryStage.show();
    }

    /**
     * Prepares the user to draw on the pane
     */
    private void paneHandler(Pane drawPane) {
        drawPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!isclicked) {
                    cshape = null;
                }
                else
                    isclicked = false;

                if (tp.ellBtnSelected() == true) {
                    x1 = event.getX();
                    y1 = event.getY();
                    ell = new Ellipse();
                    ell.setStroke(tp.getStrokePickerValue());
                    ell.setStrokeWidth(tp.getStrokeSizeValue());
                    ell.setFill(tp.getFillPickerValue());
                    drawPane.getChildren().add(ell);
                    setShapeHandler(ell);
                }
                if (tp.rectBtnSelected()){
                    x1 = event.getX();
                    y1 = event.getY();

                    rect = new Rectangle();
                    rect.setStroke(tp.getStrokePickerValue());
                    rect.setStrokeWidth(tp.getStrokeSizeValue());
                    rect.setFill(tp.getFillPickerValue());
                    drawPane.getChildren().add(rect);
                    setShapeHandler(rect);
                }
                if (tp.freeBtnSelected()){
                    x1 = event.getX();
                    y1 = event.getY();
                    free = new Path();
                    free.getElements().add(new MoveTo(x1, y1));
                    free.setStroke(tp.getStrokePickerValue());
                    free.setStrokeWidth(tp.getStrokeSizeValue());
                    drawPane.getChildren().add(free);
                    setShapeHandler(free);
                }
            }
        });
        /**
         * Allows the user to draw on the pane
         */
        drawPane.setOnMouseDragged(new EventHandler<MouseEvent>() { //drag on the draw pane
            @Override
            public void handle(MouseEvent event) {
                if (tp.ellBtnSelected() == true) {
                    radx = abs((event.getX() - x1) / 2);
                    rady = abs((event.getY() - y1) / 2);
                    ell.setRadiusX(radx);
                    ell.setRadiusY(rady);
                    ell.setCenterX(abs(event.getX() + x1) / 2);
                    ell.setCenterY((event.getY() + y1) / 2);
                }
                if (tp.rectBtnSelected()){
                    x2 = event.getX();
                    y2 = event.getY();
                    if (y2 - y1 > 0) {
                        rect.setTranslateY(0);
                        rect.setHeight((y2 - y1));
                    }
                    else{
                        rect.setTranslateY((y2 - y1));
                        rect.setHeight(-(y2 - y1));
                    }
                    if(x2 - x1 > 0){
                        rect.setTranslateX(0);
                        rect.setWidth((x2 - x1));
                    }
                    else{
                        rect.setTranslateX((x2 - x1));
                        rect.setWidth(-(x2 - x1));
                    }
                    rect.setLayoutX(x1);
                    rect.setLayoutY(y1);
                }
                if (tp.freeBtnSelected()){
                    free.getElements().add(new LineTo(event.getX(), event.getY()));
                }
            }
        });
    }

    /**
     * Sets the handlers for selecting buttons for shapes, as well as the delete button.
     * @param shape
     */
    private void setShapeHandler(Shape shape) {
        shape.setOnMousePressed(new EventHandler<MouseEvent>() { //click on shape
            @Override
            public void handle(MouseEvent event) {
                cshape = shape;
                isclicked = true;
                if (tp.editBtnSelected() == true) {
                    x1 = event.getX();
                    y1 = event.getY();
                    tp.setFillPickerValue((Color) shape.getFill());
                    tp.setStrokePickerValue((Color) shape.getStroke());
                    tp.setStrokeSizeValue(intValue(shape.getStrokeWidth()));
                }
                if (tp.eraseBtnSelected() == true) {
                    drawPane.getChildren().remove(shape);
                }
            }
        });
        shape.setOnMouseDragged(new EventHandler<MouseEvent>() { //drag the shape
            @Override
            public void handle(MouseEvent event) {
                if (tp.editBtnSelected() == true) {
                    shape.setTranslateX(shape.getTranslateX() + event.getX() - x1);
                    shape.setTranslateY(shape.getTranslateY() + event.getY() - y1);
                }
            }
        });
    }
    /**
     * Sets the fill and stroke sizes
     * */
    private void toolsHandler() {   //click on tool
        tp.setFillPickerAction(new EventHandler() {
            public void handle(Event event) {
                if (tp.editBtnSelected()) {
                    if (cshape != null) {
                        cshape.setFill(tp.getFillPickerValue());

                    }
                }
            }
        });
        tp.setStrokePickerAction(new EventHandler() {
            public void handle(Event event) {
                if (tp.editBtnSelected()) {
                    if (cshape != null) {
                        cshape.setStroke(tp.getStrokePickerValue());
                    }
                }
            }
        });
        tp.setStrokeSizeAction(new EventHandler(){
            public void handle(Event event) {
                if (tp.editBtnSelected()) {
                    if (cshape != null) {
                        cshape.setStrokeWidth(tp.getStrokeSizeValue());
                    }
                }
            }
        });
    }
}
