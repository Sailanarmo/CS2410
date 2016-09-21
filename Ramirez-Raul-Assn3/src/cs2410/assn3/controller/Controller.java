package cs2410.assn3.controller;

import cs2410.assn3.command.CommandDirectory;
import cs2410.assn3.gui.GUIDirectory;

import java.util.Scanner;

/**
 * Created by Raul on 9/20/2016.
 */
public class Controller{
    CommandDirectory myTerminal = new CommandDirectory();
    GUIDirectory myGui = new GUIDirectory();

    public Controller(){
        Scanner input = new Scanner(System.in);

        System.out.println("Which version of the program would you like?");
        System.out.print("Press 1 for Command Line, Press 2 for GUI: ");

        int option = input.nextInt();

        if(option == 1){
            System.out.println();
            myTerminal.printMenu();
        }
        if(option == 2){
            try{
                System.out.println();
                myGui.launch(GUIDirectory.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){

        new Controller();

    }
}
