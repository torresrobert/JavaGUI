import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class sqliteConnection {
	Connection conn = null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:resource/spm.db");
			JOptionPane.showMessageDialog(null,"Connection is established.");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
	}
}
