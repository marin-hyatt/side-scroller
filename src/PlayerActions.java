/**
 * An interface containing actions that multiple classes use to control the game.
 */
public interface PlayerActions {

	/**
	 * Initializes the timer.
	 */
	void initTimer();
	
	/**
	 * Resets the game.
	 */
	void resetGame();
	
	/**
	 * Gets the state of the game
	 * @return true if the game is running, false if the game isn't running.
	 */
	boolean getGameState();
	
	/**
	 * Makes the player jump.
	 */
	void jump();

}
