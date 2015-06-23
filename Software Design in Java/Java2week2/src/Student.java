class Student
{
   private String lastName;
   private long totalPoints;
   
   // constructor requires parameters - no default supplied
   public Student( String lastNm,long pts)
   {
      lastName = "zz-error";
      totalPoints = 0;
      // at least require that it stars with a letter
      if (lastNm != null && Character.isLetter(lastNm.charAt(0)))
         lastName = lastNm;
      if (pts >= 0 && pts <= 1000)
         totalPoints = pts;    
   }
   
   public String toString()
   {
      String strStudent = lastName + " Points: " + totalPoints;
      return strStudent;
   }
 
   // print out array with string as a title for the message box
   public static void printArrayConsole(String title, Student[] data)
   {
      
      System.out.println("\n********** " + title + " **********\n");
      for (int k =0; k < data.length; k++)
         System.out.println( data[k].toString() );
      System.out.println();
  }

   // returns true if a modification was made to the array
   private static boolean floatLargestToTop(Student[] data, int top)
   {
      boolean changed = false;
      Student temp;
      
      // notice we stop at length -2 because of expr. k+1 in loop
      for (int k =0; k < top; k++)
        if (data[k].lastName.compareToIgnoreCase(data[k+1].lastName) > 0)
        {
           temp = data[k];
           data[k] = data[k+1];
           data[k+1] = temp;
           changed = true;
        }
      return changed;
   }
   
    public static void arraySort(Student[] array)
    {
       for (int k = 0; k < array.length; k++)
          if ( !floatLargestToTop(array, array.length-1-k) )
             return;
    }
    
    public static int binarySearch(Student[] array, String keyLast,
       int firstIndex, int lastIndex)
    {
       int middleIndex, result;
       
       if (firstIndex > lastIndex)
          return -1;
       middleIndex = (firstIndex + lastIndex) / 2;
       result = keyLast.compareToIgnoreCase(array[middleIndex].lastName);
       
       if (result==0)
          return middleIndex;   //found him!
       else if (result < 0)
          return binarySearch(array, keyLast, firstIndex, middleIndex-1);
       else
          return binarySearch(array, keyLast, middleIndex+1, lastIndex); 
    }
}
//class Student
//{
//   private String lastName;
//   private String firstName;
//   long totalPoints;
//   
//   // constructor requires parameters - no default supplied
//   public Student( String lst, String fst, long pts)
//   {
//      lastName = firstName = "zz-error";
//      totalPoints = 0;
//      // at least require that it stars with a letter
//      if (lst != null && Character.isLetter(lst.charAt(0)))
//         lastName = lst;
//      if (fst != null && Character.isLetter(fst.charAt(0)))
//         firstName = fst;
//      if (pts >= 0 && pts <= 1000)
//         totalPoints = pts;    
//   }
//   
//   public String toString()
//   {
//      String strStudent = lastName + ", " + firstName 
//            + " Points: " + totalPoints;
//      return strStudent;
//   }
// 
//   // print out array with string as a title for the message box
//   public static void printArrayConsole(String title, Student[] data)
//   {
//      
//      System.out.println("\n********** " + title + " **********\n");
//      for (int k = 0; k < data.length; k++)
//         System.out.println( data[k].toString() );
//      System.out.println();
//  }
//    
//   public static int arraySearch(Student[] array, 
//         String keyFirst, String keyLast)
//   {
//      for (int k = 0; k < array.length; k++)
//         if ( array[k].lastName.equals(keyLast) 
//               && array[k].firstName.equals(keyFirst) )
//            return k;  // found match, return index
//         
//      return -1;   // fell through - no match  
//   }
//}