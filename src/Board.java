import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

public class Board implements Commons{
	private JFrame frame;
	private JPanel contentPane;
	private static BufferStrategy bs;
	
	public Board() {
		initUI();
	}
	
	private void initUI() {
		//Creating the window for our game
		frame = new JFrame(GAME_TITLE);
		frame.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// sets up buffer
		bs = frame.getBufferStrategy();
		if (bs == null) {
			frame.createBufferStrategy(3);
			return;
		}
		
		//Creating a JPanel to add to the window
		contentPane = new DinoGame();
		contentPane.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		contentPane.setMaximumSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		contentPane.setMinimumSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		
		frame.add(contentPane);
		frame.pack();
		
	}
	
	public static BufferStrategy getBoardBS() {
		return bs;
	}
}
