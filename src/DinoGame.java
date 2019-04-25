import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class DinoGame implements Commons, Runnable{
	
	private Board board;
	private Thread gameAnimator;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage student;
	
	public DinoGame() {
		start();
	}
	
	private void initGame() {
		board = new Board();
		student = ImageLoader.loadImage("res\\student.png");
	}
	
	private void update(){
		//stage 1 in every game cycle
	}
	
	private void render(){
		//stage 2 in every game cycle, happens after update()
		bs = board.getCanvas().getBufferStrategy();
		if (bs == null) {
			board.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.drawImage(student, BOARD_WIDTH / 10, BOARD_HEIGHT / 2, null);
		
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		initGame();
		
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

