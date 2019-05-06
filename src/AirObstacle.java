import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class AirObstacle extends Obstacle {
	
	private static int[] HEIGHTS = { 150, 200, 250 };

	public AirObstacle(BufferedImage img) {
		super(img);
	}
	
	@Override
	public void render(Graphics g) {
//		int heightIndex = (int) (Math.random() * HEIGHTS.length);
//		g.drawImage(getImg(), getX(), HEIGHTS[heightIndex], null);
		g.drawImage(getImg(), getX(), 250, null);
	}

}
