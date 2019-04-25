import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Sprite implements ActionListener {
	
	private static Graphics g;
	
	public static void setGraphics(Graphics currentG) {
		g = currentG;
	}
	
	public Graphics getGraphics() {
		return g;
	}
	
	public abstract void actionPerformed(ActionEvent e);

}
