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
	private int speed;
	private int ticksUntilFaster;
	private int x;
	
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
		if (x <= -BG_WIDTH) {
			x = 0;
		}
		g.drawImage(getImg(), x, 0, null);
		x -= speed;
		incrementTimer();
	}
	
	public void incrementTimer() {
		ticksUntilFaster--;
		if (ticksUntilFaster == 0) {
			speed++;
			ticksUntilFaster = TICKS_UNTIL_FASTER;
		}
	}

}
