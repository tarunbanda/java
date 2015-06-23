import java.util.*;

public class StudentArray
{
   public static void main (String[] args)
   {
      String[][] courseRoster;
      int  numCourses, numStudents, course, student;
      Scanner input = new Scanner(System.in);
      String userChoice;

      // part 1: get the number of courses
      while(true)
      {
         System.out.print("How many courses do you want to load: ");
         userChoice = input.nextLine();
         try
         {
            numCourses = Integer.parseInt(userChoice);
            break;
         }
         catch (NumberFormatException e)
         {
            continue;
         }
      }
      // an array of size numCourses, where each element is an empty String[] 
      courseRoster = new String[numCourses][];
        
      // part 2: get the size of each course
      for (int k = 0; k < numCourses; k++)
      {
         while(true)
         {
            System.out.print("Number of students in course " + k + ": ");
            userChoice = input.nextLine();
            try
            {
               numStudents = Integer.parseInt(userChoice);
               courseRoster[k] = new String[numStudents];
               break;
            }
            catch (NumberFormatException e)
            {
               continue;
            }
         }
      }
     
      // part 3: fill roster with bogus names
      for ( course = 0; course < courseRoster.length; course++)
      {
         for ( student = 0; student < courseRoster[course].length; 
               student++)
            courseRoster[course][student] = "lily"+ student 
                  + " obrien" + course;
         System.out.println();
      }   

      // part 4: show the rosters
      for ( course = 0; course < courseRoster.length; course++)
      {
         System.out.println("Course #" + course + " -------------");
         for ( student = 0; student < courseRoster[course].length; 
               student++)
            System.out.print("  [" + courseRoster[course][student] 
                  + "] ");
         System.out.println();
      } 
      input.close();
   }
 }