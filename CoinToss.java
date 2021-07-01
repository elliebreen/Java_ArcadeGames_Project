package Project;

import java.util.Scanner;

public class CoinToss extends Game {
	//static scanner which takes input from user
	private static Scanner input = new Scanner(System.in);

	public static void play(Player user) {
//while loop to keep playing until the user wants to quit
		outerloop: while (true) {
			boolean ok = true;
			//while loop to keep performing try catch statement until no catch
			while (ok) {
				try {//calculate the computer flip and ask user for theirs
					double flip = Math.random();
					System.out.println("Heads or tails?");
					String guess = input.nextLine();
					//if users guess is either heads of tails play the game
					if (guess.equalsIgnoreCase("heads") || guess.equalsIgnoreCase("tails")) {
						//set what heads and tails are
						String coin = "tails";
						if (flip < 0.5) {
							coin = "heads";
						}
						// if guess is equal to the coin flip print a congratulations and add pooints to users account
						if (guess.equalsIgnoreCase(coin)) {
							System.out.println("You Won! 10 Points has been added to your account.");
							user.setPoints(10);
						}//print out the results and ask user do they want to play again
						System.out.println(
								"You guessed " + guess + " The flip was " + coin + ". \n Do you want to play again? ");
						//get the response from the user
						String response = input.nextLine();
						//if the reseponse is no or anything but yes its a valid exit repsonse
						boolean validExitResponse = response.equalsIgnoreCase("no")
								|| !response.equalsIgnoreCase("yes");
						//if valid exit both loops
						if (validExitResponse) {
							break outerloop;
						}
					//otherwise tell them it must be heads of tails	
					} else {
						System.out.println("Error: Input must be heads or tails.");
						break;
					}
					ok = false;
				} catch (Exception e) {
					//catch any exceptions and tell them what input should be 
					System.out.println("Error: Input must be heads or tails.");
					//ok still true as want to re ask for input
					ok = true;
				}

			}

		}
	}
}
