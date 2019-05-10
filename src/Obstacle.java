import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The sprites of obstacles.
 * @author oz
 *
 */
public abstract class Obstacle extends Sprite {

	public static int SPEED = 3;
	private int x;
	
	/**
	 * Constructs a hidden obstacle with an image.
	 * @param img the obstacle image
	 */
	public Obstacle(BufferedImage img) {
		super(img);
		x = 0;
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
		x = BOARD_WIDTH;
	}
	
	/**
	 * Returns x coordinate of obstacle's location.
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}
	
	public void modifyX(int newPos) {
		x += newPos;
	}
	

}
