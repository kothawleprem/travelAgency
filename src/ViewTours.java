import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewTours {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTours window = new ViewTours();
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
	public ViewTours() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.YELLOW);
		panel_3.setBounds(150, 25, 640, 400);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserDashboard userdb = new UserDashboard();
				userdb.NewScreen();
				frame.dispose();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(ViewTours.class.getResource("/images/hongkong.jpg")));
		lblNewLabel.setBounds(20, 11, 179, 180);
		panel_3.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewTours.class.getResource("/images/maldives.jpg")));
		label.setBounds(230, 202, 179, 180);
		panel_3.add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ViewTours.class.getResource("/images/figma.jpg")));
		label_2.setBounds(440, 11, 179, 180);
		panel_3.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ViewTours.class.getResource("/images/goa.png")));
		label_1.setBounds(230, 11, 179, 180);
		panel_3.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(ViewTours.class.getResource("/images/kerala.png")));
		label_3.setBounds(20, 202, 179, 180);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(ViewTours.class.getResource("/images/leh.png")));
		label_4.setBounds(440, 202, 179, 180);
		panel_3.add(label_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ViewTours.class.getResource("/images/homebtn.png")));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Welcome wel= new Welcome();
				wel.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(10, 385, 130, 31);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 25, 127, 302);
		frame.getContentPane().add(panel);
		
		JButton btnDashboard = new JButton("");
		btnDashboard.setIcon(new ImageIcon(ViewTours.class.getResource("/images/dashboard.png")));
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboard userdb = new UserDashboard();
				userdb.NewScreen();
				frame.dispose();
			}
		});
		btnDashboard.setForeground(Color.BLACK);
		btnDashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDashboard.setBorderPainted(false);
		btnDashboard.setBackground(new Color(65, 105, 225));
		btnDashboard.setBounds(10, 338, 130, 30);
		frame.getContentPane().add(btnDashboard);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
