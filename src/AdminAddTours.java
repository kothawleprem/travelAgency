import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminAddTours {

	private JFrame frame;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldDoj;
	private JTextField textFieldDetails;
	private JTextField textFieldPrice;

	/**
	 * Launch the application.
	 */
	public void NewScreen(final String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddTours window = new AdminAddTours(username);
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
	public AdminAddTours(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Tours");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(299, 23, 168, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(70, 141, 81, 30);
		frame.getContentPane().add(lblName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(70, 104, 81, 30);
		frame.getContentPane().add(lblId);
		
		JLabel lblDOJ = new JLabel("DOJ");
		lblDOJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDOJ.setBounds(70, 182, 81, 30);
		frame.getContentPane().add(lblDOJ);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrice.setBounds(70, 266, 81, 30);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDetails.setBounds(70, 222, 81, 30);
		frame.getContentPane().add(lblDetails);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(223, 114, 244, 19);
		frame.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(223, 151, 244, 19);
		frame.getContentPane().add(textFieldName);
		
		textFieldDoj = new JTextField();
		textFieldDoj.setColumns(10);
		textFieldDoj.setBounds(223, 192, 244, 19);
		frame.getContentPane().add(textFieldDoj);
		
		textFieldDetails = new JTextField();
		textFieldDetails.setColumns(10);
		textFieldDetails.setBounds(223, 232, 244, 19);
		frame.getContentPane().add(textFieldDetails);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(223, 276, 244, 19);
		frame.getContentPane().add(textFieldPrice);
		
		JButton btnAddTour = new JButton("");
		btnAddTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tour_id = textFieldId.getText();
				String tour_name = textFieldName.getText();
				String tour_doj = textFieldDoj.getText();
				String tour_details = textFieldDetails.getText();
				String tour_price = textFieldPrice.getText();
				  
				 try {
	                	Class.forName("org.postgresql.Driver");
						Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
						String query = "insert into tour values('" + tour_id + "','" + tour_name + "','" + tour_doj + "','" + tour_details +  "','" + tour_price +"')";
						Statement stmt = con.createStatement();
					    stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Tour Added Successfully");
						AdminDashboard admindb = new AdminDashboard(username);
						admindb.NewScreen(username);
		     			frame.dispose();
					
	                }
	                catch(Exception exp){
	                    System.out.println("Enter Valid details.");
	            }
			}
		});
		btnAddTour.setBackground(new Color(65, 105, 225));
		btnAddTour.setBorderPainted(false);
		btnAddTour.setForeground(Color.BLACK);
		btnAddTour.setIcon(new ImageIcon(AdminAddTours.class.getResource("/images/addtour35.png")));
		btnAddTour.setBounds(177, 355, 130, 35);
		frame.getContentPane().add(btnAddTour);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
