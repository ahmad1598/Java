public class HoppityHop
{
   public static void main(String[] args)
   {
      int number = 1;
      while(number < 26)
      {
         if (((number % 5)== 0) && ((number % 3) == 0))
         {
            System.out.println("Hoppity Hop");
         }
         
         else if((number % 5)== 0)
         {
            System.out.println("Hop");
         }
         
         else if ((number % 3) == 0)
         {
            System.out.println("Hoppity");
            
         }
         
         else{
         System.out.println(number);
         }
         number++;
      }
   }
}