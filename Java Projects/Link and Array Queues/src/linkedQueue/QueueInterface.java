/**Eric Muniz

  *Project No. 4

  *Use of Queue With Linked & Circular Array 

**/
package linkedQueue;

public interface QueueInterface<T> {
	//Puts an object in the back of the queue, increments rear by 1 (or 0) and increments count by 1.
	public void enqueue(T e);
	//Returns the element in the front of the queue, deletes the content in its address, and increments first by 1, and count is decremented by 1.
	public T dequeue();
	//Returns the position of the first element in the array.
	public T first();
	//Returns count (size of the queue).
	public int size();
	//Asks the question "is the queue empty?" and returns true or false.
	public boolean isEmpty();
	//Puts objects in the stack in a string and returns a string.
	public String toString();
}
