import java.awt.Graphics;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;

import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DinoGame extends JPanel implements Commons{
	
	//private Board board;
	private Timer timer;
	private boolean running = false;
	private Student student;
	
	//private BufferStrategy bs;
	//private Graphics g;
	
	private BufferedImage pencil, homework;
	
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
// 		board = new Board();
		start();
	}
	
	private void initAssets() {
		pencil = ImageLoader.loadImage("res" + File.separator + "pencil.png");
		homework = ImageLoader.loadImage("res" + File.separator + "homework.png");
		
	}
	
//	private void render(){
//		// stage 2 in every game cycle, happens after update()
//		// sets up buffer and graphics to draw images
//		bs = board.getCanvas().getBufferStrategy();
//		if (bs == null) {
//			board.getCanvas().createBufferStrategy(3);
//			return;
//		}
//		g = bs.getDrawGraphics();
//		
//		// draws images
//		g.drawImage(student, BOARD_WIDTH / 10, BOARD_HEIGHT / 2, null);
//		
//		// shows images
//		bs.show();
//		g.dispose();
//	}
	
	public void run(){
		initGame();
		initAssets();
		
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

