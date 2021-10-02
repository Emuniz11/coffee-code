package inheritance;

public class Bird extends Animal {
	private String color;
	private Double beakLength;
	
	public Bird(boolean warm, String color, double length){
		//Calling parent constructor because constructors are not inherited ever.
		super(warm);
		this.color = color;
		length = 1.0;
	}
	
	public String toString(){
		return super.toString() + "\nColor: " + color + "\nBeakLength: " + beakLength;
	}
	
	//Overriding the parent class here.
	public void move(){
		System.out.println("I am flying...");
	}
	
}
