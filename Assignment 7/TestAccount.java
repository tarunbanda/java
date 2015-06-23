/**
* Class: CS1A Object-Oriented Programming Methodologies in Java 
* Description: This program tests class Account by creating a class object
* Due date: 6/02/2014
* Name: Tarun Banda
* File name: TestAccount.java */
public class testAccount {

	public static void main (String[] args){
		// Set myAccount to have id: 1122 and balance: $20,000
		Account myAccount = new Account(1122, 20000);
		myAccount.setAnnualInterestRate(4.5); //set annualInterstRate to 4.5%
		myAccount.deposit(3000); //deposit $3,000
		myAccount.withdraw(2500); //withdraw $2,500
		
		//printing out final balance and monthly interest
		System.out.println("Balance is " + myAccount.getBalance());
		System.out.println("Monthly interest is " + myAccount.getMonthlyInterest());
		System.out.println("The account was created at " + myAccount.getCurrentDate());
		
	}

}

