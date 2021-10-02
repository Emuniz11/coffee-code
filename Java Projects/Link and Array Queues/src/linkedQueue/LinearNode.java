/**Eric Muniz

  *Project No. 4

  *Use of Queue With Linked & Circular Array 

**/
package linkedQueue;

import linkedQueue.LinearNode;

public class LinearNode<T> {
	//Instance Variables
	private T element;
	//Each node has a next that points to the next node after.
	private LinearNode<T> next;
	
	//Constructors
	public LinearNode(){
		element = null;
		next = null;
	}
	public LinearNode(T element){
		this.element = element;
		next = null;
	}
	
	//Accessors
	public T getElement(){
		return element;
	}
	
	public LinearNode<T> getNext(){
		return next;
	}
	
	//Mutators
	public void setElement(T element){
		this.element = element;
	}
	
	public void setNext(LinearNode<T> node){
		next = node;
	}
	
	//toString
	public String toString(){
		return "" + element;
	}
}