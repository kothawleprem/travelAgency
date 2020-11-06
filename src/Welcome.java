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
		
		
		JLabel lblNewLabel = new JLabel("Travel Agency");
		lblNewLabel.setBounds(483, 99, 230, 50);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 32));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Best Deals Everyday!!");
		lblNewLabel_1.setBounds(443, 146, 340, 50);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Easy Finance");
		lblNewLabel_2.setBounds(443, 176, 222, 50);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fantastic Reviews");
		lblNewLabel_3.setBounds(443, 206, 222, 50);
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
		button.setIcon(new ImageIcon(Welcome.class.getResource("/images/loginbt.png")));
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBorderPainted(false);
		button.setBackground(new Color(65, 105, 225));
		button.setBounds(623, 358, 130, 30);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage register = new RegisterPage();
				register.NewScreen();
				frame.dispose();
			}
		});
		button_1.setIcon(new ImageIcon(Welcome.class.getResource("/images/register.png")));
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBorderPainted(false);
		button_1.setBackground(new Color(65, 105, 225));
		button_1.setBounds(420, 358, 130, 35);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Welcome.class.getResource("/images/terna.png")));
		lblNewLabel_5.setBounds(513, 11, 178, 81);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Welcome.class.getResource("/images/viewt35.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTours view = new ViewTours();
				view.NewScreen();
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(518, 314, 130, 35);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("24*7 Support");
		lblNewLabel_6.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(443, 236, 172, 50);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OurInfo ourinfo = new OurInfo();
				ourinfo.NewScreen();
				frame.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(Welcome.class.getResource("/images/ourinfo.png")));
		btnNewButton_1.setBounds(513, 400, 152, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}
