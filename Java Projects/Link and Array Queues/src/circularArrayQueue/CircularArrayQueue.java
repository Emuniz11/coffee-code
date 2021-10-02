/**Eric Muniz

  *Project No. 4

  *Use of Queue With Linked & Circular Array 

**/
package circularArrayQueue;

import exceptions.EmptyQueueException;

public class CircularArrayQueue<T> implements QueueInterface {
	private final static int DEFAULT_CAPACITY = 10;
	private int front, rear, count;
	private T[] queue;
	
	//Constructors
	public CircularArrayQueue(int capacity){
		front = rear = count = 0;
		queue = (T[])(new Object[capacity]);
	}
	public CircularArrayQueue(){
		this(DEFAULT_CAPACITY);
	}
	
	//Puts an object in the back of the queue, increments rear by 1 (or 0) and increments count by 1.
	public void enqueue(Object e) {
		if (size() == queue.length){
			expandCapacity();
		}
		queue[rear] = (T) e;
		rear = (rear+1) % queue.length;
		count++;
	}
	
	//In this case whenever the array is full, it is copied over to a new array with double the size and then queue is reinitialized.
	private void expandCapacity(){
		T[] expand = (T[])(new Object[queue.length*2]);
		for (int i=0;i<count;i++){
			expand[i] = queue[front];
			front = (front+1) % queue.length;
		}
		front = 0;
		rear = count;
		queue = expand;
	}
	
	//Returns the element in the front of the queue, deletes the content in its address, and increments first by 1, and count is decremented by 1.
	public Object dequeue() throws EmptyQueueException{
		if (isEmpty()){
			throw new EmptyQueueException();
		}
		T result = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		count--;
		return result;
	}

	//Returns the position of the first element in the array.
	public Object first() throws EmptyQueueException{
		if (isEmpty()){
			throw new EmptyQueueException();
		}
		return queue[front];
	}
	
	//Returns value first.
	public int begining(){
		return front;
	}
	
	//Returns count (size of the queue).
	public int size() {
		return count;
	}
	
	//Asks the question "is the queue empty?" and returns true or false.
	public boolean isEmpty() {
		return count==0;
	}

	//Puts objects in the stack in a string and returns a string.
	public String toString(){
		String string = "";
		//Goes through and adds each element in the queue to the string.
		for (int i=front;i<rear;i++){
			string = string + queue[i] + " ";
		}
		return string;
	}

}

