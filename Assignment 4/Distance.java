/**
* Class: CS1A Object-Oriented Programming Methodologies in Java 
* Description: This program calculates the distance between two points
* Due date: 5/05/2014
* Name: Tarun Banda
* File name: Distance.java */
// *************************************************************
//   Distance.java
//
//   Computes the distance between two points
// *************************************************************

import java.util.Scanner;

public class Distance
{
    public static void main (String[] args)
    {
	double x1, y1, x2, y2; // coordinates of two points
	double distance;       // distance between the points

	Scanner scan = new Scanner (System.in);

	
	// Read in the two points 
	System.out.print ("Enter the coordinates of the first point " +
               "(put a space between them): ");
	x1 = scan.nextDouble(); 
	y1 = scan.nextDouble();

	
	// Read 2nd set of points
	System.out.print ("Enter the coordinates of the second point: ");
	x2 = scan.nextDouble();
	y2 = scan.nextDouble();

	
	// Compute the distance by calling the Math method
	distance = (Math.pow(x1-x2,2) + Math.pow(y1-y2,2)); //square the difference
	distance = (double)Math.sqrt(distance); //Square root value to get distance
	

	
	// Print out the answer with proper rounding
	System.out.printf("The distance between (%.1f,%.1f) and (%.1f,%.1f) is %.15f." , x1, y1, x2, y2, distance);
	
    }
}
