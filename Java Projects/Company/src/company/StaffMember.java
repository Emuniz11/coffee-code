/*Eric Muniz
 * PP6 Chapter 10
 * Firm Example + Vacation Abstract Methods
 */
package company;

abstract public class StaffMember {
	protected String name;
	protected String address;
	protected String phone;
	
	public StaffMember(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public String toString(){
		return "Name: " + name + "\nAddress: " + address + "\nPhone#: " + phone;
	}
	//Abstract methods to be overridden by sub classes
	public abstract double pay();
	public abstract int vacation();
}
