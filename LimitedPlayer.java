package Project;

public class LimitedPlayer extends Player {
	// if a limited player the amount of turns is 10 so set it.
	public LimitedPlayer() {
		super.setturnsLimit(10);
	}
}
