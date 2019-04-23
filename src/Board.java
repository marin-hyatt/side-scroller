import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.*;

public class Board implements Commons{
	private JFrame frame;
	private Canvas canvas;
	
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
		
		//Creating a canvas to add to the window
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		canvas.setMaximumSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		canvas.setMinimumSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		
		frame.add(canvas);
		frame.pack();
		
	}
}
