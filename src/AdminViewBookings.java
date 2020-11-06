import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminViewBookings {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViewBookings window = new AdminViewBookings();
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
	public AdminViewBookings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JLabel lblViewBookings = new JLabel("View Bookings");
		lblViewBookings.setForeground(Color.YELLOW);
		lblViewBookings.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblViewBookings.setBounds(296, 8, 227, 49);
		frame.getContentPane().add(lblViewBookings);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(28, 68, 750, 321);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard admindb = new AdminDashboard();
				admindb.NewScreen();
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(AdminViewBookings.class.getResource("/images/back.png")));
		btnNewButton.setBounds(349, 400, 130, 30);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
