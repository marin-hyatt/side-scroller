import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PencilObstacle extends Obstacle {

	final int PENCIL_HEIGHT = 180;
	
	public PencilObstacle(BufferedImage img) {
		super(img, "pencil");
		setY(PENCIL_HEIGHT);
	}
}
