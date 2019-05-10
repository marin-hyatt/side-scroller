import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The sprite of the player.
 * @author 
 *
 */
public class Player extends Sprite {

	private int xPos = BOARD_WIDTH / 10;
	private int yPos = BOARD_HEIGHT / 2;
	private boolean isJumping = false;
	private double jumpStrength = 4;
	private double weight = 0.08;
	private int topPoint = yPos - 100;
	private boolean firstHalf = false;
	
	/**
	 * Constructs a Player with an image at the starting position.
	 * @param playerImg the player image
	 */
	public Player(BufferedImage img) {
		super(img);
	}
	
	@Override
	public void render(Graphics g) {
		if(isJumping) {
//			System.out.println("jump");
			if(yPos > topPoint && firstHalf) {
				yPos -= jumpStrength;
				jumpStrength -= weight;
			}
			if(yPos <= topPoint) {
//				System.out.println("t");
				firstHalf = false;
			}
			if(!firstHalf && yPos <= FLOOR_HEIGHT) {
				yPos += jumpStrength;
				jumpStrength += weight;
//				System.out.println("t");
			}
//			isJumping = false;
//			yPos = FLOOR_HEIGHT;
//				yPos--;
		}
//			else if(yPos <= FLOOR_HEIGHT && yPos <= topPoint) {
//				yPos--;
//			}
		g.drawImage(getImg(), xPos, yPos, null);
	}
	
	/**
	 * Returns x coordinate of the player's location.
	 * @return the x coordinate
	 */
	public int getX() {
		return xPos;
	}
	
	/**
	 * Returns y coordinate of the player's location.
	 * @return the y coordinate
	 */
	public int getY() {
		return yPos;
	}
	
	public void jump() {
		if(yPos >= FLOOR_HEIGHT) {
			isJumping = true;
			firstHalf = true;
			jumpStrength = 4;
		}
//		System.out.println("jump");
	}

}
