/*Eric Muniz
 *PP4 
 *Using Multidimensional Arrays 
 */
package array;
//Decided to use the Random object
import java.util.Random;

public class Arrays {

	public static void main(String[] args) {
		//Creating Random object
		Random rand = new Random();
		//Creating a multidimensional array of ints
		int[][] testScore = new int[5][3];
		//Creating array of Strings
		String[] stuName = new String[5];
		//Random makes initializing testScore a breeze
		for(int i=0;i<testScore.length;i++){
			for(int col=0;col<testScore[i].length;col++){
				//The int variable initialized to rand is created here so it gives different
				//test scores each time the program loops.
				int score = rand.nextInt(41)+60;
				testScore[i][col] = score;
			}
		}
		//Initialized stuName String array
		stuName[0] = "Jasmine";
		stuName[1] = "Mark";
		stuName[2] = "Beth";
		stuName[3] = "Leo";
		stuName[4] = "Dimond";
		//This loop displays the students' number, name, and scores from three tests
		for(int i=0;i<testScore.length;i++){
			System.out.println("Student " + (i+1) + ". " + stuName[i] + "\nTestScores: ");
			for(int col=0;col<testScore[i].length;col++){
				System.out.println((col+1) + ". " + testScore[i][col]);
			}
			System.out.println();
		}
		//This loop displays the students' name along with their test average
		for(int i=0;i<testScore.length;i++){
			System.out.println(stuName[i] + "'s Average:");
			System.out.println(((testScore[i][0] + testScore[i][1] + testScore[i][2])/3));
		}
		//Created an array of ints to store the classes average
		int[] average = new int[5];
		for(int i=0;i<testScore.length;i++){
			average[i] = 0;
		}
		//This loop will add all the test scores from each student together
		for(int i=0;i<testScore.length;i++){
			for(int v=0;v<testScore[i].length;v++){
				average[i] = average[i] + testScore[i][v];
			}
			average[i] = average[i]/3;
		}
		//Here is where the final calculations take place to determine the class average
		System.out.println("\nClass Average: ");
		System.out.println((average[0]+average[1]+average[2]+average[3]+average[4])/5);
		//Test1
	}
}
