package cs2410.assn3.controller;

import cs2410.assn3.command.CommandDirectory;
import cs2410.assn3.gui.GUIDirectory;

import java.util.Scanner;

/**
 * Created by Raul on 9/20/2016.
 * Version 1.0
 */


public class Controller{

    /**
     * Creating instances of the terminal version of the code and the gui version of the code.
     */
    CommandDirectory myTerminal = new CommandDirectory();
    GUIDirectory myGui = new GUIDirectory();

    /**
     * Class constructor. Takes user input to launch either the terminal or gui version of the code.
     */
    public Controller(){
        Scanner input = new Scanner(System.in);

        System.out.println("Which version of the program would you like?");
        System.out.print("Press 1 for Command Line, Press 2 for GUI: ");

        /**
         * creating an integer for user input
         */
        int option = input.nextInt();

        /**
         * While the option is not equal to 1 and not equal to 2, then keep promting the user to enter
         * a valid option.
         */
        while (option != 1 && option != 2){
            System.out.print("Please press 1 for the Terminal version of this code, or 2 for the GUI: ");
            option = input.nextInt();
        }

        /**
         * If the option is equal to 1, then launch the Terminal version of the program.
         */
        if(option == 1){
            System.out.println();
            myTerminal.printMenu();
        }
        /**
         * If the option is equal to 2, then launch the GUI version of the program.
         */
        if(option == 2){
            /**
             * Try launching the GUI, if not, tell us why.
             */
            try{
                System.out.println();
                myGui.launch(GUIDirectory.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates a new instance of Controller.
     * @param args
     */
    public static void main(String[] args){

        new Controller();

    }
}
