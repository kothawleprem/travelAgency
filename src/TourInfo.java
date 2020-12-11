import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

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
	private void initialize(final String username,int id) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tour Info");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(294, 36, 192, 39);
		frame.getContentPane().add(lblNewLabel);
		
		lblname = new JLabel("Name:");
		lblname.setForeground(new Color(255, 255, 255));
		lblname.setBackground(new Color(255, 255, 255));
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblname.setBounds(107, 141, 86, 25);
		frame.getContentPane().add(lblname);
		
		JLabel lblDetails = new JLabel("Details:");
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDetails.setForeground(new Color(255, 255, 255));
		lblDetails.setBounds(107, 177, 98, 25);
		frame.getContentPane().add(lblDetails);
		
		JLabel lblprice = new JLabel("Price:");
		lblprice.setForeground(new Color(255, 255, 255));
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblprice.setBounds(107, 215, 62, 25);
		frame.getContentPane().add(lblprice);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(TourInfo.class.getResource("/images/confirm.png")));
		btnNewButton.setBounds(188, 330, 154, 30);
		frame.getContentPane().add(btnNewButton);
		String name = "",price = "",details = "";
		try {
			 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/traveldb", "postgres", "premsk29");
	         Statement selectStmt = connection.createStatement();
			 ResultSet rs = selectStmt.executeQuery("SELECT tour_name,tour_price,tour_details FROM tour WHERE tour_id = 1");
			 while(rs.next())
	            {
				  name = rs.getString(1);
				  price = rs.getString(2);
				  details = rs.getString(3);
	            }
		
		}catch(Exception e) {
		System.out.println(e);	
		}
		
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
		
		JLabel lbldynprice = new JLabel(""+price);
		lbldynprice.setForeground(Color.YELLOW);
		lbldynprice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldynprice.setBounds(203, 215, 300, 25);
		frame.getContentPane().add(lbldynprice);
		
		JLabel lbldyndetails = new JLabel(""+details);
		lbldyndetails.setForeground(Color.YELLOW);
		lbldyndetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldyndetails.setBounds(203, 177, 300, 25);
		frame.getContentPane().add(lbldyndetails);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
