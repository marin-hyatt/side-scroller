import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 * Draws and redraws sprites according to a timer. Also controls the animation of the sprites in accordance with if the game
 * is running or not.
 *
 */
public class SpriteUpdater implements ActionListener, PlayerActions {
	
	/**
	 * Instance variable representing the board that displays the sprites.
	 */
	private Board board;
	
	/**
	 * Instance variable that helps the game look smoother.
	 */
	private BufferStrategy bs;
	
	/**
	 * Instance variable representing graphics.
	 */
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
	 * @param e the Action Event that occurs every tick in accordance with the timer
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
		
		// renders sprites
		for (Sprite eachSprite : sprites) {
			// only draws obstacles if they are in the screen
			if ((eachSprite instanceof Obstacle)) {
				if (((Obstacle) eachSprite).getX() > 0) {
					eachSprite.render(g);
				}
				else {
					//makes rectangle bounds a line so it doesn't trigger collision after it passes the player
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
	
	/**
	 * Adds the key listener to the frame so it has an effect on the graphics.
	 * @param k the KeyboardListener object that is passed in (see KeyboardListener class)
	 */
	public void registerKeyListener(KeyboardListener k) {
		board.getFrame().addKeyListener(k);
	}

	/**
	 * Initializes the timer for every sprite so they know whether the game is running or not (see Sprite class).
	 */
	@Override
	public void initTimer() {
		for(Sprite s : sprites) {
			s.initTimer();
		}
	}

	/**
	 * If the player fails, tells the sprites that the game is over.
	 */
	@Override
	public void resetGame() {
		
//		System.out.println("reset");
		for(Sprite s : sprites) {
			s.failGame();
//			System.out.println(s);
		}
	}

	/**
	 * Will be implemented in the Player class.
	 */
	@Override
	public void jump() {
		// TODO Auto-generated method stub
	}

	/**
	 * Returns if the game is running or not.
	 * @return the game state
	 */
	@Override
	public boolean getGameState() {
		return(sprites.get(0).getGameState());
	}
	
}
