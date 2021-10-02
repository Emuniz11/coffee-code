package speaker;

public class Philosopher implements Speaker{
	private String name;
	public Philosopher(String name){
		this.name = name;
	}
	public void speak(){
		System.out.println("Contemplating..always..");
	}
	public void pontificate(){
		System.out.println ("I am sophisticated\n"
				+ "Always pondering...");
	}
	public String toString(){
		return name;
	}
}
