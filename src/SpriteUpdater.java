import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 * Draws and redraws sprites according to a timer.
 * @author 
 *
 */
public class SpriteUpdater implements ActionListener {
	
	private Board board;
	private BufferStrategy bs;
	private Graphics g;
	
	private ArrayList<Sprite> sprites;
	
	/**
	 * Constructs a SpriteUpdater with an ArrayList of all sprites and a Board.
	 */
	public SpriteUpdater() {
		sprites = new ArrayList<Sprite>();
		board = new Board();
	}
	
	public void addSprite(Sprite newSprite) {
		sprites.add(newSprite);
	}
	
	/**
	 * Once the SpriteUpdater is called (as an ActionListener), the BufferStrategy is retrieved
	 * from the Canvas instance variable in the Board object. This allows a Graphics object to be
	 * constructed from the BufferStrategy. Each Sprite can then be rendered using the Graphics
	 * object onto the buffer. The buffer then shows the render on the screen and the Graphics
	 * object is disposed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		bs = board.getCanvas().getBufferStrategy();
		if (bs == null) {
			board.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		// draws images
		for (Sprite eachSprite : sprites) {
			// only draws obstacles if they are in the screen
			// TODO Re-think this strategy. My computer runs its fans every time I start the program now, which is probably a bad thing.
			if ((eachSprite instanceof Obstacle || eachSprite instanceof AirObstacle)) {
				if (((Obstacle) eachSprite).getX() > 0) {
					eachSprite.render(g);
				}
			}
			else {
				eachSprite.render(g);
			}
		}

		// shows images
		bs.show();
		g.dispose();
		
	}
}
