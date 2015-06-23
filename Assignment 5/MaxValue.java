/**
* Class: CS1A Object-Oriented Programming Methodologies in Java 
* Description: This program takes an input string of 
* 			integers and determines the largest number and the occurrence
* Due date: 5/05/2014
* Name: Tarun Banda
* File name: MaxValue.java */

import java.util.Scanner;

public class MaxValue {

	public static void main(String[] args) {
		
		Scanner data = new Scanner(System.in);
		
		//Initialize Variables
		int max = 0; //gets assigned the max number 
		int count = 0; //counts the occurrence of the max number
		String numString; //takes user input as a string
		char ch = 0; //gets assigned each character in the string
		
		//Prompt user to enter numbers
		System.out.println("Enter numbers: ");
		numString = data.nextLine(); //accepts string into variable numString
		
		// use a for loop to find max number and occurring count
		int i = 0;
		for (i = 0; i < numString.length(); i++) {  //for loop to iterate through each character in string
			ch = numString.charAt(i);
					if (ch > max) { 
						max = ch; // assigns ch to max if new max number
						count = 1; //sets count to 1
					} else if (ch == max){
						count++; //increases count by one if number is the same
					} else {
						continue; //continues loop if neither criteria is met
					}
				} 
		
		//print out max number and count
		System.out.println("The largest number is " + (char)max);
		System.out.println("the occurence count of the largest number is "+ count);
		
	}

}
