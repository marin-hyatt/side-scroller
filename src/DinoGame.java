import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.Timer;

/**
 * The main class for the game
 *
 */
public class DinoGame implements Commons, PlayerActions {
	
	private boolean isGameRunning;
	
	private Player player;
	private Background bg;
	private ScoreCounter scoreCounter;
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
		gameTimer.start();
//		initTimer();
	}
	
	private void initSprites() {
		player = new Player(ImageLoader.loadImage("res" + File.separator + "student.png"));
		bg = new Background(ImageLoader.loadImage("res" + File.separator + "bg.png"));
		scoreCounter = new ScoreCounter(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
		obstacleArr = new Obstacle[] {
				(Obstacle) new PencilObstacle(ImageLoader.loadImage("res" + File.separator + "pencil.png")),
				(Obstacle) new HomeworkObstacle(ImageLoader.loadImage("res" + File.separator + "homework.png"))
			};

		spriteUpdater = new SpriteUpdater();
		spriteUpdater.addSprite((Sprite) bg);
		spriteUpdater.addSprite((Sprite) player);
		spriteUpdater.addSprite(scoreCounter);
		spriteUpdater.addSprite((Sprite) obstacleArr[0]);
		spriteUpdater.addSprite((Sprite) obstacleArr[1]);
		spriteUpdater.registerKeyListener(keyListener);
		
		
		
		gameTimer = new Timer(TICK, spriteUpdater);
		gameTimer.setInitialDelay(0);
	}
	
	//user presses "a" to init timer and start the game
	public void initTimer() {
//		System.out.println("start");
		isGameRunning = true;
		
		if(!player.getFailed()) {
			gameTimer.addActionListener(new ObstacleSpawner(obstacleArr));
			gameTimer.addActionListener(scoreCounter);
		}
		
		spriteUpdater.initTimer();
//		player.initTimer();
//		System.out.println("player timer initiated");
//		bg.initTimer();
//		System.out.println("bg timer initiated");
		for(Obstacle element : obstacleArr) {
			element.initTimer();
//			System.out.println(element.getName() + "timer initiated");
		}
	}
	
//	public boolean getGameState() {
//		return isGameRunning;
//	}
	
	@Override
	public void jump() {
		player.jump();	
	}

	@Override
	public void resetGame() {
		isGameRunning = false;
	}

	@Override
	public boolean getGameState() {
		return player.getGameState();
	}
	
}

