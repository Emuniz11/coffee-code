package calculate;

public class Rectangle {
	//instance data: always private
	private int length;
	private int width;
		
	
	//Default constructor: empty parameters
	public Rectangle(){
			length = 0;
			width = 0;
	}
	
	public Rectangle(int l, int w){
		length = l;
		width = w;
	}
	
	//Mutators
	public void setLength(int length){
		this.length = length;
	}
	public void setWidth(int width){
		this.width = width;
	}
	
	//Accesors
	public int getLength(){
		return length;
	}
	public int getWidth(){
		return width;
	}
	
	//other methods
	//for this to work you need a return type
	public int area(){
		return length * width;
	}
	
	//The toString Method:
	//always returns a string
	//always empty parameters constructed with 
	//instance variables (there are to IV in this program)
	public String toString(){
		String result = "";
		result = length + " " + width;
		return result;
	}
}
