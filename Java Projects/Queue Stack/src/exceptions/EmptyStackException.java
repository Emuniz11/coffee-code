/**Eric Muniz

  *Project No. 2

  *Use of Stack and Drop-out Stack data structures

**/
package exceptions;

public class EmptyStackException extends RuntimeException{
	public EmptyStackException(){
		//This message appears when the stack or queue is empty
		super("This item is empty!");
	}
}
