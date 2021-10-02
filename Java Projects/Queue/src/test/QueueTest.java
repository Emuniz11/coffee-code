/**Eric Muniz

  *Project No. 4

  *Use of Queue With Linked & Circular Array 

**/
package test;

import queue.LinkedQueue;
import queue.QueueInterface;

/**
 * @author aca1124student
 *
 */
public class QueueTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QueueInterface<String> strQueue = new LinkedQueue<String>();
		strQueue.enqueue("Morning");
		strQueue.enqueue("Afternoon");
		strQueue.enqueue("Evening");
		
		System.out.println("Number of elements: " + strQueue.size());
		
		System.out.println(strQueue);
		
		System.out.println();
	}

}
