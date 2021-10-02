/** Eric Muniz
 *  Assignment 7 Option 2 (PP 9.4)
 */

package quickSortDriver;

import myQuickSort.MoTQuickSort;
import objects.PlaneTicket;
import quickSort.QuickSort;

public class QuickSortDriver {

	public static <T> void main(String[] args) {
		
		//---------------------------------------------------------------------------
		// Testing Regular QuickSort VS. Middle Of Three QuickSort With Integer Array
		//---------------------------------------------------------------------------
			//Integer QuickSort	
		Integer[] num = {100,5,7,51,22,2,1,37,25,9,32,4,81,6,3,8,10};
				
		for(int i=0;i<num.length;i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		QuickSort.quickSort(num);
		
		for(int i=0;i<num.length;i++){
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		System.out.println("QuickSort Execution Times: " + QuickSort.timesExecuted());
		
		//----------------------------------------------------------------------------
			//Middle of Three QuickSort
		Integer[] nums = {100,5,7,51,22,2,1,37,25,9,32,4,81,6,3,8,10};
		
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		MoTQuickSort.quickSort(nums);
		
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		System.out.println("Middle of Three QuickSort Execution Times: " + MoTQuickSort.timesExecuted());
		
		QuickSort.resetExecutions();
		MoTQuickSort.resetExecutions();
		
		//--------------------------------------------------------------------------
		// Testing Regular QuickSort VS. Middle Of Three QuickSort With String Array
		//--------------------------------------------------------------------------
			//String QuickSort
		String[] name = {"Eric","Rosa","Linda","Brian","Blain"};
		
		for(int i=0;i<name.length;i++){
			System.out.print(name[i] + " ");
		}
		System.out.println();
		
		QuickSort.quickSort(name);
		
		for(int i=0;i<name.length;i++){
			System.out.print(name[i] + " ");
		}
		System.out.println();
		
		System.out.println("QuickSort Execution Times: " + QuickSort.timesExecuted());
		
		//----------------------------------------------------------------------------
			//Middle of Three QuickSort
		String[] names = {"Eric","Rosa","Linda","Brian","Blain"};
		
		for(int i=0;i<names.length;i++){
			System.out.print(names[i] + " ");
		}
		System.out.println();
		
		MoTQuickSort.quickSort(names);
		
		for(int i=0;i<names.length;i++){
			System.out.print(names[i] + " ");
		}
		System.out.println();
		
		System.out.println("Middle of Three QuickSort Execution Times: " + MoTQuickSort.timesExecuted());
		
		QuickSort.resetExecutions();
		MoTQuickSort.resetExecutions();
		
		//-------------------------------------------------------------------------------
		// Testing Regular QuickSort VS. Middle Of Three QuickSort With PlaneTicket Array
		//-------------------------------------------------------------------------------
			//PlaneTicket QuickSort
		//My family is going on a vacation and we need to fly to get there. However, all of us work so we
		//can't all take the same flight! Tickets will be sorted in order of departure time. If two departures
		//are set the same but their arrivals are different, the one arriving sooner will be sorted to the front. 
		//If arrivals are the same then the names are compared.
		
		PlaneTicket[] familyTrip = new PlaneTicket[5];
		familyTrip[0] = new PlaneTicket("Rosa",1100,1400);
		familyTrip[1] = new PlaneTicket("Eric",1100,1400);
		familyTrip[2] = new PlaneTicket("Brian",700,900);
		familyTrip[3] = new PlaneTicket("Kelly",700,900);
		familyTrip[4] = new PlaneTicket("Lola",1800,2100);
		
		for(int i=0;i<familyTrip.length;i++){
			System.out.println(familyTrip[i] + " ");
		}
		
		QuickSort.quickSort(familyTrip);
		
		for(int i=0;i<familyTrip.length;i++){
			System.out.println(familyTrip[i] + " ");
		}
		
		System.out.println("QuickSort Execution Times: " + QuickSort.timesExecuted());
		
		//----------------------------------------------------------------------------
			//Middle of Three QuickSort
		PlaneTicket[] familyTrip2 = new PlaneTicket[5];
		familyTrip2[0] = new PlaneTicket("Rosa",1100,1200);
		familyTrip2[1] = new PlaneTicket("Eric",1100,1400);
		familyTrip2[2] = new PlaneTicket("Brian",700,900);
		familyTrip2[3] = new PlaneTicket("Kelly",700,900);
		familyTrip2[4] = new PlaneTicket("Lola",1800,2100);
		
		for(int i=0;i<familyTrip2.length;i++){
			System.out.println(familyTrip2[i] + " ");
		}
		
		MoTQuickSort.quickSort(familyTrip2);
		
		for(int i=0;i<familyTrip2.length;i++){
			System.out.println(familyTrip2[i] + " ");
		}
		
		System.out.println("Middle of Three QuickSort Execution Times: " + MoTQuickSort.timesExecuted());
		
		QuickSort.resetExecutions();
		MoTQuickSort.resetExecutions();
		
		//-------------------------------------------------------------------------------
		// Testing Regular QuickSort VS. Middle Of Three QuickSort With Character Array
		//-------------------------------------------------------------------------------
			//Character QuickSort
		Character[] abc = {'i','v','c','t','d','s','m','l','y','o','a',
				'r','g','q','n','b','u','x','j','e','f','w','p','z','h','k'};
		
		for(int i=0;i<abc.length;i++){
			System.out.print(abc[i]);
		}
		System.out.println();
		
		QuickSort.quickSort(abc);
		
		for(int i=0;i<abc.length;i++){
			System.out.print(abc[i]);
		}
		System.out.println();
		
		System.out.println("QuickSort Execution Times: " + QuickSort.timesExecuted());
		
		//----------------------------------------------------------------------------
			//Middle of Three QuickSort
		Character[] abc2 = {'i','v','c','t','d','s','m','l','y','o','a',
				'r','g','q','n','b','u','x','j','e','f','w','p','z','h','k'};
		
		for(int i=0;i<abc2.length;i++){
			System.out.print(abc2[i]);
		}
		System.out.println();
		
		MoTQuickSort.quickSort(abc2);
		
		for(int i=0;i<abc2.length;i++){
			System.out.print(abc2[i]);
		}
		System.out.println();
		
		System.out.println("Middle of Three QuickSort Execution Times: " + MoTQuickSort.timesExecuted());
		
		QuickSort.resetExecutions();
		MoTQuickSort.resetExecutions();
	}
	
}
