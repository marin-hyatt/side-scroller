import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DinoGame extends JPanel implements Commons{
	private static final long serialVersionUID = 1L;
	
	//private Board board;
	private Timer timer;
	private boolean running = false;
	private Student student;
	private Graphics g;
	private BufferedImage studentImg, pencilImg, homeworkImg;
	
	public DinoGame() {
		// sets up graphics to draw images using buffer
		g = Board.getBoardBS().getDrawGraphics();
		student = new Student();
		timer = new Timer(FRAME_RATE, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	              update();
	              repaint();
	          }	
		});
		run();
	}
	
	private void initGame() {
// 		board = new Board();
		start();
	}
	
	private void initAssets() {
		pencilImg = ImageLoader.loadImage("res" + File.separator + "pencil.png");
//		JLabel pencilImg = new JLabel(new ImageIcon(pencil));
//		add(pencilImg);
		homeworkImg = ImageLoader.loadImage("res" + File.separator + "homework.png");
//		JLabel homeworkImg = new JLabel(new ImageIcon(pencil));
//		add(homeworkImg);
//bg = ImageLoader.loadImage("res" + File.separator + "side scroller background.png");
		
	}
	
	public void run(){
		initGame();
		initAssets();
		
		while(running){
			update();
			repaint();
		}
		stop();
	}
	
	private void update(){
		//stage 1 in every game cycle, update position of all sprites and game state
		
	}
	
	public void paintComponent(Graphics g) {
		//renders the sprites and background, like stage 2 of every game cycle
		 student.move(g);
		// stage 2 in every game cycle, happens after update()
		// draws images
		g.drawImage(studentImg, BOARD_WIDTH / 10, BOARD_HEIGHT / 2, null);	
		// shows images
		Board.getBoardBS().show();
		g.dispose();
	}
	
	public synchronized void start(){
		//if game is already running, don't do anything
		if(running) {
			return;
		}
		//if game isn't already running, start
		else {
			running = true;
			timer.start();
		}
	}
	
	public synchronized void stop(){
		//if game isn't running, don't do anything
		if(!running) {
			return;
		}
		//if game is running, stop running
		else{
			running = false;
		}
			timer.stop();
	}
	
}

