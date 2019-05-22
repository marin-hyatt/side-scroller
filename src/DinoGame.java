import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.Timer;

/**
 * The main class for the game that initializes the game, including the sprites and timer.
 *
 */
public class DinoGame implements Commons, PlayerActions {
	
	/**
	 * Instance variable representing the player.
	 */
	private Player player;
	
	/**
	 * Instance variable representing the background.
	 */
	private Background bg;
	
	/**
	 * Instance variable representing the score counter (a counter that takes a running total of the score).
	 */
	private ScoreCounter scoreCounter;
	
	/**
	 * Instance variable representing the timer for the game, which animates the sprites as time passes.
	 */
	private Timer gameTimer;
	
	/**
	 * Instance variable that renders the sprites in accordance with the game timer.
	 */
	private SpriteUpdater spriteUpdater;
	
	/**
	 * Instance variables representing the different obstacles in the game.
	 */
	private Obstacle[] obstacleArr;
	
	/**
	 * Instance variable that responds to key input.
	 */
	private KeyboardListener keyListener;
	
	/**
	 * Initializes the game.
	 */
	public DinoGame() {
		//Display instructions to start
		initGame();
		
	}
	
	/**
	 * Initializes the game, which includes setting up the key listener, initializing the sprites, and starting the timer.
	 */
	private void initGame() {
		keyListener = new KeyboardListener(this);
		initSprites();
		gameTimer.start();
//		initTimer();
	}
	
	/**
	 * Initializes the sprites. It loads in images from the resource folder for the sprites, constructs a score counter,
	 * and adds all of the sprites to the sprite updater. It also registers the key listener so that the sprites respond
	 * to key input. Finally, it constructs the game timer so that the sprites respond to the timer.
	 */
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
	
	
	/**
	 * Initializes the timer, which adds action listeners to the obstacle spawner and score counter. It also tells all
	 * of the sprites that the timer is initialized, which signals them that the game is running (see Sprite class). 
	 */
	public void initTimer() {
//		System.out.println("start");
		
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
	
	/**
	 * Tells the player to jump (see Player class).
	 */
	@Override
	public void jump() {
		player.jump();	
	}

	/**
	 * Method implemented from the PlayerActions interface that doesn't need implementation in this specific class.
	 * See SpriteUpdater class to see implementation.
	 */
	@Override
	public void resetGame() {
	}

	/**
	 * @return true if the game is running and false if it isn't.
	 */
	@Override
	public boolean getGameState() {
		return player.getGameState();
	}
	
}

