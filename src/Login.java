import java.awt.EventQueue;

import javax.swing.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.sql.Connection;
import java.awt.event.InputMethodEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField textField;
	String newstr = new String();
	private JPasswordField inpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(186, 21, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPleaseSignIn = new JLabel("Please Sign In");
		lblPleaseSignIn.setBounds(168, 49, 92, 16);
		frame.getContentPane().add(lblPleaseSignIn);
		
		textField = new JTextField();
		textField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}

			@Override
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		textField.setBounds(150, 134, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(150, 172, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		inpass = new JPasswordField();
		inpass.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}

			@Override
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		inpass.setBounds(150, 200, 130, 20);
		frame.getContentPane().add(inpass);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(150, 107, 71, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			try {
				String query = "select * from team_members where username=? and password=?";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.setString(1, textField.getText());
				pst.setString(2, inpass.getText());


 				ResultSet rs=pst.executeQuery();
 				int count=0;
 				while(rs.next()) {
 					count++;
 				}
 				
 				if(count==1) {
 					JOptionPane.showMessageDialog(null, "Welcome "+textField.getText());	
 					frame.dispose();
 					functionSelector funcSelect = new functionSelector();
 					funcSelect.setVisible(true);
 				}
 				else if(count>1) {
 					JOptionPane.showMessageDialog(null, "Duplicate username and password");
 				}
 				else {
 					JOptionPane.showMessageDialog(null, "Username and password are not correct");
 				}
 				rs.close();
 				pst.close();
 				
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, e);			
			}

		}	
			});
		btnSignIn.setBounds(168, 232, 117, 29);
		frame.getContentPane().add(btnSignIn);
		
		
	}
}
