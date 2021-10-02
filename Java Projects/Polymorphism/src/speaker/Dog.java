package speaker;

public class Dog implements Speaker{
	private String name;
	private int age;
	public Dog(String name, int age){
		this.name = name;
		this.age = age;
	}
	public void speak(){
		System.out.println("Barking at you !");
	}
	public String toString(){
		return name + " " + age;
	}
}
