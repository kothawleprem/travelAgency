import java.awt.EventQueue;
//import java.awt.Image;
//import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
//import javax.swing.border.EtchedBorder;
//import javax.swing.border.MatteBorder;



//import javax.swing.ImageIcon;
//import javax.swing.SwingConstants;
//import javax.swing.JTextField;
import java.awt.Font;
//import javax.swing.JEditorPane;
//import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;

//import javax.swing.SwingConstants;

public class Welcome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
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
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 365, 420);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.LIGHT_GRAY, Color.BLACK, null));
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Welcome.class.getResource("/images/welcome.png")));
		lblNewLabel_4.setBounds(10, 11, 345, 398);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(520, 316, 130, 30);
		btnNewButton.setIcon(new ImageIcon(Welcome.class.getResource("/images/button1.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTours view = new ViewTours();
				view.NewScreen();
				frame.dispose();
	
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		
		JLabel lblNewLabel = new JLabel("Travel Agency");
		lblNewLabel.setBounds(482, 85, 230, 50);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 32));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Best Deals Everyday!!");
		lblNewLabel_1.setBounds(443, 146, 340, 50);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Easy Finance");
		lblNewLabel_2.setBounds(443, 180, 222, 61);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fantastic Reviews");
		lblNewLabel_3.setBounds(443, 221, 222, 61);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage login = new LoginPage();
				login.NewScreen();
				frame.dispose();
			}
		});
		button.setIcon(new ImageIcon(Welcome.class.getResource("/images/login_button.png")));
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBorderPainted(false);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(615, 376, 130, 30);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage register = new RegisterPage();
				register.NewScreen();
				frame.dispose();
			}
		});
		button_1.setIcon(new ImageIcon(Welcome.class.getResource("/images/login_button.png")));
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBorderPainted(false);
		button_1.setBackground(new Color(65, 105, 225));
		button_1.setBounds(424, 376, 130, 30);
		frame.getContentPane().add(button_1);
		
		
	}
}
