import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The sprites of obstacles.
 * @author
 *
 */
public class Obstacle extends Sprite {

	//tempWidth is for resetting the width after every time the obstacle goes off the screen
	private int tempWidth;

	/**
	 * Constructs a hidden obstacle with an image.
	 * @param img the obstacle image
	 */
	public Obstacle(BufferedImage img, String n) {
		super(img);
		tempWidth = img.getWidth();
		setName(n);
		setX(0);
		setY(BOARD_HEIGHT / 2);
		setSpeed(4);
	}

	/**
	 * Renders the obstacle, moving its location from right to left a number of pixels each tick.
	 */
	@Override
	public void render(Graphics g) {
		if(getGameState()) {
			g.drawImage(getImg(), (int) getX(), getY(), null);
			modifyX(-getSpeed());
			decrementTimer();
		}
	}
	
	/**
	 * Sets the obstacle location to the far right.
	 */
	public void reset() {
		setX(BOARD_WIDTH);
		setWidth(tempWidth);
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

}
