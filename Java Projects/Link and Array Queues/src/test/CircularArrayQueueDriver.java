/**Eric Muniz

  *Project No. 4

  *Use of Queue With Linked & Circular Array 

**/
package test;

import circularArrayQueue.CircularArrayQueue;
import circularArrayQueue.QueueInterface;
import cruiseShip.CruiseShip;
import cruiseShip.CruiseShip.Destination;
import exceptions.EmptyQueueException;

public class CircularArrayQueueDriver {

	public static void main(String[] args) {
		System.out.println("Hello! This program will demonstrate the methods of a linked queue.");
		System.out.println("We are looking at trip destinations of a cruise ship company.");
		System.out.println("We are looking at trip destinations.");
		
		//Creating CircularArrayQueue of CruiseShips.
		QueueInterface<CruiseShip> trip = new CircularArrayQueue<CruiseShip>();
		
		//Adding CruiseShips with there Destinations to the queue.
		trip.enqueue(new CruiseShip(Destination.ALASKA));
		trip.enqueue(new CruiseShip(Destination.FLORIDA));
		trip.enqueue(new CruiseShip(Destination.CALIFORNIA));
		trip.enqueue(new CruiseShip(Destination.JAMAICA));
		trip.enqueue(new CruiseShip(Destination.HAWAII));
		
		//Testing size method.
		System.out.println("Let's check the size of the object: " + trip.size());
		
		//Testing first method.
		System.out.println("Ok now lets see the what the first element is: \n" + trip.first());
		
		//Testing toString
		System.out.println(trip);
		
		//This will use CruiseShip methods.
		System.out.println("Now that we have some destinations lets find out some information about the trip!\n");
		
		for(int i=0,v=trip.size();i<v;i++){
			trip.first().travelInfo();
			trip.first();
			System.out.println(trip.dequeue() + "\n");
		}
		
		//Tests exceptions.
		System.out.println("Finaly let's test the empty queue exception.");
		
		try {
			System.out.println(trip.dequeue());
		}catch (EmptyQueueException e){
			System.out.println(e);
		}
		
	}

}
