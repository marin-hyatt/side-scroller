import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Background extends Sprite {

	private int x;
	private BufferedImage bg;
	
	public Background(BufferedImage bg) {
		x = 0;
		this.bg = bg;
	}
	
	public void render(Graphics g) {
		if (x == -541) {
			x = 0;
		}
		g.drawImage(bg, x, 0, null);
		x--;
	}

}
