import java.sql.*;
import javax.swing.*;


public class sqliteConnection {
	Connection conn = null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/roberttorres/eclipse-workspace/JavaGui/src/sqlite2.sqlite");
			JOptionPane.showMessageDialog(null,"Connection is established.");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
	}
}
