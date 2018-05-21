package soft;



import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToMysql 
{
 public static Connection getConnection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ArunDB","root","system");
		   // System.out.print("jdjfgbfjd");  
		
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
