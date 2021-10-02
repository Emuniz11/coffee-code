/**
 * 
 */
package queue;

import exceptions.EmptyStackException;
import queue.LinearNode;

/**
 * @author aca1124student
 *
 */
public class LinkedQueue<T> implements QueueInterface<T>{
	private int count;
	private LinearNode<T> front;
	private LinearNode<T> end;
	
	public LinkedQueue(){
		count = 0;
		front = null;
		end = null;
	}
	public LinkedQueue(T element){
		LinearNode<T> node = new LinearNode<T>(element);
		front = end = node;
		count = 1;
	}
 
	@Override
	public void enqueue(T element){
		LinearNode<T> node = new LinearNode<T>(element);
		if(isEmpty()){
			front = node;
			count = 1;
		}
		else{
			end.setNext(node);
			count++;
		}
		end = node; //this is executed no matter what
	}

	@Override
	public T dequeue() throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException();
		}
		count--;
		return (T) front;
	}

	@Override
	public T first() throws EmptyStackException{
		if (isEmpty()){
			throw new EmptyStackException();
		}
		return (T) front;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
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
