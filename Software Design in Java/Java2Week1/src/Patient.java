class Patient
{
   public static final int MIN_LENGTH = 2;
   public static final int MAX_LENGTH = 40;
   public static final int MIN_ID = 0;
   public static final int MAX_ID = 9999;
   public static final double MIN_TEMP = 88.;
   public static final double MAX_TEMP = 111.;
   public static final double ALARM_TEMP = 103.5;
   public static final double DEFAULT_TEMP = 98.6;
   public static final String DEFAULT_NAME = "nobody";
   public static final int DEFAULT_ID = 0;
   
   private String name;
   private int id;
   private double temperature;

   Patient()
   {
      name = DEFAULT_NAME;
      temperature = DEFAULT_TEMP;
      id = DEFAULT_ID;
   }
   
   Patient(String name, double temperature, int id)
   {
      if ( !setName(name) )
         this.name = DEFAULT_NAME;
      if ( !setTemperature(temperature) )
         this.temperature = DEFAULT_TEMP;
      if ( !setID(id) )
         this.id = DEFAULT_ID;
   }
   
   public void display()
   {
      System.out.println(  "Patient: "
         + "\n  Name: " + name
         + "\n  ID: " + id
         + "\n  Body Temperature: " + temperature + " (F)" );
      if (temperature > ALARM_TEMP)
         System.out.println( "*** urgent: attend immediately ***");
   }
   
   // Accessors can be done in line:
   double getTemperature() { return temperature; }
   int getID() { return id; }
   String getName() { return name; }
   
   // mutators
   Boolean setTemperature(double temperature)
   {
      if (temperature < MIN_TEMP || temperature > MAX_TEMP)
         return false;
      this.temperature = temperature;
      return true;

   }
   Boolean setID(int id)
   {
      if (id < MIN_ID || id > MAX_ID)
         return false;
      this.id = id;
      return true;
   }
   Boolean setName(String name)
   {
      if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH)
         return false;
      this.name = name;
      return true;
   }
}