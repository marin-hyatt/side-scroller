import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ScoreDisplayerTester extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreDisplayerTester frame = new ScoreDisplayerTester();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public ScoreDisplayerTester() {
		
		// set appearance of frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// add a score display label
		JLabel label = new JLabel("0");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.CENTER);
		
		// construct ScoreDisplayer object
		ScoreDisplayer counter = new ScoreDisplayer(label);
		counter.start();
		
		// add a start button
		JButton btnStart = new JButton("Start");
		// start ScoreDisplayer counting when pressed
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter.startCounting();
			}
		});
		contentPane.add(btnStart, BorderLayout.NORTH);
		
		// add an end button
		JButton btnEnd = new JButton("End");
		// end ScoreDisplayer counting when pressed
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter.stopCounting();
			}
		});
		contentPane.add(btnEnd, BorderLayout.SOUTH);
			
	}

}
