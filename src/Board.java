import javax.swing.*;
import java.awt.event.*;

public class Board extends JPanel implements KeyListener, Runnable{
	
	private Timer timer;
	private Thread gameAnimator;
	
	public Board() {
		add(new ScoreTimer());
	}
	
	@Override
	public void keyTyped(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_SPACE){
			//game starts
		}
		else if(event.getKeyCode() == KeyEvent.VK_UP) {
			//dinosaur jumps once 
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		
		
	}
	
	public synchronized void start() {
		
	}
	
	public synchronized void stop() {
		
	}
	
}
