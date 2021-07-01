package Project;

public class Player {
	//private variables of username, points, turnslimit and player type
	private String userName;
	private int points;
	private int turnsLimit;
	private String playerType;
	//default player 
	public Player() {
		userName = "Guest";
		points = 0;
		turnsLimit = 3;
		playerType = "Default";
	}
	//getter and setter methods for each variable
	public void setName(String userName) {
		this.userName = userName;

	}

	public String getName() {
		return userName;

	}

	public void setPoints(int points) {
		this.points += points;

	}

	public int getPoints() {
		return points;

	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;

	}

	public String getPlayerType() {
		return playerType;

	}

	public void setturnsLimit(int turnsLimit) {
		this.turnsLimit = turnsLimit;

	}

	public int getTurnsLimit() {
		return turnsLimit;

	}
	//to string method which prints name and points
	@Override
	public String toString() {
		return "\n" + getName() + "-" + getPoints() + "|\n";
	}
}