/**
* Class: CS1A Object-Oriented Programming Methodologies in Java  
* Description: Goal of the program is to identify the number times a certain character appears in a string 
* Due date: 5/05/2014
* Name: Tarun Banda
* File name: Count.java */

// ************************************************************
// Count.java
//
// This program reads in strings (phrases) and counts the
// number of blank characters and certain other letters
// in the phrase.
// ************************************************************
import java.util.Scanner;

public class Count {
	public static void main(String[] args) {
		String phrase; // a string of characters
		int countBlank; // the number of blanks (spaces) in the phrase
		int length; // the length of the phrase
		char ch; // an individual character in the string
		int countA; //the number of a's in the string
		int countE; //the number of e's in the string
		int countS; //the number of s's in the string
		int countT; //the number of t's in the string
		
		//Scanner to input data
		Scanner scan = new Scanner(System.in);
		
		
		// Print a program header
		System.out.println();
		System.out.println("Character Counter");
		System.out.println();
		
		
		// a do-while loop that runs if true
		do {

			// Read in a string and find its length
			System.out.print("Enter a sentence or phrase, quit to end: ");
			phrase = scan.nextLine();
			length = phrase.length();
			if (phrase.equals("quit")) //if statement to identify the words quit
				break; //break out of loop if string matches 
			
			// Initialize counts of all variables
			countBlank = 0; 
			countA = 0; 
			countE = 0; 
			countS = 0; 
			countT = 0;
			
			// for loop that identifies each character and adds to initialized variables
			int i;
			for (i = 0; i < length; i++) { 
				ch = phrase.charAt(i);
				switch (ch) {
				case 'a':
				case 'A': countA++;
				break;
				case 's':
				case 'S': countS++;
				break;
				case 'e':
				case 'E': countE++;
				break;
				case 't':
				case 'T': countT++;
				break;
				case ' ': countBlank++;
				break;
				}
				
			}		
			// Print the results
			System.out.println();
			System.out.println("Number of blank spaces: " + countBlank);
			System.out.println("Number of As: " + countA);
			System.out.println("Number of Es: " + countE);
			System.out.println("Number of Ss: " + countS);
			System.out.println("Number of Ts: " + countT);
			System.out.println();
			
		} while (true); //condition of the do-while loop
		
			System.exit(0); //exits system if program exits loop
	}
}

