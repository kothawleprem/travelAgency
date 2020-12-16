import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentHome {

	private JFrame frame;
	private JTextField textFieldCardNumber;
	private JTextField textFieldSecurityCode;

	/**
	 * Launch the application.
	 */
	public void NewScreen(String uname,int code) {
		final String username = uname;
		final int id= code;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentHome window = new PaymentHome(username,id);
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
	public PaymentHome(String username,int id) {
		initialize(username,id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username,int id) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 0));
		frame.setTitle("Payment - "+username);
		frame.getContentPane().setLayout(null);
		String booking_id ="";
		String tour_name="", tour_price="", customer_name="", customer_email="", customer_phone="", number_of_passengers="";
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
            Statement selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select booking_id,tour_name,tour_price,number_of_passengers from tour t join booking b on t.tour_id = b.tour_id where customer_username like '%"+username+"%' order by booking_id");
            while(rs.next())
            {
                booking_id = rs.getString(1);    //First Column
                tour_name =rs.getString(2);    //Third Column
                tour_price = rs.getString(3);
                number_of_passengers = rs.getString(4);
      //Fourth Column
            }
            ResultSet rs2 = selectStmt.executeQuery("select customer_name,customer_email,customer_phone from customer where customer_username like '%"+username+"%'");
            while(rs2.next())
            {
            	customer_name = rs2.getString(1);
            	customer_email = rs2.getString(2);
            	customer_phone = rs2.getString(3);
            }
            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		int person = Integer.parseInt(number_of_passengers);
		int cost = Integer.parseInt(tour_price);
		int amount = person*cost;
		final String bid = booking_id;
		
		JLabel lblNewLabel = new JLabel("Payments");
		lblNewLabel.setBounds(234, 11, 225, 39);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 32));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(57, 61, 709, 238);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Current Transaction Details");
		lblNewLabel_1.setBounds(134, 7, 244, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblCustomerName = new JLabel("Name of the Customer");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCustomerName.setBounds(10, 69, 176, 20);
		panel.add(lblCustomerName);
		
		JLabel lblEmail = new JLabel("Email of Customer");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(10, 100, 195, 20);
		panel.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone number of Customer");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhone.setBounds(10, 131, 244, 20);
		panel.add(lblPhone);
		
		JLabel lblTourName = new JLabel("Tour Selected");
		lblTourName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTourName.setBounds(10, 162, 125, 20);
		panel.add(lblTourName);
		
		JLabel lblPrice = new JLabel("Tour Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrice.setBounds(10, 193, 125, 20);
		panel.add(lblPrice);
		
		JLabel lblBookingId = new JLabel("Booking ID");
		lblBookingId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBookingId.setBounds(10, 38, 176, 20);
		panel.add(lblBookingId);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(242, 38, 12, 175);
		panel.add(verticalStrut);
		
		JLabel lblBookingIDdyn = new JLabel(""+booking_id);
		lblBookingIDdyn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBookingIDdyn.setBounds(275, 38, 399, 20);
		panel.add(lblBookingIDdyn);
		
		JLabel lblCustomerNamedyn = new JLabel(""+customer_name);
		lblCustomerNamedyn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCustomerNamedyn.setBounds(275, 69, 399, 20);
		panel.add(lblCustomerNamedyn);
		
		JLabel lblEmaildyn = new JLabel(""+customer_email);
		lblEmaildyn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmaildyn.setBounds(275, 100, 399, 20);
		panel.add(lblEmaildyn);
		
		JLabel lblPhonedyn = new JLabel(""+customer_phone);
		lblPhonedyn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhonedyn.setBounds(274, 131, 413, 20);
		panel.add(lblPhonedyn);
		
		JLabel lblTourNamedyn = new JLabel(""+tour_name);
		lblTourNamedyn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTourNamedyn.setBounds(275, 162, 399, 20);
		panel.add(lblTourNamedyn);
		
		JLabel lblPricedyn = new JLabel("");
		lblPricedyn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPricedyn.setBounds(275, 193, 125, 20);
		panel.add(lblPricedyn);
		lblPricedyn.setText(""+amount);		
		
		JLabel lblNewLabel_2 = new JLabel("Enter Card Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(67, 310, 165, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter Your Security Code");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(67, 335, 207, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		textFieldCardNumber = new JTextField();
		textFieldCardNumber.setBounds(303, 313, 207, 20);
		frame.getContentPane().add(textFieldCardNumber);
		textFieldCardNumber.setColumns(10);
		final String card_number = textFieldCardNumber.getText();
		
		textFieldSecurityCode = new JTextField();
		textFieldSecurityCode.setColumns(10);
		textFieldSecurityCode.setBounds(303, 338, 207, 20);
		frame.getContentPane().add(textFieldSecurityCode);
		final String security_code = textFieldSecurityCode.getText();
		
		
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String crdno="";
				 String code="";
				try {
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");

					Statement stmt = connection.createStatement();
					String query = "Select * from transaction where card_number like '"+card_number+"%' AND security_code like '"+security_code+"%'";
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next())
					{
						crdno = rs.getString(1);
						code = rs.getString(2) ;
					}
					if(crdno.equals(card_number) || code.equals(security_code))
					{
						try {
							String query2 = "update booking set booking_status = 'Completed' where booking_id = '"+bid+"' ";
                            stmt.executeUpdate(query2);
                            UserBookingSuccessful ubooks = new UserBookingSuccessful(username);
    						ubooks.NewScreen(username);
    						frame.dispose();
						}catch(Exception ep) {
							System.out.println(ep);
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Details!");
					}
					connection.close();
				}catch(Exception exp) {
					System.out.println(exp);
				}	
			}
			
		});
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(PaymentHome.class.getResource("/images/confirm.png")));
		btnNewButton.setBounds(67, 379, 166, 39);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("For Amount of "+amount);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(234, 387, 237, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTours view = new ViewTours(username);
				view.NewScreen(username);
				frame.dispose();
			}
			
		});
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setBorderPainted(false);

		btnNewButton_1.setIcon(new ImageIcon(PaymentHome.class.getResource("/images/cancel.png")));
		btnNewButton_1.setBounds(566, 379, 135, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
