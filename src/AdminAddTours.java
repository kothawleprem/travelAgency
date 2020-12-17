import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;

public class AdminAddTours {

	private JFrame frame;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldDoj;
	private JTextField textFieldDetails;
	private JTextField textFieldPrice;
	private JTextField textFieldImage;

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
		frame.setTitle("Add Tours - "+username);
		frame.getContentPane().setLayout(null);
		String tour_id_1 ="", tour_id_2 ="",tour_id_3 ="",tour_id_4 ="",tour_id_5 ="",tour_id_6 ="",tour_id_7 ="", tour_id_8 ="",tour_id_9 ="",tour_id_10 ="",tour_id_11 ="",tour_id_12 ="";
		try {
			String query = "Select tour_name from tour where tour_id = '1'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_1 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel = new JLabel("Add Tours");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 32));
		lblNewLabel.setBounds(186, 25, 224, 58);
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
		lblDetails.setBackground(new Color(65, 105, 225));
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
		
		textFieldImage = new JTextField();
		textFieldImage.setBounds(343, 318, 124, 20);
		frame.getContentPane().add(textFieldImage);
		textFieldImage.setColumns(10);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImage.setBounds(70, 307, 81, 30);
		frame.getContentPane().add(lblImage);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorderPainted(false);

		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setIcon(new ImageIcon(AdminAddTours.class.getResource("/images/attachbtn.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				int index = filename.indexOf("src");
				String newFilename = filename.substring(index+3);
				textFieldImage.setText(newFilename.replace("\\", "/"));
			

				Image getAbsolutePath = null;
				ImageIcon icon = new ImageIcon(newFilename);
				Image image = icon.getImage().getScaledInstance(179, 180, Image.SCALE_SMOOTH);
			}
		});
		btnNewButton.setBounds(210, 310, 130, 38);
		
		
	
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewBack = new JButton("");
		btnNewBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard admindb = new AdminDashboard(username);
				admindb.NewScreen(username);
     			frame.dispose();
			}
		});
		btnNewBack.setBorderPainted(false);
		btnNewBack.setIcon(new ImageIcon(AdminAddTours.class.getResource("/images/back.png")));
		btnNewBack.setBackground(new Color(65, 105, 225));
		btnNewBack.setBounds(332, 372, 145, 35);
		frame.getContentPane().add(btnNewBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(511, 42, 283, 388);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Current Tours");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(88, 11, 160, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(32, 51, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tour Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(76, 48, 90, 21);
		panel.add(lblNewLabel_3);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(59, 45, 7, 316);
		panel.add(verticalStrut);
		
		JLabel lblNewLabel_4 = new JLabel("1");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(32, 76, 26, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("2");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(32, 101, 26, 14);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("3");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(32, 126, 26, 14);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("4");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_3.setBounds(32, 151, 26, 14);
		panel.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("5");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_4.setBounds(32, 176, 26, 14);
		panel.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("6");
		lblNewLabel_4_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_5.setBounds(32, 201, 26, 14);
		panel.add(lblNewLabel_4_5);
		
		
		JLabel lblNewLabel_5 = new JLabel(""+tour_id_1);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(75, 76, 198, 16);
		panel.add(lblNewLabel_5);
		
		try {
			String query = "Select tour_name from tour where tour_id = '2'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_2 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel_5_1 = new JLabel(""+tour_id_2);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_1.setBounds(75, 101, 198, 16);
		panel.add(lblNewLabel_5_1);
		
		try {
			String query = "Select tour_name from tour where tour_id = '3'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_3 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel_5_2 = new JLabel(""+tour_id_3);
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_2.setBounds(75, 128, 198, 16);
		panel.add(lblNewLabel_5_2);
		
		try {
			String query = "Select tour_name from tour where tour_id = '4'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_4 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel_5_3 = new JLabel(""+tour_id_4);
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_3.setBounds(76, 153, 198, 16);
		panel.add(lblNewLabel_5_3);
		
		try {
			String query = "Select tour_name from tour where tour_id = '5'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_5 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel_5_4 = new JLabel(""+tour_id_5);
		lblNewLabel_5_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_4.setBounds(76, 178, 198, 16);
		panel.add(lblNewLabel_5_4);
		
		try {
			String query = "Select tour_name from tour where tour_id = '6'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_6 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		JLabel lblNewLabel_5_5 = new JLabel(""+tour_id_6);
		lblNewLabel_5_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_5.setBounds(75, 203, 198, 16);
		panel.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_6 = new JLabel("* TourName indicates no Tour is Currently added!!");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(0, 372, 296, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4_5_1 = new JLabel("7");
		lblNewLabel_4_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_5_1.setBounds(32, 226, 26, 14);
		panel.add(lblNewLabel_4_5_1);
		
		try {
			String query = "Select tour_name from tour where tour_id = '7'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_7 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel_5_5_1 = new JLabel(""+tour_id_7);
		lblNewLabel_5_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_5_1.setBounds(75, 228, 198, 16);
		panel.add(lblNewLabel_5_5_1);
		
		
		JLabel lblNewLabel_4_5_2 = new JLabel("8");
		lblNewLabel_4_5_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_5_2.setBounds(32, 251, 26, 14);
		panel.add(lblNewLabel_4_5_2);
		
		try {
			String query = "Select tour_name from tour where tour_id = '8'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_8 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel_5_5_2 = new JLabel(""+tour_id_8);
		lblNewLabel_5_5_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_5_2.setBounds(76, 253, 198, 16);
		panel.add(lblNewLabel_5_5_2);
		
		JLabel lblNewLabel_4_5_3 = new JLabel("9");
		lblNewLabel_4_5_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_5_3.setBounds(32, 276, 26, 14);
		panel.add(lblNewLabel_4_5_3);
		
		try {
			String query = "Select tour_name from tour where tour_id = '9'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_9 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel_5_5_3 = new JLabel(""+tour_id_9);
		lblNewLabel_5_5_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_5_3.setBounds(76, 278, 198, 16);
		panel.add(lblNewLabel_5_5_3);
		
		JLabel lblNewLabel_4_5_4 = new JLabel("10");
		lblNewLabel_4_5_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_5_4.setBounds(32, 301, 26, 14);
		panel.add(lblNewLabel_4_5_4);
		
		try {
			String query = "Select tour_name from tour where tour_id = '10'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_10 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel_5_5_4 = new JLabel(""+tour_id_10);
		lblNewLabel_5_5_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_5_4.setBounds(75, 303, 198, 16);
		panel.add(lblNewLabel_5_5_4);
		
		JLabel lblNewLabel_4_5_5 = new JLabel("11");
		lblNewLabel_4_5_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_5_5.setBounds(32, 326, 26, 14);
		panel.add(lblNewLabel_4_5_5);
		
		try {
			String query = "Select tour_name from tour where tour_id = '11'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_11 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel_5_5_5 = new JLabel(""+tour_id_11);
		lblNewLabel_5_5_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_5_5.setBounds(76, 328, 198, 16);
		panel.add(lblNewLabel_5_5_5);
		
		JLabel lblNewLabel_4_5_6 = new JLabel("12");
		lblNewLabel_4_5_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_5_6.setBounds(32, 351, 26, 14);
		panel.add(lblNewLabel_4_5_6);
		
		try {
			String query = "Select tour_name from tour where tour_id = '12'";
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	            Statement selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery(query);
	            while(rs.next()) {
	            	tour_id_12 = rs.getString(1);
	            }
	            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel_5_5_6 = new JLabel(""+tour_id_12);
		lblNewLabel_5_5_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_5_6.setBounds(76, 350, 198, 16);
		panel.add(lblNewLabel_5_5_6);
		
		JButton btnAddTour = new JButton("");
		btnAddTour.setBorderPainted(false);

		btnAddTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tour_id = textFieldId.getText();
				String tour_name = textFieldName.getText();
				String tour_doj = textFieldDoj.getText();
				String tour_details = textFieldDetails.getText();
				String tour_price = textFieldPrice.getText();
				String tour_image = textFieldImage.getText();
				
				int t_id = Integer.parseInt(tour_id);  
				
				 try {
	                	Class.forName("org.postgresql.Driver");
	                //	System.out.println("ID"+tour_id);
						Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
						String query = "update tour set tour_name = '"+tour_name+"' , tour_doj = '"+tour_doj+"' , tour_details = '"+tour_details+"' , tour_price = '"+tour_price+"' , tour_image = '"+tour_image+"' where tour_id = '"+t_id+"'";
								
						Statement stmt = con.createStatement();
					    stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Tour Added Successfully");
						AdminDashboard admindb = new AdminDashboard(username);
						admindb.NewScreen(username);
		     			frame.dispose();
					
	                }
	                catch(Exception exp){
	                    System.out.println(exp);
	            }
			}
		});
		btnAddTour.setBackground(new Color(65, 105, 225));
		btnAddTour.setBorderPainted(false);
		btnAddTour.setForeground(Color.BLACK);
		btnAddTour.setIcon(new ImageIcon(AdminAddTours.class.getResource("/images/addtour35.png")));
		btnAddTour.setBounds(145, 372, 130, 35);
		frame.getContentPane().add(btnAddTour);
		
		
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
