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
import java.sql.Statement;
import java.awt.event.ActionEvent;

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
		
		JLabel lbl_image = new JLabel("");
		lbl_image.setBounds(555, 116, 179, 180);
		frame.getContentPane().add(lbl_image);
		
		textFieldImage = new JTextField();
		textFieldImage.setBounds(322, 318, 145, 20);
		frame.getContentPane().add(textFieldImage);
		textFieldImage.setColumns(10);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImage.setBounds(70, 307, 81, 30);
		frame.getContentPane().add(lblImage);
		
		JButton btnNewButton = new JButton("Attach");
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
		btnNewButton.setBounds(223, 317, 89, 23);
		
		JButton btnAddTour = new JButton("");
		btnAddTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tour_id = textFieldId.getText();
				String tour_name = textFieldName.getText();
				String tour_doj = textFieldDoj.getText();
				String tour_details = textFieldDetails.getText();
				String tour_price = textFieldPrice.getText();
				String tour_image = textFieldImage.getText();
				
				
				 try {
	                	Class.forName("org.postgresql.Driver");
	                //	System.out.println("ID"+tour_id);
						Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
						String query = "update tour set tour_name = '"+tour_name+"' , tour_doj = '"+tour_doj+"' , tour_details = '"+tour_details+"' , tour_price = '"+tour_price+"' , tour_image = '"+tour_image+"' where tour_id like '%"+tour_id+"%'";
								
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
		btnAddTour.setBounds(146, 355, 130, 35);
		frame.getContentPane().add(btnAddTour);
		
	
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewBack = new JButton("");
		btnNewBack.setBorderPainted(false);
		btnNewBack.setIcon(new ImageIcon(AdminAddTours.class.getResource("/images/back.png")));
		btnNewBack.setBackground(new Color(65, 105, 225));
		btnNewBack.setBounds(332, 355, 145, 35);
		frame.getContentPane().add(btnNewBack);
		
		
		
		
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
