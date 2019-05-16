import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PencilObstacle extends Obstacle {

	final int PENCIL_HEIGHT = 180;
	
	public PencilObstacle(BufferedImage img) {
		super(img);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getImg(), getX(), PENCIL_HEIGHT, null);
		modifyX(-getSpeed());
		decrementTimer();
	}


	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

}
