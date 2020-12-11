//Prem Kothawle S.E IT A-04

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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
		frame.setResizable(false);
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
		
		
		JLabel lblheading = new JLabel("Travel Agency");
		lblheading.setBounds(486, 58, 230, 50);
		lblheading.setForeground(Color.YELLOW);
		lblheading.setFont(new Font("Georgia", Font.BOLD, 32));
		frame.getContentPane().add(lblheading);
		
		JLabel lblInfo1 = new JLabel("Best Deals Everyday!!");
		lblInfo1.setBounds(443, 146, 340, 50);
		lblInfo1.setForeground(Color.WHITE);
		lblInfo1.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		frame.getContentPane().add(lblInfo1);
		
		JLabel lblInfo2 = new JLabel("Easy Finance");
		lblInfo2.setBounds(443, 176, 222, 50);
		lblInfo2.setForeground(Color.WHITE);
		lblInfo2.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		frame.getContentPane().add(lblInfo2);
		
		JLabel lblInfo3 = new JLabel("Fantastic Reviews");
		lblInfo3.setBounds(443, 206, 222, 50);
		lblInfo3.setForeground(Color.WHITE);
		lblInfo3.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		frame.getContentPane().add(lblInfo3);
		
		JLabel lblInfo4 = new JLabel("24*7 Support");
		lblInfo4.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		lblInfo4.setForeground(new Color(255, 255, 255));
		lblInfo4.setBounds(443, 236, 172, 50);
		frame.getContentPane().add(lblInfo4);
		
		JButton btnlogin = new JButton("");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage login = new LoginPage();
				login.NewScreen();
				frame.dispose();
			}
		});
		btnlogin.setIcon(new ImageIcon(Welcome.class.getResource("/images/loginbt.png")));
		btnlogin.setForeground(Color.BLACK);
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnlogin.setBorderPainted(false);
		btnlogin.setBackground(new Color(65, 105, 225));
		btnlogin.setBounds(623, 358, 130, 30);
		frame.getContentPane().add(btnlogin);
		
		JButton btnregister = new JButton("");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage register = new RegisterPage();
				register.NewScreen();
				frame.dispose();
			}
		});
		btnregister.setIcon(new ImageIcon(Welcome.class.getResource("/images/register.png")));
		btnregister.setForeground(Color.BLACK);
		btnregister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnregister.setBorderPainted(false);
		btnregister.setBackground(new Color(65, 105, 225));
		btnregister.setBounds(420, 358, 130, 35);
		frame.getContentPane().add(btnregister);
		
        final String username  = "";
		JButton btnView = new JButton("");
		btnView.setIcon(new ImageIcon(Welcome.class.getResource("/images/viewt35.png")));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTours view = new ViewTours(username);
				view.NewScreen(username);
				frame.dispose();
			}
		});
		btnView.setBackground(new Color(65, 105, 225));
		btnView.setBorderPainted(false);
		btnView.setBounds(518, 314, 130, 35);
		frame.getContentPane().add(btnView);
		
		
		
		JButton btnInfo = new JButton("");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OurInfo ourinfo = new OurInfo();
				ourinfo.NewScreen();
				frame.dispose();
			}
		});
		btnInfo.setBackground(new Color(65, 105, 225));
		btnInfo.setBorderPainted(false);
		btnInfo.setIcon(new ImageIcon(Welcome.class.getResource("/images/ourinfo.png")));
		btnInfo.setBounds(513, 400, 152, 35);
		frame.getContentPane().add(btnInfo);
		
		
	}
}
