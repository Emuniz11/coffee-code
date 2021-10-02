/**Eric Muniz

  *Project No. 4

  *Use of Queue With Linked & Circular Array 

**/
package exceptions;

	@SuppressWarnings("serial")
	public class EmptyQueueException extends RuntimeException{
		public EmptyQueueException(){
			//This message appears when the queue is empty
			super("This item is empty!");
		}
}
