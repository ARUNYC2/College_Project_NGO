package soft;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.*;
import javax.swing.table.*;
class Dt extends JFrame
{ 
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	public Dt() 
	{ 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","rana");
			String sql = "Select * from distributions";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			Vector<String> columnNames = new Vector<String>();
			int columns = md.getColumnCount();
			for (int i = 1; i <= columns; i++) {
			columnNames.addElement( md.getColumnName(i) );
		}
//--------------------------------------------------
		Vector<Object> data = new Vector<Object>();
		while (rs.next())
		{
			Vector<Object> row = new Vector<Object>(columns);
			for (int i = 1; i <= columns; i++)
			{
				row.addElement( rs.getObject(i) );
			}
			data.addElement(row);
		}
		rs.close();
		pstmt.close();
		JTable table = new JTable(data,columnNames);
		JScrollPane scrollPane = new JScrollPane( table );
		table.setBackground(Color.YELLOW);
		table.setSelectionBackground(Color.red);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		
		setLayout(null);
		scrollPane.setBounds(100, 100, 400, 200);
		add( scrollPane );
		setSize(600,400);
		setVisible(true);
		}
		catch(Exception ex){ex.printStackTrace();}
	}
}
	public class DistributionTable extends showInTable
	{
		public static void main(String args[])
		{
			new Dt();
		}
	}
