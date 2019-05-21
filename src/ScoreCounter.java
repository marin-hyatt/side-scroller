import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ScoreCounter extends Sprite implements ActionListener {
	
	private static Font scoreFont = new Font("Sanserif", Font.BOLD, 15);
	private static int TICKS_UNTIL_SCORE = 10;
	
	private int ticksUntilScore;
	private int score;

	public ScoreCounter(BufferedImage img) {
		super(img);
		ticksUntilScore = TICKS_UNTIL_SCORE;
		score = 0;
	}

	@Override
	public void render(Graphics g) {
		if(getGameState()) {
			g.setFont(scoreFont);
			g.drawString(String.valueOf(score), BOARD_WIDTH - 50, 50);
		}
	}
	
	public void failGame() {
		super.failGame();
		ticksUntilScore = TICKS_UNTIL_SCORE;
		score = 0;
//		System.out.println(ticksUntilScore + " " + score);
	}
	
	public int getScore() {
		return score;
	}

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
		}
	}
}
