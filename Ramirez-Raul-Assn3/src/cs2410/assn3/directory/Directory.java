package cs2410.assn3.directory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

/**
 * Created by rlram on 9/17/2016.
 */
public class Directory {


    private static final String file = "D:\\Documents\\CS2410\\Ramirez-Raul-Assn3\\data\\cs2410-directory.data";
	// private static final String file = "././data/cs2410-directory.data";
    Scanner fileIn = null;
        PrintWriter fileOut = null;
    float total = 0;
    int age = 0;
    public void readFromFile(){
        System.out.println();
        try{
            fileIn = new Scanner(new FileReader(file));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

	System.out.printf("%-10s \t", "First Name");
            System.out.printf("%-10s \t", "Last Name");
            System.out.printf("%-10s \t", "Age");
	    System.out.printf("%-10s ", "Phone Number");
            System.out.println();


        while(fileIn.hasNext()){
	    String fName = fileIn.next();
	    String lName = fileIn.next();
	    String age = fileIn.next();
	    String number = fileIn.next();
	   
	     
	    System.out.printf("%-10s \t", fName);
            System.out.printf("%-10s \t", lName);
            System.out.printf("%-10s \t", age);
	    System.out.printf("%-10s ", number);
            System.out.println();

           // System.out.printf(fileIn.nextLine());
        }
    }

    public void insertFile(){
	Scanner input = new Scanner(System.in);
		System.out.print("Enter First Name: ");
		String fName = input.next();
		System.out.print("Enter Last Name: ");
		String lName = input.next();
		System.out.print("Enter Age: ");
		String age = input.next();
		System.out.print("Enter Phone Number: ");
		String number = input.next();
	try{
		fileOut = new PrintWriter(new BufferedWriter(new FileWriter("D:\\Documents\\CS2410\\Ramirez-Raul-Assn3\\data\\cs2410-directory.data", true)));
	   // fileOut = new PrintWriter(new BufferedWriter(new FileWriter("././data/cs2410-directory.data", true)));
	    fileOut.println(fName + " " + lName + " " + age + " " + number);
		fileOut.close();
	} catch (IOException e){
	    e.printStackTrace();
	}
	    System.out.println("Person Added!");
    }

    public float averageAge(){
	    System.out.println();
	try{
	    fileIn = new Scanner(new FileReader(file));
	} catch (FileNotFoundException e){
	    e.printStackTrace();
	}

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
