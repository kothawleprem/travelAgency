import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class UserDashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDashboard window = new UserDashboard();
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
	public UserDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("My Bookings");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyBookings mybook = new MyBookings();
				mybook.NewScreen();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(543, 126, 124, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAddInformation = new JButton("My Information");
		btnAddInformation.setBorderPainted(false);
		btnAddInformation.setForeground(Color.BLACK);
		btnAddInformation.setBackground(Color.WHITE);
		btnAddInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInformation myinfo =new MyInformation();
				myinfo.NewScreen();
				frame.dispose();
			}
		});
		btnAddInformation.setBounds(543, 193, 124, 31);
		frame.getContentPane().add(btnAddInformation);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBorderPainted(false);
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(543, 327, 124, 31);
		frame.getContentPane().add(btnLogout);
		
		JButton btnViewTours = new JButton("View Tours");
		btnViewTours.setBorderPainted(false);
		btnViewTours.setForeground(Color.BLACK);
		btnViewTours.setBackground(Color.WHITE);
		btnViewTours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTours view = new ViewTours();
				view.NewScreen();
				frame.dispose();
			}
		});
		btnViewTours.setBounds(543, 260, 124, 31);
		frame.getContentPane().add(btnViewTours);
		
		JLabel lblNewLabel = new JLabel("User Dashboard");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(495, 40, 227, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 377, 420);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(UserDashboard.class.getResource("/images/world.png")));
		lblNewLabel_1.setBounds(10, 11, 357, 398);
		panel.add(lblNewLabel_1);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
