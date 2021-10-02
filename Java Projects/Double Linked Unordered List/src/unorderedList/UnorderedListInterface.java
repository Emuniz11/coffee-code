/*
 * Eric Muniz 
 * Doubly Linked Unordered List Implementation 
 * I was not able to make use of the Serialization interface
 */
package unorderedList;

public interface UnorderedListInterface<T> {
	
	//Removes first element in list
	public T removeFirst();
	//Removes last element in list
	public T removeLast();
	//Removes designated element from list
	public T remove(T element);
	//Returns element in front
	public T first();
	//Returns element at the end of the list
	public T last();
	//I am not too sure what this is for?
	public boolean contains();
	//Check to see if the list is empty
	public boolean isEmpty();
	//Returns size of list
	public int size();
	//Adds an element to the front of the list
	public void addToFront(T element);
	//Adds an element to the rear of the list
	public void addToRear(T element);
	//Adds an element after a targeted position 
	public void addAfter(T element, T target);
	
}
