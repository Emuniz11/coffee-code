/*Eric Muniz
 *Project No. 5 
 *Hospital Staff 
*/
package hospital;

public class Employee extends Individual {
	//I decided to go with pay rate and job title as the employee characteristics
	//The title will let the program know which action to take
	protected double payRate;
	protected String job;
	//Constructor Method that account for super class
	public Employee(String name, int age, double payRate, String job){
		super(name,age);
		this.payRate = payRate;
		this.job = job;
	}
	//toString Method
	public String toString(){
		String result = super.toString();
		return result += "\nPosition: " + job;
	}
	//Overriding pay so that the method return the pay rate
	/*pay is overridden*/
	public double pay(){
		return payRate;
	}
	//This is where employee action takes place
	//could not justify creating separate classes for each job
	//so I took this approach. Based on the job title the employee 
	//performs a certain action.
	/*Also I used ternary conditional statements*/
	/*duty is overridden*/
	public String duty(){
		String action = "";
		//Not an employee
		action = (job=="None")? "I do not work here.": action;
		//Receptionist
		action = (job=="Reception")? "Hello! have you made an appointment?": action;
		//Nurse
		action = (job=="Nurse")? "All I need to do is check the patients blood pressure.": action;
		//Doctor
		action = (job=="Doctor")? "The nurse tells me you have been feeling faint, will you expand?": action;
		//Surgeon
		action = (job=="Surgeon")? "I will be preforming an amputation later today.": action;
		//Administrator 
		action = (job=="Administrator")? "I implement new technology in the hospital.": action;
		//Janitor
		action = (job=="Janitor")? "*Mopping*": action;
		//Clerk
		action = (job=="Clerk")? "Your change is $3.00.": action;
		//Food Handler
		action = (job=="Food")? "We have a soup special today.": action;
		return action;
	}
}
