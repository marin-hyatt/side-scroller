import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * The Sprite class stores an image and provides instructions for rendering the image.
 */
public abstract class Sprite implements Commons {
	
	/**
	 * Constant representing the number of ticks until the speed of the sprite animation is increased.
	 */
	public static final int TICKS_UNTIL_FASTER = 600;
	
	/**
	 * Instance variable representing the image file of the sprite.
	 */
	private BufferedImage img;
	
	/**
	 * Instance variable representing the name of the sprite.
	 */
	private String name;
	
	/**
	 * Instance variable representing the x position of the sprite.
	 */
	private int x;
	
	/**
	 * Instance variable representing the y position of the sprite.
	 */
	private int y;
	
	/**
	 * Instance variable representing the width of the sprite.
	 */
	private int width;
	
	/**
	 * Instance variable representing the height of the sprite.
	 */
	private int height;
	
	/**
	 * Instance variable representing the speed of the sprite's movement.
	 */
	private int speed;
	
	/**
	 * Instance variable representing the number of ticks until the speed of the sprite animation is increased.
	 */
	private int ticksUntilFaster;
	
	/**
	 * Instance variable representing whether or not the game is running.
	 */
	private boolean isRunning;
	
	/**
	 * Instance variable representing whether or not the player failed the game.
	 */
	private boolean failed;
	
	/**
	 * Constructs a Sprite with an image, width, and height. 
	 * @param img the image to be stored
	 */
	public Sprite(BufferedImage img) {
		this.img = img;
		width = img.getWidth();
		height = img.getHeight();
		isRunning = false;
		ticksUntilFaster = TICKS_UNTIL_FASTER;
	}
	
	/**
	 * Getter for the name.
	 * @return name of sprite
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter for name
	 * @param n name of sprite
	 */
	public void setName(String n) {
		name = n;
	}
	
	/**
	 * Getter for the state of the game
	 * @return true if game is running, false if it isn't.
	 */
	public boolean getGameState() {
//		System.out.println(isRunning);
		return isRunning;
	}
	
	/**
	 * Setter for the game state.
	 * @param b whether the game is running or not.
	 */
	protected void setGameState(boolean b) {
		isRunning = b;
		failed = true;
	}
	
	/**
	 * Returns x coordinate of sprite's location.
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets x coordinate of sprite's location.
	 * @param xPos x coordinate to set sprite's location to
	 */
	public void setX(int xPos) {
		x = xPos;
	}
	
	/**
	 * Adds an integer to the sprite's x position if the game is running.
	 * @param newPos amount to increment the x position by
	 */
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
	
	/**
	 * Sets y coordinate of sprite's location.
	 * @param yPos y coordinate to set sprite's location to
	 */
	public void setY(int yPos) {
		y = yPos;
	}
	
	/**
	 * Sets width of sprite.
	 * @param w width of sprite
	 */
	public void setWidth(int w) {
		width = w;
	}
	
	/**
	 * Returns width of the sprite.
	 * @return the sprite width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Sets height of sprite.
	 * @param h the height of sprite
	 */
	public void setHeight(int h) {
		height = h;
	}
	
	/**
	 * Returns height of the sprite.
	 * @return the sprite height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Returns a Rectangle representing the bounds of the sprite.
	 * @return the bounds of the sprite
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	/**
	 * Returns if the game is failed or not
	 * @return true if the game is failed, false if it isn't
	 */
	public boolean getFailed() {
		return failed;
	}
	
	/**
	 * Checks whether the sprite intersects another sprite.
	 * @param s the other sprite
	 * @return true if the sprites collide, false if they didn't
	 */
	public boolean checkCollisions(Sprite s) {
		if(getBounds().intersects(s.getBounds())) {
//			System.out.println("collide");
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the stored image.
	 * @return the stored image
	 */
	public BufferedImage getImg() {
		return img;
	}
	
//	public String toString() {
////		return(getName() + x + " " + y + " " + width + " " + height);
//		return(getName() + getFailed());
//	}
	
	/**
	 * Returns the speed of the sprite
	 * @return the sprite speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Sets the speed to a new speed.
	 * @param newSpeed the new speed of the sprite
	 */
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	
	/**
	 * Increments the speed by one.
	 */
	public void speedUp() {
		speed++;
	}
	
	/**
	 * Returns the number of ticks until the sprite speeds up.
	 * @return the number of ticks until the sprite moves faster
	 */
	public int getTicksUntilFaster() {
		return ticksUntilFaster;
	}
	
	/**
	 * Sets the number of ticks until the sprite moves faster to an input.
	 * @param t the number of ticks until the sprite speeds up
	 */
	public void setTicksUntilFaster(int t) {
		ticksUntilFaster = t;
	}
	
	/**
	 * Decreases the number of ticks until the sprite increases its speed.
	 */
	public void decrementTimer() {
		ticksUntilFaster--;
		if (ticksUntilFaster == 0) {
			speedUp();
			ticksUntilFaster = TICKS_UNTIL_FASTER;
		}
	}
	
	/**
	 * Tells the sprites that the game is running and the player hasn't failed.
	 */
	public void initTimer() {
//		System.out.println("init");
		isRunning = true;
		failed = false;
		
	}
	
	/**
	 * When the player fails, tells the sprites that the game isn't running and that the player failed.
	 * Also resets the speed to what it was in the beginning of the game.
	 */
	public void failGame() {
		isRunning = false;
		failed = true;
		setSpeed(2);
//		System.out.println(getName() + " fail");
//		System.out.println("value of isRunning: " + isRunning);
	}
	
	/**
	 * Instructions for rendering the image.
	 * @param g
	 */
	public abstract void render(Graphics g);
}
