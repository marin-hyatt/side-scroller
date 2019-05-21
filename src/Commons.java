/**
 * Interface with some common constants, such as the width of the window for the game and the frames per second.
 */
public interface Commons {
	final int BOARD_WIDTH = 450;
	final int BOARD_HEIGHT = 300;
	final int FLOOR_HEIGHT = BOARD_HEIGHT / 2;
	final String GAME_TITLE = "Side Scroller";
	
	final int FPS = 60;
	final int MILLISECONDS = 1000;
	final int TICK = MILLISECONDS / FPS;
}
