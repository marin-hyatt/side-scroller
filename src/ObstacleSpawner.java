import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Spawns obstacles at random intervals.
 * @author 
 *
 */
public class ObstacleSpawner implements ActionListener {

	private int ticksUntilSpawn;
	private Obstacle[] obstacles;
	
	public ObstacleSpawner(Obstacle[] obstacleArray) {
		ticksUntilSpawn = (int) (Math.random() * 76 + 225);
		obstacles = obstacleArray;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (ticksUntilSpawn == 0) {
			int chosenIndex = (int) (Math.random() * obstacles.length);
			obstacles[chosenIndex].reset();
			ticksUntilSpawn = (int) (Math.random() * 76 + 225);
		}
		else {
			ticksUntilSpawn--;
		}
		
	}

}
