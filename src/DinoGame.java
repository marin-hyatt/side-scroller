import java.io.File;

import javax.swing.Timer;

public class DinoGame implements Commons, PlayerActions {
	
	private Player player;
	private Background bg;
	private Timer gameTimer;
	private SpriteUpdater spriteUpdater;
	private Obstacle[] obstacleArr;
	private KeyboardListener keyListener;
	
	public DinoGame() {
		//Display instructions to start
		initGame();
	}
	
	private void initGame() {
		keyListener = new KeyboardListener(this);
		initSprites();
//		initTimer();
	}
	
	private void initSprites() {
		player = new Player(ImageLoader.loadImage("res" + File.separator + "student.png"));
		bg = new Background(ImageLoader.loadImage("res" + File.separator + "bg.png"));
		obstacleArr = new Obstacle[] {
				(Obstacle) new PencilObstacle(ImageLoader.loadImage("res" + File.separator + "pencil.png")),
				(Obstacle) new HomeworkObstacle(ImageLoader.loadImage("res" + File.separator + "homework.png"))
			};

		spriteUpdater = new SpriteUpdater();
		spriteUpdater.addSprite((Sprite) bg);
		spriteUpdater.addSprite((Sprite) player);
		spriteUpdater.addSprite((Sprite) obstacleArr[0]);
		spriteUpdater.addSprite((Sprite) obstacleArr[1]);
		spriteUpdater.registerKeyListener(keyListener);
		
		gameTimer = new Timer(TICK, spriteUpdater);
		gameTimer.addActionListener(new ObstacleSpawner(obstacleArr));
		gameTimer.setInitialDelay(0);
	}
	
	//user presses "a" to init timer
	public void initTimer() {
//		System.out.println("start");
		gameTimer.start();
	}
	
	@Override
	public void jump() {
		player.jump();	
	}
	
}

