/** Eric Muniz
 *  Assignment 7 Option 2 (PP 9.4)
 */

package objects;

public class PlaneTicket implements Comparable<PlaneTicket>{
	//Basic Class used for QuickSort examples.
	//Instance Variables
	private String name;
	private Integer departure;
	private Integer arrival;
	
	//Constructors
	public PlaneTicket(){
		name = null;
		departure = 0;
		arrival = 0;
	}
	public PlaneTicket(String name, Integer departure, Integer arrival){
		this.name = name;
		this.departure = departure;
		this.arrival = arrival;
	}
	
	//ToString
	public String toString(){
		return "Name: " + name + " Departure: " + departure + " Arrival: " + arrival;
	}
	
	//CompareTo
	public int compareTo(PlaneTicket other) {
		int result;
		if(departure.equals(other.departure)){
			if(arrival.equals(other.arrival)){
				result = name.compareTo(other.name);
			}
			else{
				result = arrival.compareTo(other.arrival);
			}
		}
		else{
			result = departure.compareTo(other.departure);
		}
		return result;
	}
}
