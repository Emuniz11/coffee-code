/**
 * 
 */
package exceptions;

/**
 * @author Emuniz
 *
 */
public class EmptyStackException extends RuntimeException{
	public EmptyStackException(){
		//This message appears when the stack or queue is empty
		super("This item is empty!");
	}
}
