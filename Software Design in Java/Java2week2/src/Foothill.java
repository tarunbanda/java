public class Foothill
{
   public static void main (String[] args)
   {
      Student[] myClass = 
      {
         new Student("smith", 95), 
         new Student("bauer", 123),
         new Student("jacobs", 195), 
         new Student("renquist", 148),
         new Student("3ackson", 108), 
         new Student("perry", 225),
         new Student("loceff", 44), 
         new Student("stollings", 452),
         new Student("charters", 295), 
         new Student("cassar", 321),
      };
  
      Student.printArrayConsole("The Array to be Searched:", myClass);
      Student.arraySort(myClass);
      Student.printArrayConsole("The Array to be Searched:", myClass);
 
      String last;
      int found;
 
      last = "stollings";
      found = Student.binarySearch(myClass, last, 0, 
         myClass.length - 1);
      if ( found >= 0 )
         System.out.println(last + " IS in list at position " 
            + found);
      else
         System.out.println(last + " is NOT in list.");
 
      last = "Jacobs";
      found = Student.binarySearch(myClass, last, 
         0, myClass.length - 1);
      if ( found >= 0 )
         System.out.println(last + " IS in list at position " + found);
      else
         System.out.println(last + " is NOT in list.");

      last = "Smart";
      found = Student.binarySearch(myClass, last, 
         0, myClass.length - 1);
      if ( found >= 0 )
         System.out.println(last + " IS in list at position " + found);
      else
         System.out.println(last + " is NOT in list.");
    }
}



//public class Foothill
//{
//   public static void main (String[] args)
//   {
//      Student[] myClass = { new Student("smith","fred", 95), 
//         new Student("bauer","jack",123),
//         new Student("jacobs","carrie", 195), 
//         new Student("renquist","abe",148),
//         new Student("3ackson","trevor", 108),
//         new Student("perry","fred",225),
//         new Student("loceff","fred", 44), 
//         new Student("stollings","pamela",452),
//         new Student("charters","rodney", 295), 
//         new Student("cassar","john",321),
//         };
//  
//      Student.printArrayConsole("The Array to be Searched:", myClass);
//
//      String first, last;
//      int found;
// 
//      first = "pamela"; last = "stollings";
//      found = Student.arraySearch(myClass, first, last );
//      if ( found >= 0 )
//         System.out.println( first + " " + last 
//               + " IS in list at position " + found);
//      else
//         System.out.println( first + " " + last 
//               + " is NOT in list.");
// 
//      first = "pamela"; last = "jacobs";
//      found = Student.arraySearch(myClass, first, last );
//      if ( found >= 0 )
//         System.out.println( first + " " + last 
//               + " IS in list at position " + found);
//      else
//         System.out.println( first + " " + last 
//               + " is NOT in list.");
//
//      first = "carrie"; last = "jacobs";
//      found = Student.arraySearch(myClass, first, last );
//      if ( found >= 0 )
//         System.out.println( first + " " + last 
//               + " IS in list at position " + found);
//      else
//         System.out.println( first + " " + last 
//               + " is NOT in list.");
//    }
//}

//public class Foothill
//{
//   public static void main (String[] args)
//   {
//      String[] myArray = {"martin", "claudia", "sandra", "samuels",
//         "terry", "jack", "clark", "palmer", "abraham", "Mike"};
//      
//      printArray("Before: ", myArray);
//      arraySort(myArray);
//      printArray("After: ", myArray);
//   }
//   
//   // returns true if a modification was made to the array
//   public static boolean floatLargestToTop(String[] data, int top)
//   {
//      boolean changed = false;
//      String temp;
//      
//      // notice we stop at length -2 because of expr. k+1 in loop
//      for (int k =0; k < top; k++)
//         if (data[k].compareToIgnoreCase(data[k+1]) > 0)
//         {
//            temp = data[k];
//            data[k] = data[k+1];
//            data[k+1] = temp;
//            changed = true;
//         }
//      return changed;
//   }
//   
//    public static void arraySort(String[] array)
//    {
//       for (int k = 0; k < array.length; k++)
//          if ( !floatLargestToTop(array, array.length-1-k) )
//             return;
//    }
//    
//   // print out array with string as a title for the message box
//   public static void printArray(String title, String[] data)
//   {
//      
//      System.out.println("-------- " + title + " -------- ");
//      for (int k =0; k < data.length; k++)
//         System.out.println(data[k]);
//      System.out.println();
//
//   }
//}
