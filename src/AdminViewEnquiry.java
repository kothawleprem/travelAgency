import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;

import net.proteanit.sql.DbUtils;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminViewEnquiry {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void NewScreen(final String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViewEnquiry window = new AdminViewEnquiry(username);
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
	public AdminViewEnquiry(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 784, 309);
		frame.getContentPane().add(scrollPane);
		
		table =  new JTable();
		scrollPane.setViewportView(table);
		
	
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			String query = "select enquiry_id,enquiry_customer_name,enquiry_contact,enquiry_messsage from enquire;";
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
            PreparedStatement pst = connection.prepareStatement(query) ;
            ResultSet rs = pst.executeQuery();
        	table.setModel(DbUtils.resultSetToTableModel(rs));
		    connection.close();
		    }catch(Exception e) {
			System.out.println(e);
		}
		
		 JButton btnNewButton = new JButton("");
         btnNewButton.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		AdminDashboard admindb = new AdminDashboard(username);
				admindb.NewScreen(username);
				frame.dispose();
         	}
         });
         
 		btnNewButton.setBorderPainted(false);
         btnNewButton.setBackground(new Color(65, 105, 225));
         btnNewButton.setIcon(new ImageIcon(AdminViewEnquiry.class.getResource("/images/back.png")));
         btnNewButton.setBounds(347, 409, 151, 30);
         frame.getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("View Enquiry");
        lblNewLabel_1.setForeground(Color.YELLOW);
        lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 32));
        lblNewLabel_1.setBounds(304, 28, 236, 38);
        frame.getContentPane().add(lblNewLabel_1);
        
	}

}
