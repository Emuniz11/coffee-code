/**Eric Muniz

  *Project No. 2

  *Use of Stack and Drop-out Stack data structures

**/
package stack;

public interface StackInterface<T> {
	//Pushes an object on top of the stack and increments top by 1.
	public void push(T e);
	//Pop will return the object on top of the stack, delete what was in its address, and decrements top.
	public T pop();
	//Peek will return the object on top of the stack.
	public T peak();
	//Will return top (size of the stack).
	public int size();
	//Asks the question "is top==0?" and returns true or false.
	public boolean isEmpty();
	//Puts objects in the stack in a string and returns a string.
	public String toString();
}
