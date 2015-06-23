/**
* Class: CS1A Object-Oriented Programming Methodologies in Java 
* Description: This program calculates the taxes and net pay of an employees paycheck
* Due date: 5/05/2014
* Name: Tarun Banda
* File name: Payroll.java */
import java.util.Scanner;


public class Payroll {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		//declare variables
		String name;
		double hours, payrate, fedTax, stateTax,grossPay, netPay;
		double fedWithholding, stateWithholding,totalDeduction;
		
		
		//Employee Name
		System.out.println("Enter employee's name: ");
		name = input.nextLine();
		
		
		//Employee Hours
		System.out.println("Enter number of hours worked in a week: ");
		hours = input.nextDouble();
		
		
		//Employee Pay rate
		System.out.println("Enter hourly pay rate: ");
		payrate = input.nextDouble();
		
		
		//Employee federal tax withholdings 
		System.out.println("Enter federal tax withholding rate: ");
		fedTax = input.nextDouble();
		
		
		//Employee state tax withholdings
		System.out.println("Enter state tax withholding rate: ");
		stateTax = input.nextDouble();
		
		//Calculate grossPay, FedWithholding, stateWithholding, todalDeduction, netPay
		grossPay = (Math.floor((hours*payrate)*100)/100); //use Math.floor method to round down
		fedWithholding = (Math.floor((grossPay*fedTax)*100)/100);
		stateWithholding = (Math.floor((grossPay*stateTax)*100)/100);
		totalDeduction = (Math.floor((fedWithholding + stateWithholding)*100)/100);
		netPay = (Math.floor((grossPay - totalDeduction)*100)/100);
		
		//Print using printf() each of the fields using format specifiers
		System.out.println();
		System.out.println("Employee Name: " + name); //prints name
		System.out.println("Hours Worked: " + hours); //prints hours worked
		System.out.println("Pay Rate: $" + payrate); //prints Pay Rate
		System.out.printf("Gross Pay: $%.1f\n",  (grossPay)); //prints Gross Pay
		System.out.println("Deductions: "); 
		//uses escape sequence \t to tab then print using format specifiers
		System.out.printf("\tFederal Withholding (%.2f%s): $%.1f\n",fedTax, "%", fedWithholding);
		System.out.printf("\tState Withholding (%.2f%s): $%.2f\n", stateTax, "%", stateWithholding);
		System.out.printf("\tTotal Deduction: $%.2f\n",totalDeduction);
		System.out.printf("Net Pay: $%.2f", netPay);
		
		
	}
}
