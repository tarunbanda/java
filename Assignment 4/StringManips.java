/**
* Class: CS1A Object-Oriented Programming Methodologies in Java  
* Description: This program manipulate strings that have been input
* Due date: 5/05/2014
* Name: Tarun Banda
* File name: StringManips.java */
// ***************************************************************
// FILE:  StringManips.java
//
// Purpose: Test several methods for manipulating String objects
// ***************************************************************

import java.util.Scanner;

public class StringManips
{
    public static void main (String[] args)
    {
	String phrase = new String ("This is a String test.");
	int phraseLength;   // number of characters in the phrase String
	int middleIndex;    // index of the middle character in the String
	String middle3;        // middle 3 characters of the phrase
	String city, state;    // hometown city and state

      Scanner scan = new Scanner (System.in);

	// compute the length and middle index of the phrase
	phraseLength = phrase.length();
	middleIndex = phraseLength / 2;

	
	// get middle 3 characters
	middle3 = phrase.substring(middleIndex-1, middleIndex+2);

	// print information about the phrase
	System.out.println();
	System.out.println ("Original phrase: " + phrase);
	System.out.println ("Length of the phrase: " + phraseLength +
			    " characters");
	System.out.println ("Index of the middle: " + middleIndex);
	System.out.println ("Character at the middle index: " + 
			    phrase.charAt(middleIndex));
	System.out.println ("Middle 3 characters: " + middle3);
	
	System.out.println();

	//prompt user to enter city
	System.out.println("Enter your hometown city: ");
	city = scan.nextLine();
	
	//prompt user to enter state
	System.out.println("Enter your hometown state: ");
	state = scan.nextLine();
	
	//Print State name in uppercase, city in lowercase, and state in uppercase
	System.out.println(state.toUpperCase() +" " + city.toLowerCase() +" "+ state.toUpperCase());	
    }
}







