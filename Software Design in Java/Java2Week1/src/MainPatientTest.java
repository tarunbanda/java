import java.util.Scanner;

public class MainPatientTest
{
   // declare a (rare) global that can be used by all for console input
   static Scanner inputStream;
   
   // -------  main --------------
   public static void main(String[] args)
   {
      // variables to capture input
      String userName;
      double userTemp;
      int userId;
      
      // instantiate scanner
      inputStream = new Scanner(System.in);
      
      // Patient objects
      Patient person1 = new Patient();
      Patient person2 = new Patient();

      // get the info for patient #1:
      System.out.println("Patient #1 ---");
      // we built three helper methods for this
      userName = getPatientName();
      userId = getPatientID();
      userTemp = getPatientTemp();

      // set patient #1
      if ( !person1.setName(userName) )
         System.out.println("Error in patient name: Invalid length.");
      if ( !person1.setID(userId) )
         System.out.println("Error in patient id: out of range.");
      if ( !person1.setTemperature(userTemp) )
         System.out.println("Error in patient temperature:  out of range.");

      // get the info for patient #2:
      System.out.println("Patient #2 ---");
      userName = getPatientName();
      userId = getPatientID();
      userTemp = getPatientTemp();

      // set patient #2
      if ( !person2.setName(userName) )
         System.out.println("Error in patient name: Invalid length.");
      if ( !person2.setID(userId) )
         System.out.println("Error in patient id: out of range.");
      if ( !person2.setTemperature(userTemp) )
         System.out.println("Error in patient temperature:  out of range.");

      // display patients
      if (person1.getTemperature() > person2.getTemperature())
      {
          person1.display();
          person2.display();
      }
          else
          {
              person2.display();
              person1.display();
          }
          
              
   }
   
   // main methods (non-Patient methods)
   static String getPatientName()
   {
      String stringIn;
      
      System.out.print("What's the patient's name? ");
      stringIn = inputStream.nextLine();
      return stringIn;
   }

   static int getPatientID()
   {
      int id;
      String stringIn;

      System.out.print("What's the patient's id #? ");
      stringIn = inputStream.nextLine();
      id = Integer.parseInt(stringIn);
      return id;
   }

   static double getPatientTemp()
   {
      double temp;
      String stringIn;
      
      System.out.print("What's the patient's temperature? ");
      stringIn = inputStream.nextLine();
      temp = Double.parseDouble(stringIn);
      return temp;
   }
}