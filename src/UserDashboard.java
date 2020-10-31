import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserDashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDashboard window = new UserDashboard();
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
	public UserDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("My Bookings");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyBookings mybook = new MyBookings();
				mybook.NewScreen();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(147, 130, 114, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAddInformation = new JButton("My Information");
		btnAddInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInformation myinfo =new MyInformation();
				myinfo.NewScreen();
				frame.dispose();
			}
		});
		btnAddInformation.setBounds(452, 130, 124, 23);
		frame.getContentPane().add(btnAddInformation);
		
		JButton btnLogout = new JButton("Logout");

		btnLogout.setBounds(468, 241, 89, 23);
		frame.getContentPane().add(btnLogout);
		
		JButton btnViewTours = new JButton("View Tours");
		btnViewTours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTours view = new ViewTours();
				view.NewScreen();
				frame.dispose();
			}
		});
		btnViewTours.setBounds(157, 241, 89, 23);
		frame.getContentPane().add(btnViewTours);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
