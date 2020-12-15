import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class MyBookings {

	private JFrame frame;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public void NewScreen(final String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyBookings window = new MyBookings(username);
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
	public MyBookings(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setTitle("My Bookings - "+username);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Bookings");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(287, 11, 203, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 364, 409, -251);
		frame.getContentPane().add(scrollPane);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(27, 67, 751, 303);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 44, 731, 248);
		panel.add(table);
		
		try {
			String query = "select booking_id,tour_name,tour_doj,tour_details,tour_price from tour t join booking b on t.tour_id = b.tour_id where customer_username like '%"+username+"%' order by booking_id;";
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
            PreparedStatement pst = connection.prepareStatement(query) ;
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            connection.close();
           
		}catch(Exception e) {
			System.out.println(e);
		}
		
		 JLabel lblNewLabel_1 = new JLabel("Booking ID");
         lblNewLabel_1.setBounds(62, 11, 82, 14);
         panel.add(lblNewLabel_1);
         
         JLabel lblNewLabel_2 = new JLabel("Tour Name");
         lblNewLabel_2.setBounds(207, 11, 71, 14);
         panel.add(lblNewLabel_2);
         
         JLabel lblNewLabel_3 = new JLabel("Tour DOJ");
         lblNewLabel_3.setBounds(352, 11, 71, 14);
         panel.add(lblNewLabel_3);
         
         JLabel lblNewLabel_4 = new JLabel("Tour Details");
         lblNewLabel_4.setBounds(642, 11, 71, 14);
         panel.add(lblNewLabel_4);
         
         JLabel lblNewLabel_5 = new JLabel("Tour Price");
         lblNewLabel_5.setBounds(498, 11, 71, 14);
         panel.add(lblNewLabel_5);
         
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDashboard userdb = new UserDashboard(username);
				userdb.NewScreen(username);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(MyBookings.class.getResource("/images/back.png")));
		btnNewButton.setBounds(322, 381, 130, 30);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
