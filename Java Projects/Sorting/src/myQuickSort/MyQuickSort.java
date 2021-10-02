package myQuickSort;

public class MyQuickSort{
	private static int executions = 0;
	
	public static <T extends Comparable<T>> void quickSort(T[] data){
		quickSort(data, 0, data.length-1);
	}
	private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max){
		if (min < max){
			executions++;
			int middle = middleOfThree(data, min, max);
			int partition = partition(data, min, max, middle);
			quickSort(data, min, partition - 1);
			quickSort(data, partition + 1, max);
		}
	}
	
	private static <T extends Comparable<T>> 
	int middleOfThree(T[] data, int min, int max){
		int center = (min + max)/2;
		
		if(data[min].compareTo(data[center]) > 0){
			swap(data, min, center);
		}
		
		if(data[min].compareTo(data[max]) > 0){
			swap(data, min, max);
		}
		
		if(data[center].compareTo(data[max]) > 0){
			swap(data, center, max);
		}
		
		swap(data, center, max - 1);
		return max-1;
	}
	
	private static <T extends Comparable<T>> 
	int partition(T[] data, int min, int max, int middle){
		int left = min;
		int right = max;
		
		while(left<right){
			while(data[left].compareTo(data[middle]) < 0){
				left++;
			}
			while(data[right].compareTo(data[middle]) > 0){
				right--;
			}
			
			
			swap(data, left, right);
			
		}
		swap(data,left, max-1);
		return left;
	}
	
	private static <T extends Comparable<T>> 
	void swap(T[] data, int index1, int index2){
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	public static int timesExecuted(){
		return executions;
	}
	
	public static void resetExecutions(){
		executions = 0;
	}
}
