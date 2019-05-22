import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * An obstacle representing a failed homework.
 */
public class HomeworkObstacle extends Obstacle {
	
	/**
	 * Constant representing the y position of the homework when it moves.
	 */
	final int HOMEWORK_HEIGHT = 175;

	/**
	 * Constructs the homework obstacle and sets the y position to the homework height.
	 * @param img the image file representing the homework
	 */
	public HomeworkObstacle(BufferedImage img) {
		super(img, "homework");
		setY(HOMEWORK_HEIGHT);
	}
}
