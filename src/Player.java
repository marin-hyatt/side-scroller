import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The sprite of the player.
 * @author 
 *
 */
public class Player extends Sprite {

	private int x, y;
	
	/**
	 * Constructs a Player with an image at the starting position.
	 * @param playerImg the player image
	 */
	public Player(BufferedImage img) {
		super(img);
		x = BOARD_WIDTH / 10;
		y = BOARD_HEIGHT / 2;
	}
	
	/**
	 * Renders the player.
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(getImg(), x, y, null);
	}
	
	/**
	 * Returns x coordinate of the player's location.
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Returns y coordinate of the player's location.
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}

}
