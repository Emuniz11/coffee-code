/*Eric Muniz
 * PP6 Chapter 10
 * Firm Example + Vacation Abstract Methods
 */
package company;

public class Volunteer extends StaffMember{
	
	public Volunteer(String name, String address, String phone){
		super(name,address,phone);
	}
	//Volunteers make no money
	public double pay(){
		return 0.0;
	}
	//Volunteers get no vacation days
	public int vacation(){
		return 0;
	}
}
