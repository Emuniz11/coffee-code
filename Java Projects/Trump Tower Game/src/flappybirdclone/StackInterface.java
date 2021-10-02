package flappybirdclone;

public interface StackInterface<T> {
	public void push(T e);
	public T pop();
	public T peak();
	public int size();
	public boolean isEmpty();
	public String toString();
}
