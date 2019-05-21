/**
 * The Board class stores the graphical elements that display the game to the screen.
 */
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Board implements Commons{
	
	/**
	 * Instance variable of type JFrame that is being displayed on the screen. 
	 * All other graphical elements are added to this frame to be displayed.
	 */
	private JFrame frame;
	
	/**
	 * Instance variable of type Canvas that the sprites are being added to so they get displayed to the screen.
	 */
	private Canvas canvas;
	
	/**
	 * Initializes the graphics.
	 */
	public Board() {
		initUI();
	}
	
	/**
	 * Initializes the frame and the canvas and sets their dimensions. Adds the canvas to the frame and sets the frame to be
	 * visible so all elements are being displayed.
	 */
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
	
	/**
	 * Returns stored JFrame.
	 * @return the frame with the graphical elements.
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Returns stored Canvas.
	 * @return the stored Canvas
	 */
	public Canvas getCanvas() {
		return canvas;
	}
}
