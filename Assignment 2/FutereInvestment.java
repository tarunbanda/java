/**
 * Class: CS1A Object-Oriented Programming Methodologies in Java * Description: (Give a brief description for Assignment 2)
 * Due date: 4/21/2014
 * Name: Tarun Banda
 * File name: Names.java
 */

import java.util.Scanner;


public class FutereInvestment {

	public static void main(String[] args) {
		// Create a Scannar 
		Scanner input = new Scanner(System.in);
		
		//Enter investment amount
		System.out.println("Enter Investment amount:");
		double investmentAmount = input.nextDouble();
		
		//Enter annual interest rate
		System.out.println("Enter annual interest rate:");
		double annualInterestRate = input.nextDouble();
		
		//Convert to monthly interst rate
		double monthlyInterestRate = annualInterestRate/1200;
		
		//Enter number of years
		System.out.println("Enter number of years:");
		double numberOfYears = input.nextDouble();
		
		//Calculate futureInvestmentValue
		double futureInvestmentvalue = investmentAmount * Math.pow(1 
				+ monthlyInterestRate,numberOfYears * 12);
		
		//Display the result
		System.out.println("Accumulated value is " + 
				(int)(futureInvestmentvalue * 100) / 100.0);
		
	}

}
