import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * The Sprite class stores an image and provides instructions for rendering the image.
 * @author 
 *
 */
public abstract class Sprite implements Commons, PlayerActions {
	
	public static int TICKS_UNTIL_FASTER = 600;
	
	private BufferedImage img;
	private String name;
	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;
	private int ticksUntilFaster;
	private boolean isRunning;
	
	/**
	 * Constructs a Sprite class with an image.
	 * @param img the image to be stored
	 */
	public Sprite(BufferedImage img) {
		this.img = img;
		width = img.getWidth();
		height = img.getHeight();
		isRunning = false;
		ticksUntilFaster = TICKS_UNTIL_FASTER;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public boolean getGameState() {
		return isRunning;
	}
	
	/**
	 * Returns x coordinate of sprite's location.
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}
	
	public void setX(int xPos) {
		x = xPos;
	}
	
	public void modifyX(int newPos) {
		if(isRunning) {
			x += newPos;
		}
	}
	
	/**
	 * Returns y coordinate of sprite's location.
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}
	
	public void setY(int yPos) {
		y = yPos;
	}
	
	public void setWidth(int w) {
		width = w;
	}
	
	/**
	 * Returns width of the sprite.
	 * @return the obstacle width
	 */
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int h) {
		height = h;
	}
	
	/**
	 * Returns height of the sprite.
	 * @return the obstacle height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Returns a Rectangle representing the bounds of the sprite.
	 * @return the obstacle width
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	public void checkCollisions(Sprite s) {
		if(getBounds().intersects(s.getBounds())) {
			System.out.println("collide");
		}
	}
	
	/**
	 * Returns the stored image.
	 * @return the stored image
	 */
	public BufferedImage getImg() {
		return img;
	}
	
	public String toString() {
		return(getName() + x + " " + y + " " + width + " " + height);
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
