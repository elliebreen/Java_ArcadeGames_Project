package Project;

public class VIPPlayer extends Player {
	//VIP player which allows players to have 100 goes
	public VIPPlayer() {
		super.setturnsLimit(100);
	}
	// a to string method which shows they are a VIP player
	@Override
	public String toString() {
		return "\n" + getName() + "(" + getPlayerType() + ")" + "-" + getPoints() + "|\n";
	}

}
