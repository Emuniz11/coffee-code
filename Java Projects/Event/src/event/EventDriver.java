/**
 * Eric Muniz
 * PP 1 Classes & Objects
 */
package event;

public class EventDriver {

	public static void main(String[] args) {
		//The players I made
		Player[] players = {new Player("Eric",0),
						new Player("Bob",0),
						new Player("Sandy",0),
						new Player("Candice",0),
						new Player("Jason",0)};
		//With the players I can create a game
		Game competition = new Game(players);
		//The game starts (adding points/determining rank/display stats
		competition.start();
		//Lets the user know the game is over
		competition.end();
		//After the games have ended the winner is decided!
		System.out.println("And the winner is!....\n\n" + competition.decideWinner());
		
		
	}

}
