import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;

public class DinoGame implements Commons, Runnable{
	
	private Board board;
	private Thread gameAnimator;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage student, pencil, homework, bg;
	
	public DinoGame() {
		start();
	}
	
	private void initGame() {
		board = new Board();
	}
	
	private void initAssets() {
		student = ImageLoader.loadImage("res" + File.separator + "student.png");
		pencil = ImageLoader.loadImage("res" + File.separator + "pencil.png");
		homework = ImageLoader.loadImage("res" + File.separator + "homework.png");
		bg = ImageLoader.loadImage("res" + File.separator + "bg.png");
		
	}
	
	private void update(){
		// stage 1 in every game cycle
	}
	
	private void render(){
		// stage 2 in every game cycle, happens after update()
		// sets up buffer and graphics to draw images
		bs = board.getCanvas().getBufferStrategy();
		if (bs == null) {
			board.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		// draws images
		g.drawImage(bg, 0, 0, null);
		g.drawImage(student, BOARD_WIDTH / 10, BOARD_HEIGHT / 2, null);
		
		// shows images
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		initGame();
		initAssets();
		
		while(running){
			update();
			render();
		}
		
		stop();
		
	}
	
	public synchronized void start(){
		//if game is already running, don't do anything
		if(running) {
			return;
		}
		//if game isn't already running, start
		else {
			running = true;
			gameAnimator = new Thread(this);
			gameAnimator.start();
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
		try {
			gameAnimator.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

