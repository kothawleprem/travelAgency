import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
//import javax.swing.JTextArea;
//import javax.swing.JTextPane;
//import java.util.*;
public class TourInfo {

	private JFrame frame;
	private JLabel lblname;

	/**
	 * Launch the application.
	 */
	public void NewScreen(String uname,int code) {
		final String username = uname;
		final int id= code;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TourInfo window = new TourInfo(username,id);
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
	public TourInfo(String username,int id) {
		initialize(username,id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//@SuppressWarnings("deprecation")
	private void initialize(final String username,final int id) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setTitle("Tour Info - "+username);
		frame.getContentPane().setLayout(null);
		
		String name = "",details = "",doj="",price="",image="";
		try {
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
	         Statement selectStmt = connection.createStatement();
			 ResultSet rs = selectStmt.executeQuery("SELECT tour_name,tour_doj,tour_details,tour_price,tour_image FROM tour WHERE tour_id = '"+id+"'");
			 while(rs.next())
	            {
				  name = rs.getString(1);
				  doj = rs.getString(2);
				  price = rs.getString(4);
				  details = rs.getString(3);
				  image = rs.getString(5);
	            }
				connection.close();

		}catch(Exception e) {
		System.out.println(e);	
		}
		
		JLabel lblNewLabel = new JLabel("Tour Info");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 32));
		lblNewLabel.setBounds(294, 36, 192, 39);
		frame.getContentPane().add(lblNewLabel);
		 
 		lblname = new JLabel("Name:");
 		lblname.setForeground(new Color(255, 255, 255));
 		lblname.setBackground(new Color(255, 255, 255));
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblname.setBounds(107, 141, 86, 25);
		frame.getContentPane().add(lblname);
		
		JLabel lblDOJ = new JLabel("DOJ:");
		lblDOJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDOJ.setForeground(new Color(255, 255, 255));
		lblDOJ.setBounds(107, 177, 98, 25);
		frame.getContentPane().add(lblDOJ);
		
		JLabel lbldetail = new JLabel("Details:");
		lbldetail.setForeground(new Color(255, 255, 255));
		lbldetail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldetail.setBounds(107, 215, 86, 25);
		frame.getContentPane().add(lbldetail);
		
		String [] unames ;
		ArrayList<String> mylist = new ArrayList<String>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
			Statement stmt = con.createStatement();
			String query = "Select admin_username from admin";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				mylist.add(rs.getString(1));
				
			}
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		int flag = 0;
		for(int i=0;i<mylist.size();i++) {
			if( username.contentEquals(mylist.get(i)))
				flag=1;

		}
		final int check=flag;
		
		final JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(TourInfo.class.getResource("/images/confirm.png")));
		btnNewButton.setBounds(188, 330, 154, 30);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.length()==0)
				{
					JOptionPane.showMessageDialog(btnNewButton, "Not logged in");
					
				}
				else if(check==1)
				{
					JOptionPane.showMessageDialog(btnNewButton, "You are an Admin!");
				}
				else
				{
					UserBookingConfirmation bookconf = new UserBookingConfirmation(username,id);
					bookconf.NewScreen(username,id);
					frame.dispose();
				}
				
			}
		});
		flag=0;
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTours view = new ViewTours(username);
				view.NewScreen(username);
				frame.dispose();
			}
		});
		button.setIcon(new ImageIcon(TourInfo.class.getResource("/images/back.png")));
		button.setBorderPainted(false);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(395, 330, 154, 39);
		frame.getContentPane().add(button);
		
		JLabel lblid = new JLabel("ID:");
		lblid.setForeground(Color.WHITE);
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblid.setBounds(107, 105, 50, 25);
		frame.getContentPane().add(lblid);
		
		JLabel lbldynid = new JLabel(""+id);
		lbldynid.setForeground(Color.YELLOW);
		lbldynid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldynid.setBounds(203, 105, 206, 25);
		frame.getContentPane().add(lbldynid);
		
		JLabel lbldynname = new JLabel(""+name);
		lbldynname.setForeground(Color.YELLOW);
		lbldynname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldynname.setBounds(203, 141, 300, 25);
		frame.getContentPane().add(lbldynname);
		
		JLabel lbldyndetails = new JLabel(""+details);
		lbldyndetails.setForeground(Color.YELLOW);
		lbldyndetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldyndetails.setBounds(203, 215, 300, 25);
		frame.getContentPane().add(lbldyndetails);
		
		JLabel lbldyndoj = new JLabel(""+doj);
		lbldyndoj.setForeground(Color.YELLOW);
		lbldyndoj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldyndoj.setBounds(203, 177, 300, 25);
		frame.getContentPane().add(lbldyndoj);
		
		JLabel lblprice_1 = new JLabel("Price:");
		lblprice_1.setForeground(Color.WHITE);
		lblprice_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblprice_1.setBounds(107, 256, 62, 25);
		frame.getContentPane().add(lblprice_1);
		
		JLabel lbldynprice = new JLabel(""+price);
		lbldynprice.setForeground(Color.YELLOW);
		lbldynprice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldynprice.setBounds(203, 256, 300, 25);
		frame.getContentPane().add(lbldynprice);
		
		JLabel lblNewLabelImageTour = new JLabel("");
		lblNewLabelImageTour.setIcon(new ImageIcon(TourInfo.class.getResource(""+image)));
		lblNewLabelImageTour.setBounds(567, 113, 179, 180);
		frame.getContentPane().add(lblNewLabelImageTour);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
