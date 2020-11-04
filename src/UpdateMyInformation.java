import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateMyInformation {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMyInformation window = new UpdateMyInformation();
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
	public UpdateMyInformation() {
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
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 366, 420);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UpdateMyInformation.class.getResource("/images/upmyinfo.png")));
		lblNewLabel.setBounds(10, 11, 346, 398);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Update Information");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1.setBounds(437, 40, 341, 54);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(411, 129, 109, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(411, 210, 109, 27);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(411, 170, 109, 27);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(411, 250, 138, 27);
		frame.getContentPane().add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setBounds(559, 136, 206, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(559, 177, 206, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(559, 217, 206, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(559, 257, 206, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInformation myinfo =new MyInformation();
				myinfo.NewScreen();
				frame.dispose();
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(460, 336, 101, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInformation myinfo =new MyInformation();
				myinfo.NewScreen();
				frame.dispose();
			}
		});
		btnCancel.setBorderPainted(false);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(641, 336, 101, 33);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCity.setBounds(411, 288, 138, 27);
		frame.getContentPane().add(lblCity);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(559, 288, 206, 20);
		frame.getContentPane().add(textField_4);
		
	}
}
