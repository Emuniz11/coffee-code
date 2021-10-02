/**
 * 
 */
package exceptions;

/**
 * @author aca1124student
 *
 */

	@SuppressWarnings("serial")
	public class EmptyStackException extends RuntimeException{
		public EmptyStackException(){
			//This message appears when the stack or queue is empty
			super("This item is empty!");
		}
}
