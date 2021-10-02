/*
 * Eric Muniz 
 * Doubly Linked Unordered List Implementation 
 * I was not able to make use of the Serialization interface
 */
package unorderedList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import exceptions.ElementNotFoundException;
import student.Student;

public class LinkedUnorderedList<T> implements UnorderedListInterface, Serializable{
	
	//Instance Variables
	private int count;
	private DoublyLinkedNode<T> front;
	private DoublyLinkedNode<T> end;
	
	//Constructors
	public LinkedUnorderedList(){
		count = 0;
		front = null;
		end = null;
	}
	public LinkedUnorderedList(T element){
		DoublyLinkedNode<T> node = new DoublyLinkedNode<T>(element);
		front = end = node;
		count = 1;
	}
	
	//These next 3 methods are for removing elements from the list in various ways.
	public Object removeFirst() {
		//This one will remove the front element and assign the next element to be the front
		T result = front.getElement();
		front = front.getNext();
		front.setPrevious(null);
		count--;
		return result;
	}

	public Object removeLast() {
		//This method will remove the last element and assign the previous element to be the end
		T result = end.getElement();
		end = end.getPrevious();
		end.setNext(null);
		count--;
		return result;
	}

	public Object remove(Object element) {
		//This method will remove a target element from the list.
		//When the target element is found the nodes linked to the target will like to each other instead
		if(isEmpty())
			throw new ElementNotFoundException();
		
		DoublyLinkedNode<T> current = front;
		DoublyLinkedNode<T> bump = front.getNext();
		int scan = 0;
		T result = current.getElement();
		
		while(scan!=1){
			if(current.getElement().equals(element)){
				
				result = current.getElement();
				//If removed element is in front of list this will work on it
				if(current.getPrevious() == null){
					front = bump;
					front.setPrevious(null);
				}
				//Otherwise this is the case
				else{
					bump.setPrevious(current.getPrevious());
					current = current.getPrevious();
				}
				//This will happen if the target is not last on the list
				if(current.getNext() != null){
					current.setNext(bump);
				}
				
				scan = 1;
				count = count-1;
			}
			//This part moves my two test nodes through the list until the target is found
			else if(current.getNext() == null){
				scan = 1;
			}
			else{
				current = current.getNext();
				if(bump.getNext() == null){
	
				}
				else{
					bump = current.getNext();
				}
			}
		}
		return result;
	}
	
	//Returns first element in list
	public Object first() {
		return ((Student)front.getElement()).getFullName();
	}
	
	//Returns last element in list
	public Object last() {
		return ((Student)end.getElement()).getFullName();
	}
	
	//Not sure what this is suppose to do?
	public boolean contains() {
		return false;
	}
	
	//Checks to see if list is empty
	public boolean isEmpty() {
		return count == 0;
	}
	
	//Returns the size of the list
	public int size() {
		return count;
	}
	
	//These next 3 methods are different ways an unordered list adds elements
	public void addToFront(Object element) {
		//This will add an element to the front of the list as well as make links necessary 
		DoublyLinkedNode<T> node = new DoublyLinkedNode<T>((T) element);
		//This method is sometimes called before there is even a front
		//This if statement will take care of this problem
		if(isEmpty()){
			front = end = node;
			count++;
		}
		else{
		//Otherwise this is the normal addToFront
			DoublyLinkedNode<T> bump = front;
			front.setPrevious(node);
			front = node;
			front.setNext(bump);
			count++;
		}
	}

	public void addToRear(Object element) {
		//This will add an element to the rear a reestablish links
		DoublyLinkedNode<T> node = new DoublyLinkedNode<T>((T) element);
		//Again sometimes this can be called first so there is an 
		//if statement to take care of that
		if(isEmpty()){
			end = front = node;
			count++;
		}
		DoublyLinkedNode<T> bump = end;
		end.setNext(node);
		end = node;
		end.setPrevious(bump);
		count++;
	}

	public void addAfter(Object element, Object target) {
		//This method has a target element that we want to be able to 
		//add a new element in after it
		if (isEmpty())
			throw new ElementNotFoundException();
		
		int scan = 0;
		//Create the new node for the element
		DoublyLinkedNode<T> node = new DoublyLinkedNode<T>((T) element);
		DoublyLinkedNode<T> current = front;
		DoublyLinkedNode<T> bump = front.getNext();
		//Once current is equal to the target element the method will begin to establish new links 
		while(scan != 1){
			if((current.getElement().equals(target))){
				//If there is a next then this will take care of the link
				if(current.getNext() != null){
					bump = current.getNext();
					bump.setPrevious(node);
					node.setNext(bump);
				}
				current.setNext(node);
				
				node.setPrevious(current);
				
				scan = 1;
				count++;
			}
			else if(current.getNext() == null){
				scan = 1;
			}
			else{
				current = current.getNext();
				if(bump.getNext() == null){
	
				}
				else{
					bump = current.getNext();
				}
			}
		}	
	}
	
	//toString
	public String toString(){
		DoublyLinkedNode<T> current = front;
		String result = "";
		for(int i=count-1;i>=0;i--){
			result += ((Student) (current.getElement())).getFullName();
			if(i != 0){
				result += ", ";
			}
			current = current.getNext();
		}
		return result;
	}
	
	//
	public void save(String fileName) throws IOException{
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);;
		oos.flush();
		oos.close();
	}
	
	public static Student load(String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student pos = (Student) ois.readObject();
		ois.close();
		return pos;
	}

}
