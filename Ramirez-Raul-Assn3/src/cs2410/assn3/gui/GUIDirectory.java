package cs2410.assn3.gui;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;




public class GUIDirectory extends Application{

    public GUIDirectory(){}

    public void start(Stage primaryStage) throws Exception {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); //try other types
        alert.setTitle("The Title Goes Here");
        alert.setHeaderText("This is the Header"); //try setting to null
        alert.setContentText("I have a great message for you!");

        Optional<ButtonType> result1 = alert.showAndWait();
        if (result1.get() == ButtonType.OK) {
            System.out.println("You clicked OK");
        } else if (result1.get() == ButtonType.CANCEL) {
            System.out.println("You clicked Cancel");
        }

        TextInputDialog dialog = new TextInputDialog("Default Name");
        dialog.setTitle("Title Goes Here");
        dialog.setHeaderText("This is the Header");
        dialog.setContentText("Please enter your name:");

        Optional<String> result2 = dialog.showAndWait();
        if (result2.isPresent()) {
            System.out.println("Your name: " + result2.get());
        }

        ArrayList<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");

        ChoiceDialog choice = new ChoiceDialog("a", list);
        choice.setTitle("Title Goes Here");
        choice.setHeaderText(null);
        choice.setContentText("Choose one");

        result2 = choice.showAndWait();
        if (result2.isPresent()) {
            System.out.println("You chose: " + result2.get());
        }
    }
}
