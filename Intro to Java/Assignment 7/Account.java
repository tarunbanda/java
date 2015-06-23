/**
* Class: CS1A Object-Oriented Programming Methodologies in Java 
* Description: This program creates an account object 
* Due date: 6/02/2014
* Name: Tarun Banda
* File name: Account.java */

import java.util.Date;

//create Account.java which create an Account object
public class Account {

	private int id = 0; //set id to private 
	private double balance = 0; // set balance to private
	private double annualInterestRate = 0; //set annualInterestRate to private
	private Date dateCreated = new Date(); //create a private date variable using java.util.Date
	
	//Constructor for an object with no-args
	public Account() { 
	}
	
	//Constructor for crating an Account object with two args, id and balance
	public Account(int initId, double initBalance) {
		id = initId;
		balance = initBalance;
	}
	
	//mutator for id since variable is private
	 public void setId(int newId) {
		 id = newId;
		 }

	//accessor for id
	 public int getId() {
		 return id;
		 }
	 
	 //mutator for balance since variable is private
	 public void setBalance(double newBalance) {
		 balance = newBalance;
	 }
	 
	 //accessor for balance
	 public double getBalance() {
		 return balance;
	 }
	 
	 //mutator for annualInterstRate since variable is private
	 public void setAnnualInterestRate(double newAnnualInterestRate) {
		 annualInterestRate = newAnnualInterestRate;
	 }
	 
	 //accesor for annualInterstRate
	 public double getAnnualInterstRate() {
		 return annualInterestRate;
	 }
	 
	 //accesor for getting current date/time
	 public String getCurrentDate() {
		 return dateCreated.toString();
	 }
	 
	 //method that double returns monthlyInterest 
	 public double getMonthlyInterest() {
		 double monthlyInterestRate = ((annualInterestRate/12)/100); //divide annual interest rate by 12 to get monthly rate
		 return balance*monthlyInterestRate; //get interest amount by multiplying monthly rate by balance
	 }
	 
	 //method to withdraw from Account
	 public void withdraw(double withdrawAmount) {
		 balance = balance - withdrawAmount;
	 }
	 
	 //method to deposit amount to Account
	 public void deposit(double depositAmount) {
		 balance = balance + depositAmount;
	 }
}
