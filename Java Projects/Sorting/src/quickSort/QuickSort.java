/** Eric Muniz
 *  Assignment 7 Option 2 (PP 9.4)
 */

package quickSort;

public class QuickSort {
	private static int executions = 0;
	
	public static <T extends Comparable<T>> void quickSort(T[] data){
		//This is the only method that the user will be able to call.
		//The array passed will be all that is necessary for this class to work.
		//Calling this method will call the private constructor of this class.
		quickSort(data, 0, data.length-1);
	}
	private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max){
		//The if conditional statement will be the base case.
		if (min < max){
			//Every time quickSort is called executions will increment. 
			executions++;
			//Calling partition will find a middle element and place all element less than it on the left
			//and greater than the middle will go on the right.
			int indexofpartition = partition(data, min, max);
			//Here is where the lower part of the partition is sorted.
			quickSort(data, min, indexofpartition - 1);
			//Here is where the greater part of the partition is sorted.
			quickSort(data, indexofpartition + 1, max);
		}
	}
	
	private static <T extends Comparable<T>> int partition(T[] data, int min, int max){
		//Actual partition element.
		T partitionelement;
		int left, right;
		int middle = (min + max)/2;
		
		partitionelement = data[middle];
		swap(data, middle, min);
		left = min;
		right = max;
		//Here are the steps taken to place lower on left and higher on right.
		while (left < right){
			//Finds swapping position on left half.
			while (left < right && data[left].compareTo(partitionelement) <= 0){
				left++;
			}
			//Now again on right half.
			while (data[right].compareTo(partitionelement) > 0){
				right--;
			}
			if(left < right){
				swap(data,left,right);
			}
		}
		swap(data, min, right);
		return right;
	}
	
	//This method is used to swap the vales between the two given index.
	private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2){
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	//Setter and Getter for execution instance variable.
	public static int timesExecuted(){
		return executions;
	}
	
	public static void resetExecutions(){
		executions = 0;
	}
}
