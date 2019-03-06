//Student: Ahmad Rasoulpour
//Professor: Stanley Egwuonwu
//Assignment: A04 Conveyor

public class Conveyor
{
   // fields
   private String type;
   private double speed;
    
   // constructors 
   public Conveyor(String type, double speed) // Constructor has some input or parameters
   {
      //checking to make sure that speed is not negative
      if (speed > 0){
      this.type = type;
      this.speed = speed;
      }
   }
   
   // methods
   
   // setter has some input or parameters
   public void setSpeed(double speed) 
   {
      if (speed>0)
      {
      this.speed = speed;
      }
   }
   
   // getter does'nt have any input or parameters /
   // has some output or return.
   public String getType() 
   { 
      return type;
   }
   
   public double getSpeed()
   {
      return speed;
   }
   
   //The method timeToTransport requires some calculation
   public double timeToTrasport(double distance)
   { 
     distance = distance / speed;
     return distance;
   }  
}