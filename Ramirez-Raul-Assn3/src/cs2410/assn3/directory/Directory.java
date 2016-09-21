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
	//private static final String file = "././data/cs2410-directory.data";
    Scanner fileIn = null;
        PrintWriter fileOut = null;
    float total = 0;
    int age = 0;
    public String readFromFile(){
	String output = "";
        System.out.println();
        try{
            fileIn = new Scanner(new FileReader(file));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

	output += String.format("%-15s %-15s %15s %15s\n", "First Name", "Last Name", "Age", "Phone Number");


        while(fileIn.hasNext()){
	    String fName = fileIn.next();
	    String lName = fileIn.next();
	    String age = fileIn.next();
	    String number = fileIn.next();
	   
	    output += String.format("%-15s %-15s %15s %15s\n", fName, lName, age, number); 

        }
	return output;
    }

    public void insertFile(String fName, String lName, String age, String number){

	try{
		fileOut = new PrintWriter(new BufferedWriter(new FileWriter("D:\\Documents\\CS2410\\Ramirez-Raul-Assn3\\data\\cs2410-directory.data", true)));
	    //fileOut = new PrintWriter(new BufferedWriter(new FileWriter("././data/cs2410-directory.data", true)));
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
