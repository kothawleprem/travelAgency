import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLoginPage {

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
					AdminLoginPage window = new AdminLoginPage();
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
	public AdminLoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setTitle("Admin Login");
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(AdminLoginPage.class.getResource("/images/submitbtn.png")));
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
					String query = "Select * from admin where admin_username like '"+username+"%' AND admin_password like '"+pass+"%'";

					ResultSet rs = stmt.executeQuery(query);
					if(rs.next())
					{
						AdminDashboard admindb = new AdminDashboard(username);
						admindb.NewScreen(username);
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
		btnNewButton.setBounds(116, 223, 150, 35);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblAdminLogin = new JLabel("User Login?");
		lblAdminLogin.setForeground(Color.WHITE);
		lblAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdminLogin.setBounds(46, 320, 128, 29);
		frame.getContentPane().add(lblAdminLogin);
		
		JButton btnAdmin = new JButton("");
		btnAdmin.setIcon(new ImageIcon(AdminLoginPage.class.getResource("/images/User.png")));
		btnAdmin.setBorderPainted(false);
		btnAdmin.setForeground(Color.BLACK);
		btnAdmin.setBackground(new Color(65, 105, 225));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage login = new LoginPage();
				login.NewScreen();
				frame.dispose();
				
			}
		});
		btnAdmin.setBounds(249, 320, 130, 35);
		frame.getContentPane().add(btnAdmin);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Login");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Georgia", Font.BOLD, 32));
		lblNewLabel_2.setBounds(82, 27, 238, 38);
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
		
		textField = new JTextField();
		textField.setBounds(161, 127, 177, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 167, 177, 20);
		frame.getContentPane().add(passwordField);
	}
}
