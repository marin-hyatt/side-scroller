import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Student extends Sprite {

	public Student(BufferedImage student) {
		super(student);
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getImg(), BOARD_WIDTH / 10, BOARD_HEIGHT / 2, null);
	}

}
