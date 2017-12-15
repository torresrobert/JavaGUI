import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import java.sql.*;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class requirements extends JFrame {

	private JPanel contentPane;
	private JTextField rqnumTB;
	private JTextField rqtitleTB;
	private JButton btnNonfunctional;
	private JLabel lblNumber;
	private JTextArea rqdescriptTB;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					requirements frame = new requirements();
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
	public requirements() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		JLabel lblEnter = new JLabel("Requirements");
		lblEnter.setBounds(10, 10, 159, 30);
		lblEnter.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		contentPane.add(lblEnter);
		
		JLabel lblRequirementTitle = new JLabel("Description");
		lblRequirementTitle.setBounds(30, 120, 110, 25);
		lblRequirementTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblRequirementTitle);
		
		rqnumTB = new JTextField();
		rqnumTB.setBounds(197, 60, 218, 26);
		rqnumTB.setColumns(10);
		contentPane.add(rqnumTB);
		
		JLabel lblDescription = new JLabel("Title");
		lblDescription.setBounds(30, 90, 43, 25);
		lblDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblDescription);
		
		rqtitleTB = new JTextField();
		rqtitleTB.setBounds(197, 90, 218, 26);
		rqtitleTB.setColumns(10);
		contentPane.add(rqtitleTB);
		
		lblNumber = new JLabel("Number");
		lblNumber.setBounds(30, 60, 78, 25);
		lblNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblNumber);
		
		rqdescriptTB = new JTextArea();
		rqdescriptTB.setBounds(207, 127, 206, 69);
		contentPane.add(rqdescriptTB);
		
		JScrollPane scrollBar = new JScrollPane(rqdescriptTB);
		scrollBar.setBounds(197, 128, 217, 68);
		contentPane.add(scrollBar);
		
		btnNonfunctional = new JButton("Non-Functional");
		JButton btnSubmit = new JButton("Submit Risk");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					//String query = "INSERT INTO requirements(requirmentID,title, description, projectID) VALUES (int,'something', 'something', int)";
					//each question mark is the place where each setString function will be inserted
					String query = "insert into non_functional_req (id,title,description) values (?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, rqnumTB.getText());
					pst.setString(2, rqtitleTB.getText());
					pst.setString(3, rqdescriptTB.getText());
					

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
		btnNonfunctional.setBounds(225, 235, 159, 29);
		contentPane.add(btnNonfunctional);
		
		JButton btnNewButton = new JButton("Functional");
		btnNewButton.setBounds(54, 234, 159, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					//String query = "INSERT INTO requirements(requirmentID,title, description, projectID) VALUES (int,'something', 'something', int)";
					//each question mark is the place where each setString function will be inserted
					String query = "insert into functional_req (id,title,description) values (?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, rqnumTB.getText());
					pst.setString(2, rqtitleTB.getText());
					pst.setString(3, rqdescriptTB.getText());
					

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
		
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		
	
	}
}
