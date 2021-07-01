package Project;

import java.util.Scanner;

public class RockPaperScissors extends Game {

	private static Scanner input = new Scanner(System.in);
	//static play method which plays the game
	public static void play(Player user) {
		//double while loop, one to exit and one to continue playing if catch occurs in try catch
		outerloop: while (true) {
			boolean ok = true;
			while (ok) {
				try {
					//ask user for input
					System.out.println("Rock, Paper, Scissors?");
					String guess = input.nextLine();
					//check input is valid
					if (guess.equalsIgnoreCase("rock") || guess.equalsIgnoreCase("paper")
							|| guess.equalsIgnoreCase("scissors")) {
						//generate computers choice
						double generated = Math.random();
						String computer = "";
						if (generated < 0.3) {
							computer = "Paper";
						} else if (generated > 0.3 && generated < 0.6) {
							computer = "Scissors";
						} else {
							computer = "Rock";
						}//set the win conditions
						boolean win = guess.equalsIgnoreCase("rock") && computer.equalsIgnoreCase("scissors")
								|| guess.equalsIgnoreCase("paper") && computer.equalsIgnoreCase("rock")
								|| guess.equalsIgnoreCase("scissors") && computer.equalsIgnoreCase("paper");
						boolean draw = guess.equalsIgnoreCase(computer);
						//if win/draw/lose show message and set points
						if (win) {
							System.out.println("You won! 10 Points has been added to your account.");
							user.setPoints(10);
						} else if (draw) {
							System.out.println("Its a draw! 2 Points has been added to your account.");
							user.setPoints(2);
						} else {
							System.out.println("Hard Luck - You lost!");
						}//tell the user their guess and ask do they want to play again
						System.out.println("You chose " + guess + " The computer was  " + computer
								+ ". \n Do you want to play again? ");
						String response = input.nextLine();
						//declare valid exit responses
						boolean validExitResponse = response.equalsIgnoreCase("no")
								|| !response.equalsIgnoreCase("yes");
						//if valid exit response break both loops
						if (validExitResponse) {
							break outerloop;
						}
					//if not valid response print error message 
					} else {
						System.out.println("Error: Input must be rock, paper or scissors.");
						break;
					}
					ok = false;
				//catch any errors and print what input should be 
				} catch (Exception e) {
					System.out.println("Error: Input must be rock, paper or scissors.");
					ok = true;
				}
			}
		}
	}
}
