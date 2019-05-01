import java.io.File;

import javax.swing.Timer;

public class DinoGame implements Commons, Runnable{
	
	private Thread gameAnimator;
	private boolean running = false;
	
//	private BufferedImage student, pencil, homework;
	private Student student;
	private Background bg;
	private Timer gameTimer;
	private SpriteUpdater spriteUpdater;
	
	public DinoGame() {
		start();
	}
	
	private void initGame() {
		initSprites();
	}
	
	private void initSprites() {
		student = new Student(ImageLoader.loadImage("res" + File.separator + "student.png"));
//		pencil = ImageLoader.loadImage("res" + File.separator + "pencil.png");
//		homework = ImageLoader.loadImage("res" + File.separator + "homework.png");
		bg = new Background(ImageLoader.loadImage("res" + File.separator + "bg.png"));

		spriteUpdater = new SpriteUpdater();
		spriteUpdater.addSprite((Sprite) bg);
		spriteUpdater.addSprite((Sprite) student);
		
		gameTimer = new Timer(TICK, spriteUpdater);
		gameTimer.setInitialDelay(0);
	}
	
	public void run(){
		
		initGame();
		gameTimer.start();
		
		while(running){
			
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

