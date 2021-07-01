package Project;

import java.util.Scanner;

public class Game {

	private static Scanner input = new Scanner(System.in);

	// startup method which prints welcome message and startup options
	public void startUp() {

		System.out.println(
				"Welcome to Arcade Games!\n=============================\n Choose Player Status: \n 1. New Player  \n 2. Quit");
	}

	//method to get the response from user.. try catch to catch any IO exceptions
	public int getChoice() {
		boolean ok = true;
		int playerResponse = 0;
		// while loop as want to keep getting response until is correct
		while (ok) {
			try {
				playerResponse = input.nextInt();
				input.nextLine();
				// when ok, set to false to exit while loop
				ok = false;

			} catch (Exception e) {
				System.out.println("Input must be a -1 ,1 or 2! Please Enter another Number");
				input.nextLine();
				ok = true;
			}
		}
		return playerResponse;
	}

	//main menu method which welcomes specific user and asks which game to play
	public void MainMenu(Player user) {
		System.out.println("Hello " + user.getName()
				+ "! Please Choose a game or -1 to quit: \n 1 - Rock, Paper, Scissors \n 2 - Coin Toss");

	}

	//set details method which does a while loop like above, to ask and set the user's name
	public void setDetails(Player user) {
		boolean ok = true;
		while (ok) {
			try {
				System.out.println("Welcome! Please enter your name to start: ");
				String userName = input.nextLine();
				user.setName(userName);
				ok = false;
			} catch (Exception e) {
				System.out.println("Oops an error occured!");
				input.nextLine();
				ok = true;
			}
		}
	}

	//get what type of player the player is and create player object based on that input
	public Player getDetails() {

		System.out.println("Are you a Limited or VIP Player?");
		String playerType = input.nextLine();
		Player current = null;

		if (playerType.equalsIgnoreCase("VIP")) {
			current = new VIPPlayer();
			current.setPlayerType(playerType);
		} else if (playerType.equalsIgnoreCase("Limited")) {
			current = new LimitedPlayer();
			current.setPlayerType(playerType);
		//if neither limited nor VIP set a default player
		} else {
			current = new Player();
		}

		return current;
	}

	//play method which plays the game chosen by the specific user
	public void playGame(int game, Player user) {
		if (game == 1) {
			RockPaperScissors.play(user);
		} else if (game == 2) {
			CoinToss.play(user);
		}
	}

}
