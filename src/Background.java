import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The sprite of the looping background.
 * @author 
 *
 */
public class Background extends Sprite {

	private static int BG_WIDTH = 541;
	private static Font instructFont = new Font("Sanserif", Font.BOLD, 15);
	
	/**
	 * Constructs a Background with an image and an x-coordinate.
	 * @param bg the background image
	 */
	public Background(BufferedImage img) {
		super(img);
		setX(0);
		setSpeed(1);
	}
	
	/**
	 * Moves the background back a number of pixels each frame, looping once the image is at an end.
	 */
	@Override
	public void render(Graphics g) {
		
		if(getGameState()) {
//			System.out.println("background");
			if (getX() <= -BG_WIDTH) {
				setX(0);
			}
			g.drawImage(getImg(), getX(), 0, null);
			modifyX(-getSpeed());
			if(getSpeed() <= 4) {
				decrementTimer();
			}
//			System.out.println(getSpeed());
		}
		else if(getFailed()){
			//puts instructions here
			g.drawImage(getImg(), getX(), 0, null);
			g.setFont(instructFont);
			g.drawString("Press A to play again.", 15, BOARD_HEIGHT / 4);
		}
		else {
			//puts instructions here
			g.drawImage(getImg(), getX(), 0, null);
			g.setFont(instructFont);
			g.drawString("Press A to start.", 15, BOARD_HEIGHT / 4);
			g.drawString("Avoid the obstacles by pressing the spacebar to jump!", 15, BOARD_HEIGHT / 4 + 50);
		}
	}

}
