import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen(String uname) {
		final String username = uname;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard(username);
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
	public AdminDashboard(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.YELLOW));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 361, 420);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminDashboard.class.getResource("/images/admin.png")));
		lblNewLabel.setBounds(10, 11, 341, 398);
		panel.add(lblNewLabel);
		
		JLabel lblAdminDashboard = new JLabel("Admin Dashboard");
		lblAdminDashboard.setForeground(Color.YELLOW);
		lblAdminDashboard.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAdminDashboard.setBounds(464, 30, 287, 49);
		frame.getContentPane().add(lblAdminDashboard);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(AdminDashboard.class.getResource("/images/viewb.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewBookings advbook = new AdminViewBookings(username);
				advbook.NewScreen(username);
				frame.dispose();
			}
		});
		button.setForeground(Color.BLACK);
		button.setBorderPainted(false);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(527, 119, 130, 35);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/images/addtour35.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddTours addTours = new AdminAddTours(username);
				addTours.NewScreen(username);
				frame.dispose();
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setBorderPainted(false);
		button_1.setBackground(new Color(65, 105, 225));
		button_1.setBounds(527, 233, 130, 35);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/images/logoutbtn.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutPage logout = new LogoutPage();
				logout.NewScreen();
				frame.dispose();
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setBorderPainted(false);
		button_2.setBackground(new Color(65, 105, 225));
		button_2.setBounds(527, 292, 130, 35);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(AdminDashboard.class.getResource("/images/viewt35.png")));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTours view = new ViewTours(username);
				view.NewScreen(username);
				frame.dispose();
			}
		});
		button_3.setForeground(Color.BLACK);
		button_3.setBorderPainted(false);
		button_3.setBackground(new Color(65, 105, 225));
		button_3.setBounds(527, 173, 130, 35);
		frame.getContentPane().add(button_3);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
