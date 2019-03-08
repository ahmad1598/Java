public class GoldenRatioApp
{
   private int number1;
   private int number2;
   
   public static boolean isGoldenRatio (int num1, int num2) 
   {
            
      boolean result;

      double total = num1/num2;
      
      if (Math.round(total) == 1.618)
      {
         result = true;
      }
      else
      {
         result = false;
      }
      return result;

   }
   public static void main(String[] args) 
   { 
     int number1 = 100004;
     int number2 = 161800;
     System.out.printf("isGoldenRatio(%d,%d): %b%n", 
         number1, number2, isGoldenRatio(number1, number2));    
   }

}