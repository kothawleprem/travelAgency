import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollBar;
import java.awt.ScrollPane;

public class ViewTours {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen(String uname) {
		final String username = uname;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTours window = new ViewTours(username);
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
	public ViewTours(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	String connect(int id) {
		String details = "";
		try {
			Class.forName("org.postgresql.Driver");
			//System.out.println("Got ID"+id);
			Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
			Statement selectStmt = con.createStatement();
			ResultSet rs = selectStmt.executeQuery("select tour_image from tour where tour_id = '"+id+"'");
			while(rs.next())
            {
				details = rs.getString(1);
            }
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return details;
	} 
	
	private void initialize(final String username) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setTitle("View Tours");
		frame.getContentPane().setLayout(null);
		String details = "";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
			Statement selectStmt = con.createStatement();
			ResultSet rs = selectStmt.executeQuery("select tour_details from tour where tour_id = '07'");
			while(rs.next())
            {
				details = rs.getString(1);
            }
			//System.out.println("Hello"+details);
		}catch(Exception e) {
			System.out.println(e);
		}
	//	JScrollPane jp = new JScrollPane();
		
		JPanel panel_3 = new JPanel();
	//	panel_3.setViewportView(panel_3);
		panel_3.setBackground(Color.YELLOW);
		panel_3.setBounds(150, 25, 640, 400);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		frame.getContentPane().add(panel_3);
		
		JLabel labelID1 = new JLabel("");
		String detail1 = connect(1);
		labelID1.setIcon(new ImageIcon(ViewTours.class.getResource(""+detail1)));
		labelID1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,1);
				tourin.NewScreen(username,1);
				frame.dispose();
			}
		});
		labelID1.setBounds(20, 11, 179, 180);
		panel_3.add(labelID1);
		
	
		JLabel labelID2 = new JLabel("");
		String detail2 = connect(2);
		labelID2.setIcon(new ImageIcon(ViewTours.class.getResource(""+detail2)));
		labelID2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,2);
				tourin.NewScreen(username,2);
				frame.dispose();
			}
		});
		labelID2.setBounds(20, 202, 179, 180);
		panel_3.add(labelID2);
		
		JLabel labelID3 = new JLabel("");
		String detail3 = connect(3);
		labelID3.setIcon(new ImageIcon(ViewTours.class.getResource(""+detail3)));
		labelID3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,3);
				tourin.NewScreen(username,3);
				frame.dispose();
			}
		});
		labelID3.setBounds(230, 11, 179, 180);
		panel_3.add(labelID3);
		
		JLabel labelID4 = new JLabel("");
		String detail4 = connect(4);
		labelID4.setIcon(new ImageIcon(ViewTours.class.getResource(""+detail4)));
		labelID4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,4);
				tourin.NewScreen(username,4);
				frame.dispose();
			}
		});
		labelID4.setBounds(230, 202, 179, 180);
		
		panel_3.add(labelID4);
		
		JLabel labelID5 = new JLabel("");
		String detail5 = connect(5);
		labelID5.setIcon(new ImageIcon(ViewTours.class.getResource(""+detail5)));
		labelID5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,5);
				tourin.NewScreen(username,5);
				frame.dispose();
			}
		});
		labelID5.setBounds(440, 11, 179, 180);
		panel_3.add(labelID5);
		
		
		JLabel labelID6 = new JLabel("");
		String detail6 = connect(6);
		labelID6.setIcon(new ImageIcon(ViewTours.class.getResource(""+detail6)));
		labelID6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,6);
				tourin.NewScreen(username,6);
				frame.dispose();
			}
		});
		labelID6.setBounds(440, 202, 179, 180);
		panel_3.add(labelID6);
		
		
		final JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ViewTours.class.getResource("/images/homebtn.png")));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				
		
					Welcome wel= new Welcome();
					wel.main(null);
					frame.dispose();
				
				
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(10, 385, 130, 31);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 25, 127, 302);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ViewTours.class.getResource("/images/tree.png")));
		lblNewLabel_1.setBounds(0, 0, 127, 302);
		panel.add(lblNewLabel_1);
		
		JButton btnDashboard = new JButton("");
		btnDashboard.setIcon(new ImageIcon(ViewTours.class.getResource("/images/dashboard.png")));
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.length()==0)
				{
					JOptionPane.showMessageDialog(btnNewButton, "Not logged in");
					
				}
				else if(username.contains("admin"))
					{

					AdminDashboard admindb = new AdminDashboard(username);
					admindb.NewScreen(username);
					frame.dispose();
                  }
				else
				{
					UserDashboard userdb = new UserDashboard(username);
					userdb.NewScreen(username);
					frame.dispose();
				}
				
			}
		});
		btnDashboard.setForeground(Color.BLACK);
		btnDashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDashboard.setBorderPainted(false);
		btnDashboard.setBackground(new Color(65, 105, 225));
		btnDashboard.setBounds(10, 338, 130, 30);
		frame.getContentPane().add(btnDashboard);
		
		
		
		frame.setBounds(100, 100, 820, 480);
		//JScrollPane scroll = new JScrollPane(frame,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}

