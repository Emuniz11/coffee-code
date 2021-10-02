/*Eric Muniz
 *Project No. 5 
 *Hospital Staff 
*/
package hospital;

public class HospitalDriver {

	public static void main(String[] args) {
		//Created 9 individuals to use as employees
		Individual[] staff = new Individual[9];
		//Gave each individual a name, age, pay rate, and job title
		staff[0] = new Salary("Rosa",22,220000,"Doctor");
		staff[1] = new Salary("Daniel",28,65000,"Nurse");
		staff[2] = new Hourly("Tina",27,20,"Reception");
		staff[3] = new Salary("Brian",31,310000,"Surgeon");
		staff[4] = new Salary("Beth",43,120000,"Administrator");
		staff[5] = new Hourly("Tanner",18,14,"Janitor");
		staff[6] = new Hourly("Grace",17,15,"Clerk");
		staff[7] = new Hourly("Jeff",47,17,"Food");
		staff[8] = new Salary("UNKNOWN",0,0,"None");
		//This will award add bonuses and hours
		((Salary)staff[0]).addBonus(50000);
		((Hourly)staff[2]).addHours(32);
		((Salary)staff[3]).addBonus(75000);
		((Salary)staff[4]).addBonus(7000);
		((Hourly)staff[5]).addHours(47);
		((Hourly)staff[6]).addHours(25);
		((Hourly)staff[7]).addHours(11);		
		//The for loop will print all the employees information along with any bonuses or hours worked and a description 
		//of what action they are taking
		for (int count=0; count < staff.length; count++){ 
			double amount;
			System.out.println(staff[count]);
			amount = staff[count].pay(); 
			//If the individual does not work at the hospital this message appears
			if (amount == 0.0)
				System.out.println("Oops!"); 
			//Otherwise the program print the wage being paid and their appropriate action
			else System.out.println("Paid: $" + amount);
			System.out.println(staff[count].duty());
			System.out.println("-----------------------------------"); 
		} 
	}

}
