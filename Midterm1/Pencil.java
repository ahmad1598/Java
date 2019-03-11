//Student: Ahmad Rasoulpour
//Professor: Stanley Egwuonwu
//Midterm1- CSIS-1400

public class Pencil
{
   //fields
   private int length;
   private String color;
   
   
   //constructor
   public Pencil(int l , String c)
   {  
      length = l;
      color = c;
      
   }
   //
   public int getLength()
   { 
       return length;
   }
   public String getColor()
   {
      return color;
   }
   public int sharpen()
   {
      
      
      if (length > 5)
      {
         length--;
      }
      return length;
   }
   
}