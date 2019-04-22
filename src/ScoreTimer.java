import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class ScoreTimer extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public ScoreTimer() {
		
		// set appearance of frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// add a score display label
		JLabel label = new JLabel("00000");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.CENTER);
		
		// listen for timer then add 1 to score every interval
		ActionListener scoreAdder = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(label.getText()) + 1;
				label.setText(String.format("%05d", score));
			}
		};
		
		// construct a Timer to activate scoreAdder after every interval
		Timer timer = new Timer(100, scoreAdder);
		timer.setInitialDelay(0);
		
		// add a start button
		JButton btnStart = new JButton("Start");
		// reset score and start timer when pressed
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("0");
				timer.start();
			}
		});
		contentPane.add(btnStart, BorderLayout.NORTH);
		
		// add an end button
		JButton btnEnd = new JButton("End");
		// stop timer when pressed
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});
		contentPane.add(btnEnd, BorderLayout.SOUTH);
			
	}

}
