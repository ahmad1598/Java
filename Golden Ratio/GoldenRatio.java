public class GoldenRatio
{
   private int number1;
   private int number2;
   
   public void GoldenRatiom (int num1, int num2)
   {
      number1 = num1;
      number2 = num2;
   }
   
   public boolean isGoldenRatio()
   {
      boolean result = false;
      double total = (double)number1/number2;
      total = (Math.round(total*1000)/1000.0);
      
      if (total == 1.618)
      {
         result = true;
      }
      else
      {
         result = false;
      }
      
      
      return result;
   }
   
}