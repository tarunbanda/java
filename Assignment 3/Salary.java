/**
* Class: CS1A Object-Oriented Programming Methodologies in Java 
* * Description: The goal of Salary.java is determine the raise to recieve based on performance
* Due date: 4/26/2014
* Name: Tarun Banda
* File name: Salary.java
*/
//****************************************************** 
// Salary.java
// Compute the raise and new salary for an employee 
//****************************************************** import java.util.Scanner;
import java.util.Scanner;

public class Salary {
	public static void main(String[] args) {
		double currentSalary; //Current annual salary
		int rating; // performance rating
		double raise = 0; // dollar amount of the raise
		
		Scanner scan = new Scanner(System.in);
		//Get the current salary and performance rating
		System.out.print("Enter the current annual salary: ");
		currentSalary = scan.nextDouble();
		
		System.out.print("Enter the performance rating: ");
		rating = scan.nextInt();//Store input in ratings
		
		//Compute the raise according to rating
		switch (rating) {
			case 1: raise = (double)(currentSalary * .06); break;
			case 2:	raise = (double)(currentSalary * .04); break;
			case 3:	raise = (double)(currentSalary * .015);
		}
		//Print raise and new salary
		System.out.print("Amount of your raise: $" + raise + "\n");
		System.out.print("Your new salary: $" + (currentSalary + raise));
		
	}
}
