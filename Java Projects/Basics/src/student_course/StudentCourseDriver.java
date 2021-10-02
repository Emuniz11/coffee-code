/*Eric Muniz
 * PP3
 * Student & Course Objects
 */
package student_course;

public class StudentCourseDriver {

	public static void main(String[] args) {
		//Created five students
		Student stu1 = new Student("Bob", 20);
		Student stu2 = new Student("Crystal", 21);
		Student stu3 = new Student("Daniel", 25);
		Student stu4 = new Student("Beth", 19);
		Student stu5 = new Student("Dillan", 23);
		//And two courses
		Course course1 = new Course("Astrophysics");
		Course course2 = new Course("Biochemistry");
		//Here I set the students grades for the three tests
		stu1.setTestScore(1, 100);
		stu1.setTestScore(2, 85);
		stu1.setTestScore(3, 92);
		stu2.setTestScore(1, 98);
		stu2.setTestScore(2, 88);
		stu2.setTestScore(3, 82);
		stu3.setTestScore(1, 75);
		stu3.setTestScore(2, 82);
		stu3.setTestScore(3, 63);
		stu4.setTestScore(1, 98);
		stu4.setTestScore(2, 86);
		stu4.setTestScore(3, 89);
		stu5.setTestScore(1, 99);
		stu5.setTestScore(2, 98);
		stu5.setTestScore(3, 99);
		//Here I added students to the courses
		course1.addStudent(stu2);
		course1.addStudent(stu4);
		course1.addStudent(stu5);
		course2.addStudent(stu1);
		course2.addStudent(stu3);
		//Execution of methods
		System.out.println("Students/Test Scores:\n");
		System.out.println(stu1);
		System.out.println(stu2);
		System.out.println(stu3);
		System.out.println(stu4);
		System.out.println(stu5);
		
		System.out.println("\nCourses:\n");
		System.out.println(course1.getCourseName());
		System.out.println(course1.roll());
		
		System.out.println("\n");
		System.out.println(course2.getCourseName());
		System.out.println(course2.roll());
		
		System.out.println("\nCourse Averages:\n");
		System.out.println(course1.getCourseName() + ": " + course1.courseAverage());
		System.out.println(course2.getCourseName() + ": " + course2.courseAverage());
	}

}
