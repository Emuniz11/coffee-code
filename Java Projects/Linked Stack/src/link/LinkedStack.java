/**Eric Muniz
 * PP 3 Linked List with Enum
 */
package link;

import exceptions.EmptyStackException;
import objects.Painting;
import objects.Painting.Genre;
import stack.LinearNode;
import stack.StackInterface;

public class LinkedStack<T> implements StackInterface<T>{
	//count is the size of the linked stack
	private int count;
	//top refers to the LinearNode that has been most recently added
	private LinearNode<T> top;
	
	//Contructors
	public LinkedStack(){
		count = 0;
		top = null;
	}
	public LinkedStack(T element){
		LinearNode<T> node = new LinearNode<T>(element);
		top = node;
		count = 1;
	}
	
	//This method pushes an object onto the linked stack
	public void push(Object e) {
		//Creates a new link
		LinearNode<T> node = new LinearNode<T>((T) e);
		//if the stack is empty then basically the contructor is called
		if (isEmpty()){
			top = node;
			count = 1;
		}
		//if not then increment count
		//top is now the newly added node
		//sets the link to the current top
		else{
			node.setNext(top);
			top = node;
			count++;
		}	
	}
	
	//This method return the top element on the linked stack.
	public T pop() throws EmptyStackException {
		if(isEmpty()){
			throw new EmptyStackException();
		}
		//the top element gets put into a holding variable
		T result = top.getElement();
		//top is essentially "decrement" to the previous node
		top = top.getNext();
		//decrement count because the size decreases
		count--;
		return result;
	}
	
	//Return the top element
	public T peak() throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException();
		}
		T result = top.getElement();
		return result;
	}
	
	//Returns the size of the linked stack. This is also the next available position
	public int size() {
		return count;
	}
	
	//Return true if the linked stack has elements
	public boolean isEmpty() {
		return count == 0;
	}
	
	//toString
	public String toString(){
		//result holds all the elements
		String result = "";
		//current will hold top node
        LinearNode<T> current = top;
        //if there is no next then the loop will stop
        while(current.getNext() != null){
        	result += current.getElement() + "\n";
            current = current.getNext();   
        }
        //this will add the final element
        result += current.getElement();
        return "List: \n" + result;
	}
}
