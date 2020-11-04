import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
//import javax.swing.JTextPane;

public class MyInformation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInformation window = new MyInformation();
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
	public MyInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Profile");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(121, 46, 173, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(25, 117, 109, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(25, 192, 109, 27);
		frame.getContentPane().add(lblEmail);
		
		
		JButton btnNewButton = new JButton("Update Information");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateMyInformation upmyinfo = new UpdateMyInformation();
				upmyinfo.NewScreen();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(36, 321, 127, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Dashboard");
		button.setBorderPainted(false);
		button.setForeground(Color.BLACK);
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboard userdb = new UserDashboard();
				userdb.NewScreen();
				frame.dispose();
						
			}
		});
		button.setBounds(269, 321, 127, 39);
		frame.getContentPane().add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(448, 11, 346, 420);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MyInformation.class.getResource("/images/myinfo.png")));
		lblNewLabel_2.setBounds(10, 11, 326, 398);
		panel.add(lblNewLabel_2);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(25, 154, 109, 27);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(25, 230, 138, 27);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblNewLabel_3 = new JLabel("Prem Kothawle");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(185, 117, 184, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lbluname = new JLabel("prem29");
		lbluname.setForeground(Color.YELLOW);
		lbluname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbluname.setBackground(Color.WHITE);
		lbluname.setBounds(185, 154, 127, 27);
		frame.getContentPane().add(lbluname);
		
		JLabel lbluemail = new JLabel("kothawleprem@gmail.com");
		lbluemail.setForeground(Color.YELLOW);
		lbluemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbluemail.setBounds(185, 192, 266, 27);
		frame.getContentPane().add(lbluemail);
		
		JLabel label = new JLabel("9123456780");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(183, 230, 145, 27);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_4 = new JLabel("City");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(25, 268, 46, 27);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblMumbai = new JLabel("Mumbai");
		lblMumbai.setForeground(Color.YELLOW);
		lblMumbai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMumbai.setBounds(185, 268, 145, 27);
		frame.getContentPane().add(lblMumbai);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
