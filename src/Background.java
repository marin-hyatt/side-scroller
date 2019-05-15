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
	private static int TICKS_UNTIL_FASTER = 600;
	private static Font instructFont = new Font("Sanserif", Font.BOLD, 15);
	private int speed;
	private int ticksUntilFaster;
	private int x;
	private boolean isRunning;
	
	/**
	 * Constructs a Background with an image and an x-coordinate.
	 * @param bg the background image
	 */
	public Background(BufferedImage img) {
		super(img);
		x = 0;
		speed = 1;
		ticksUntilFaster = TICKS_UNTIL_FASTER;
	}
	
	/**
	 * Moves the background back a number of pixels each frame, looping once the image is at an end.
	 */
	@Override
	public void render(Graphics g) {
		
		if(isRunning) {
			if (x <= -BG_WIDTH) {
				x = 0;
			}
			g.drawImage(getImg(), x, 0, null);
			x -= speed;
			incrementTimer();
		}
		else {
			//puts instructions here
			g.drawImage(getImg(), x, 0, null);
			g.setFont(instructFont);
			g.drawString("Press A to start.", 15, BOARD_HEIGHT / 4);
			g.drawString("Avoid the obstacles by pressing the spacebar to jump!", 15, BOARD_HEIGHT / 4 + 50);
		}
	}
	
	public void incrementTimer() {
		ticksUntilFaster--;
		if (ticksUntilFaster == 0) {
			speed++;
			ticksUntilFaster = TICKS_UNTIL_FASTER;
		}
	}

	@Override
	public void initTimer() {
		isRunning = true;
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

}
