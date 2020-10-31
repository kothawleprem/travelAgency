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
		lblNewLabel.setBounds(98, 150, 128, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(98, 196, 128, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(228, 154, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(228, 200, 86, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboard userdb = new UserDashboard();
				userdb.NewScreen();
				frame.dispose();
						
			}
		});
		btnNewButton.setBounds(152, 254, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNoAccountSign = new JLabel("No Account? Sign Up");
		lblNoAccountSign.setBounds(98, 317, 128, 29);
		frame.getContentPane().add(lblNoAccountSign);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage register = new RegisterPage();
				register.NewScreen();
				frame.dispose();
			}
		});
		btnRegister.setBounds(236, 320, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblAdminLogin = new JLabel("Admin Login?");
		lblAdminLogin.setBounds(98, 381, 128, 29);
		frame.getContentPane().add(lblAdminLogin);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLoginPage adminlog = new AdminLoginPage();
				adminlog.NewScreen();
				frame.dispose();
				
			}
		});
		btnAdmin.setBounds(236, 384, 89, 23);
		frame.getContentPane().add(btnAdmin);
		
		JLabel lblNewLabel_2 = new JLabel("Login Page");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(130, 98, 184, 38);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
