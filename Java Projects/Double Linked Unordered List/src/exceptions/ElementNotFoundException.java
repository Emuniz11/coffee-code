/*
 * Eric Muniz 
 * Doubly Linked Unordered List Implementation 
 * I was not able to make use of the Serialization interface
 */
package exceptions;

public class ElementNotFoundException extends RuntimeException{

	public ElementNotFoundException() {
		super("Element Not Found");
	}

}
