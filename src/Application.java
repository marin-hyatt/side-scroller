/**
 * This is a list of what each person contributed to the development of the game.
 * 
 * Celina Wu: Setting up the game timer and animating all of the sprites in accordance with the timer, drawing the background by hand,
 * creating the score counter, condensing a lot of the code, contributing to the javadoc
 * 
 * Marin Hyatt: Setting up the basic structure of the game, making the game respond to all user input, creating the jumping algorithm,
 * creating the starting and ending states of the game (including background text), resetting the game whenever the player fails,
 * contributing to the javadoc, drawing the player and obstacles by hand
 */
import java.awt.EventQueue;
/**
 * Runs the game.
 */
public class Application implements Commons{
	  
	/**
	 * Constructs a DinoGame object, starting the game.
	 * @param args N/A
	 */
	  public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						new DinoGame();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	  }
}

