/**
 * Eric Muniz
 * PP 1 Classes & Objects
 */
package event;
//wanted to use random so I had to import 
import java.util.Random;

public class Player {
	private String name;
	private String rank;
	private int score;
	private Random rand;
	//The Constructor
	public Player(String name, int score){
		this.name = name;
		this.score = score;
	}
	//Each player plays 5 games and the sum of the games will be their overall points
	//All random numbers
	public void play(){
		for(int i=0;i<5;i++){
			rand = new Random();
			score = score+rand.nextInt(11);
		}
	}
	//This will decide the players rank based on how many points the scored
	public String decideRank(){
		String result = "";
		result = (score>-1)?"Rank 4":result;
		result = (score>=20)?"Rank 3":result;
		result = (score>=30)?"Rank 2":result;
		result = (score>=40)?"Rank 1":result;
		rank = result;
		return rank;
	}
	//These are my getter methods
	public String getName(){
		return name;
	}
	
	public String getRank(){
		return rank;
	}
	
	public int getScore(){
		return score;
	}
	//toString method
	public String toString(){
		return name + " \nScore: " + score + "\n" + rank;
	}
}
