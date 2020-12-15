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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(318, 11, 143, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(28, 71, 752, 310);
		frame.getContentPane().add(panel);
		
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
