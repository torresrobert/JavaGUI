import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.sql.Connection;
import java.awt.event.InputMethodEvent;
import javax.swing.JPasswordField;

public class teamMembers extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField username;
	private JPasswordField passwordField;
	private JTextField email;
	private JTextField teamName;
	private JRadioButton managerYes;
	private JRadioButton manegerNo;
	private JRadioButton pOwnerYes;
	private JRadioButton pOwnerNo;
	

	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					teamMembers frame = new teamMembers();
					frame.setVisible(true);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField empIDtext;

	/**
	 * Create the frame.
	 */
	public teamMembers() {
		
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewUsers = new JLabel("Team Members");
		lblNewUsers.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewUsers.setBounds(10, 10, 204, 30);
		contentPane.add(lblNewUsers);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(29, 52, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(29, 80, 61, 16);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(29, 108, 61, 16);
		contentPane.add(lblEmail);
		
		JLabel lblManager = new JLabel("Is Manager?");
		lblManager.setBounds(29, 136, 120, 16);
		contentPane.add(lblManager);
		
		JLabel lblIsProjectManager = new JLabel("Is Product Owner?");
		lblIsProjectManager.setBounds(29, 164, 140, 16);
		contentPane.add(lblIsProjectManager);
		
		JLabel lblTeamName = new JLabel("Team Name");
		lblTeamName.setBounds(29, 192, 140, 16);
		contentPane.add(lblTeamName);
		
		username = new JTextField();
		username.setBounds(102, 47, 67, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(303, 75, 130, 26);
		contentPane.add(passwordField);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(303, 103, 130, 26);
		contentPane.add(email);
		
		JRadioButton managerYes = new JRadioButton("Yes");
		buttonGroup.add(managerYes);
		managerYes.setBounds(292, 132, 54, 23);
		contentPane.add(managerYes);
		
		JRadioButton managerNo = new JRadioButton("No");
		buttonGroup.add(managerNo);
		managerNo.setBounds(379, 132, 54, 23);
		contentPane.add(managerNo);
		
		JRadioButton pOwnerNo = new JRadioButton("No");
		buttonGroup_1.add(pOwnerNo);
		pOwnerNo.setBounds(379, 160, 54, 23);
		contentPane.add(pOwnerNo);
		
		JRadioButton pOwnerYes = new JRadioButton("Yes");
		buttonGroup_1.add(pOwnerYes);
		pOwnerYes.setBounds(292, 160, 54, 23);
		contentPane.add(pOwnerYes);
		
		teamName = new JTextField();
		teamName.setColumns(10);
		teamName.setBounds(303, 187, 130, 26);
		contentPane.add(teamName);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			try {
				
				managerYes.setActionCommand("Yes");
				managerNo.setActionCommand("No");
				pOwnerYes.setActionCommand("Yes");
				pOwnerNo.setActionCommand("No");
				String choice1 = buttonGroup.getSelection().getActionCommand();
				String choice2 = buttonGroup_1.getSelection().getActionCommand();
				
				//String query = "INSERT INTO requirements(requirmentID,title, description, projectID) VALUES (int,'something', 'something', int)";
				//each question mark is the place where each setString function will be inserted
				String query = "insert into team_members (username,password,email,manager,product_owner,team_name,employee_id) values (?,?,?,?,?,?,?)";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.setString(1, username.getText());
				pst.setString(2, passwordField.getText());
				pst.setString(3, email.getText());
				pst.setString(4, choice1);
				pst.setString(5, choice2);
				pst.setString(6, teamName.getText());
				pst.setString(7, empIDtext.getText());

				
				//executes the sql query 
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
		btnSubmit.setBounds(160, 243, 117, 29);
		contentPane.add(btnSubmit);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(204, 52, 96, 16);
		contentPane.add(lblEmployeeId);
		
		empIDtext = new JTextField();
		empIDtext.setColumns(10);
		empIDtext.setBounds(303, 47, 130, 26);
		contentPane.add(empIDtext);
	}
}
