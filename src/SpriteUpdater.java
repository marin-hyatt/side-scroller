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
public class SpriteUpdater implements ActionListener, PlayerActions {
	
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
	 * 
	 * 
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
		if (sprites.get(1).checkCollisions(sprites.get(3)) || sprites.get(1).checkCollisions(sprites.get(4)) ) {
			if(!sprites.get(1).getFailed()) {
				//displays score before it gets reset to 0
				((Background) sprites.get(0)).setScore(((ScoreCounter) sprites.get(2)).getScore());
				System.out.println(((ScoreCounter) sprites.get(2)).getScore());
				//resets game
				resetGame();
			}
		}
		
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
//			g.drawRect(eachSprite.getX(), eachSprite.getY(), eachSprite.getWidth(), eachSprite.getHeight());
		}
			
	//		for(Sprite s : sprites) {
	//			System.out.println(s);
	//		} 
			
		// shows images
		bs.show();
		g.dispose();
		
	}
	
	public void registerKeyListener(KeyboardListener k) {
		board.getFrame().addKeyListener(k);
	}

	@Override
	public void initTimer() {
		for(Sprite s : sprites) {
			s.initTimer();
		}
	}

	@Override
	public void resetGame() {
		
//		System.out.println("reset");
		for(Sprite s : sprites) {
			s.failGame();
//			System.out.println(s);
		}
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean getGameState() {
		return(sprites.get(0).getGameState());
	}
	
}
