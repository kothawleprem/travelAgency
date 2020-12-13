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
	private void initialize(final String username) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		
	//	JScrollPane jp = new JScrollPane();
		
		JPanel panel_3 = new JPanel();
	//	panel_3.setViewportView(panel_3);
		panel_3.setBackground(Color.YELLOW);
		panel_3.setBounds(150, 25, 640, 400);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		frame.getContentPane().add(panel_3);
		
		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,1);
				tourin.NewScreen(username,1);
				frame.dispose();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(ViewTours.class.getResource("/images/hongkong.jpg")));
		lblNewLabel.setBounds(20, 11, 179, 180);
		panel_3.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,2);
				tourin.NewScreen(username,2);
				frame.dispose();
			}
		});
		label.setIcon(new ImageIcon(ViewTours.class.getResource("/images/maldives.jpg")));
		label.setBounds(230, 202, 179, 180);
		panel_3.add(label);
		
		JLabel label_2 = new JLabel("");
		
		label_2.setIcon(new ImageIcon(ViewTours.class.getResource("/images/figma.jpg")));
		label_2.setBounds(440, 11, 179, 180);
		panel_3.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TourInfo tourin = new TourInfo(username,3);
				tourin.NewScreen(username,3);
				frame.dispose();
			}
		});
		label_1.setIcon(new ImageIcon(ViewTours.class.getResource("/images/goa.png")));
		label_1.setBounds(230, 11, 179, 180);
		panel_3.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(ViewTours.class.getResource("/images/kerala.png")));
		label_3.setBounds(20, 202, 179, 180);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(ViewTours.class.getResource("/images/leh.png")));
		label_4.setBounds(440, 202, 179, 180);
		panel_3.add(label_4);
		
		
		
		
		
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
