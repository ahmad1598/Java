public class LabChar
{
   public static void main (String [] args)
   {
      char dash = '-';
      System.out.printf("Dash:%c \n",dash);
      char a = 'a';
      char letter = a;
      char b = ++letter;
      char c = ++letter;
      letter += 2;
      char e = letter;
      
      System.out.printf("letter:%c a:%c b:%c c:%c e:%c \n", letter, a , b , c , e);
      
      char copyrightSign = '\u00A9';
      
      int copyNumber = (int)copyrightSign;
      
      System.out.printf("Copyright Sign: %c %d %X \n", copyrightSign, copyNumber, copyNumber);
      
      char yen = '\u00A5';
      int yenNumber = (int)yen;
      System.out.printf("Yen: %c %d %X", yen, yenNumber, yenNumber);
      
   }
}