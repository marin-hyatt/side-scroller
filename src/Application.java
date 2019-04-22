import java.awt.EventQueue;
import javax.swing.JFrame;

public class Application extends JFrame{

	/**
	 * Launch the application.
	 */

	public Application() {
		initUI();
	}

	private void initUI() {
		add(new ScoreTimer());
		// set appearance of frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreTimer frame = new ScoreTimer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

