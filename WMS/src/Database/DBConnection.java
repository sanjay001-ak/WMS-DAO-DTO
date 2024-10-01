package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection 
{

	public static Connection getConnection() throws ClassNotFoundException 
	{

		Connection con=null;

		

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
        	con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3307/wms","root","Sanjay@2004");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return con;
	}

}

