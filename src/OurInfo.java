import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class OurInfo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OurInfo window = new OurInfo();
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
	public OurInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Our Info");
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Our Info");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 32));
		lblNewLabel.setBounds(318, 11, 143, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(28, 71, 752, 310);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JEditorPane dtrpnTheTravelAgency = new JEditorPane();
		dtrpnTheTravelAgency.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtrpnTheTravelAgency.setText("A passenger finds it very difficult to search for the best tours as he/she must browse multiple records, contact many travel agents etc. which is a tedious process and is time consuming.\r\n\r\nThis Travel Agency System was established to cater the need of increasing travel related issues faced by the passengers.\r\n\r\nThis system makes travel easy and comfortable for the Passengers.\r\n\r\nAnyone can ask agency their queires and interested passengers can register and further login to avail the \r\nservices.\r\n\r\nIt has the feature to view past bookings and add number of passengers too.\r\n\r\nAdmins would view your bookings and read to your queries.\r\n\r\n\r\n");
		dtrpnTheTravelAgency.setBounds(10, 11, 732, 288);
		panel.add(dtrpnTheTravelAgency);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Welcome wel= new Welcome();
				wel.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(OurInfo.class.getResource("/images/back.png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(452, 392, 130, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnquiryPage enqpage = new EnquiryPage();
				enqpage.NewScreen();
				frame.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(OurInfo.class.getResource("/images/enquiry.png")));
		button.setBorderPainted(false);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(191, 392, 130, 35);
		frame.getContentPane().add(button);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
