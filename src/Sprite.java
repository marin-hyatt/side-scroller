import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Sprite class stores an image and provides instructions for rendering the image.
 * @author 
 *
 */
public abstract class Sprite implements Commons, PlayerActions {
	
	public static int TICKS_UNTIL_FASTER = 600;
	
	private BufferedImage img;
	private int speed;
	private int ticksUntilFaster;
	private int x;
	private boolean isRunning;
	
	/**
	 * Constructs a Sprite class with an image.
	 * @param img the image to be stored
	 */
	public Sprite(BufferedImage img) {
		this.img = img;
		isRunning = false;
		ticksUntilFaster = TICKS_UNTIL_FASTER;
	}
	
	/**
	 * Returns the stored image.
	 * @return the stored image
	 */
	public BufferedImage getImg() {
		return img;
	}
	
	/**
	 * Returns x coordinate of sprite's location.
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public void modifyX(int newPos) {
			x += newPos;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
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
	
	/**
	 * Instructions for rendering the image.
	 * @param g
	 */
	public abstract void render(Graphics g);

	public void initTimer() {
		isRunning = true;
	}
	
	public boolean getIsRunning() {
		return isRunning;
	}
	
}
