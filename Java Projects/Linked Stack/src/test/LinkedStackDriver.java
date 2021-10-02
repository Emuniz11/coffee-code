/**Eric Muniz
 * PP 3 Linked List with Enum
 */
package test;

import java.util.Scanner;

import exceptions.EmptyStackException;
import link.*;
import objects.Painting;
import objects.Painting.Genre;
import stack.*;

public class LinkedStackDriver {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		//Creates a new LinkedStack of Painting
		StackInterface<Painting> pStack = new LinkedStack<Painting>();
		
		//Testing isEmpty
		System.out.println("Lets make sure we are starting from nothing. Is pStack empty? " 
				+ pStack.isEmpty());
		System.out.println("Now lets put some objects in the linked stack.");
		
		//Testing push
		pStack.push(new Painting("Danny D.",Genre.ABSTRACT, "1700's"));
		pStack.push(new Painting("Michael A.",Genre.FANTASY,"1600's"));
		pStack.push(new Painting("Bobby B.",Genre.ENVIORMENTAL,"1980's"));
		pStack.push(new Painting("Calie Sea",Genre.LANDSCAPE,"2000's"));
		
		//Testing toString
		System.out.println("We will see what was pushed on the stack by demonstrating the toString method\n"
				+pStack);
		
		//Testing size
		System.out.println("We will now check the size of the linked stack. \npStack size is " 
				+pStack.size() + "\n");
		
		//Created holder variable for the size of the LinkedStack and an array of painting to hold the pStack elements
		Painting[] holder = new Painting[pStack.size()];
		int size = pStack.size();
		
		//popping everything off of pStack
		for(int i=size-1;i>=0;i--){
			holder[i] = pStack.pop();
		}
		
		//Testing getArtist, getEra, getGenre, and paintingDetails methods
		for(int i=size-1;i>=0;i--){
			System.out.println("This is " + holder[i].getArtist() + " and their peice is of the "
					+ holder[i].getEra() + " time period.\nThe genre is " + holder[i].getGenre() + ".");
			holder[i].paintingDetails();
			System.out.println();
		}
		
		System.out.println("Now let's test the EmptyStackException.");
		
		//Testing exception class
		try {
			System.out.println("This should be " + pStack.peak());
			System.out.println("Dequeue! " + pStack.pop());
		}catch (EmptyStackException e){
			System.out.println(e);
		}
		
		//Putting back elements into pStack
		for(int i=0;i<size;i++){
			pStack.push(holder[i]);
		}
		
		//Testing peak
		System.out.println("Now let's add everything back to the stack and take a PEAK.");
		System.out.println(pStack.peak());
		
		System.out.println("Let's change this one that we PEAKed at.");
		
		//Testing setters in Painting class
		pStack.peak().setArtist("Holly H.");
		pStack.peak().setGenre(Genre.ABSTRACT);
		pStack.peak().setEra("1850's");
		
		//Another peak test
		System.out.println("Now lets take another PEAK. " + pStack.peak());
		
		//Test toString
		System.out.println("One last look at the stack in its toString form." + "\n" + pStack);
	
	}

}
