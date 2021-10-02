package calculate;

public class RectangleDriver {

	public static void main(String[] args) {
		//create Rectangle objects
		Rectangle rec1 = new Rectangle();
		Rectangle rec2 = new Rectangle(12,12);
		
		//Calling mutators
		rec1.setLength(10);
		rec1.setWidth(10);
		
		//toString methods automatically called 
		//within a System.out.print statement
		System.out.println("Rec 1 is " + rec1);
		System.out.println("Rec 2 is " + rec2);
		
		System.out.println("Rec 1's length is " + rec1.getLength());
		System.out.println("Rec 1's width is " + rec1.getWidth());
		
		System.out.println("Rec 1's area is " + rec1.area());
		System.out.println("Rec 2's area is " + rec2.area());

	}

}
