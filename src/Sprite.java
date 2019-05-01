import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Sprite class stores an image and provides instructions for rendering the image.
 * @author 
 *
 */
public abstract class Sprite implements Commons {
	
	private BufferedImage img;
	
	/**
	 * Constructs a Sprite class with an image.
	 * @param img the image to be stored
	 */
	public Sprite(BufferedImage img) {
		this.img = img;
	}
	
	/**
	 * Returns the stored image.
	 * @return the stored image
	 */
	public BufferedImage getImg() {
		return img;
	}
	
	/**
	 * Instructions for rendering the image.
	 * @param g
	 */
	public abstract void render(Graphics g);

}
