package inheritance;

public class Driver {

	public static void main(String[] args) {
		Animal animal = new Animal(true);
		Bird bird = new Bird(true,"Blue",2);
		
		System.out.println(animal + "\n" + bird);
		
		bird.move();
		animal.move();
	}

}
