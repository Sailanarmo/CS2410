

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Add a description of the class here
 *
 * @author Chad
 * @version XXX
 */
public class GUI extends Application {
    private Text text = new Text("Hello");

    @Override
    public void start(Stage primaryStage) throws Exception {

        ToolBar toolBar = new ToolBar();

        BorderPane mainPane = new BorderPane();
        HBox hBox = new HBox();

        initComboBoxes(hBox);
        hBox.setSpacing(5);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        StackPane displayPane = new StackPane();
        displayPane.setPrefSize(400, 500);
        displayPane.getChildren().add(text);
        mainPane.setTop(hBox);
        mainPane.setCenter(displayPane);
        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initComboBoxes(Pane pane) {

        ComboBox<String> stringComboBox = new ComboBox<>();
        stringComboBox.getItems().addAll("Math", "Income", "Hours", "IQ", "Say", "Carrots", "Contracts");
        stringComboBox.setValue(stringComboBox.getItems().get(0));

        stringComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(stringComboBox.getValue() == ("Math")) {
                    text.setText("Do some Math yo.");
                }
                if(stringComboBox.getValue() == "Income") {
                    text.setText("We are poor yo");
                }
                if(stringComboBox.getValue() == "Hours") {
                    text.setText("Do some more work yo.");
                }
                if(stringComboBox.getValue() == "IQ") {
                    text.setText("You are smart yo.");
                }
                if(stringComboBox.getValue() == "Say") {
                    text.setText("Say Something yo");
                }
                if(stringComboBox.getValue() == "Carrots") {
                    text.setText("Carrots yo");
                }
                if(stringComboBox.getValue() == "Contracts") {
                    text.setText("I got a contract for you yo.");
                }
            }
        });

        Button hourly = new Button("Hourly");
        hourly.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setText("PLS");
            }
        });

        Button contract = new Button("Contract");
        contract.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setText("Halp");
            }
        });

        Button hobbit = new Button("Hobbit");
        hobbit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setText("Ok");
            }
        });

        pane.getChildren().addAll(stringComboBox, hourly, contract, hobbit);
    }
}
