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
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
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
	public AdminDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		lblAdminDashboard.setBounds(465, 44, 287, 49);
		frame.getContentPane().add(lblAdminDashboard);
		
		JButton button = new JButton("View Bookings");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setForeground(Color.BLACK);
		button.setBorderPainted(false);
		button.setBackground(Color.WHITE);
		button.setBounds(527, 119, 124, 31);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("View Tours");
		button_1.setForeground(Color.BLACK);
		button_1.setBorderPainted(false);
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(527, 233, 124, 31);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Logout");
		button_2.setForeground(Color.BLACK);
		button_2.setBorderPainted(false);
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(527, 292, 124, 31);
		frame.getContentPane().add(button_2);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
