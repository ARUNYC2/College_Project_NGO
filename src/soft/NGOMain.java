package soft;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

import soft.ConnectToMysql;



class Nm extends JFrame
{
	Connection con;
	PreparedStatement pst;
	public Nm() throws Exception
	{
		con=ConnectToMysql.getConnection();
		pst=con.prepareStatement("select * from admin");
		ResultSet rs=pst.executeQuery();
		if(rs.next()==true)
			new Ali();
		else
			new Asu();
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
}

public class NGOMain
{	
	public static void main(String[] args) 
	{
		try {
			new Nm();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
