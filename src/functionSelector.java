import java.awt.BorderLayout;
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
import java.sql.Connection;
import java.awt.event.InputMethodEvent;
import javax.swing.JPasswordField;

public class functionSelector extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					functionSelector frame = new functionSelector();
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
	
	 *
	 *
	 */
	
	
	
	
	
	public functionSelector() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblChooseAFunction = new JLabel("Welcome ");
		lblChooseAFunction.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		contentPane.add(lblChooseAFunction, BorderLayout.NORTH);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Requirements (Functional or Non-Functional)", "Team Members", "Risks", "Time Sheet"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("");
		contentPane.add(list, BorderLayout.EAST);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			try {

				if(list.getSelectedIndex()!=-1) {
					if(((list.getSelectedValue()).toString().equalsIgnoreCase("Requirements (Functional or Non-Functional)"))){
 					requirements req = new requirements();
 					req.setVisible(true);
 					}
					else if(list.getSelectedIndex()!=-1) {
						if(((list.getSelectedValue()).toString().equalsIgnoreCase("Team Members"))){
	 					teamMembers teamMem = new teamMembers();
	 					teamMem.setVisible(true);
	 					}
						else if(list.getSelectedIndex()!=-1) {
							if(((list.getSelectedValue()).toString().equalsIgnoreCase("Risks"))){
		 					risks risks = new risks();
		 					risks.setVisible(true);
		 					}
							else if(list.getSelectedIndex()!=-1) {
								if(((list.getSelectedValue()).toString().equalsIgnoreCase("Time Sheet"))){
			 					timeSheet tsheet = new timeSheet();
			 					tsheet.setVisible(true);
			 					}
				}}}}

 				
 				
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, e);			
			}

		}	
			});

		
		contentPane.add(btnSubmit, BorderLayout.SOUTH);
		
		JLabel lblChooseAFunction_1 = new JLabel("Choose a function");
		lblChooseAFunction_1.setVerticalAlignment(SwingConstants.TOP);
		lblChooseAFunction_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblChooseAFunction_1, BorderLayout.WEST);
	}

}
