/*Eric Muniz
 * PP6 Chapter 10
 * Firm Example + Vacation Abstract Methods
 */
package company;

public class Executive extends Employee{
	private double bonus;
	//Added paidVacation instance
	private int paidVacation;
	//Initialized bonus and paidVaction to 0
	public Executive(String name, String address, String phone, String ssNum, Double payRate){
		super(name,address,phone,ssNum,payRate);
		bonus = 0;
		paidVacation = 0;
	}
	//Awards bonus to Executive
	public void awardBonus(double bonus){
		this.bonus = bonus;
	}
	//Continued toString
	public String toString(){
		return super.toString() + "\nBonus: " + bonus;
	}
	//Returns pay + bonus as well as reinitialize bonus to 0
	public double pay(){
		double payment = super.pay() + bonus;
		bonus = 0;
		return payment;
	}
	//This will add paidVacationDays to Executive
	public void addPaidVacation(int weeks){
		paidVacation += weeks;
	}
	//Overridden vacation to add vacationDays to paidVacation
	public int vacation(){
		return super.vacation() + paidVacation;
	}
}
