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
	public void jump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setFont(scoreFont);
		g.drawString(String.valueOf(score), BOARD_WIDTH - 50, 50);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ticksUntilScore == 0) {
			score++;
			ticksUntilScore = TICKS_UNTIL_SCORE;
		}
		else {
			ticksUntilScore--;
		}
	}

}
