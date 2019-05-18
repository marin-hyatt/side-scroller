import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * The Sprite class stores an image and provides instructions for rendering the image.
 * @author 
 *
 */
public abstract class Sprite implements Commons, PlayerActions{
	
	private BufferedImage img;
	private String name;
	private int x;
	private int y;
	private int width;
	private int height;
	
	/**
	 * Constructs a Sprite class with an image.
	 * @param img the image to be stored
	 */
	public Sprite(BufferedImage img) {
		this.img = img;
		width = img.getWidth();
		height = img.getHeight();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
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
	
	/**
	 * Instructions for rendering the image.
	 * @param g
	 */
	public abstract void render(Graphics g);

	public abstract void initTimer();
}
