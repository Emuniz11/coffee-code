/**
 * Eric Muniz
 * PP 1 Classes & Objects
 */
package event;

public class Game {
	//Each game requires an array of players
	private Player[] player;
	//Constructor 
	public Game(Player[] player){
		this.player = player;
	}
	//This will use the play method found in Player Class to give scores to each player
	//When the score is decided then the rank is determined
	//Then I wanted the Player name and stats to show
	public void start(){
		System.out.println("Let the games begin!\n");
		for (int i=0;i<player.length;i++){
			player[i].play();
		}
		for(int i=0;i<player.length;i++){
			player[i].decideRank();
		}
		for (int i=0;i<player.length;i++){
			System.out.println("Player " +  player[i].getName() + ": " + player[i].getScore());
			System.out.println(player[i].getRank() + "\n");
		}
	}
	//Lets the user know the game is over
	public void end(){
		System.out.println("Game Ended");
	}
	//This method compared the scores of all the players with each other and determines who actually has the highest score
	public Player decideWinner(){
		int result = 0;
		int highscore = 0;
		Player winner = player[0];
		for(int i=0;i<player.length;i++){
			result = player[i].getScore();
			if (result >=highscore){
				highscore = result;
			}
		}
		for(int i=0;i<player.length;i++){
			winner = (player[i].getScore()==highscore)? player[i]:winner;
		}
		return winner;
	}
}
