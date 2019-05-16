import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The sprites of obstacles.
 * @author oz
 *
 */
public abstract class Obstacle extends Sprite {

	/**
	 * Constructs a hidden obstacle with an image.
	 * @param img the obstacle image
	 */
	public Obstacle(BufferedImage img) {
		super(img);
		setX(0);
		setSpeed(4);
	}

	/**
	 * Renders the obstacle, moving its location from right to left a number of pixels each tick.
	 */
	@Override
	public abstract void render(Graphics g);
	
	/**
	 * Sets the obstacle location to the far right.
	 */
	public void reset() {
		setX(BOARD_WIDTH);
	}

}
