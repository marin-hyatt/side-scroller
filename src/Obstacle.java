import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The sprites of obstacles.
 * @author oz
 *
 */
public abstract class Obstacle extends Sprite {

	//tempWidth is for resetting the width after every time the obstacle goes off the screen
	private int tempWidth;
	private static int TICKS_UNTIL_FASTER = 600;
	public int speed;
	public int ticksUntilFaster;
	private boolean isRunning;
	
	
	/**
	 * Constructs a hidden obstacle with an image.
	 * @param img the obstacle image
	 */
	public Obstacle(BufferedImage img, String n) {
		super(img);
		tempWidth = img.getWidth();
		setName(n);
		setX(BOARD_WIDTH + 10);
		setY(BOARD_HEIGHT / 2);
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
		setX(BOARD_WIDTH);
		setWidth(tempWidth);
	}
	
	public void modifyX(int newPos) {
		if(isRunning) {
			setX(getX() + newPos);
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
