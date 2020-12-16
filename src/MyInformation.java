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
import java.sql.*;
public class MyInformation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen(String uname) {
		final String username = uname;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInformation window = new MyInformation(username);
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
	public MyInformation(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username) {
		String name = "",email="",phone="",city="";    
		frame = new JFrame();
		frame.setTitle("My Information - "+username);
		
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
            Statement selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("SELECT customer_name,customer_phone,customer_email,customer_city FROM customer WHERE customer_username like '%"+username+"%'");
            while(rs.next())
            {
                name = rs.getString(1);    //First Column
                phone = rs.getString(2);    //Second Column
                email =rs.getString(3);    //Third Column
                city = rs.getString(4);
      //Fourth Column
            }
            connection.close();
		}
		 
		 catch (Exception e) {
		        e.printStackTrace();
		 }				

   
	///	rs = stmt.executeQuery("SELECT customer_name,customer_phone,customer_email FROM customer WHERE customer_username = username");
		
		JLabel lblNewLabel = new JLabel("My Profile");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 32));
		lblNewLabel.setBounds(121, 46, 173, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(25, 117, 109, 27);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(25, 192, 109, 27);
		frame.getContentPane().add(lblEmail);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(MyInformation.class.getResource("/images/Update_button.png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateMyInformation upmyinfo = new UpdateMyInformation(username);
				upmyinfo.NewScreen(username);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(33, 336, 130, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(MyInformation.class.getResource("/images/dashboard.png")));
		button.setBorderPainted(false);
		button.setForeground(Color.BLACK);
		button.setBackground(new Color(65, 105, 225));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboard userdb = new UserDashboard(username);
				userdb.NewScreen(username);
				frame.dispose();
						
			}
		});
		button.setBounds(239, 336, 130, 30);
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
		
		JLabel lblUName = new JLabel(""+name);
		lblUName.setForeground(Color.YELLOW);
		lblUName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUName.setBounds(185, 117, 184, 27);
		frame.getContentPane().add(lblUName);
		
		JLabel lblUUname = new JLabel(""+username);
		lblUUname.setForeground(Color.YELLOW);
		lblUUname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUUname.setBounds(185, 154, 127, 27);
		frame.getContentPane().add(lblUUname);
		
		JLabel lblUemail = new JLabel(""+email);
		lblUemail.setForeground(Color.YELLOW);
		lblUemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUemail.setBounds(185, 192, 266, 27);
		frame.getContentPane().add(lblUemail);
		
		JLabel lblUphone = new JLabel(""+phone);
		lblUphone.setForeground(Color.YELLOW);
		lblUphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUphone.setBounds(183, 230, 145, 27);
		frame.getContentPane().add(lblUphone);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCity.setBounds(25, 268, 46, 27);
		frame.getContentPane().add(lblCity);
		
		JLabel lblUCity = new JLabel(""+city);
		lblUCity.setForeground(Color.YELLOW);
		lblUCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUCity.setBounds(185, 268, 145, 27);
		frame.getContentPane().add(lblUCity);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
