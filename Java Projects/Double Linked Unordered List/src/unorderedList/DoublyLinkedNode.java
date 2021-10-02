/*
 * Eric Muniz 
 * Doubly Linked Unordered List Implementation 
 * I was not able to make use of the Serialization interface
 */
package unorderedList;

public class DoublyLinkedNode<T> {
	//Instance Variables
	private T element;
	//Each node has a next that points to the next node after.
	private DoublyLinkedNode<T> next;
	private DoublyLinkedNode<T> previous;
	
	//Constructors
	public DoublyLinkedNode(){
		element = null;
		next = null;
		previous = null;
	}
	public DoublyLinkedNode(T element){
		this.element = element;
		next = null;
		previous = null;
	}
	
	//Accessors
	public T getElement(){
		return element;
	}
	
	public DoublyLinkedNode<T> getNext(){
		return next;
	}
	
	public DoublyLinkedNode<T> getPrevious(){
		return previous;
	}
	
	//Mutators
	public void setElement(T element){
		this.element = element;
	}
	
	public void setNext(DoublyLinkedNode<T> node){
		next = node;
	}
	
	public void setPrevious(DoublyLinkedNode<T> node){
		previous = node;
	}
	
	//toString
	public String toString(){
		return "" + element;
	}
}