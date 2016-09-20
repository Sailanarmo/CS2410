package cs2410.assn3.directory;

import cs2410.assn3.command.CommandDirectory;
import cs2410.assn3.gui.GUIDirectory;


import java.util.Scanner;

/**
 * Created by rlram on 9/17/2016.
 */
public class Main {

    CommandDirectory myTerminal = new CommandDirectory();
    GUIDirectory myGui = new GUIDirectory();

    public Main(){
	Scanner input = new Scanner(System.in);


	System.out.println("Which version of the program would you like?");
	System.out.print("Press 1 for Command Line, Press 2 for GUI: ");
	
	int option = input.nextInt();	
	
	if(option == 1){
	    myTerminal.printMenu();
	}
	if(option == 2){
	    try{
		myGui.launch(GUIDirectory.class);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public static void main(String[] args){

    	new Main();

    }
}
