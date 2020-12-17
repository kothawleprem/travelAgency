import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class UserBookingSuccessful {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen(final String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserBookingSuccessful window = new UserBookingSuccessful(username);
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
	public UserBookingSuccessful(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setTitle("Booking Successful - "+username);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Booking Done!!!");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 32));
		lblNewLabel_1.setBounds(73, 27, 350, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboard userdb = new UserDashboard(username);
				userdb.NewScreen(username);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorderPainted(false);

		btnNewButton.setIcon(new ImageIcon(UserBookingSuccessful.class.getResource("/images/dashboard.png")));
		btnNewButton.setBounds(124, 130, 153, 30);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(449, 11, 345, 419);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(74, 71, 225, 252);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(UserBookingSuccessful.class.getResource("/images/tick.png")));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyBookings mybook = new MyBookings(username);
				mybook.NewScreen(username);
				frame.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBorderPainted(false);

		btnNewButton_1.setIcon(new ImageIcon(UserBookingSuccessful.class.getResource("/images/viewb.png")));
		btnNewButton_1.setBounds(124, 210, 153, 45);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorderPainted(false);

		btnNewButton_2.setBackground(new Color(65, 105, 225));
		btnNewButton_2.setIcon(new ImageIcon(UserBookingSuccessful.class.getResource("/images/logoutbtn.png")));
		btnNewButton_2.setBounds(137, 296, 133, 45);
		frame.getContentPane().add(btnNewButton_2);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
