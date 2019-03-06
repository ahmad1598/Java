//student: Ahmad Rasoulpour
//Professor: Stanley Egwuonwu
//Course: CSIS - 1400
//Assignment: A02 Ski Tickets

import java.util.*;
public class SkiTickets
{
   public static void main (String [] args)
   {
      //create and instantiate input and input2 object from Scanner class
      Scanner input = new Scanner(System.in);
      Scanner input2 = new Scanner(System.in);      
      
      //asking user to put number fo adult tickets
      System.out.print("Number of adult tickets: ");
      
      //create new variable for holding user's string. 
      //using nextLine method for allow user to put multiple words
      double adultTick = input.nextDouble();
      
      //asking user to put number fo youth tickets
      System.out.print("Number of youth tickets: ");
      double youthTick = input.nextDouble();
      
      //asking user to put name
      System.out.print("Name: ");
      String name = input2.nextLine();
      
      //print empty lines
      System.out.printf("%n");
      System.out.printf("%n");
      
      //starting print out Outputs
      System.out.printf("Invoice for %s:%n", name);
      System.out.println();
      //print out and calculate tickets base on ticket price
      System.out.printf("Adult tickets  %2.0f  .. $ %2.2f %n", adultTick,(adultTick * 93));
      System.out.printf("Youth tickets  %2.0f  .. $ %2.2f %n", youthTick,(youthTick * 47));
     
      System.out.println("------------------------------");
      
      //print out total result and showing on the right align
      System.out.printf("%23c %.2f %n", '$' ,((adultTick * 93) + (youthTick * 47)));
      System.out.printf("%-30s","========");
   }
}