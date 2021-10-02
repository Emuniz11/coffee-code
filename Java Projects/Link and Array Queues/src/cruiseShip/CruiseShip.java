/**Eric Muniz

  *Project No. 4

  *Use of Queue With Linked & Circular Array 

**/
package cruiseShip;

public class CruiseShip {
	//Destination is an enum for ease of use
	public enum Destination {
		FLORIDA,JAMAICA,ALASKA,CALIFORNIA,HAWAII
	}
	
	//Instance Variables
	private int fair;
	private int travelTime;
	private Destination destination;
	
	//Constructors
	public CruiseShip(Destination destination){
		fair = 0;
		travelTime = 0;
		//Everything will depend on the destination.
		this.destination = destination;
	}
	public CruiseShip(){
		fair = 0;
		travelTime = 0;
		destination = null;
	}
	
	//This is where most of the information comes from.
	//Depending on the destination there will be an appropriate cost and travel time.
	public void travelInfo(){
		switch(destination){
		case ALASKA:
			System.out.println("It might be alittle dark if you travel here in the summer.");
			travelTime = 23;
			fair = 435;
			break;
		case JAMAICA:
			System.out.println("Some of the best jerk chicken I have ever eaten was in Jamaica.");
			travelTime = 14;
			fair = 345;
			break;
		case FLORIDA:
			System.out.println("Watch out for the aligators!");
			travelTime = 12;
			fair = 220;
			break;
		case CALIFORNIA:
			System.out.println("Bring extra money because this place is expensive.");
			travelTime = 13;
			fair = 275;
			break;
		case HAWAII:
			System.out.println("You will be laid upon arrival.");
			travelTime = 19;
			fair = 405;
			break;
		}
	}
	
	//Getters
	public int getTravelTime(){
		return travelTime;
	}
	
	public int getFair(){
		return fair;
	}
	
	public Destination getDestination(){
		return destination;
	}
	
	//toString
	public String toString(){
		return "Destination: " + destination + "\nCost: $" + fair + "\nTravel Time: " + travelTime + " hours";
	}

}