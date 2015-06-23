/**
* Class: CS1A Object-Oriented Programming Methodologies in Java 
* Description: This is a currency converter that converts from dollars to RMB and vice versa
* Due date: 4/26/2014
* Name: Tarun Banda
* File name: CurrencyExchange.java
*/

import java.util.Scanner;

public class CurrencyExchange {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		//Takes exchange rate as an input
		System.out.print("Enter the exchange rate from dollars to RMB: ");
		double rate = input.nextDouble();
		//Converts dollars to RMB or vice versa based on 0 or 1 input
		System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
		int conversionType = input.nextInt();
		System.out.print("Enter the dollar amount: ");
		double amount = input.nextDouble();
		
		//if-else statement to display the correct conversion
		if (conversionType == 0)
			System.out.print("$" + amount + " is " + ((int)(amount*rate*10))/10.0 + " yuan");
		else
			System.out.print(amount + " yuan is $" + ((int)((amount/rate)*100))/100.0);
		
	}
}