/*Eric Muniz
 * PP3
 * Student & Course Objects
 */
package student_course;

//Neccessary to import ArrayList
import java.util.ArrayList;

public class Course {
	private String courseName;
	//ArrayList of Students
	private ArrayList<Student> attendies = new ArrayList<Student>();
	//Count will equal to the number of students in a course
	private int count;
	
	//---------Constructor---------
	public Course(String courseName){
		this.courseName = courseName;
		count = 0;
	}
	
	//---------Mutator---------
	public void addStudent(Student student){
		attendies.add(student);
		count++;
	}
	
	//---------Accessor---------
	public String getCourseName(){
		return courseName;
	}
	
	//---------Misc---------
	//Returns the average of all the students' averages in a course
	public int courseAverage(){
		Student[] array = attendies.toArray(new Student[attendies.size()]);
		//For some reason could not use ArrayList correctly in this loop
		//Changed ArrayList to array for easier use
		int avg = 0;
		for(int i=0;i<count;i++){
			avg = avg + array[i].average();
		}
		avg = avg / count;
		return avg;
	}
	
	//---------"toString"---------
	public String roll(){
		String r = "";
		for (int i=0;i<count;i++){
			r = r + attendies.get(i) + "\n";
		}
		return r;
	}
	
}
