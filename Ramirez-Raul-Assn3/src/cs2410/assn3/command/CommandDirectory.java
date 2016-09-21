package cs2410.assn3.command;

import cs2410.assn3.directory.Directory;
import cs2410.assn3.controller.Controller;

import java.util.Scanner;

public class CommandDirectory { 

    Directory directory = new Directory();
    
    public CommandDirectory(){} //need to see if this is correct
    
    public void printMenu(){
	System.out.println("Directory Menu");
	System.out.println("(1) List Directory");
	System.out.println("(2) Add Person");
	System.out.println("(3) List Average Age");
	System.out.println("(4) Quit Program");
	askInput();
    }

    public void askInput(){

	Scanner input = new Scanner(System.in);
	System.out.print("Choose an option: ");
	int option = input.nextInt();

	while (option < 1 || option > 4){
	    System.out.print("Invalid input! Please enter a valid number: ");
	    option = input.nextInt();
	}

	if (option == 1){
	    directory.readFromFile();
	    System.out.println();
	    printMenu();
	}
	if (option == 2){
	    System.out.println("You have chosen 2");
	    System.out.println();
	    printMenu();
	}
	if (option == 3){
	    System.out.println("Average Age: " + directory.averageAge());
	    System.out.println();
	    printMenu();
	}
	if (option == 4){
	    System.out.println("Adios!");
	}
    }
}
