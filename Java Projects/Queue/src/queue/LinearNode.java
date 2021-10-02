/**
 * 
 */
package queue;

/**
 * @author aca1124student
 *
 */
public class LinearNode<T> {
	private T element;
	private LinearNode<T> next;
	
	public LinearNode(){
		element = null;
		next = null;
	}
	public LinearNode(T element){
		this.element = element;
		next = null;
	}
	
	public T getElement(){
		return element;
	}
	
	public LinearNode<T> getNext(){
		return next;
	}
	
	public void setElement(T element){
		this.element = element;
	}
	
	public void setNext(LinearNode<T> node){
		next = node;
	}
	
	public String toString(){
		return "" + element;
	}
}
