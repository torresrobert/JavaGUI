import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class timeSheet extends JFrame {

	private JPanel contentPane;
	private JTextField empID;
	private JTextField hours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timeSheet frame = new timeSheet();
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
	public timeSheet() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTimeSheet = new JLabel("Time Sheet");
		lblTimeSheet.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblTimeSheet.setBounds(6, 18, 128, 30);
		contentPane.add(lblTimeSheet);

		JSeparator separator = new JSeparator();
		separator.setBounds(56, 88, 1, 12);
		contentPane.add(separator);

		empID = new JTextField();
		empID.setBounds(212, 88, 130, 26);
		contentPane.add(empID);
		empID.setColumns(10);

		JLabel lblName = new JLabel("Employee ID");
		lblName.setBounds(41, 93, 105, 12);
		contentPane.add(lblName);

		JLabel lblHoursWorked = new JLabel("Hours Worked");
		lblHoursWorked.setBounds(41, 126, 89, 12);
		contentPane.add(lblHoursWorked);

		hours = new JTextField();
		hours.setBounds(212, 119, 130, 26);
		contentPane.add(hours);
		hours.setColumns(10);

		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(343, 124, 61, 16);
		contentPane.add(lblHours);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					//String query = "INSERT INTO requirements(requirmentID,title, description, projectID) VALUES (int,'something', 'something', int)";
					//each question mark is the place where each setString function will be inserted
					String query = "update team_members set hours=hours+? where employee_id=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, hours.getText());
					pst.setString(2, empID.getText());
					

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
		btnSubmit.setBounds(213, 174, 117, 29);
		contentPane.add(btnSubmit);
	}
}
