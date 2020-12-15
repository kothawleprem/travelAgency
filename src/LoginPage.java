import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
//import java.awt.BorderLayout;
//import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.sql.*;

public class LoginPage {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

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
		frame.setTitle("Login");
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(203, 167, 194, 20);
		frame.getContentPane().add(passwordField);
		frame.setBounds(100, 100, 820, 480);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(LoginPage.class.getResource("/images/submitbtn.png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String username = " ";
				username=textField.getText();
	            @SuppressWarnings("deprecation")
				String pass = passwordField.getText();
				try {
					Class.forName("org.postgresql.Driver");
					Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
					Statement stmt = con.createStatement();
					String query = "Select * from customer where customer_username like '"+username+"%' AND customer_password like '"+pass+"%'";

					ResultSet rs = stmt.executeQuery(query);
					if(rs.next())
					{
						UserDashboard userdb = new UserDashboard(username);
						userdb.NewScreen(username);
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Login");
					}
					con.close();
				}catch (Exception exp) {
					System.out.println(exp);
				}
				
						
			}
		});
		btnNewButton.setBounds(136, 223, 130, 35);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNoAccountSign = new JLabel("Need an Account?");
		lblNoAccountSign.setForeground(Color.WHITE);
		lblNoAccountSign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNoAccountSign.setBounds(46, 283, 179, 29);
		frame.getContentPane().add(lblNoAccountSign);
		
		JButton btnRegister = new JButton("");
		btnRegister.setIcon(new ImageIcon(LoginPage.class.getResource("/images/register.png")));
		btnRegister.setBorderPainted(false);
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setBackground(new Color(65, 105, 225));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage register = new RegisterPage();
				register.NewScreen();
				frame.dispose();
			}
		});
		btnRegister.setBounds(249, 283, 130, 35);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblAdminLogin = new JLabel("Admin Login?");
		lblAdminLogin.setForeground(Color.WHITE);
		lblAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdminLogin.setBounds(46, 337, 128, 29);
		frame.getContentPane().add(lblAdminLogin);
		
		JButton btnAdmin = new JButton("");
		btnAdmin.setIcon(new ImageIcon(LoginPage.class.getResource("/images/adminbtn.png")));
		btnAdmin.setBorderPainted(false);
		btnAdmin.setForeground(Color.BLACK);
		btnAdmin.setBackground(new Color(65, 105, 225));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLoginPage adminlog = new AdminLoginPage();
				adminlog.NewScreen();
				frame.dispose();
				
			}
		});
		btnAdmin.setBounds(249, 337, 130, 35);
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
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Welcome wel= new Welcome();
				wel.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/homebtn.png")));
		btnNewButton_1.setBounds(158, 393, 130, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
