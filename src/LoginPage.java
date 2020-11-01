import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
//import java.awt.BorderLayout;
//import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class LoginPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(46, 119, 128, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(46, 159, 128, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(203, 123, 194, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(203, 163, 194, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboard userdb = new UserDashboard();
				userdb.NewScreen();
				frame.dispose();
						
			}
		});
		btnNewButton.setBounds(136, 223, 102, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNoAccountSign = new JLabel("Need an Account?");
		lblNoAccountSign.setForeground(Color.WHITE);
		lblNoAccountSign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNoAccountSign.setBounds(46, 314, 179, 29);
		frame.getContentPane().add(lblNoAccountSign);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBorderPainted(false);
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setBackground(Color.WHITE);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage register = new RegisterPage();
				register.NewScreen();
				frame.dispose();
			}
		});
		btnRegister.setBounds(249, 314, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblAdminLogin = new JLabel("Admin Login?");
		lblAdminLogin.setForeground(Color.WHITE);
		lblAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdminLogin.setBounds(46, 377, 128, 29);
		frame.getContentPane().add(lblAdminLogin);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBorderPainted(false);
		btnAdmin.setForeground(Color.BLACK);
		btnAdmin.setBackground(Color.WHITE);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLoginPage adminlog = new AdminLoginPage();
				adminlog.NewScreen();
				frame.dispose();
				
			}
		});
		btnAdmin.setBounds(249, 384, 89, 23);
		frame.getContentPane().add(btnAdmin);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Georgia", Font.BOLD, 32));
		lblNewLabel_2.setBounds(136, 27, 184, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(432, 11, 362, 420);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LoginPage.class.getResource("/images/login.png")));
		lblNewLabel_3.setBounds(27, 11, 325, 398);
		panel.add(lblNewLabel_3);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
