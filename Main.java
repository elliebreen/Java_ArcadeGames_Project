package Project;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	// create an array list to store the players for current session
	static ArrayList<Player> playerslist = new ArrayList<Player>();
	static Leaderboard currentLeaders = new Leaderboard();

	public static void main(String[] args) {
		// create a games instance
		Game session = new Game();

		outerloop: while (true) {
			// start up the games console
			session.startUp();
			// get the users choice
			int startUpResponse = session.getChoice();

			// if the user chooses to create a new player
			if (startUpResponse == 1) {
				//instantiate a player based on their details
				Player current = session.getDetails();
				session.setDetails(current);
				// add the player to the players list
				playerslist.add(current);
				int turns = current.getTurnsLimit();
				//tell the player how many turns they have
				System.out.println("You are a " + current.getPlayerType() + "player. You have  " + current.getTurnsLimit() + "turns.");
				//while the player has turns play
				while (turns > 0) {
					// ask the user which game they want to play
					session.MainMenu(current);
					
					int playerResponse = session.getChoice();
					// of they choose -1 they want to quit, break the loop
					if (playerResponse == -1) {
						break;
					} // otherwise play the game chosen
					session.playGame(playerResponse, current);
					//once game played decrement turns
					turns--;
				}
				//if theyre out of turns print error message and exit and show leaderboard as they can no longer play
				if (turns == 0) {
					System.out.println("Sorry, You are all out of turns!");
					break outerloop;
				}
				// if the user chooses to quit, quit the game
			} else if (startUpResponse == 2) {
				break outerloop;
			}

		}
		// write players.tostring method to leaderboard file and catch any errors
		for (Player players : playerslist) {
			try {
				currentLeaders.writeToFile((((Player) players).toString()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//call the leaderboard show method to show leaderboard
		currentLeaders.show();
		System.out.println(" Thanks for playing!");
	}
}
