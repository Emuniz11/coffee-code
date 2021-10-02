/*Eric Muniz
 * PP6 Chapter 10
 * Firm Example + Vacation Abstract Methods
 */
package company;
//Sub class of StaffMember
public class Employee extends StaffMember{
	protected String ssNum;
	protected double payRate;
	protected int vacationDays;;
	//Added vacationDays to the constructor and initialized it to 14 
	public Employee(String name, String address, String phone, String ssNum, Double payRate){
		super(name,address,phone);
		this.ssNum = ssNum;
		this.payRate = payRate;
		vacationDays = 14;
	}
	//This toString method will keep the toString complete in terms of where the StaffMember is in the hierarchy 
	public String toString(){
		return super.toString() + "\nSocial Security#: " + ssNum;
	}
	//Returns payRate to be used more with child class
	public double pay(){
		return payRate;
	}
	//Lets employee use there vacation days
	public void useV(int use){
		vacationDays -= use;
	}
	//Allows the Employee to use their vacation days
	public int vacation(){
		return vacationDays;
	}
}
