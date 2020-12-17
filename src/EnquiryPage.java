import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class EnquiryPage {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldContact;

	/**
	 * Launch the application.
	 */
	public void  NewScreen() { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnquiryPage window = new EnquiryPage();
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
	public EnquiryPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 0));
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Enquire");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 32));
		lblNewLabel.setBounds(140, 29, 147, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(33, 89, 84, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Contact");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(33, 134, 84, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Message");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(33, 190, 116, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(127, 95, 198, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		//ename = textFieldName.getText();
		
		textFieldContact = new JTextField();
		textFieldContact.setColumns(10);
		textFieldContact.setBounds(127, 138, 198, 20);
		frame.getContentPane().add(textFieldContact);
	//	econtact = textFieldContact.getText();
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(127, 190, 198, 195);
		frame.getContentPane().add(editorPane);

		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(423, 29, 371, 401);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setIcon(new ImageIcon(EnquiryPage.class.getResource("/images/enqpage.png")));
		lblNewLabel_4.setBounds(0, 0, 371, 401);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				String ename=textFieldName.getText();
				String emessage=editorPane.getText();
				String econtact=textFieldContact.getText();
				int flag = 0;
		    	if(ename.length()==0) {
					JOptionPane.showMessageDialog(null, "Enter Valid Name");
					flag++;
				}
				if(econtact.length()==0) {
					JOptionPane.showMessageDialog(null, "Enter Valid Contact Number.");
					flag++;

				}
				if(emessage.length()==0) {
					JOptionPane.showMessageDialog(null, "Enter Valid Message.");
                    flag++;
				} 
				try {
					
				    if(flag==0) {
				    	String query = "insert into enquire(enquiry_customer_name,enquiry_contact,enquiry_messsage) values('"+ename+"','"+econtact+"','"+emessage+"')";
						Class.forName("org.postgresql.Driver");
						Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/TravelAgency", "postgres", "prem");
						Statement stmt = con.createStatement();
					    stmt.executeUpdate(query);
				    	JOptionPane.showMessageDialog(null, "Enquiry Message Sent Successfully");
					    Welcome wel= new Welcome();
						wel.main(null);
						frame.dispose();
						 con.close();
				    }
				    else
				    	flag=0;
				   
				}catch(Exception exp) {
					System.out.println(exp);
				}
			
			}
		});
		btnNewButton.setIcon(new ImageIcon(EnquiryPage.class.getResource("/images/submitbtn.png")));
		btnNewButton.setBorderPainted(false);

		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setBounds(147, 396, 163, 36);
		frame.getContentPane().add(btnNewButton);
		
		
		
		frame.setBounds(100, 100, 820, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
