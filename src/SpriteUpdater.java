import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class SpriteUpdater implements ActionListener {
	
	private Board board;
	private BufferStrategy bs;
	private Graphics g;
	
	private ArrayList<Sprite> sprites;
	
	public SpriteUpdater(ArrayList<Sprite> sprites) {
		this.sprites = sprites;
		board = new Board();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		bs = board.getCanvas().getBufferStrategy();
		if (bs == null) {
			board.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		// draws images
		for (Sprite eachSprite : sprites) {
			eachSprite.render(g);
		}

		// shows images
		bs.show();
		g.dispose();
		
	}
}
