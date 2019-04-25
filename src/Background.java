import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class Background extends Sprite {

	private int x;
	private BufferedImage bg;
	
	public Background(BufferedImage bg) {
		x = 0;
		this.bg = bg;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		getGraphics().drawImage(bg, x + 1, 0, null);
	}
	
	public void render() {
		getGraphics().drawImage(bg, x + 1, 0, null);
	}

}
