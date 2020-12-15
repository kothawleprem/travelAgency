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
	public void NewScreen(String uname) {
		final String username = uname;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDashboard window = new UserDashboard(username);
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
	public UserDashboard(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setTitle("User Dashboard - "+username);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(UserDashboard.class.getResource("/images/mybookings.png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyBookings mybook = new MyBookings(username);
				mybook.NewScreen(username);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(543, 126, 131, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAddInformation = new JButton("");
		btnAddInformation.setIcon(new ImageIcon(UserDashboard.class.getResource("/images/myinfobtn.png")));
		btnAddInformation.setBorderPainted(false);
		btnAddInformation.setForeground(Color.BLACK);
		btnAddInformation.setBackground(new Color(65, 105, 225));
		btnAddInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInformation myinfo =new MyInformation(username);
				myinfo.NewScreen(username);
				frame.dispose();
			}
		});
		btnAddInformation.setBounds(543, 193, 131, 31);
		frame.getContentPane().add(btnAddInformation);
		
		JButton btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(UserDashboard.class.getResource("/images/logoutbtn.png")));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutPage logout = new LogoutPage();
				logout.NewScreen();
				frame.dispose();
			}
		});
		btnLogout.setBorderPainted(false);
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setBackground(new Color(65, 105, 225));
		btnLogout.setBounds(543, 327, 130, 30);
		frame.getContentPane().add(btnLogout);
		
		JButton btnViewTours = new JButton("");
		btnViewTours.setIcon(new ImageIcon(UserDashboard.class.getResource("/images/viewt.png")));
		btnViewTours.setBorderPainted(false);
		btnViewTours.setForeground(Color.BLACK);
		btnViewTours.setBackground(new Color(65, 105, 225));
		btnViewTours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTours view = new ViewTours(username);
				view.NewScreen(username);
				frame.dispose();
			}
		});
		btnViewTours.setBounds(543, 260, 130, 34);
		frame.getContentPane().add(btnViewTours);
		
		JLabel lblNewLabel = new JLabel("Welcome "+username);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(497, 40, 269, 49);
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
