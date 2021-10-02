/*Eric Muniz
 * PP6 Chapter 10
 * Firm Example + Vacation Abstract Methods
 */
package company;

public class Hourly extends Employee{
	private int hoursWorked;
	//Constructor
	public Hourly(String name, String address, String phone, String ssNum, Double payRate){
		super(name,address,phone,ssNum,payRate);
		hoursWorked = 0;
	}
	//Setter for hourly work
	public void addHours(int add){
		hoursWorked += add;
	}
	//Overridden pay
	public double pay(){
		double  payment= payRate * hoursWorked;
		hoursWorked = 0;
		return payment;
	}
	//Continued String
	public String toString(){
		return super.toString() + "\nCurrent Hours: " + hoursWorked;
	}
	//Setter for vacationDays
	public void useDays(int use){
		vacationDays -= use;
	}
	//Overridden vacation
	public int vacation(){
		return vacationDays;
	}
}
