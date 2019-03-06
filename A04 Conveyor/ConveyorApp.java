//Student: Ahmad Rasoulpour
//Professor: Stanley Egwuonwu
//Assignment: A04 Conveyor

public class ConveyorApp
{
   public static void main(String[] args)
   {
      
      Conveyor flatBelt = new Conveyor("flat belt", 0.9);
      System.out.printf("Conveyor1: flat belt conveyor with a speed of %.1f m/s \n"
       ,flatBelt.getSpeed());
      System.out.printf("Time to transport an item 50 m: %.1f s \n",flatBelt.timeToTrasport(50));
      System.out.println();
      
      Conveyor roller = new Conveyor("roller", -0.5);
      System.out.printf("Conveyor2: roller conveyor with a speed of %.1f m/s \n"
       ,roller.getSpeed());
       System.out.printf("Time to transport an item 50 m: %.1f s \n",roller.timeToTrasport(50));
      System.out.println();
      
      System.out.println(".. updainting speed");
      System.out.println();
      
      //The input validation should notice that the value -3.0 is not valid and 
      //thus leave the speed unchanged (still 0.9)
      flatBelt.setSpeed(-3.0);
      //displays only one digit after the decimal point
      System.out.printf("Conveyor1: flat belt conveyor with a speed of %.1f m/s \n"
       ,flatBelt.getSpeed());
      System.out.printf("Time to transport an item 50 m: %.1f s \n",flatBelt.timeToTrasport(50));
      System.out.println();

      //valid value, this time it reflects the latest updates
      roller.setSpeed(0.4);
      System.out.printf("Conveyor2: roller conveyor with a speed of %.1f m/s \n"
       ,roller.getSpeed());
       System.out.printf("Time to transport an item 50 m: %.1f s \n",roller.timeToTrasport(50));
      System.out.println();
}
}