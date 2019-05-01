import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Obstacle extends Sprite {

	public static int SPEED = 2;
	private int x;
	
	public Obstacle(BufferedImage img) {
		super(img);
		x = 0;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getImg(), x, BOARD_HEIGHT / 2, null);
		x -= SPEED;
	}
	
	public void reset() {
		x = BOARD_WIDTH;
	}
	
	public int getX() {
		return x;
	}
	

}
