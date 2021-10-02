/**Eric Muniz

  *Project No. 4

  *Use of Queue With Linked & Circular Array 

**/
package linkedQueue;

import exceptions.EmptyQueueException;
import linkedQueue.LinearNode;

public class LinkedQueue<T> implements QueueInterface<T>{
	//Instance Variable
	private int count;
	private LinearNode<T> front;
	private LinearNode<T> end;
	
	//Constructors
	public LinkedQueue(){
		count = 0;
		front = null;
		end = null;
	}
	public LinkedQueue(T element){
		//A linear node is created here because it is the node that holds the element and it links to the next node.
		LinearNode<T> node = new LinearNode<T>(element);
		//Since there is only one node the front and end are the same.
		front = end = node;
		//Size is now one.
		count = 1;
	}
 
	public void enqueue(T element){
		//A linear node is created here because it is the node that holds the element and it links to the next node.
		LinearNode<T> node = new LinearNode<T>(element);
		//Checks to make sure the queue is not empty.
		if(isEmpty()){
			front = node;
		}
		else{
			//Creates a link
			end.setNext(node);
		}
		//Sets the end node.
		end = node; 
		//Increment count.
		count++;
	}
	
	//This method will check to see if anything is in the queue and if so will get the front element from front node, make the next node front, 
	//decrements the size, and returns the element.
	public T dequeue() throws EmptyQueueException{
		if(isEmpty()){
			throw new EmptyQueueException();
		}
		T result = (T) front.getElement();
		front = front.getNext();
		count--;
		if(isEmpty()){
			end = null;
		}
		return (T) result;
	}
	
	//Exception will be thrown if queue is empty
	public T first() throws EmptyQueueException{
		if (isEmpty()){
			throw new EmptyQueueException();
		}
		return (T) front.getElement();
	}
	
	//Checks to see if queue is empty. Returns true or false.
	public boolean isEmpty() {
		return count == 0;
	}
	
	//Returns size of queue
	public int size() {
		return count;
	}
	
	public String toString(){
		//result holds all the elements
		String result = "";
		//current will hold front element
		LinearNode<T> current = front;
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

