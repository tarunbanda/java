import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//import cs1c.BubbleSort;
//import cs1c.TimeConverter;

/*
 * Assume that you are developing a feature of an application for a super market.
 * Your feature must manage the customers in a register.
 * Write a program that given the customers in a file, your program
 * process one queue at a time.
 */
public class SuperMarket 
{
	// To simplify implementation, let's assume there are only three registers
	// in our supermarket.
	private Queue<String> register01;
	private Queue<String> register02;
	private Queue<String> register03;

	private ArrayList<Integer> priceOfGroceries;

	// TO DO: NOT include
	public SuperMarket(String filename)
	{
		register01 = new Queue<String>("registr  1");
		register02 = new Queue<String>("register 2");
		register03 = new Queue<String>("register 3");

		try 
		{
			File infile = new File(filename);
			Scanner input = new Scanner(infile);

			String line = "";
			while (input.hasNextLine()) 
			{
				line = input.nextLine(); 
				String [] tokens = line.split(" ");

				int registerNumber = Integer.parseInt(tokens[0]);
				String customerName = tokens[1];

				switch(registerNumber)
				{
				case 1:
					register01.enqueue(customerName);				

					break;
				case 2:
					register02.enqueue(customerName);				
					break;
				case 3:
					register03.enqueue(customerName);				
					break;
				default:
					System.err.println("Error: invalid register number " + registerNumber);
				}
			}			
			input.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	
	} // constructor


	// do not include definition
	public void printRegister(int registerNumber)
	{
		switch(registerNumber)
		{
		case 1:
			System.out.println(register01);
			break;
		case 2:
			System.out.println(register02);
			break;
		case 3:
			System.out.println(register03);
			break;
		default:
			System.err.println("Error: invalid register number " + registerNumber);
		}
	}


	// do not include definition
	public Queue<String> getRegister(int registerNumber)
	{
		switch(registerNumber)
		{
		case 1:
			return register01;
		case 2:
			return register02;
		case 3:
			return register03;
		default:
			System.err.println("Error: invalid register number " + registerNumber);
		}
		return null;
	}

	public static void main(String[] args) 
	{
		final String FILENAME = "resources/registers.txt";	// Directory path for Mac OS X
		//final String FILENAME = "resources\\registers.txt";	// Directory path for Windows OS (i.e. Operating System)


		// The constructor of class SuperMarket reads the file
		// and adds customer lanes to the appropriate register.
		// For example, if the file contains line: 
		// Alice 1
		// Then the an object of type String containing "Alice" will be placed in register01.
		SuperMarket market = new SuperMarket(FILENAME);

		int totalCustomersInLine = market.getRegister(1).size() 
				+ market.getRegister(2).size() 
				+ market.getRegister(3).size();
		System.out.println("Number of customers in market : " + totalCustomersInLine);


		System.out.println("\nCustomers in each register:");
		for (int registerNumber = 1; registerNumber <= 3; registerNumber++)
		{
			market.printRegister(registerNumber);
		}

		Random rand = new Random();
		int numberToAssist = rand.nextInt(totalCustomersInLine);
		System.out.println("\nNumber of customers to assist " + numberToAssist);
		
		int registerNumber = 0;
		try
		{
			for (int i = 0; i < numberToAssist; i++)
			{
				registerNumber = 1;
				if (i % 2 == 0)
					registerNumber = 2;
				else if (i % 3 == 0)
					registerNumber = 3;
				market.getRegister(registerNumber).dequeue();
			}
		} 
		catch (java.util.NoSuchElementException ex)
		{
			System.out.println("Warning: No customers left to process in register " + registerNumber);
		}

		System.out.println("\nCustomers in each register:");
		for (registerNumber = 1; registerNumber <= 3; registerNumber++)
		{
			market.printRegister(registerNumber);
		}
	}

}
