/**Eric Muniz

  *Project No. 2

  *Use of Stack and Drop-out Stack data structures

**/
package item;
//Used Random so I had to import it
import java.util.Random;

public class Food {
	//Instance Variables
	private String name;
	private int cost;
	//Constructors
	public Food(){
		name = null;
		cost = 0;
	}
	public Food(String name){
		this.name = name;
		cost = 0;
	}
	//Prints out Yum!
	public void eat(){
		System.out.println("Yum!");
	}
	//Returns name.
	public String getName(){
		return name;
	}
	//The cost of the food is randomly calculated and printed
	public void outing(){
		Random rand = new Random();
		cost = rand.nextInt(11);
		System.out.println("Your bill is $" + cost);
	}
	
	public String toString(){
		return name + ": $" + cost;
	}
}
