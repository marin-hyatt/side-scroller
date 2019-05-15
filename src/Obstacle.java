import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The sprites of obstacles.
 * @author oz
 *
 */
public abstract class Obstacle extends Sprite {

	private int x;
	private boolean isRunning;
	
	
	/**
	 * Constructs a hidden obstacle with an image.
	 * @param img the obstacle image
	 */
	public Obstacle(BufferedImage img) {
		super(img);
		x = 0;
		speed = 4;
		ticksUntilFaster = TICKS_UNTIL_FASTER;
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
		if(isRunning) {
			x += newPos;
		}
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void speedUp() {
		speed++;
	}
	
	public void decrementTimer() {
		ticksUntilFaster--;
		if (ticksUntilFaster == 0) {
			speedUp();
			ticksUntilFaster = TICKS_UNTIL_FASTER;
		}
	}
	
	public void initTimer() {
		isRunning = true;
	}

}
