import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.*;

import javax.swing.JPasswordField;


public class RegisterPage {

	private JFrame frame;
	private JTextField cname;
	private JTextField uemail;
	private JTextField uphone;
	private JTextField cusername;
	private JPasswordField upassword;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage window = new RegisterPage();
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
	public RegisterPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setTitle("Register");
		frame.getContentPane().setLayout(null);
		
		JLabel lblregister = new JLabel("Register");
		lblregister.setForeground(Color.YELLOW);
		lblregister.setBackground(Color.WHITE);
		lblregister.setFont(new Font("Georgia", Font.BOLD, 32));
		lblregister.setBounds(139, 27, 189, 52);
		frame.getContentPane().add(lblregister);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(45, 90, 110, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		cname = new JTextField();
		cname.setBounds(200, 100, 176, 20);
		frame.getContentPane().add(cname);
		cname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(45, 140, 110, 36);
		frame.getContentPane().add(lblEmail);
		
		uemail = new JTextField();
		uemail.setColumns(10);
		uemail.setBounds(200, 150, 176, 20);
		frame.getContentPane().add(uemail);
		
		uphone = new JTextField();
		uphone.setColumns(10);
		uphone.setBounds(200, 200, 176, 20);
		frame.getContentPane().add(uphone);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(45, 190, 110, 36);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(45, 290, 110, 36);
		frame.getContentPane().add(lblPassword);
		
		final JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(RegisterPage.class.getResource("/images/register.png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = cname.getText();
                String email = uemail.getText();
                String username = " ";
                username = cusername.getText();
                String phone = uphone.getText();
                String city = "";
                //int len = mobileNumber.length();
                @SuppressWarnings("deprecation")
				String password = upassword.getText();
                String query = "INSERT INTO customer values('" + username + "','" + name + "','" + email + "','" + password +  "','" + city +"','" + phone + "')";
            
                try {
                	Class.forName("org.postgresql.Driver");
					Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
					Statement stmt = con.createStatement();
				    int x = stmt.executeUpdate(query);
				    JOptionPane.showMessageDialog(null, "Account Created Successfully");
				    UserDashboard userdb = new UserDashboard(username);
		     		userdb.NewScreen(username);
		     		frame.dispose();
					
                }
                catch(Exception exp){
                	JOptionPane.showMessageDialog(null, "Account Already Exits.");
                   // System.out.println(exp);
                }   
                
			}   
               
		});
		btnNewButton.setBounds(222, 341, 130, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Already have an Account?");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(45, 395, 235, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(RegisterPage.class.getResource("/images/loginbt.png")));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage login = new LoginPage();
				login.NewScreen();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(281, 395, 130, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(45, 240, 110, 36);
		frame.getContentPane().add(lblUsername);
		
		cusername = new JTextField();
		cusername.setColumns(10);
		cusername.setBounds(200, 250, 176, 20);
		frame.getContentPane().add(cusername);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(440, 22, 354, 409);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(RegisterPage.class.getResource("/images/regi.png")));
		lblNewLabel_3.setBounds(30, 11, 314, 387);
		panel.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_4 = new JLabel("By Registering You Agree  T&C.\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(10, 321, 228, 52);
		frame.getContentPane().add(lblNewLabel_4);
		
		upassword = new JPasswordField();
		upassword.setBounds(200, 302, 176, 20);
		frame.getContentPane().add(upassword);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Terms terms = new Terms();
				terms.NewScreen();
				
			}
		});
		btnNewButton_2.setBackground(new Color(65, 105, 225));
		btnNewButton_2.setIcon(new ImageIcon(RegisterPage.class.getResource("/images/T&C.png")));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(55, 361, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
