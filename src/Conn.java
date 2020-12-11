import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	public Conn() {
		
		
		try {
			//STEP 1: Register JDBC driver
			 Class.forName("org.postgresql.Driver");
			 c= DriverManager.getConnection("jdbc:postgresql://localhost:5433/traveldb", "postgres", "premsk29");
			 s = c.createStatement();
			 
		}catch(Exception e) {
	}
		
	}
}
