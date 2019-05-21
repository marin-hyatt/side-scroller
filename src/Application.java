import java.awt.EventQueue;

public class Application implements Commons{
	  
	/**
	 * Constructs a DinoGame object, starting the game.
	 * @param args N/A
	 */
	  public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						new DinoGame();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	  }
}

