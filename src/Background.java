import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The sprite of the looping background.
 * @author 
 *
 */
public class Background extends Sprite {

	/**
	 * Constant determining the width of the background sprite.
	 */
	private static int BG_WIDTH = 541;
	
	/**
	 * Instance variable setting the font of the text displayed in the background.
	 */
	private static Font instructFont = new Font("Sanserif", Font.BOLD, 15);
	
	/**
	 * Instance variable representing the score that the player got after losing the game.
	 */
	private int score;
	
	/**
	 * Constructs a Background with an image and an x-coordinate.
	 * @param bg the background image
	 */
	public Background(BufferedImage img) {
		super(img);
		setX(0);
		setSpeed(1);
	}
	
	/**
	 * Sets the score to be dispalyed
	 * @param s the player's score, taken from the ScoreCounter class
	 */
	public void setScore(int s) {
		score = s;
	}
	
	/**
	 * If the game is running, moves the background back a number of pixels each frame, looping once the image is at an end.
	 * If the player failed the game, displays the message to restart the game.
	 * If the player just started the game, displays instructions for starting the game.
	 */
	@Override
	public void render(Graphics g) {
		
		if(getGameState()) {
//			System.out.println("background");
			if (getX() <= -BG_WIDTH) {
				setX(0);
			}
			g.drawImage(getImg(), getX(), 0, null);
			modifyX(-getSpeed());
			if(getSpeed() <= 4) {
				decrementTimer();
			}
//			System.out.println(getSpeed());
		}
		else if(getFailed()){
			//puts instructions here
			g.drawImage(getImg(), getX(), 0, null);
			g.setFont(instructFont);
			g.drawString("Score: " + score, 15, BOARD_HEIGHT / 4);
			g.drawString("Press A to play again.", 15, BOARD_HEIGHT / 4 + 50);
		}
		else {
			//puts instructions here
			g.drawImage(getImg(), getX(), 0, null);
			g.setFont(instructFont);
			g.drawString("Press A to start.", 15, BOARD_HEIGHT / 4);
			g.drawString("Avoid the obstacles by pressing the spacebar to jump!", 15, BOARD_HEIGHT / 4 + 50);
		}
	}

}
