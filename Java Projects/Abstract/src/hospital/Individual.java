/*Eric Muniz
 *Project No. 5 
 *Hospital Staff 
*/
package hospital;

abstract public class Individual {
	//Two characteristics all individuals have are name and age
	private String name;
	private int age;
	//Constructor Method
	public Individual(String name, int age){
		this.name = name;
		this.age = age;
	}
	//toString Method (This method is overridden)
	public String toString(){
		return "Name: " + name + "\nAge: " + age;
	}
	//Abstract methods that the child classes will have to implement
	public abstract String duty();
	public abstract double pay();
}
