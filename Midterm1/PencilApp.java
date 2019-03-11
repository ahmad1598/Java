//Student: Ahmad Rasoulpour
//Professor: Stanley Egwuonwu
//Midterm1- CSIS-1400

public class PencilApp
{
   public static void main(String[] args)
   {
      //instance of Pencil
      Pencil myPencil = new Pencil(7 , "yellow");
      
      System.out.printf("myPencil has the color %s\n", myPencil.getColor());
      System.out.printf("myPencil has length %d\n", myPencil.getLength());
      
      //sharpen the pencil twice
      myPencil.sharpen();
      myPencil.sharpen();
      
      System.out.printf("After sharpening twice myPencil has length %d\n", myPencil.getLength());
      
      //sharpen the pencil on more time
      myPencil.sharpen();
      System.out.printf("After calling sharpen again the length is still %d \n ", myPencil.getLength());
   }
}