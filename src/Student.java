import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Student class is the sprite of the student.
 * @author 
 *
 */
public class Student extends Sprite {

	/**
	 * Constructs a Student with an image.
	 * @param student the student image
	 */
	public Student(BufferedImage student) {
		super(student);
	}
	
	/**
	 * Renders the student.
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(getImg(), BOARD_WIDTH / 10, BOARD_HEIGHT / 2, null);
	}

}
