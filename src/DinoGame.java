import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DinoGame extends JPanel implements Commons{
	
	//private Board board;
	private Timer timer;
	private boolean running = false;
	private Student student;
	
	public DinoGame() {
		student = new Student();
		timer = new Timer(FRAME_RATE, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	              update();
	              repaint();
	          }	
		});
		run();
	}
	
	private void initGame() {
//		board = new Board();
		start();
	}
	
	public void run(){
		initGame();
		while(running){
			update();
			repaint();
		}
		stop();
	}
	
	private void update(){
		//stage 1 in every game cycle, update position of all sprites and game state
		
	}
	
	public void paintComponent(Graphics g) {
		//renders the sprites and background, like stage 2 of every game cycle
		 student.move(g);          
	}
	
	public synchronized void start(){
		//if game is already running, don't do anything
		if(running) {
			return;
		}
		//if game isn't already running, start
		else {
			running = true;
			timer.start();
		}
	}
	
	public synchronized void stop(){
		//if game isn't running, don't do anything
		if(!running) {
			return;
		}
		//if game is running, stop running
		else{
			running = false;
		}
			timer.stop();
	}
	
}

