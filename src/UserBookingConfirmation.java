import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class UserBookingConfirmation {

	private JFrame frame;
	private JTextField textFieldPassengers;

	/**
	 * Launch the application.
	 */
	public void NewScreen(final String username,final int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserBookingConfirmation window = new UserBookingConfirmation(username,id);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param id 
	 */
	public UserBookingConfirmation(String username, int id) {
		initialize(username,id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username,final int id) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setTitle("Booking Confirmation - "+username);
		frame.getContentPane().setLayout(null);
		
		String name = "",tname="",phone="",email="",doj="";
		String price="";
		String details="";
		int fprice = 0;
		try {
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	         Statement selectStmt = connection.createStatement();
	         ResultSet rs = selectStmt.executeQuery("SELECT customer_name,customer_phone,customer_email FROM customer WHERE customer_username like '%"+username+"%'");
	         while(rs.next())
	            {
	                name = rs.getString(1);    //First Column
	                phone = rs.getString(2);    //Second Column
	                email =rs.getString(3);    //Third Column
	               // age = rs.getString(3);
	      //Fourth Column
	            }
			ResultSet rs2 = selectStmt.executeQuery("SELECT tour_name,tour_doj,tour_details,tour_price FROM tour WHERE tour_id like '%"+id+"%'");
			while(rs2.next())
            {
			  tname = rs2.getString(1);
			  doj = rs2.getString(2);
			  price = rs2.getString(4);
			  
			  details = rs2.getString(3);
            }
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Confirm Your Booking");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 32));
		lblNewLabel.setBounds(251, 10, 318, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTourName = new JLabel("Tour Name");
		lblTourName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTourName.setBounds(40, 65, 133, 42);
		frame.getContentPane().add(lblTourName);
		
		JLabel lblTourDoj = new JLabel("Tour DOJ");
		lblTourDoj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTourDoj.setBounds(40, 105, 133, 42);
		frame.getContentPane().add(lblTourDoj);
		
		JLabel lblTourDetails = new JLabel("Tour Details");
		lblTourDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTourDetails.setBounds(40, 145, 133, 42);
		frame.getContentPane().add(lblTourDetails);
		
		JLabel lblTourPrice = new JLabel("Tour Price");
		lblTourPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTourPrice.setBounds(40, 185, 133, 42);
		frame.getContentPane().add(lblTourPrice);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCustomerName.setBounds(40, 225, 156, 42);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblCustomerPhone = new JLabel("Customer Phone");
		lblCustomerPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCustomerPhone.setBounds(40, 265, 156, 42);
		frame.getContentPane().add(lblCustomerPhone);
		
		JLabel lblCustomerEmail = new JLabel("Customer Email");
		lblCustomerEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCustomerEmail.setBounds(40, 305, 156, 42);
		frame.getContentPane().add(lblCustomerEmail);
		
		JLabel lbldynTourName = new JLabel(""+tname);
		lbldynTourName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldynTourName.setBounds(260, 65, 320, 30);
		frame.getContentPane().add(lbldynTourName);
		
		JLabel lbldynTourDoj = new JLabel(""+doj);
		lbldynTourDoj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldynTourDoj.setBounds(260, 105, 320, 30);
		frame.getContentPane().add(lbldynTourDoj);
		
		final JLabel lbldynTourPrice = new JLabel("");
		lbldynTourPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldynTourPrice.setBounds(260, 185, 320, 30);
		frame.getContentPane().add(lbldynTourPrice);
		
		JLabel lbldynDetails = new JLabel(""+details);
		lbldynDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldynDetails.setBounds(260, 145, 320, 30);
		frame.getContentPane().add(lbldynDetails);
		
		JLabel lbldynCustomerName = new JLabel(""+name);
		lbldynCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldynCustomerName.setBounds(260, 225, 320, 30);
		frame.getContentPane().add(lbldynCustomerName);
		
		JLabel lbldynCustomerPhone = new JLabel(""+phone);
		lbldynCustomerPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldynCustomerPhone.setBounds(260, 265, 320, 30);
		frame.getContentPane().add(lbldynCustomerPhone);
		
		JLabel lbldynCustomerEmail = new JLabel(""+email);
		lbldynCustomerEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldynCustomerEmail.setBounds(260, 305, 320, 30);
		frame.getContentPane().add(lbldynCustomerEmail);
		
		textFieldPassengers = new JTextField();
		textFieldPassengers.setBounds(577, 105, 116, 20);
//		textFieldPassengers.setText("1");
		frame.getContentPane().add(textFieldPassengers);
		textFieldPassengers.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Total Number of Passengers");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(519, 68, 275, 36);
		frame.getContentPane().add(lblNewLabel_1);
		int per;
		fprice = Integer.parseInt(price);
		final int cost = fprice;
		 JButton btnNewButton_1 = new JButton("");
		 btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBorderPainted(false);

		 btnNewButton_1.setIcon(new ImageIcon(UserBookingConfirmation.class.getResource("/images/check.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int amount = 0;
				String p = textFieldPassengers.getText();
				int person = Integer.parseInt(p);
				
				amount = person*cost;
				lbldynTourPrice.setText(""+amount);
			//	per = amount/cost;
			}
		});
	//	btnNewButton_1.addActionListener((ActionListener) this);
		btnNewButton_1.setBounds(570, 144, 133, 30);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(UserBookingConfirmation.class.getResource("/images/makePayment.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int flag=0;
				 String status = "Processing";
			    try {
			    	Class.forName("org.postgresql.Driver");
					Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
					String query = "insert into booking (customer_username,tour_id,number_of_passengers,booking_status) values('" + username + "','" + id + "','" + textFieldPassengers.getText() + "','" + status + "')";
					Statement stmt = con.createStatement();
				    stmt.executeUpdate(query);
				    flag++;
			    }catch(Exception exp)
			    {
			    	System.out.println(exp);
			    }
			   
				if(flag==1) {
				    JOptionPane.showMessageDialog(null, "Proceding to Payments!!");
				    PaymentHome payHome = new PaymentHome(username,id);
				    payHome.NewScreen(username, id);
				    frame.dispose();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(257, 370, 156, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TourInfo tourin = new TourInfo(username,id);
				tourin.NewScreen(username,id);
				frame.dispose();
			}
		});
		btnBack.setBackground(new Color(65, 105, 225));
		btnBack.setBorderPainted(false);
		btnBack.setIcon(new ImageIcon(UserBookingConfirmation.class.getResource("/images/back.png")));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.setBounds(473, 370, 156, 42);
		frame.getContentPane().add(btnBack);
		
		
		
		
	}
}
 