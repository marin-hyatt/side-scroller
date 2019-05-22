import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Listens for key input and responds to it.
 */
public class KeyboardListener implements KeyListener{
	
	/**
	 * Instance variable representing an object of a class that implements the PlayerActions interface.
	 */
	private PlayerActions p;
	
	/**
	 * Constructs a key listener.
	 * @param a the object responding to key input
	 */
	public KeyboardListener(PlayerActions a) {
		p = a;
	}
	
	/**
	 * If the key typed is "a" or "A", start the object's timer.
	 * If the key typed is a space, make the player jump as long as the game is running.
	 * @param e a KeyEvent passed in whenever the user types a key
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
//			System.out.println("gamestate: " + p.getGameState());
			if(!p.getGameState()) {
				p.initTimer();
			}
		}
		else if(e.getKeyChar() == ' ') {
			p.jump();
		}
	}

	/**
	 * This method is required because this class implements KeyListener, but this method is not used.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("key pressed");
		
	}

	/**
	 * This method is required because this class implements KeyListener, but this method is not used.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("key");
		
	}

}
