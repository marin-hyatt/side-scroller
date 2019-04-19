import javax.swing.JLabel;

/**
 * An updating display for the accumulating score.
 * @author Celina Wu
 */
public class ScoreDisplayer extends Thread {

	private static final int TIME_DELAY = 100;
	
	private JLabel display;
	private int score;
	private boolean counting;
	
	/**
	 * Constructs a paused ScoreDisplayer instance with an initial score of 0 and
	 * stores the memory reference of a JLabel used to display the score.
	 * @param inDisplay the score display
	 */
	public ScoreDisplayer(JLabel inDisplay) {
		counting = false;
		display = inDisplay;
		int score = 0;
		// bad design
		display.setText(String.valueOf(score));
	}
	
	/**
	 * Updates and displays the score asynchronously from the main thread.
	 * As long as the game is running, counting will be true and the score will
	 * continue to be updated, incremented by 1 after a given time delay.
	 */
	public void run() {
		// more bad design, burning up CPU
		// should use wait() notify()
		// considering abandoning Thread entirely for Timer
		while (true) {
			// bad design
			int score = 0;
			display.setText(String.valueOf(score));
			while (counting) {
				try {
					Thread.sleep(TIME_DELAY);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				score++;
				display.setText(String.valueOf(score));
			}
			while (!counting) {
				try {
					Thread.sleep(TIME_DELAY);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Starts the run method to count and update the display.
	 */
	public void startCounting() {
		counting = true;
	}
	
	/**
	 * Stops the run method from counting and updating the display.
	 */
	public void stopCounting() {
		counting = false;
	}
	
}
