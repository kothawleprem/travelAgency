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

public class ViewTours2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen(String uname) {
		final String username = uname;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTours2 window = new ViewTours2(username);
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
	public ViewTours2(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	String connect(int id) {
		String images = "";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
			Statement selectStmt = con.createStatement();
			ResultSet rs = selectStmt.executeQuery("select tour_image from tour where tour_id = '"+id+"'");
			while(rs.next())
            {
				images = rs.getString(1);
            }
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return images;
	} 
	
	private void initialize(final String username) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setTitle("View Tours Domestic");
		frame.getContentPane().setLayout(null);
	//	String images = "";

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.YELLOW);
		panel_3.setBounds(150, 25, 640, 400);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		frame.getContentPane().add(panel_3);
		
		JLabel labelID7 = new JLabel("");
		String image7 = connect(7);
		labelID7.setIcon(new ImageIcon(ViewTours2.class.getResource(""+image7)));
		labelID7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,7);
				tourin.NewScreen(username,7);
				frame.dispose();
			}
		});
		labelID7.setBounds(20, 11, 179, 180);
		panel_3.add(labelID7);
		
	
		JLabel labelID8 = new JLabel("");
		String image8 = connect(8);
		
		labelID8.setIcon(new ImageIcon(ViewTours2.class.getResource(""+image8)));
		labelID8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,8);
				tourin.NewScreen(username,8);
				frame.dispose();
			}
		});
		labelID8.setBounds(20, 202, 179, 180);
		panel_3.add(labelID8);
		
		JLabel labelID9 = new JLabel("");
		String image9 = connect(9);
		labelID9.setIcon(new ImageIcon(ViewTours2.class.getResource(""+image9)));
		labelID9.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,9);
				tourin.NewScreen(username,9);
				frame.dispose();
			}
		});
		labelID9.setBounds(230, 11, 179, 180);
		panel_3.add(labelID9);
		
		JLabel labelID10 = new JLabel("");
		String image10 = connect(10);
		labelID10.setIcon(new ImageIcon(ViewTours2.class.getResource(""+image10)));
		labelID10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,10);
				tourin.NewScreen(username,10);
				frame.dispose();
			}
		});
		labelID10.setBounds(230, 202, 179, 180);
		
		panel_3.add(labelID10);
		
		JLabel labelID11 = new JLabel("");
		String image11 = connect(11);
		labelID11.setIcon(new ImageIcon(ViewTours2.class.getResource(""+image11)));
		labelID11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,11);
				tourin.NewScreen(username,11);
				frame.dispose();
			}
		});
		labelID11.setBounds(440, 11, 179, 180);
		panel_3.add(labelID11);
		
		
		JLabel labelID12 = new JLabel("");
		String image12 = connect(12);
		labelID12.setIcon(new ImageIcon(ViewTours2.class.getResource(""+image12)));
		labelID12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,12);
				tourin.NewScreen(username,12);
				frame.dispose();
			}
		});
		labelID12.setBounds(440, 202, 179, 180);
		panel_3.add(labelID12);
		
		
		final JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ViewTours2.class.getResource("/images/homebtn.png")));
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
		panel.setBounds(10, 25, 127, 243);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ViewTours2.class.getResource("/images/tree.png")));
		lblNewLabel_1.setBounds(0, 0, 127, 243);
		panel.add(lblNewLabel_1);
		
		JButton btnDashboard = new JButton("");
		btnDashboard.setIcon(new ImageIcon(ViewTours2.class.getResource("/images/dashboard.png")));
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
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTours view = new ViewTours(username);
				view.NewScreen(username);
				frame.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBorderPainted(false);

		btnNewButton_1.setIcon(new ImageIcon(ViewTours2.class.getResource("/images/back.png")));
		btnNewButton_1.setBounds(10, 284, 130, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}

