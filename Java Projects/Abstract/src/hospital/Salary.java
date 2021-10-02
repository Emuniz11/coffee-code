/*Eric Muniz
 *Project No. 5 
 *Hospital Staff 
*/
package hospital;

public class Salary extends Employee{
	//A bonus can be given to salary wage employees
	private double bonus;
	//Constructor Method w/ super to account for the super class constructor
	public Salary(String name, int age, double payRate, String job){
		super(name,age,payRate,job);
	}
	//This method adds a bonus
	public void addBonus(double add){
		bonus = bonus + add;
	}
	//This method adds the bonus to the salary
	public double pay(){
		double fullPay = payRate + bonus;
		bonus = 0;
		return fullPay;
	}
	//toString Method Overridden
	public String toString (){
		String result = super.toString();
		return result += "\nPay Rate: $" + payRate + "\nBonus: $" + bonus;
	}

}
