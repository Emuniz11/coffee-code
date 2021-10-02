/*Eric Muniz
 *Project No. 5 
 *Hospital Staff 
*/
package hospital;

public class Hourly extends Employee {
	//Hours will be used to calculate an hourly employee's wage
	private double hours;
	//Constructor Method that account for super classes
	public Hourly(String name, int age, double payRate, String job){
		super(name,age,payRate,job);
		hours = 0;
	}
	//Add hours to an employee
	public void addHours(int add){
		hours += add;
	}
	//This method pays the employee their pay rate times their hours worked
	public double pay(){
		double fullPay = payRate * hours;
		hours = 0;
		return fullPay;
	}
	//toString Method
	public String toString(){
		String result = super.toString();
		return result += "\nPay Rate: $" + payRate + "\nHours Worked: $" + hours;
	}
}
