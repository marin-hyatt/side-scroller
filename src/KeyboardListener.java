import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener{
	
	private PlayerActions p;
	
	public KeyboardListener(PlayerActions a) {
		p = a;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == 'a') {
			p.initTimer();
		}
		else if(e.getKeyChar() == ' ') {
			p.jump();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("key pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("key");
		
	}

}
