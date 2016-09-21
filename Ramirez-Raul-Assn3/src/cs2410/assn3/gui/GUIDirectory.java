package cs2410.assn3.gui;

import cs2410.assn3.directory.Directory;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import java.util.Optional;

/**
 * The GUI Version of the directory.
 * The GUI will call the menu() function which will display options for the users to use.
 * Once the user makes an appropriate selection, the Menu will choose the appropriate method
 * and print the menu() out again. Only being able to quit by pressing 4 to exit.
 */
public class GUIDirectory extends Application{

    /**
     * Creating an instance of Directory to access the text file.
     */
    Directory myGui = new Directory();

    /**
     * creates a private static final string called css that has the path of my file.
     */
    private static final String css = "resources/custom.css";


    /**
     * Creates a menu for the GUI to use.
     */
    public void menu() {
        /**
         * Creates a new TextInputDialog called menu and sets the text field to be empty.
         */
        TextInputDialog menu = new TextInputDialog(null);
        menu.setTitle("Directory");
        menu.setHeaderText(null);
        menu.setGraphic(null);
        menu.setContentText("Directory Menu\n(1) List Directory\n(2) Add Person\n(3) List Average Age\n(4) Quit Program");

        /**
         * Creates and Optional<Sting> called result and waits for the input, then in creats a temporary string and
         * stores the result in the string to then convert the string into an inegeter for easy comparison.
         */
        Optional<String> result = menu.showAndWait();
        String temp = result.get();
        int answer = Integer.parseInt(temp);

        /**
         * while the answer is less than 1 or greater than 4, create a new alert of type error.
         * Tell the user they have a bad input and print the menu for them to input again.
         */
        while (answer < 1 || answer > 4){
            Alert alert = new Alert((Alert.AlertType.ERROR));
            alert.setContentText("Invalid input! Please enter a number between 1-4!!");
            alert.setTitle("Invalid Input!!");
            alert.setHeaderText(null);

            alert.showAndWait();
            menu();
        }

        /**
         * if the user input is present then we are ok to proceed.
         */
        if (result.isPresent()) {
            /**
             * If answer is equal to 1, call the function printDirectory() then print the menu.
             */
            if (answer == 1) {
                printDirectory();
                menu();
            }
            /**
             * If answer is equal to 2, call the insertPerson() function and then print the menu.
             */
            if (answer == 2) {
                insertPerson();
                menu();
            }
            /**
             * If answer is equal to 3, call the returnAverage() function and then print the menu
             */
            if(answer == 3) {
                returnAverage();
                menu();
            }
            /**
             * If answer is equal to 4, then exit the program.
             */
            if(answer == 4) {
                System.exit(0);
            }
        }
    }

    /**
     * printDirectory calls readFromFile() in the directory and displays it into the screen.
     */
    public void printDirectory() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(myGui.readFromFile());
        alert.setTitle("Directory");
        alert.setHeaderText(null);
        alert.getDialogPane().setPrefSize(600, 300);
        alert.setGraphic(null);

        alert.getDialogPane().getStylesheets().add(css);
        alert.showAndWait();
    }

    /**
     * insertPerson() takes user input, collects it into a Optional<String> and is then
     * stored into a string itself to pass onto the insertFile() function in the directory.
     */
    public void insertPerson() {
        /**
         * creates a TextInputDialog and name fName, is then asked for the first name the user
         * wants to create.
         */
        TextInputDialog fName = new TextInputDialog(null);
        fName.setTitle("First Name");
        fName.setGraphic(null);
        fName.setHeaderText(null);
        fName.setContentText("Please Enter your First Name:");

        /**
         * Creates an Optional<String> and stores it into a String to pass into the insertFile() Function.
         */
        Optional<String> fNameAnswer = fName.showAndWait();
        String fN = fNameAnswer.get();

        /**
         * Creates a TextInputDialog and name it lName, it then asks the user for the last name.
         */
        TextInputDialog lName = new TextInputDialog(null);
        lName.setTitle("Last Name");
        lName.setGraphic(null);
        lName.setHeaderText(null);
        lName.setContentText("Please Enter your Last Name:");

        /**
         * Creates and Optional<String> and stores it into a String to pass into the insertFile() Function.
         */
        Optional<String> lNameAnswer = lName.showAndWait();
        String lN = lNameAnswer.get();

        /**
         * Creates a TextInputDialog and name it age, it then asks the user for the age.
         */
        TextInputDialog age = new TextInputDialog(null);
        age.setTitle("Age");
        age.setGraphic(null);
        age.setHeaderText(null);
        age.setContentText("Please Enter your age:");

        /**
         * Creates and Optional<String> and stores it into a String to pass into the insertFile() Function.
         */
        Optional<String> ageAnswer = age.showAndWait();
        String aA = ageAnswer.get();

        /**
         * Creates a TextInputDialog and name it number, it then asks the user for the phone number.
         */
        TextInputDialog number = new TextInputDialog(null);
        number.setTitle("Phone Number");
        number.setGraphic(null);
        number.setHeaderText(null);
        number.setContentText("Please Enter your phone number:");

        /**
         * Creates and Optional<String> and stores it into a String to pass into the insertFile() Function.
         */
        Optional<String> numberAnswer = number.showAndWait();
        String nA = numberAnswer.get();

        /**
         * Calls the insertFile() Function and passes the parameters from the strings that were created.
         */
        myGui.insertFile(fN, lN, aA, nA);
    }

    /**
     * returnAverage simply calls the averageAge() function from the directory and outputs it to the screen.
     * float temp is simply there to be called to convert into a String to display to the screen.
     */
    public void returnAverage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        float temp = myGui.averageAge();
        String average = Float.toString(temp);
        alert.setContentText("The average age is: " + average);
        alert.setTitle("Average Age");
        alert.setHeaderText(null);

        //alert.getDialogPane().getStylesheets().add("D:\\Documents\\CS2410\\Ramirez-Raul-Assn3\\data\\custom.css");
        alert.getDialogPane().getStylesheets().add(css);
        alert.showAndWait();
    }

    /**
     * start simply just calls the menu() function once the GUI is launched.
     *
     * @param primaryStage sets the Stage to be the initial stage.
     * @throws Exception incase we need to check ourselves
     */
    public void start(Stage primaryStage) throws Exception {

        menu();

    }
}
