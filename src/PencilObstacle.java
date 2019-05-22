import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * A class representing a pencil as an obstacle.
 */
public class PencilObstacle extends Obstacle {

	/**
	 * Constant representing the y position at which the pencil moves.
	 */
	final int PENCIL_HEIGHT = 180;
	
	/**
	 * Constructs the pencil with the y Position at the pencil height.
	 * @param img the image file representing the pencil
	 */
	public PencilObstacle(BufferedImage img) {
		super(img, "pencil");
		setY(PENCIL_HEIGHT);
	}
}
