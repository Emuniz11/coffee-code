/**Eric Muniz

  *Project No. 2

  *Use of Stack and Drop-out Stack data structures

**/
package test;

//Imported the necessary packages.
import stack.*;
import exceptions.EmptyStackException;
import queue.*;
import item.*;

public class Driver {

	public static void main(String[] args) {
		//****Using Stack with Player Class****
		System.out.println("Today is the national semi finals!" + 
		"\nLet the games begin!");
		//A Stack of Players is created.
		StackInterface<Player> pStack = new Stack<Player>(3);
		//Here is where players are added to the stack.
		pStack.push(new Player("Eric"));
		pStack.push(new Player("John"));
		pStack.push(new Player("Beth"));
		//The top of pStack is 3 which means if I add another Player then
		//the method will also run the expandCapcity method doubling the top variable.
		pStack.push(new Player("Andy"));
		//To use the Player methods I had to find a way to let StackInterface "access" the Player class.
		//I did this by creating an array to hold the popped players of pStack.
		//The array is of the Player Class and can use these methods.
		Player[] t = new Player[pStack.size()];
		
		for(int i=pStack.size()-1;i>=0;i--){
			t[i] = pStack.pop();
			t[i].play();
			t[i].decideRank();
		}
		//The players are returned to their original spots on the stack.
		for(int i=0;i<t.length;i++){
			pStack.push(t[i]);
		}
		
		System.out.println(pStack);
		
		//------------------------------------------------------------------------------------------------------------------------------------------
	    //****Using Drop Out Stack with Food Class****
		System.out.println("Time to eat!");
		//A Queue of Food is created.
		QueueInterface<Food> fStack = new Queue<Food>(3);
		//Adding some food to the queue.
		//Each time the method is called count is incremented by 1 and also
		//rear by 1 or jumps to zero if there is room.
		fStack.enqueue(new Food("Ice Cream"));
		fStack.enqueue(new Food("Burger"));
		fStack.enqueue(new Food("Eggs"));
		fStack.enqueue(new Food("Bacon"));
		//Place holder created to store what is in the queue.
		Food[] food = new Food[fStack.size()];
		//Had to keep these two instance variables for indexes.
		int p = ((Queue<Food>) fStack).begining();
		int v = fStack.size();
		for(int i=p;i<v;i++){		
			//After food is transfered, the methods are tested.
			food[i] = fStack.dequeue();
			System.out.println("I feel like eating " + food[i].getName());
			food[i].eat();
			food[i].outing();
		}
		//The food is back enqueue however there positions in the circular array are different.
		for(int i=0;i<v;i++){
			fStack.enqueue(food[i]);
		}
		
		System.out.println(fStack);
		
		//------------------------------------------------------------------------------------------------------------------------------------------
		//****Using More Stack****
		System.out.println("To begin, I will implement a data structure called a stack! \n"
				+ "In this case I will be using Integers as the data type.");
		//Stack of Integers is created.
		StackInterface<Integer> intStack = new Stack<Integer>(3);
		//Adding Integers.
		intStack.push(0);
		intStack.push(25);
		intStack.push(50);
		//Testing peeking and popping.
		System.out.println("Lets pop everything from the stack...");
		System.out.println("The size of the stack is " + intStack.size());
		System.out.println("This should be <PEEK> " + intStack.peak() + "\nPOP! " + intStack.pop());
		System.out.println("This should be <PEEK> " + intStack.peak() + "\nPOP! " + intStack.pop());
		System.out.println("This should be <PEEK> " + intStack.peak() + "\nPOP! " + intStack.pop());
		//Testing expand capacity method.
		System.out.println("Now let's PUSH 5 new numbers to test the expandCapacity method...");
		intStack.push(20);
		intStack.push(40);
		intStack.push(60);
		intStack.push(80);
		intStack.push(100);
		
		System.out.println("This should be <PEAK> " + intStack.peak() + "\nPOP! " + intStack.pop());
		//Testing size and toString method.
		System.out.println("The size of the stack is |Size| " + intStack.size());
		System.out.println("This is the data in the stack returned by the toString method \n" + intStack);
		//Testing the exception EmptyStackException.
		System.out.println("Now lets pop everything from the stack and test the EmptyStackException \nwhich will in turn use the isEmpty method.");
		System.out.println("This should be <PEEK> " + intStack.peak() + "\nPOP! " + intStack.pop());
		System.out.println("This should be <PEEK> " + intStack.peak() + "\nPOP! " + intStack.pop());
		System.out.println("This should be <PEEK> " + intStack.peak() + "\nPOP! " + intStack.pop());
		System.out.println("This should be <PEEK> " + intStack.peak() + "\nPOP! " + intStack.pop());
		
		try {
			System.out.println("This should be <PEEK> " + intStack.peak() + "\nPOP! " + intStack.pop());
		}catch (EmptyStackException e){
			System.out.println(e);
		}
		
		//------------------------------------------------------------------------------------------------------------------------------------------
		//****Using More Drop Out Stack****
		System.out.println("\n\nNow to implement the data structure called drop-out stack (circular array)!");
		System.out.println("The data type we will be using is String.");
		//Created a Queue of Strings.
		QueueInterface<String> strStack = new Queue<String>(3);
		//Strings are added to the queue.
		strStack.enqueue("Rosa");
		strStack.enqueue("Tyler");
		strStack.enqueue("James");
		
		System.out.println("I'll start by putting names enqueue.");
		System.out.println("The size of the stack is " + strStack.size());
		//Dequeuing all Strings.
		System.out.println("Now let's dequeue all the names...");
		System.out.println("Unlike the normal stack's method pop, the dequeue method returns the item in front of the array instead of the rear.");
		System.out.println("This should be " + strStack.first());
		System.out.println("Dequeue! " + strStack.dequeue());
		System.out.println("This should be " + strStack.first());
		System.out.println("Dequeue! " + strStack.dequeue());
		System.out.println("This should be " + strStack.first());
		System.out.println("Dequeue! " + strStack.dequeue());
		//One more dequeue will call the expandCapacity method.
		System.out.println("We will test the expandCapacity method now...");
		System.out.println("The current size of the strStack is " + strStack.size());
		//Testing toString.
		strStack.enqueue("Mark");
		strStack.enqueue("Zack");
		strStack.enqueue("Scott");
		strStack.enqueue("Mike");
		strStack.enqueue("Meagan");
		System.out.println("This is the data in the stack returned by the toString method \n" + strStack);
		//Testing size.
		System.out.println("The current size of the strStack is " + strStack.size());
		//Testing EmptyStackException.
		System.out.println("Let's try dequeue again to test the EmptyStackException");
		System.out.println("This should be " + strStack.first());
		System.out.println("Dequeue! " + strStack.dequeue());
		System.out.println("This should be " + strStack.first());
		System.out.println("Dequeue! " + strStack.dequeue());
		System.out.println("This should be " + strStack.first());
		System.out.println("Dequeue! " + strStack.dequeue());
		System.out.println("This should be " + strStack.first());
		System.out.println("Dequeue! " + strStack.dequeue());
		System.out.println("This should be " + strStack.first());
		System.out.println("Dequeue! " + strStack.dequeue());
		
		try {
			System.out.println("This should be " + strStack.first());
			System.out.println("Dequeue! " + strStack.dequeue());
		}catch (EmptyStackException e){
			System.out.println(e);
		}
	}

}
