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
//		System.out.println(sprites.get(sprites.size()-1));
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
		
		//checks if player collides with pencil obstacle or homework obstacle
		if ( sprites.get(1).checkCollisions(sprites.get(2)) ||
				sprites.get(1).checkCollisions(sprites.get(3)) ) {
			System.out.println("stop game");
		}
		else {
			// draws images
			for (Sprite eachSprite : sprites) {
				// only draws obstacles if they are in the screen
				if ((eachSprite instanceof Obstacle)) {
					if (((Obstacle) eachSprite).getX() > 0) {
						eachSprite.render(g);
					}
					else {
						//makes rectangle bounds a line so it doesn't trigger collision
						eachSprite.setWidth(0);
					}
				}
				else {
					eachSprite.render(g);
				}
				g.drawRect(eachSprite.getX(), eachSprite.getY(), eachSprite.getWidth(), eachSprite.getHeight());
			}
			
	//		for(Sprite s : sprites) {
	//			System.out.println(s);
	//		} 
		}
			
		// shows images
		bs.show();
		g.dispose();
		
	}
	
	public void registerKeyListener(KeyboardListener k) {
		board.getFrame().addKeyListener(k);
	}
	
}
