import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Sprite implements Commons {
	
	private BufferedImage img;
	
	public Sprite(BufferedImage img) {
		this.img = img;
	}
	
	public BufferedImage getImg() {
		return img;
	}
	
	public abstract void render(Graphics g);

}
