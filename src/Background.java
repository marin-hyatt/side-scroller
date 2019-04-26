import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Background extends Sprite {

	private static int BG_WIDTH = 541;
	private int x;
	
	public Background(BufferedImage bg) {
		super(bg);
		x = 0;
	}
	
	@Override
	public void render(Graphics g) {
		System.out.println(x);
		if (x <= -BG_WIDTH) {
			x = 0;
		}
		g.drawImage(getImg(), x, 0, null);
		x--;
	}

}
