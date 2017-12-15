import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JPasswordField;

public class risks extends JFrame {

	private JPanel contentPane;
	private JTextField rtitleTB;
	private JTextField rstatusTB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					risks frame = new risks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public risks() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRisks = new JLabel("Risks");
		lblRisks.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblRisks.setBounds(10, 10, 159, 30);
		contentPane.add(lblRisks);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitle.setBounds(30, 60, 159, 30);
		contentPane.add(lblTitle);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblDescription.setBounds(30, 92, 159, 30);
		contentPane.add(lblDescription);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStatus.setBounds(30, 179, 159, 30);
		contentPane.add(lblStatus);
		
		rtitleTB = new JTextField();
		rtitleTB.setBounds(180, 60, 235, 26);
		contentPane.add(rtitleTB);
		rtitleTB.setColumns(10);
		
		rstatusTB = new JTextField();
		rstatusTB.setColumns(10);
		rstatusTB.setBounds(285, 184, 130, 26);
		contentPane.add(rstatusTB);

		JTextArea rdescriptTB = new JTextArea();
		rdescriptTB.setLineWrap(true);
		rdescriptTB.setBounds(180, 102, 235, 70);
		contentPane.add(rdescriptTB);
		
		JButton btnSubmit = new JButton("Submit Risk");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					//String query = "INSERT INTO requirements(requirmentID,title, description, projectID) VALUES (int,'something', 'something', int)";
					//each question mark is the place where each setString function will be inserted
					String query = "insert into risks (title,description,status) values (?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, rtitleTB.getText());
					pst.setString(2, rdescriptTB.getText());
					pst.setString(3, rstatusTB.getText());
					

					pst.execute();
	 				
	 				dispose();
					functionSelector funcSelect = new functionSelector();
					funcSelect.setVisible(true);
	 			
					
	 				pst.close();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e);	
					
				}
				
				}	
				});
		btnSubmit.setBounds(298, 228, 117, 29);
		contentPane.add(btnSubmit);
		
		
	}
}
