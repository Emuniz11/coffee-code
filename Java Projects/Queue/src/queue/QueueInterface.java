/**
 * 
 */
package queue;

/**
 * @author aca1124student
 *
 */
public interface QueueInterface<T> {
	public void enqueue(T element);
	public T dequeue();
	public T first();
	public boolean isEmpty();
	public int size();
	public String toString();
}
