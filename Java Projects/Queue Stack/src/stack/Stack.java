/**Eric Muniz

  *Project No. 2

  *Use of Stack and Drop-out Stack data structures

**/
package stack;
//Made some nesicarry exceptions so I imported that package.
import exceptions.*;

public class Stack<T> implements StackInterface{
	private int top;
	private T[] stack;
	private final static int DEFAULT_SIZE = 2;
	
	//Constructor Methods. General and Input
	public Stack(int size){
		top = 0;
		//cast the object into T because we don't know the data type at this point.
		stack = (T[])(new Object[size]);
	}
	public Stack(){
		this (DEFAULT_SIZE);
	}
	
	//This method puts a object on the stack. When an object is placed the top instance variable is incremented.
	public void push(Object e) {
		//Just in case the array is full the expand capacity method will double its size.
		if (top==stack.length){
			expandCapacity();
		}
		stack[top] = (T) e;
		top++;
	}
	
	//In this case whenever the array is full, it is copied over to a new array with double the size and then stack is reinitialized.
	private void expandCapacity(){
		T[] newStack = (T[]) (new Object[stack.length*2]);
		for (int i=0;i<stack.length;i++){
			newStack[i] = (T) stack[i];
		}
		stack = newStack;
	}
	
	//This method returns the object on top of the stack as well as decrements top and initializes where the object was in the array to null.
	public Object pop() throws EmptyStackException{
		//In case the array is empty there is an exception
		if (isEmpty()){
			throw new EmptyStackException();
		}
		top--;
		T item = stack[top];
		stack[top] = null;
		return item;
	}
	
	//This method return the object on top of the stack.
	public Object peak() throws EmptyStackException{
		//An exception is placed here in case the stack is empty.
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return stack[top-1];
	}
	
	//Returns top (size of the stack).
	public int size() {
		return top;
	}
	
	//Returns true or false asking the question "Is this stack empty?"
	public boolean isEmpty() {
		return top==0;
	}
	
	//toString Method
	public String toString(){
		String string = "";
		for (int i=top-1;i>=0;i--){
			string = string + String.valueOf(stack[i]) + "\n" ;
		}
		return string;
	}

}
