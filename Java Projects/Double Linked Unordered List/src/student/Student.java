/*
 * Eric Muniz 
 * Doubly Linked Unordered List Implementation 
 * I was not able to make use of the Serialization interface
 */
package student;

import java.io.Serializable;
import java.io.*;

public class Student implements Serializable {
	//Instance Variables
	private String lastName;
	private String firstName;
	private String emailAddress;
	private String emailMsg;
	private String isPresent;
	
	//Constructor
	public Student(String lastName, String firstName, String emailAddress) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.emailAddress = emailAddress;
	}
	
	//Mutators
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setEmailAdress(String emailAddress){
		this.emailAddress = emailAddress;
	}
	
	//Accessors
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getEmailAddress(){
		return emailAddress;
	}
	
	public String getFullName(){
		return firstName + " " + lastName;
	}
	
	//For serialization
	public void save(String fileName) throws IOException{
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);;
		oos.flush();
		oos.close();
	}
	
	public static Student load(String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student pos = (Student) ois.readObject();
		ois.close();
		return pos;
	}

}
