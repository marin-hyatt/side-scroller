import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PencilObstacle extends Obstacle {

	final int PENCIL_HEIGHT = 180;
	
	public PencilObstacle(BufferedImage img) {
		super(img, "pencil");
		setY(PENCIL_HEIGHT);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getImg(), (int) getX(), getY(), null);
		modifyX(-getSpeed());
		decrementTimer();
	}


	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

}
