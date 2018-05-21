package soft;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


class Dsearch extends JFrame
{
	Connection con;
	PreparedStatement pst;
	ImageIcon fetch,iresult,iall,iconsole;
	JLabel did,name,amount,datef,datet,console;
	JButton all,result,fdid,fname,famount,fdate;
	JComboBox cdid;
	JTextField tname,tamount,tdatef,tdatet;
	JPanel pdid,pname,pamount,pdate,presult,pnl,lpnl;
	JScrollPane scrollPane=new JScrollPane();
	
	Dsearch()
	{
		con=ConnectToMysql.getConnection();
		pdid=new JPanel();
		pname=new JPanel();
		pamount=new JPanel();
		pdate=new JPanel();
		presult=new JPanel();
		pnl=new JPanel();
		lpnl=new JPanel();
		
		lpnl.setBounds(30, 10, 400, 60);
		pnl.setBounds(0, 0, 560, 660);
		pdid.setBounds(30, 90, 400, 70);
		pname.setBounds(30, 170, 400, 70);
		pamount.setBounds(30, 250, 400, 70);
		pdate.setBounds(30, 330, 400, 70);
		presult.setBounds(30, 450, 400, 150);
		pnl.setBackground(Color.darkGray);
		
		pnl.setBorder(BorderFactory.createBevelBorder(1));
		pdid.setBorder(BorderFactory.createBevelBorder(1));
		pname.setBorder(BorderFactory.createBevelBorder(1));
		pamount.setBorder(BorderFactory.createBevelBorder(1));
		pdate.setBorder(BorderFactory.createBevelBorder(1));
		presult.setBorder(BorderFactory.createBevelBorder(1));
		
		add(pnl);
		pnl.add(pdid);
		pnl.add(pname);
		pnl.add(pamount);
		pnl.add(pdate);
		pnl.add(presult);
		
		iconsole=new ImageIcon("donationsearchconsole.png");
		iall=new ImageIcon("show_all.png");
		fetch=new ImageIcon("fetch.png");
		iresult=new ImageIcon("result.png");
		
		console=new JLabel(iconsole);
		did=new JLabel("Doner ID");
		name=new JLabel("Name");
		amount=new JLabel("Amount >=");
		datef=new JLabel("Date   From");
		datet=new JLabel("To");
	
		all=new JButton(iall);
		result=new JButton(iresult);
		fdid=new JButton(fetch);
		fname=new JButton(fetch);
		famount=new JButton(fetch);
		fdate=new JButton(fetch);
		
		cdid=new JComboBox();
		
		tname=new JTextField();
		tamount=new JTextField();
		tdatef=new JTextField();
		tdatet=new JTextField();
	
//----------------------->>>>>>>>>>>	
		did.setBounds(20, 10, 70, 40);
		cdid.setBounds(100, 15, 200, 30);
		fdid.setBounds(300, 20, 100, 42);
		fdid.setBorder(BorderFactory.createEmptyBorder());
		fdid.setContentAreaFilled(false);
		pdid.add(did);
		pdid.add(cdid);
		pdid.add(fdid);
		
//----------------------->>>>>>>>>>>
		
		name.setBounds(20, 10, 70, 40);
		tname.setBounds(100, 15, 200, 30);
		fname.setBounds(300, 20, 100, 42);
		fname.setBorder(BorderFactory.createEmptyBorder());
		fname.setContentAreaFilled(false);
		pname.add(name);
		pname.add(tname);
		pname.add(fname);
		
//----------------------->>>>>>>>>>>
		
		amount.setBounds(20, 10, 70, 40);
		tamount.setBounds(100, 15, 200, 30);
		famount.setBounds(300, 20, 100, 42);
		famount.setBorder(BorderFactory.createEmptyBorder());
		famount.setContentAreaFilled(false);
		pamount.add(amount);
		pamount.add(tamount);
		pamount.add(famount);
		
//----------------------->>>>>>>>>>>
		
		datef.setBounds(10, 10, 70, 40);
		tdatef.setBounds(90, 20, 70, 20);
		datet.setBounds(170, 10, 30, 40);
		tdatet.setBounds(210, 20, 70, 20);
		fdate.setBounds(300, 20, 100, 42);
		fdate.setBorder(BorderFactory.createEmptyBorder());
		fdate.setContentAreaFilled(false);
		pdate.add(datef);
		pdate.add(datet);
		pdate.add(tdatet);
		pdate.add(tdatef);
		pdate.add(fdate);
		
//----------------------->>>>>>>>>>>
		
		result.setBounds(320,380, 100,100);
		result.setBorder(BorderFactory.createEmptyBorder());
		result.setContentAreaFilled(false);
		pnl.add(result);
		
		all.setBounds(40,380, 130,100);
		all.setBorder(BorderFactory.createEmptyBorder());
		all.setContentAreaFilled(false);
		pnl.add(all);	
		
		console.setBounds(30, 0, 400, 100);
		console.setBorder(BorderFactory.createEmptyBorder());
		//console.setContentAreaFilled(false);
		pnl.add(console);
		
	
		
		pnl.setVisible(true);
		pnl.setLayout(null);
		pdid.setVisible(true);
		pdid.setLayout(null);
		pname.setVisible(true);
		pname.setLayout(null);
		pamount.setVisible(true);
		pamount.setLayout(null);
		pdate.setVisible(true);
		pdate.setLayout(null);
		presult.setVisible(true);
		presult.setLayout(null);
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		setSize(470, 660);
		try {
			filldid();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		fdid.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				fillfetchdidd();
			}
		});
		fname.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				fillfetchname();
			}
		});
		
		famount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				fillfetchamount();
			}
		});
		
		fdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				fillfetchdate();
			}
		});
		
	}
	
	
	void fillfetchdate()
	{
		ResultSet rs;
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","rana");
			   //String sql = "Select * from school where snmae=?";
			    pst = con.prepareStatement("Select * from donations where date between ? and ?");
			    
			    pst.setString(1,String.valueOf(tdatef.getText()));
			    pst.setString(2,String.valueOf(tdatet.getText()));
			   // JOptionPane.showMessageDialog(null, String.valueOf(cschool.getSelectedItem()));
			    rs = pst.executeQuery();
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
			   pst.close();
			   JTable table = new JTable(data,columnNames);
			   scrollPane.setVisible(false);
			   scrollPane = new JScrollPane( table );
			   scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			   
			   table.setBackground(Color.YELLOW);
			   table.setSelectionBackground(Color.red);
			   
			   //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			 table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			 scrollPane.setBounds(0, 5, 400, 200);
			 //  add( scrollPane );
			   presult.add(scrollPane);
			   //rpnl.add(table);
			   
	   }
	  catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
	}
	
	void fillfetchamount()
	{
		ResultSet rs;
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","rana");
			   //String sql = "Select * from school where snmae=?";
			    pst = con.prepareStatement("Select * from donations where amount>=?");
			    String s=String.valueOf(tamount.getText());
			    pst.setString(1,s);
			   // JOptionPane.showMessageDialog(null, String.valueOf(cschool.getSelectedItem()));
			    rs = pst.executeQuery();
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
			   pst.close();
			   JTable table = new JTable(data,columnNames);
			   scrollPane.setVisible(false);
			   scrollPane = new JScrollPane( table );
			   scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			   table.setBackground(Color.YELLOW);
			   table.setSelectionBackground(Color.red);
			   
			   //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			 table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			 scrollPane.setBounds(0, 5, 400, 200);
			   add( scrollPane );
			   presult.add(scrollPane);
			   //rpnl.add(table);
			   
	   }
	  catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
	}
	
	void fillfetchname()
	{
		ResultSet rs;
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","rana");
			   //String sql = "Select * from school where snmae=?";
			    pst = con.prepareStatement("Select * from donations where name like ?");
			    String s=String.valueOf(tname.getText());
			    s+="%";
			    pst.setString(1,s);
			   // JOptionPane.showMessageDialog(null, String.valueOf(cschool.getSelectedItem()));
			    rs = pst.executeQuery();
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
			   pst.close();
			   JTable table = new JTable(data,columnNames);
			   scrollPane.setVisible(false);
			   scrollPane = new JScrollPane( table );
			   scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			   table.setBackground(Color.YELLOW);
			   table.setSelectionBackground(Color.red);
			   
			   //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			 table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			 scrollPane.setBounds(0, 5, 400, 200);
			   //add( scrollPane );
			   presult.add(scrollPane);
			   //rpnl.add(table);
			   
	   }
	  catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
	}
	
	void fillfetchdidd()
	{
		ResultSet rs;
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","rana");
			   //String sql = "Select * from school where snmae=?";
			    pst = con.prepareStatement("Select * from donations where did=?");
			    pst.setString(1,String.valueOf(cdid.getSelectedItem()));
			   // JOptionPane.showMessageDialog(null, String.valueOf(cschool.getSelectedItem()));
			    rs = pst.executeQuery();
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
			   pst.close();
			   JTable table = new JTable(data,columnNames);
			   scrollPane.setVisible(false);
			   scrollPane = new JScrollPane( table );
			   scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			   scrollPane.setBounds(0, 5, 400, 140);
			   table.setBackground(Color.YELLOW);
			   table.setSelectionBackground(Color.red);
			   
			   //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			 table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			 
			   //add( scrollPane );
			   presult.add(scrollPane);
			   //rpnl.add(table);
			   
	   }
	  catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
	}
	
	void fillfetchdid()
	{
		ResultSet rs;
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","rana");
			   //String sql = "Select * from school where snmae=?";
			    pst = con.prepareStatement("Select * from donations where did=?");
			    pst.setString(1,String.valueOf(cdid.getSelectedItem()));
			   // JOptionPane.showMessageDialog(null, String.valueOf(cschool.getSelectedItem()));
			    rs = pst.executeQuery();
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
			   pst.close();
			   JTable table = new JTable(data,columnNames);
			   scrollPane.setVisible(false);
			   scrollPane = new JScrollPane( table );
			   scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			   scrollPane.setBounds(0, 5, 400, 140);
			   table.setBackground(Color.YELLOW);
			   table.setSelectionBackground(Color.red);
			   
			   //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			 table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			 
			   //add( scrollPane );
			   presult.add(scrollPane);
			   //rpnl.add(table);
			   
	   }
	  catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
	}
	
	void filldid() throws Exception
	{
		cdid.removeAll();
		cdid.addItem("Select");
		
		pst=con.prepareStatement("select distinct did from donations");
		ResultSet rs=pst.executeQuery();
		while(rs.next()==true)
		{
			String s=rs.getString("did");
			cdid.addItem(s+"");
		}
	}
}
public class DonationSearch 
{

	public static void main(String[] args) 
	{
		new Dsearch();
	}

}
