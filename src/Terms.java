import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Terms {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Terms window = new Terms();
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
	public Terms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 784, 389);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Terms And Conditions");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(268, 0, 258, 53);
		panel.add(lblNewLabel);
		
		JEditorPane dtrpnToTravelTo = new JEditorPane();
		dtrpnToTravelTo.setEditable(false);
		dtrpnToTravelTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dtrpnToTravelTo.setText("To travel to India from overseas countries except for the citizen of Nepal & Bhutan, one needs a 06 months valid  passport and a valid Visa. And processing of Passport and Visa are not included in the tour cost.\r\n\r\nPlease note that cost of the vehicle (car / coaches with the driver) does not include extra usage of vehicle like after transfer or after sightseeing until or unless it is mentioned in the itinerary.\r\n\r\nIn all circumstances and at all times it is the sole responsibility of the Client to take care of their baggage and personal effects and Travel Tours shall not be liable for any loss of baggage/personal effects of the Client by airline/cruise/ coach or any other carrier. \r\n\r\nCancelled bookings will incur charges. These charges can be up to 100% of the cost of the booking, regardless of whether travel has commenced or not. \r\n\r\nTour once commenced will strictly go as per the itinerary finalized. In case of events and circumstances beyond    our control, we reserve the right to change all or parts of the contents of the itinerary for safety and well being of  our esteemed passengers.\r\n\r\nPlease note that standard check-in / Checkout time in most hotels is 1200 Hrs. (IST). Therefore cost of early check-in or Late check-out is not included in the tour cost. ");
		dtrpnToTravelTo.setBounds(37, 46, 706, 329);
		panel.add(dtrpnToTravelTo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Terms.class.getResource("/images/Rectangle 2 (1).png")));
		lblNewLabel_1.setBounds(15, 50, 12, 14);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Terms.class.getResource("/images/Rectangle 2 (1).png")));
		label.setBounds(15, 102, 12, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Terms.class.getResource("/images/Rectangle 2 (1).png")));
		label_1.setBounds(15, 154, 12, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Terms.class.getResource("/images/Rectangle 2 (1).png")));
		label_2.setBounds(15, 221, 12, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Terms.class.getResource("/images/Rectangle 2 (1).png")));
		label_3.setBounds(15, 272, 12, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Terms.class.getResource("/images/Rectangle 2 (1).png")));
		label_4.setBounds(15, 340, 12, 14);
		panel.add(label_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Terms.class.getResource("/images/ok.png")));
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(318, 407, 130, 35);
		frame.getContentPane().add(btnNewButton);
		
		
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
