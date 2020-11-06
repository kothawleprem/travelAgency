import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TourInfo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TourInfo window = new TourInfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TourInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tour Info");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(294, 36, 192, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(107, 105, 86, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setBounds(107, 163, 62, 25);
		frame.getContentPane().add(lblDate);
		
		JLabel lblInfo = new JLabel("Price:");
		lblInfo.setForeground(new Color(255, 255, 255));
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfo.setBounds(107, 223, 62, 30);
		frame.getContentPane().add(lblInfo);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(TourInfo.class.getResource("/images/confirm.png")));
		btnNewButton.setBounds(188, 330, 154, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTours view = new ViewTours();
				view.NewScreen();
				frame.dispose();
			}
		});
		button.setIcon(new ImageIcon(TourInfo.class.getResource("/images/back.png")));
		button.setBorderPainted(false);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(395, 330, 154, 39);
		frame.getContentPane().add(button);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
