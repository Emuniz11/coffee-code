/** Eric Muniz
 *  Assignment 7 Option 2 (PP 9.4)
 */

package myQuickSort;

public class MoTQuickSort {
	//A lot if this is the same as QuickSort so I will only comment what I think are the differences.
	private static int executions = 0;
	
	public static <T extends Comparable<T>> void quickSort(T[] data){
		quickSort(data, 0, data.length-1);
	}
	private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max){
		if (min < max){
			executions++;
			//Middle is now a method that picks the middle but sorts min, mid, max.
			int middle = middleOfThree(data, min, max);
			//The parameters for partition now have the added middle.
			int indexofpartition = partition(data, min, max, middle);
			quickSort(data, min, indexofpartition - 1);
			quickSort(data, indexofpartition + 1, max);
		}
	}
	
	//This method will sort min,mid,max and return mid for middle.
	private static <T extends Comparable<T>> 
	int middleOfThree(T[] data, int min, int max){
		int mid = (min+max)/2;
		//If min is great than mid:
		if(data[min].compareTo(data[mid]) > 0){
			swap(data,min,mid);
		}
		//If min is greater than max:
		if(data[min].compareTo(data[max]) > 0){
			swap(data,min,max);
		}
		//If mid is greater than max:
		if(data[mid].compareTo(data[max]) > 0){
			swap(data,mid,max);
		}
		return mid;
	}
	
	private static <T extends Comparable<T>> int partition(T[] data, int min, int max, int middle){
		//There is no need to calculate middle here since I made a method to find it.
		T partitionelement;
		int left, right;
		//Middle is used as an index to find the middle element.
		partitionelement = data[middle];
		swap(data, middle, min);
		left = min;
		right = max;
		
		while (left < right){
			while (left < right && data[left].compareTo(partitionelement) <= 0){
				left++;
			}
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
	
	private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2){
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	public static int timesExecuted(){
		return executions;
	}
	
	public static void resetExecutions(){
		executions =0;
	}
}
