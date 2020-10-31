import java.awt.EventQueue;
//import java.awt.Image;
//import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
//import javax.swing.border.EtchedBorder;
//import javax.swing.border.MatteBorder;



//import javax.swing.ImageIcon;
//import javax.swing.SwingConstants;
//import javax.swing.JTextField;
import java.awt.Font;
//import javax.swing.JEditorPane;
//import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
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
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.LIGHT_GRAY, Color.BLACK, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 380, 420);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Travel Agency");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 32));
		lblNewLabel.setBounds(491, 35, 230, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Best Offers\r\n\r\n");
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(443, 146, 340, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Financial Support!!");
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(443, 180, 222, 61);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fantastic Reviews");
		lblNewLabel_3.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(443, 225, 222, 61);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("View Packages");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPackages viewpack = new ViewPackages();
				viewpack.NewScreen();
				frame.dispose();
	
			}
		});
		btnNewButton.setBounds(649, 240, 134, 34);
	
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage register = new RegisterPage();
				register.NewScreen();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(455, 380, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage login = new LoginPage();
				login.NewScreen();
				frame.dispose();
			}
		});
		btnLogin.setBounds(659, 380, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		
	}


}
