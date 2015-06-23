/**
* Class: CS1A Object-Oriented Programming Methodologies in Java 
* Description: Uses Dialog boxes to take hour and hourly wage inputs and outputs gross pay
* Due date: 5/05/2014
* Name: Tarun Banda
* File name: PayCheck.java */

import javax.swing.*;

public class PayCheck {

	public static void main(String[] args) {
		
		//Initialize variables
		double weeklyhours = 0;
		double hourlywage = 0;
		double grosspay = 0;
		double overtime = 0;
		
		//while loop
		int option = 0;
		while (option == JOptionPane.YES_OPTION) {
			// Enter hours worked and wage in dialog box
			String hours = JOptionPane.showInputDialog(null, "Enter hours worked",
					"Input", JOptionPane.QUESTION_MESSAGE);
			String wage = JOptionPane.showInputDialog(null, "Enter hourly rate",
					"Input", JOptionPane.QUESTION_MESSAGE);
		
			// convert string to double
			weeklyhours = Double.parseDouble(hours); //transform string into double
			hourlywage = Double.parseDouble(wage); //transform string into double
			if (weeklyhours <= 40) {
				grosspay = weeklyhours*hourlywage; //calculate gross pay with no overtime
				}
			else //calculate gross pay with overtime
				overtime = weeklyhours - 40;
				grosspay = 40*(hourlywage) + overtime*(hourlywage*1.5);
			
			//JOption Message to show gross pay
			JOptionPane.showMessageDialog(null, "Gross pay is " + grosspay, 
					"Message",JOptionPane.INFORMATION_MESSAGE);
			
			//JOption option to prompt prompt another attempt
			option = JOptionPane.showConfirmDialog(null, "Do Another?");
	
		}
		
	}

}
