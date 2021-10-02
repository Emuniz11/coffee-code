/*Eric Muniz
 * PP6 Chapter 10
 * Firm Example + Vacation Abstract Methods
 */
package company;

public class Staff {
	private StaffMember[] staffList;
	
	public Staff(){
		staffList = new StaffMember[5];
		
		staffList[0] = new Executive("Sam","123 Main dr.","1234567898","###-##-####",2423.07);
		staffList[1] = new Employee("Carla","456 Off Line","2222222222","###-##-####",1246.15);
		staffList[2] = new Employee("Woody","789Off Rocker","4556223993","###-##-####",1169.23);
		staffList[3] = new Hourly("Diane","678 Avenue","8884561238","###-##-####",10.55);
		staffList[4] = new Volunteer("Norm","987 Treedom","2541684947");
		//Use the methods casting when needed
		((Executive)staffList[0]).awardBonus(500.00);
		((Hourly)staffList[3]).addHours(40);
		//These are the methods the project asks for
		//Adds Days to an hourly Employee
		((Hourly)staffList[3]).useDays(12);
		//Adds more vacation days to Executive Employees
		((Executive)staffList[0]).addPaidVacation(14);
		//An employee uses some of their vacation days
		((Employee)staffList[2]).useV(9);
	}
	
	public void payDay(){
		double amount;
		for(int i=0;i<staffList.length;i++){
			//This displays the name, address, phone#, and ssNum
			System.out.println(staffList[i]);
			//This will display the total number of vacation days a StaffMember has
			System.out.println("Vacation Days: " + staffList[i].vacation());
			//This pays employees with their respective payRate
			amount = staffList[i].pay();
			//Displays paidRate unless the StaffMember is an volunteer
			if(amount==0.0){
				System.out.println("Thanks!");
			}
			else{
				System.out.println("Paid: " + amount);
			}
			System.out.println("----------------------");
		}
	}
}
