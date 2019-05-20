import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Spawns obstacles at random intervals.
 * @author 
 *
 */
public class ObstacleSpawner implements ActionListener {

	final int RANGE = 76;
	final int MAX = 255;
	
	private int ticksUntilSpawn;
	private Obstacle[] obstacles;
	
	/**
	 * Stores a random time interval indicating the number of ticks before the next obstacle 
	 * appears. Stores an array of all obstacles to be spawned.
	 * @param obstacleArray all obstacles to be spawned
	 */
	public ObstacleSpawner(Obstacle[] obstacleArray) {
		ticksUntilSpawn = (int) (Math.random() * RANGE + MAX);
		obstacles = obstacleArray;
	}
	
	/**
	 * Decrements the number of ticks remaining before the next obstacle appears every time the
	 * Timer calls the ObstacleSpawner ActionListener. Once there are no remaining ticks, pick
	 * a random obstacle from the array. Reset the obstacle's location (essentially preparing it
	 * to be rendered on screen). Choose another random number of ticks before the next obstacle
	 * spawns.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (ticksUntilSpawn == 0) {
			int chosenIndex = (int) (Math.random() * obstacles.length);
			obstacles[chosenIndex].reset();
			ticksUntilSpawn = (int) (Math.random() * RANGE + MAX);
		}
		else {
			ticksUntilSpawn--;
		}
	}

}
