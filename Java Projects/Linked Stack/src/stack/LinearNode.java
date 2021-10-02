/**Eric Muniz
 * PP 3 Linked List with Enum
 */
package stack;

public class LinearNode<T> {
	//Instance Variables
	//This is the link
	private LinearNode<T> next;
	//This is the actual element 
	private T element;
	
	//Constructors
	public LinearNode(T element){
		next = null;
		this.element = element;
	}
	public LinearNode(){
		next = null;
		element = null;
	}
	
	//Returns next node
	public LinearNode<T> getNext(){
		return next;
	}
	
	//Sets next node
	public void setNext(LinearNode<T> node) {
		next = node;
	}
	
	//Returns element
	public T getElement() {
		return element;
	}
	
	//Sets element
	public void setElement(T element){
		this.element = element;
	}
}
