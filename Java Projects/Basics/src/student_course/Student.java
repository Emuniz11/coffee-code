/*Eric Muniz
 * PP3
 * Student & Course Objects
 */
package student_course;

public class Student {
	//Included what our last Student object was
	private String last;
	private int age;
	//Here are the test scores 1, 2, and 3 instances
	public int testScore1;
	public int testScore2;
	public int testScore3;
		
	//---------Constructors---------
	public Student(String last, int age){
		this.last = last;
		this.age = age;
	}
	public Student(int testScore1, int testScore2, int testScore3){
		this.testScore1 = testScore1;
		this.testScore2 = testScore2;
		this.testScore3 = testScore3;
	}
	//Overloaded Constructor so that all test score values are assumed to be zero
	public Student(){
		testScore1 = 0;
		testScore2 = 0;
		testScore3 = 0;
	}
		
	//---------Mutator---------
	public void setTestScore(int testNum, int score){
		if (testNum == 1){
			this.testScore1 = score;
		}
		else if (testNum == 2){
			this.testScore2 = score;
		}
		else {
			this.testScore3 = score;
		}
	}
		
	//---------Accessors---------
	public int getTestScore(int testNum){
		if (testNum == 1){
			return testScore1;
		}
		else if (testNum == 2){
			return testScore2;
		}
		else {
			return testScore3;
		}
	}
		
	public int getAge(){
		return age;
	}
		
	public String getName(){
		return last;
	}
		
	//---------toString---------
	public String toString(){
		return "Name: " + last + "\nAge: " + age + "\nTest Scores:\n1. " + testScore1 + "\t2. "
				+ testScore2  + "\t3. " + testScore3;
	}
		
	//---------Misc---------
	//Gets the average of all 3 of a students test scores
	public int average(){
		int avg = (testScore1+testScore2+testScore3)/3;
		return avg;
	}
}
