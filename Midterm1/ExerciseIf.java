//Student: Ahmad Rasoulpour
//Professor: Stanley Egwuonwu
//Midterm1- CSIS-1400

import java.util.*;
public class ExerciseIf
{
   public static void main (String[] args)
   {
      //instance of Scanner
      Scanner input = new Scanner(System.in);
      System.out.print("Number: ");
      int number = input.nextInt();
      System.out.printf("2 x %d  = %d \n", number , 2 * number); 
      
      //checking if our number is 2-digit number
      if (number >= 10 && number <= 99)
      {
         System.out.printf("%d is a 2-digit number \n", number);
         
         System.out.println(".o\\\"/o.");
      }
   }
}
