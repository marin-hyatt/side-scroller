# side-scroller
A side-scroller obstacle game, inspired by the no Internet dino game.

## Latest commit
Add obstacles and spawner

Add the Obstacle class for the pencil and homework sprites. Add the 
ObstacleSpawner class to reset the position of the Obstacle objects at
random intervals, essentially "spawning" each obstacle randomly. 
Modifies the SpriteUpdater class to only render objects that have been
reset by ObstacleSpawner by only rendering Obstacle objects that have
an x-coordinate visible in the window.

Issues with the solution:
- The computer may consistently run its fan when the program starts now.
  This is likely because of some extreme inefficiency in the way
  obstacles are implemented -- perhaps its because SpriteUpdater must
  loops through inactive obstacles, or because two ActionListeners
  running at 60 FPS is too much.
- This implementation has the potential for error when ObstacleSpawner
  spawns an obstacle that is already spawned and moving across the
  screen. ObstacleSpawner may also only spawn one of each type of
  obstacle at the time.
