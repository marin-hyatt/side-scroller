
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Application extends JFrame implements Commons{

	JFrame mainWindow = new JFrame("Dinosaur Game");
	  
	  public void display() {
	    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    Container container = mainWindow.getContentPane();
	    
	    Board gamePanel = new Board();
	    gamePanel.addKeyListener(gamePanel);
	    gamePanel.setFocusable(true);
	    
	    container.setLayout(new BorderLayout());
	    
	    container.add(gamePanel, BorderLayout.CENTER);
	    
	    mainWindow.setSize(BOARD_WIDTH, BOARD_HEIGHT);
	    mainWindow.setResizable(false);
	    mainWindow.setVisible(true);
	  }
	  
	  public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Application frame = new Application();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	  }
}

