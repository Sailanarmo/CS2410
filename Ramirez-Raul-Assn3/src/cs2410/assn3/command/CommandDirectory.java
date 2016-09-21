package cs2410.assn3.command;

import cs2410.assn3.directory.Directory;

import java.util.Scanner;

/**
 * The command line version of the directory.
 *
 * Asks the user for input from a menu and executes a function that is called. It is basically a "fake" while loop
 * as printMenu is always called at the end of each option except for 4 as once that is chosen the loop is officially
 * terminated and ends the program.
 *
 */
public class CommandDirectory {

	/**
	 * creates an instance of Directory
	 */
    Directory directory = new Directory();
    
    public CommandDirectory(){} //need to see if this is correct

	/**
	 * printMenu() simply prints the menu and then calls the askInput() function.
	 */
	public void printMenu(){
		System.out.println("Directory Menu");
		System.out.println("(1) List Directory");
		System.out.println("(2) Add Person");
		System.out.println("(3) List Average Age");
		System.out.println("(4) Quit Program");
		askInput();
    }

	/**
	 * askInput() asks the user for an answer between 1-4. If they go out of the bounds of 1-4, they will
	 * be asked to input a correct answer. When the user chooses and appropriate number, that number will
	 * go to the appropriate method to call.
	 */
	public void askInput(){

		/**
		 * Creates a scanner for the user to input options.
		 */
		Scanner input = new Scanner(System.in);
		System.out.print("Choose an option: ");
		/**
		 * creates an integer called option to store the user input.
		 */
		int option = input.nextInt();

		/**
		 * While the option is not less than 1, or greater than 4, spit out an error and have the user try again.
		 */
		while (option < 1 || option > 4){
	    	System.out.print("Invalid input! Please enter a valid number(1-4): ");
	    	option = input.nextInt();
		}

		/**
		 * if option is equal to 1, then call the readFromFile() function in directory and output it to the screen.
		 * Then call printMenu() again.
		 */
		if (option == 1){
	    	System.out.println(directory.readFromFile());
	    	System.out.println();
	    	printMenu();
		}
		/**
		 * if option is equal to 2, then create a Scanner for the user to create strings. Take the first name and
		 * store it into a string called fName. The the last name and store it into a string called lName, take the
		 * age and store it into a string call age, and take the phone number and store it into a string called number.
		 *
		 * Then take those string parameters and pass them into the insertFile() function in directory. Then call
		 * printMenu() again.
		 */
		if (option == 2){
			Scanner insert = new Scanner(System.in);
			System.out.print("Enter First Name: ");
			String fName = insert.next();
			System.out.print("Enter Last Name: ");
			String lName = insert.next();
			System.out.print("Enter Age: ");
			String age = insert.next();
			System.out.print("Enter Phone Number: ");
			String number = insert.next();
	    	directory.insertFile(fName, lName, age, number);
	    	System.out.println("Person Added!");
	    	printMenu();
		}
		/**
		 * if option is equal to 3, print the average age by calling the averageAge() function in directory.
		 * Then print the menu again.
		 */
		if (option == 3){
	    	System.out.println("Average Age: " + directory.averageAge());
			System.out.println();
	    	printMenu();
		}
		/**
		 * if option is equal to 4. Print out adios, since there is no more arguments to follow. The program
		 * simply quits because there is nothing left to execute.
		 */
		if (option == 4){
	    	System.out.println("Adios!");
		}
    }
}
