import java.io.File;

import javax.swing.Timer;

public class DinoGame implements Commons, Runnable{
	
	private Thread gameAnimator;
	private boolean running = false;
	
//	private BufferedImage student, pencil, homework;
	private Player player;
	private Background bg;
	private Timer gameTimer;
	private SpriteUpdater spriteUpdater;
	private Obstacle[] obstacleArr;
	
	public DinoGame() {
		start();
	}
	
	private void initGame() {
		initSprites();
	}
	
	private void initSprites() {
		player = new Player(ImageLoader.loadImage("res" + File.separator + "student.png"));
		bg = new Background(ImageLoader.loadImage("res" + File.separator + "bg.png"));
		obstacleArr = new Obstacle[] {
				(Obstacle) (new AirObstacle(ImageLoader.loadImage("res" + File.separator + "pencil.png"))),
				new Obstacle(ImageLoader.loadImage("res" + File.separator + "homework.png"))
			};

		spriteUpdater = new SpriteUpdater();
		spriteUpdater.addSprite((Sprite) bg);
		spriteUpdater.addSprite((Sprite) player);
		spriteUpdater.addSprite((Sprite) obstacleArr[0]);
		spriteUpdater.addSprite((Sprite) obstacleArr[1]);
		
		gameTimer = new Timer(TICK, spriteUpdater);
		gameTimer.addActionListener(new ObstacleSpawner(obstacleArr));
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

