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
	/**
	 * Instance variable representing if the player is jumping or not.
	 */
	private boolean isJumping = false;
	
	/**
	 * Instance variable representing the rate at which the y position is changed when jumping.
	 */
	private double jumpStrength = 4;
	
	/**
	 * Instance variable representing the rate at which the jumpStrength changes. 
	 * Use of this variable allows the player to mimic real-life jumping by having the y position change slower at the peak of the jump.
	 */
	private double weight = 0.08;
	
	/**
	 * Instance variable representing the y position that is the peak of the jump.
	 */
	private double topPoint;
	
	/**
	 * Instance variable representing whether the player has reached the peak of the jump yet.
	 */
	private boolean firstHalf = false;
	
	/**
	 * Constructs a Player with an image at the starting position, an x and y position, width and height, and the top point.
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
	
	/**
	 * Renders the player. If the game is running and the player is jumping, decrease the y position by the jumpStrength.
	 * Decrease the jumpStrength as the player gets further into the jump. If the player has passed the peak of the jump,
	 * increase the y position by the jumpStrength and increase the jumpStrength. When the player has reached the floor,
	 * the jump is over.
	 * @param g the graphics component
	 */
	@Override
	public void render(Graphics g) {
//		System.out.println(getGameState());
		if(isJumping && getGameState()) {
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
			if(getY() == FLOOR_HEIGHT) {
				isJumping = false;
			}
		}
		g.drawImage(getImg(), (int) getX(), (int) getY(), null);
	}
	
	/**
	 * Sets the player's state to jumping if the y position is at or below the floor. Resets the jump settings.
	 */
	public void jump() {
		if(getY() >= FLOOR_HEIGHT) {
			isJumping = true;
			firstHalf = true;
			jumpStrength = 4;
		}
//		System.out.println("jump");
	}

}
