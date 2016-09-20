package cs2410.assn3.command;

import java.util.Scanner;

public class CommandDirectory { 

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
	    System.out.println("You have chosen 1");
	    System.out.println();
	    printMenu();
	}
	if (option == 2){
	    System.out.println("You have chosen 2");
	    System.out.println();
	    printMenu();
	}
	if (option == 3){
	    System.out.println("You have chosen 3");
	    System.out.println();
	    printMenu();
	}
	if (option == 4){
	    System.out.println("Adios!");
	}
    }
}
