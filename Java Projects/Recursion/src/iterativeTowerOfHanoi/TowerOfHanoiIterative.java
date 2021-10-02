/* Eric Muniz
 * PP 6 Iterative Tower Of Hanoi 
 */
package iterativeTowerOfHanoi;

public class TowerOfHanoiIterative {

	public static void main(String[] args) {
		//***This program only works with even number disks***
		// How man disks in challenge
		int diskCount = 4;
		// These will hold locations and help determine new locations for disks
		int second = 0, third;
		// These will have actual disks that will be output for the user
		int pos2, pos3;
		// Loop control and location index finder
		int j, i = 1;
		// There needs to be extra space in the array
		int[] location = new int[diskCount+2];
		// Location of starting point
		location[i] = 0;
		// This will help find indexes 
		location[diskCount+1] = 2;
		
		// Total moves will depend on how many disks there are
		// Always 2^(n-1)
		int totalMoves = 1;
		for(i=1;i<=diskCount;i++){
			totalMoves = totalMoves * 2;
		}
		totalMoves--;
		
		System.out.println("This is The Tower Of Hanoi problem sloved iteritively." + "\nThere are " + diskCount + " disks in this challenge.");
	
		for(i=1;i<=totalMoves;i++){
			// If i is an odd number then only disk 1 moves. 
			// Disk one will always move first and will always move ever other move
			if (i%2==1){
				// Second will hold the previous position of disk 1
				second = location[1]; 
				// Since there are only three possible locations taking the modules of location + 1 will always be 1, 2, or 3
				location[1] = (location[1]+ 1) %3;
				//This is the output for odd number disks
				System.out.print("Move disc 1 to ");
				// 'A' + location[1] will give the correct position of disk 1
				System.out.println((char)('A'+location[1]));
			}
			
			//This else statement will happen when it is an even disk
			else{
				// Since the move is even, only disks that aren't disk one can move
				third = 3 - second - location[1];
				// find smallest values on the other 2 corners
				//Go through array and find the location index that equals the previous position of disk 1
				pos2 = diskCount+1; 
				for (j=diskCount+1; j>=2; j--) 
					if (location[j]==second)
						//Set pos2 to that index
						pos2=j;
				//Go though same steps for pos3
				pos3 = diskCount+1; 
				for (j=diskCount+1; j>=2; j--) 
					//When the the data in location[j] is the same as third then j is the index that needs to be saved
					if (location[j]==third) 
						pos3=j;
				//This is output for even numbered disks
				System.out.print("Move disc ");
				// Only the smaller disk can go on a bigger disk
				if (pos2<pos3){
					System.out.print(pos2);
					System.out.print(" to ");
					System.out.println((char)('A'+third));
					location[pos2]=third;
				}
				else{
					System.out.print(pos3);
					System.out.print(" to ");
					System.out.println((char)('A'+second));
					location[pos3]=second;
				}
			 } 
		}
	}	
}
