import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class UpdateMyInformation {

	private JFrame frame;
	private JTextField textName;

	private JTextField textEmail;
	private JTextField textPhoneNumber;
	private JTextField textCity;

	/**
	 * Launch the application.
	 */
	public void NewScreen(String uname) {
		final String username = uname;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMyInformation window = new UpdateMyInformation(username);
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
	public UpdateMyInformation(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 366, 420);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UpdateMyInformation.class.getResource("/images/upmyinfo.png")));
		lblNewLabel.setBounds(10, 11, 346, 398);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Update Information");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1.setBounds(437, 40, 341, 54);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(411, 172, 109, 27);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(411, 210, 109, 27);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(411, 134, 109, 27);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(411, 250, 138, 27);
		frame.getContentPane().add(lblPhoneNumber);
		String name = "",email="",phone="",city="";
		try {
			Conn c = new Conn();
		
			String sql = "SELECT customer_name,customer_phone,customer_email,customer_city FROM customer WHERE customer_username like '%"+username+"%'";
		    ResultSet rs = c.s.executeQuery(sql);
		    while(rs.next())
            {
                name = rs.getString(1);    //First Column
                phone = rs.getString(2);    //Second Column
                email =rs.getString(3);    //Third Column
                city = rs.getString(4);
      //Fourth Column
            }
		    		
		}catch(Exception exp) {
			
		}
		
		textName = new JTextField();
		textName.setBounds(559, 179, 206, 20);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		textName.setText(name);
		
		JLabel lbluname = new JLabel(""+username);
		lbluname.setForeground(Color.YELLOW);
		lbluname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbluname.setBounds(559, 134, 206, 27);
		frame.getContentPane().add(lbluname);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(559, 217, 206, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setText(email);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setColumns(10);
		textPhoneNumber.setBounds(559, 257, 206, 20);
		frame.getContentPane().add(textPhoneNumber);
		textPhoneNumber.setText(phone);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCity.setBounds(411, 288, 138, 27);
		frame.getContentPane().add(lblCity);
		
		textCity = new JTextField();
		textCity.setColumns(10);
		textCity.setBounds(559, 288, 206, 20);
		frame.getContentPane().add(textCity);
		textCity.setText(city);
		
		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(UpdateMyInformation.class.getResource("/images/Update_button.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				try {
					String s1 = textName.getText();
					String s2 = textEmail.getText();
					String s4 = textCity.getText();
					String s3 = textPhoneNumber.getText();
				//	Connection c =  DriverManager.getConnection("jdbc:postgresql://localhost:5433/traveldb", "postgres", "premsk29");;
				//	String q1 = "update customer set customer_name = premsk";
				//	c.s.executeUpdate(q1);
				//	String query = "INSERT INTO customer values('" + username + "','" + name + "','" + email + "',
				//	+'" + password +"','" + city +"','" + phone + "')";
					 String query = "update customer set customer_name = '"+s1+"',customer_email = '"+s2+"', customer_phone = '"+s3+"',customer_city = '"+s4+"' where customer_username like '"+username+"%'";
					 c.s.executeUpdate(query);
					 JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
				
				}catch(Exception exp) {
					System.out.println(exp);
				}
				MyInformation myinfo =new MyInformation(username);
				myinfo.NewScreen(username);
				frame.dispose();
			}
		});
		btnUpdate.setBorderPainted(false);
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBackground(new Color(65, 105, 225));
		btnUpdate.setBounds(437, 336, 130, 30);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnCancel = new JButton("");
		btnCancel.setIcon(new ImageIcon(UpdateMyInformation.class.getResource("/images/cancel.png")));
		btnCancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				MyInformation myinfo =new MyInformation(username);
				myinfo.NewScreen(username);
				frame.dispose();
			}
		});
		btnCancel.setBorderPainted(false);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(new Color(65, 105, 225));
		btnCancel.setBounds(627, 336, 130, 35);
		frame.getContentPane().add(btnCancel);
		
		
		
	}
}
