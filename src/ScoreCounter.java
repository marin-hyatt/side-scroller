import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Displays the player's score on the screen when the game is running and increments it.
 *
 */
public class ScoreCounter extends Sprite implements ActionListener {
	
	/**
	 * Instance variable containing the font that the score will be displayed in.
	 */
	private static Font scoreFont = new Font("Sanserif", Font.BOLD, 15);
	
	/**
	 * Constant representing the number of ticks it takes before the score is increased.
	 */
	private static final int TICKS_UNTIL_SCORE = 10;
	
	/**
	 * Instance variable representing the number of ticks it takes before the score is increased.
	 */
	private int ticksUntilScore;
	
	/**
	 * Instance variable representing the current score.
	 */
	private int score;
	
	/**
	 * Instance variable representing the score from the previous game, to be displayed when the player fails.
	 */
	private int prevScore;

	/**
	 * Constructs a ScoreCounter and sets the score to 0.
	 * @param img
	 */
	public ScoreCounter(BufferedImage img) {
		super(img);
		ticksUntilScore = TICKS_UNTIL_SCORE;
		score = 0;
	}

	/**
	 * Renders the score if the game is running.
	 * @param g the graphics element
	 */
	@Override
	public void render(Graphics g) {
		if(getGameState()) {
			g.setFont(scoreFont);
			g.drawString(String.valueOf(score), BOARD_WIDTH - 50, 50);
		}
	}
	
	/**
	 * If the player fails, resets the current score.
	 */
	public void failGame() {
//		prevScore = score;
		super.failGame();
		ticksUntilScore = TICKS_UNTIL_SCORE;
		score = 0;
//		System.out.println(score);
	}
	
	/**
	 * Returns the score from the previous game.
	 * @return the previous score
	 */
	public int getScore() {
//		System.out.println("getScore: " + prevScore);
		return prevScore;
	}

	/**
	 * If the game is running, increment the score. Also stores the current score to return when the game is failed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(getGameState()) {
			if (ticksUntilScore == 0) {
				score++;
				ticksUntilScore = TICKS_UNTIL_SCORE;
			}
			else {
				ticksUntilScore--;
			}
			prevScore = score;
		}
	}
}
