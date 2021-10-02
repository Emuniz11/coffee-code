package inheritance;

public class Animal {
	private boolean warmBlooded;
	private String foodType;
	
	//So to create an animal you must include true/false in this case because it requires
	//one parameter.
	public Animal (boolean warm){
		warmBlooded = warm;
		foodType = "UNKNOWN";
	}
	public void eat(String food){
		foodType = food;
	}
	public void move(){
		System.out.println("I am moving.");
	}
	public String toString(){
		return "WarmBlooded: " + warmBlooded + "\nFoodType: " + foodType;
	}
}
