/**
 * 
 */
package flappybirdclone;



import flappybirdclone.EmptyStackException;
import flappybirdclone.LinearNode;
import flappybirdclone.StackInterface;

/**
 * @author aca1124student
 *
 */
public class LinkedStack<T> implements StackInterface{
	private int count;
	private LinearNode<T> top;
	
	public LinkedStack(){
		count = 0;
		top = null;
	}
	public LinkedStack(T element){
		LinearNode<T> node = new LinearNode<T>(element);
		top = node;
		count = 1;
	}
	
	@Override
	public void push(Object e) {
		LinearNode<T> node = new LinearNode<T>((T) e);
		if (isEmpty()){
			top = node;
			count = 1;
		}
		else{
			node.setNext(top);
			top = node;
			count++;
		}	
	}

	@Override
	public Object pop() throws EmptyStackException {
		if(isEmpty()){
			throw new EmptyStackException();
		}
		T result = top.getElement();
		top = top.getNext();
		count--;
		return result;
	}

	@Override
	public Object peak() throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException();
		}
		T result = top.getElement();
		return result;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

}
