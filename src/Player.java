import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The sprite of the player.
 * @author 
 *
 */
public class Player extends Sprite {
//	private int xPos = BOARD_WIDTH / 10;
//	private int yPos = BOARD_HEIGHT / 2;
	private boolean isJumping = false;
	private double jumpStrength = 4;
	private double weight = 0.08;
	private double topPoint;
	private boolean firstHalf = false;
	
	/**
	 * Constructs a Player with an image at the starting position.
	 * @param playerImg the player image
	 */
	public Player(BufferedImage img) {
		super(img);
		setName("player");
		setX(BOARD_WIDTH / 10);
		setY(BOARD_HEIGHT / 2);
		setWidth(55);
		setHeight(85);
		topPoint = getY() - 100;
	}
	
	@Override
	public void render(Graphics g) {
		if(isJumping && getIsRunning()) {
//			System.out.println("jump");
			if(getY() > topPoint && firstHalf) {
				setY((int) (getY() - jumpStrength));
				jumpStrength -= weight;
			}
			if(getY() <= topPoint) {
//				System.out.println("t");
				firstHalf = false;
			}
			if(!firstHalf && getY() <= FLOOR_HEIGHT) {
				setY((int) (getY() + jumpStrength));
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
		g.drawImage(getImg(), (int) getX(), (int) getY(), null);
	}
	
	public void jump() {
		if(getY() >= FLOOR_HEIGHT) {
			isJumping = true;
			firstHalf = true;
			jumpStrength = 4;
		}
//		System.out.println("jump");
	}

}
