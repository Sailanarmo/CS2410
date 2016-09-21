package cs2410.assn3.directory;

import java.io.*;
import java.util.Scanner;


/**
 * Created by rlram on 9/17/2016.
 */
public class Directory {


    private static final String file = "D:\\Documents\\CS2410\\Ramirez-Raul-Assn3\\data\\cs2410-directory.data";
    Scanner fileIn = null;
        PrintWriter fileOut = null;
    float total = 0;
    int age = 0;
    public void readFromFile(){
        
        try{
            fileIn = new Scanner(new FileReader(file));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

	System.out.printf("%-10s \t", "First Name");
            System.out.printf("%-10s \t", "Last Name");
            System.out.printf("%s \t", "Age");
	    System.out.printf("%s ", "Phone Number");
            System.out.println();


        while(fileIn.hasNext()){
	    String fName = fileIn.next();
	    String lName = fileIn.next();
	    String age = fileIn.next();
	    String number = fileIn.next();
	   
	     
	    System.out.printf("%-10s \t", fName);
            System.out.printf("%-10s \t", lName);
            System.out.printf("%s \t", age);
	    System.out.printf("%s ", number);
            System.out.println();

           // System.out.printf(fileIn.nextLine());
        }
    }

    public void insertFile(){
	Scanner input = new Scanner(System.in);
	String fname = input.next();
	String lname = input.next();
	String age = input.next();
	String number = input.next();
	try{
	    fileOut = new PrintWriter(new BufferedWriter(new FileWriter("././data/cs2410-directory.data", true)));
	    fileOut.print(

    public float averageAge(){
	
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
