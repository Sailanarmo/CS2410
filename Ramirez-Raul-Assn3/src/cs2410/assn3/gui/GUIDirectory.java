package cs2410.assn3.gui;

import cs2410.assn3.directory.Directory;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import java.util.Optional;





public class GUIDirectory extends Application{

    Directory myGui = new Directory();

    private static final String css = "D:\\Documents\\CS2410\\Ramirez-Raul-Assn3\\data\\custom.css";
    //private static final String css = "././data/custom.css";
    public GUIDirectory(){}

    public void menu() {
        TextInputDialog menu = new TextInputDialog(null);
        menu.setTitle("Directory");
        menu.setHeaderText(null);
        menu.setGraphic(null);
        menu.setContentText("Directory Menu\n (1) List Directory\n (2) Add Person\n (3) List Average Age\n (4) Quit Program");

        Optional<String> result = menu.showAndWait();
        if (result.isPresent()) {
            if (result.get().equals("1")) {
                printDirectory();
                menu();
            }
            if (result.get().equals("2")) {
                insertPerson();
                menu();
            }
            if(result.get().equals("3")) {
                returnAverage();
                menu();
            }
            if(result.get().equals("4")) {
                System.exit(0);
            }
        }
    }

    public void printDirectory() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(myGui.readFromFile());
        alert.setTitle("Directory");
        alert.setHeaderText(null);
        alert.getDialogPane().setPrefSize(600, 300);
        alert.setGraphic(null);

       // alert.getDialogPane().getStylesheets().add("D:\\Documents\\CS2410\\Ramirez-Raul-Assn3\\data\\custom.css");
        alert.getDialogPane().getStylesheets().add(css);
        alert.showAndWait();
    }

    public void insertPerson() {
        TextInputDialog fName = new TextInputDialog(null);
        fName.setTitle("First Name");
        fName.setGraphic(null);
        fName.setHeaderText(null);
        fName.setContentText("Please Enter your First Name:");

        Optional<String> fNameAnswer = fName.showAndWait();
        String fN = fNameAnswer.get();

        TextInputDialog lName = new TextInputDialog(null);
        lName.setTitle("Last Name");
        lName.setGraphic(null);
        lName.setHeaderText(null);
        lName.setContentText("Please Enter your Last Name:");

        Optional<String> lNameAnswer = lName.showAndWait();
        String lN = lNameAnswer.get();

        TextInputDialog age = new TextInputDialog(null);
        age.setTitle("Age");
        age.setGraphic(null);
        age.setHeaderText(null);
        age.setContentText("Please Enter your age:");

        Optional<String> ageAnswer = age.showAndWait();
        String aA = ageAnswer.get();

        TextInputDialog number = new TextInputDialog(null);
        number.setTitle("Phone Number");
        number.setGraphic(null);
        number.setHeaderText(null);
        number.setContentText("Please Enter your phone number:");

        Optional<String> numberAnswer = fName.showAndWait();
        String nA = numberAnswer.get();

        myGui.insertFile(fN, lN, aA, nA);
    }

    public void returnAverage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        float temp = myGui.averageAge();
        String average = Float.toString(temp);
        alert.setContentText(average);
        alert.setTitle("CSS Demo");
        alert.setHeaderText(null);
        alert.getDialogPane().setPrefSize(600, 300);
        alert.setGraphic(null);

        alert.getDialogPane().getStylesheets().add("D:\\Documents\\CS2410\\Ramirez-Raul-Assn3\\data\\custom.css");
        //alert.getDialogPane().getStylesheets().add(css);
        alert.showAndWait();
    }

    public void start(Stage primaryStage) throws Exception {

        menu();

    }
}
