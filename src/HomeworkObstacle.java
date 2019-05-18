import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HomeworkObstacle extends Obstacle {
	
	final int HOMEWORK_HEIGHT = 175;

	public HomeworkObstacle(BufferedImage img) {
		super(img, "homework");
		setY(HOMEWORK_HEIGHT);
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
