/**
* Class: CS1A Object-Oriented Programming Methodologies in Java 
* Description: This calculates the discount for sales based on quantity purchased
* Due date: 4/26/2014
* Name: Tarun Banda
* File name: SoftwareSales.java
*/


import java.util.Scanner;


public class SoftwareSales {
	public static void main(String[] args) {
		//create a Scanner
		int price = 99;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of units sold: ");
		int quantity = input.nextInt();
		
		//if-else statements to bracket discounts accordingly
		if (quantity >= 10 && quantity <= 19) {
			System.out.print("Units sold: " + quantity + "\n");
			System.out.print("Discount: $" + ((int)(price*quantity*.2*10))/10.0 + "\n");
			System.out.print("Cost: $" + ((int)(price*quantity*.8*10))/10.0);
		}
		else if (quantity >= 20 && quantity <= 49) {
			System.out.print("Units sold: " + quantity + "\n");
			System.out.print("Discount: $" + ((int)(price*quantity*.3*10))/10.0 + "\n");
			System.out.print("Cost: $" + ((int)(price*quantity*.7*10))/10.0);
		}
		else if (quantity >= 50 && quantity <= 99) {
			System.out.print("Units sold: " + quantity + "\n");
			System.out.print("Discount: $" + ((int)(price*quantity*.4*10))/10.0 + "\n");
			System.out.print("Cost: $" + ((int)(price*quantity*.6*10))/10.0);
		}
		else if (quantity >= 100) {
			System.out.print("Units sold: " + quantity + "\n");
			System.out.print("Discount: $" + ((int)(price*quantity*.5*10))/10.0 + "\n");
			System.out.print("Cost: $" + ((int)(price*quantity*.5*10))/10.0);	
		}
		else {
			System.out.print("No Discount for less than 10 units sold.");
		}
	}
}
