/*
 * Eric Muniz 
 * Doubly Linked Unordered List Implementation 
 * I was not able to make use of the Serialization interface
 */
package driver;

import java.io.IOException;
import student.Student;
import unorderedList.LinkedUnorderedList;

public class StudentDriver {

	public static void main(String[] args) throws IOException {
		
		//Introduction
		System.out.println("Hello! \nThis program will demonstrate the capabilities of "
				+ "a Doubly Linked Unordered List.\n");
		System.out.println("Lets start by making a Doubly Linked Unordered List "
				+ "made up of students.");
		System.out.println("The program also makes student variables however they "
				+ "are not yet instantiated.\n");
		
		//Variables need to test the LinkedUnorderedList and Student classes
		LinkedUnorderedList<Student> sList = new LinkedUnorderedList<Student>();
		Student s1,s2,s3,s4,s5;
		
		//Testing addToFront
		System.out.println("Now let's add Student 1 to the list.");
		sList.addToFront(s1 = new Student("Mathews", "Sally", "bs@alamo.edu"));
		
		//Testing first
		System.out.println("Let's see who signed up first.\n" + sList.first());
		System.out.println("Let's get some more people signed up.");
		
		//Testing addToRear
		System.out.println("Billy and Danny got here after Sally so they will be behinde her.");
		sList.addToRear(s2 = new Student("Bob", "Billy", "bb@alammo.edu"));
		sList.addToRear((s3 = new Student("DeVito", "Danny", "dd@alammo.edu")));
		
		//Testing addToFront
		System.out.println("Bill is an honors student and is allowed to skip ahead on the list.");
		sList.addToFront(s4 = new Student("Nieh", "Bill", "bn@alammo.edu"));
		
		//Testing addAfter
		System.out.println("Cindy is also an honors student but she got here after Bill so that"
				+ " means she will go after him on the list.");
		sList.addAfter(s5 = new Student("Lu", "Cindy", "cl@alammo.edu"), s4);
		
		//Testing toString
		System.out.println("\nNow we have the full list of students with them in the correct order.");
		System.out.println(sList);
		
		//Testing remove
		System.out.println("Unfortunetly a student has decided to be dropped."
				+ " So we need to take Sally off the list.");
		sList.remove(s1);
		
		//Testing toString
		System.out.println("Now we have our new list.\n" + sList);
		
		//Testing removeFirst and removeLast
		System.out.println("\nNow we will begin the interview process." 
				+ "We will have two interviewers.\nOne will start at the begining of the list"
				+ " and the other at the end.");
		System.out.println("Bill and Danny are first to interview.");
		sList.removeFirst();
		sList.removeLast();
		
		//Testing toString
		System.out.println("Now let's see who we have left on the list.");
		System.out.println(sList);
	}

}
