package cs2410.assn3.directory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

/**
 * The Directory class, shares the file between both the Terminal and Gui version.
 */
public class Directory {



    private static final String file = "D:\\Documents\\CS2410\\Ramirez-Raul-Assn3\\data\\cs2410-directory.data";
	//private static final String file = "././data/cs2410-directory.data";

	/**
	 * setting up variables Scanner, PrintWriter, float, and int to use for later in the code.
	 */
    Scanner fileIn = null;
	PrintWriter fileOut = null;
    float total = 0;
    int age = 0;

	/**
	 * readFromFile() Outputs the file to the screen.
	 * @return a String that is read from the file and outputted to the screen.
	 */
    public String readFromFile(){
		String output = "";
        System.out.println();
		/**
		 * try opening the file, if you cannot open the file, catch and throw and exception of why we cannot.
		 */
        try{
            fileIn = new Scanner(new FileReader(file));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

		/**
		 * call output and Formats the string to our liking, this is the header specifically.
		 */
		output += String.format("%-15s %-15s %15s %15s\n", "First Name", "Last Name", "Age", "Phone Number");


		/**
		 * While there are still things to read, store the items into their appropriate strings by
		 * their order. Then format the output to our liking. Then return the output.
		 */
        while(fileIn.hasNext()){
	    	String fName = fileIn.next();
	    	String lName = fileIn.next();
	    	String age = fileIn.next();
	    	String number = fileIn.next();
	   
	    	output += String.format("%-15s %-15s %15s %15s\n", fName, lName, age, number);
        }
	return output;
    }

	/**
	 * insertFile takes 4 string parameters, opens a text file, writes to the file, and closes the file.
	 *
	 * @param fName string to store the first name
	 * @param lName string to store the last name
	 * @param age string to store the age
	 * @param number string to store a phone number
	 */
    public void insertFile(String fName, String lName, String age, String number){
		/**
		 * try opening the file to get ready for writing. If not, tell us why we cannot.
		 */
		try{
			fileOut = new PrintWriter(new BufferedWriter(new FileWriter("D:\\Documents\\CS2410\\Ramirez-Raul-Assn3\\data\\cs2410-directory.data", true)));
	    	//fileOut = new PrintWriter(new BufferedWriter(new FileWriter("././data/cs2410-directory.data", true)));
	    	fileOut.println(fName + " " + lName + " " + age + " " + number);
			fileOut.close();
		} catch (IOException e){
	    	e.printStackTrace();
		}
    }

	/**
	 * averageAge reads the first integer it finds and divides it by a float to give us back a decimal point.
	 * @return the average age.
	 */
	public float averageAge(){
	    System.out.println();
		/**
		 * try opening the file for rading, if we cannot, tell us why.
 		 */
		try{
	    	fileIn = new Scanner(new FileReader(file));
		} catch (FileNotFoundException e){
	    	e.printStackTrace();
		}
		/**
		 * while the file still has stuff to read add up how many times we have gone through it,
		 * ignore the strings and find the integer in the file. Store that integer into age and
		 * add age to itself each time we loop through. Ignore the last string and return the
		 * average age.
		 */
		while(fileIn.hasNext()){
	    	total++;
	    	fileIn.next();
            fileIn.next();
	    	age += fileIn.nextInt();
            fileIn.next();
		}
	    return age/total;
    }
}
