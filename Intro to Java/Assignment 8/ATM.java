/**
* Class: CS1A Object-Oriented Programming Methodologies in Java 
* Description: This program tests class Account by creating a class object
* Due date: 6/8/2014
* Name: Tarun Banda
* File name: TestAccount.java */

import java.util.Scanner;


public class ATM {

	public static void main (String[] args){
		
		int menuChoice; //initialize menu choice
		int accountId; //initialize accountId
		
		Account[] accountArray = new Account[10];

		//Use a for loop to ad Id's to accountArray
		for (int i = 0; i < accountArray.length ;i++) {
			accountArray[i] = new Account(i,100);
			}
		Scanner input = new Scanner(System.in);

			//create a do-while loop to prompt user for accountId repeatedly
			do {
			System.out.print("Enter an id: ");
			accountId = input.nextInt();
			//if-else statement to make sure proper id is entered. 
			if (accountId < 0 | accountId > 9) { 
				System.out.print("Enter a valid id (between 0 and 9): ");
				accountId = input.nextInt();
			}
			else {
			
				//nested do-loop to prompt user for menuChoice
				do {
					System.out.print("Main menu \n1: check balance\n2: withdraw\n3: deposit\n4: exit\nEnter a choice: ");
					menuChoice = input.nextInt();
					
					Account tempAccount = accountArray[accountId]; //create a tempAccount to store values for the user
					//displays accountbalance
					if (menuChoice == 1) {
						System.out.print("The balance is " + tempAccount.getBalance() + "\n");
					}
					//withdraws user entered amount
					if (menuChoice == 2) {
						System.out.print("Enter an amount to withdraw: ");
						double withdrawAmount = input.nextDouble();
						tempAccount.withdraw(withdrawAmount);
					}
					//deposits user entered amount
					if (menuChoice == 3) {
						System.out.print("Enter an amount to deposit: ");
						double depositAmount = input.nextDouble();
						tempAccount.deposit(depositAmount);
					}
					
				} while (menuChoice != 4); //exists inner do-while loop if menuChoice 4 is entered
			
			} 
			
			} while (accountId >= 0 && accountId < 10); //exits outer do-while loop if invalid account is entered
			
			System.out.println("Incorrect id, exiting ATM");
	}

}
