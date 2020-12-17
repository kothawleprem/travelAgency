import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class AdminViewBookings {

	private JFrame frame;
	private JTable table;
	//private JTable table_1;

	/**
	 * Launch the application.
	 */
	public void NewScreen(final String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViewBookings window = new AdminViewBookings(username);
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
	public AdminViewBookings(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setTitle("View Bookings");
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblViewBookings = new JLabel("View Bookings");
		lblViewBookings.setForeground(Color.YELLOW);
		lblViewBookings.setFont(new Font("Georgia", Font.BOLD, 32));
		lblViewBookings.setBounds(296, 8, 339, 49);
		frame.getContentPane().add(lblViewBookings);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 68, 750, 321);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 55, 728, 253);
		panel.add(table);
		
		try {
			String query = "select booking_id,customer_name,customer_phone,tour_name from customer c inner join booking b on c.customer_username = b.customer_username inner join tour t on b.tour_id = t.tour_id  where booking_status = 'Completed' order by booking_id;";
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
            PreparedStatement pst = connection.prepareStatement(query) ;
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            connection.close();
		}catch(Exception e) {
			System.out.println(e);
		}
            
            JLabel lblNewLabel = new JLabel("Booking ID");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblNewLabel.setBounds(49, 24, 88, 20);
            panel.add(lblNewLabel);
            
            JLabel lblCustomerName = new JLabel("Customer Name");
            lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblCustomerName.setBounds(217, 24, 117, 20);
            panel.add(lblCustomerName);
            
            JLabel lblNewLabel_1_1 = new JLabel("Tour Name");
            lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblNewLabel_1_1.setBounds(609, 24, 88, 20);
            panel.add(lblNewLabel_1_1);
            
            JLabel lblCustomerPhone = new JLabel("Customer Phone");
            lblCustomerPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblCustomerPhone.setBounds(410, 24, 117, 20);
            panel.add(lblCustomerPhone);
	
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard admindb = new AdminDashboard(username);
				admindb.NewScreen(username);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(AdminViewBookings.class.getResource("/images/back.png")));
		btnNewButton.setBounds(349, 400, 130, 30);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
