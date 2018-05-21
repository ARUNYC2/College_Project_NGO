package soft;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class Ssearch extends JFrame
{
	JScrollPane scrollPane=new JScrollPane();
	int a,b;
	Connection con;
	PreparedStatement pst;
	ImageIcon iresult,iconsole,ifetch,iall;
	JPanel pnl,lpnl,rpnl,spnl,apnl,rspnl;
	JLabel school,amount,result,console;
	JButton sfetch,afetch,all;
	JTextField tamount;
	JComboBox cschool;

	Ssearch()
	{
		con=ConnectToMysql.getConnection();
		iresult=new ImageIcon("result_label.png");
		iconsole=new ImageIcon("schoolsearchconsole.png");
		ifetch=new ImageIcon("fetch.png");
		iall=new ImageIcon("show_all.png");
		
		rspnl=new JPanel();
		pnl=new JPanel();
		lpnl=new JPanel();
		rpnl=new JPanel();
		spnl=new JPanel();
		apnl=new JPanel();
	
		pnl.setBackground(Color.DARK_GRAY);
		
		pnl.setBorder(BorderFactory.createBevelBorder(1));
		lpnl.setBorder(BorderFactory.createBevelBorder(1));
		spnl.setBorder(BorderFactory.createBevelBorder(1));
		apnl.setBorder(BorderFactory.createBevelBorder(1));
		rpnl.setBorder(BorderFactory.createBevelBorder(1));
		rspnl.setBorder(BorderFactory.createBevelBorder(1));
		
		pnl.setBounds(0, 0, 700, 600);
		lpnl.setBounds(20, 80, 200, 500);
		rpnl.setBounds(245, 80, 400, 500);
		spnl.setBounds(10, 10, 180, 120);
		apnl.setBounds(10, 150, 180, 120);
		rspnl.setBounds(0, 0, 400, 70);
		
		add(pnl);
		pnl.add(lpnl);
		pnl.add(rpnl);
		lpnl.add(apnl);
		lpnl.add(spnl);
		rpnl.add(rspnl);
		
		school=new JLabel("Schools");
		amount=new JLabel("Amount >=");
		result=new JLabel(iresult);
		console=new JLabel(iconsole);
		
		sfetch=new JButton(ifetch);
		afetch=new JButton(ifetch);
		all=new JButton(iall);
		
		
		tamount=new JTextField();
		cschool=new JComboBox();
		
		console.setBounds(30, 0, 400, 60);
		pnl.add(console);
		
//---------------------->>>>>>>>>>>>>>>>>>>>>>>>>>		
		school.setBounds(70, 5, 100, 30);
		cschool.setBounds(10, 30, 150, 20);
		sfetch.setBounds(40, 65, 100, 45);
		sfetch.setBorder(BorderFactory.createEmptyBorder());
		sfetch.setContentAreaFilled(false);
		spnl.add(school);
		spnl.add(sfetch);
		spnl.add(cschool);

//---------------------->>>>>>>>>>>>>>>>>>>>>>>>>>		
		amount.setBounds(70, 5, 100, 30);
		tamount.setBounds(10, 30, 150, 20);
		afetch.setBounds(40, 65, 100, 45);
		afetch.setBorder(BorderFactory.createEmptyBorder());
		afetch.setContentAreaFilled(false);
		apnl.add(amount);
		apnl.add(afetch);
		apnl.add(tamount);
		
//------------------->>>>>>>>>>>>>>>
		
		result.setBounds(10, 10, 180, 50);
		rspnl.add(result);
		
		all.setBounds(30, 300, 150, 60);
		lpnl.add(all);
		all.setBorder(BorderFactory.createEmptyBorder());
		all.setContentAreaFilled(false);
		
		
		pnl.setVisible(true);
		pnl.setLayout(null);
		spnl.setVisible(true);
		spnl.setLayout(null);
		apnl.setVisible(true);
		apnl.setLayout(null);
		lpnl.setVisible(true);
		lpnl.setLayout(null);
		rpnl.setVisible(true);
		rpnl.setLayout(null);
		
		try {
			fetchschool();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		setSize(670, 630);
		
		sfetch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				fillresultschool();
			}
		});
		
		afetch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				fillresultamount();
			}
		});
		
		all.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				fillresult();
			}
		});
		repaint();
		
		
	}
	
	void fillresult()
	{
		ResultSet rs;
		   try {
			  // if(b==1)
				//   rpnl.remove(scrollPane2);
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","rana");
			   //String sql = "Select * from school where snmae=?";
			    pst = con.prepareStatement("Select * from distributions");
			   
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
			   table.setBackground(Color.YELLOW);
			   table.setSelectionBackground(Color.red);
			   
			   //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			 table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			 scrollPane.setBounds(0, 100, 600, 600);
			   //add( scrollPane );
			   rpnl.add(scrollPane);
			   //rpnl.add(table);
			   repaint();
			   
	   }
	  catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
		   a=1;
		  
		  
	}
	
	void fillresultschool()
	   {
		ResultSet rs;
		try {
			//if(a==1)
				//rpnl.remove(scrollPane2);
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","rana");
			//String sql = "Select * from distributions where snmae=?";
			pst = con.prepareStatement("Select * from distributions where sname=?");
			pst.setString(1, String.valueOf(cschool.getSelectedItem()));
			rs = pst.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			Vector<String> columnNames = new Vector<String>();
			int columns = md.getColumnCount();
			
			/*for (int i = 1; i <= columns; i++) {
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
			}*/
			
			columnNames.addElement("Columns");
			columnNames.addElement("Data");
			
			Vector<Object> data = new Vector<Object>();
			
			if(rs.next()){
				for (int i = 1; i <= columns; i++)
				{
					Vector<Object> row = new Vector<Object>(columns);
					//System.out.println(md.getColumnName(i)+"\t"+rs.getObject(i));
					row.addElement(md.getColumnName(i));
					row.addElement(rs.getObject(i));
					data.addElement(row);
				}
			}
			
			rs.close();
			pst.close();
			JTable table = new JTable(data,columnNames);
			scrollPane.setVisible(false);
			 scrollPane = new JScrollPane( table );
			table.setBackground(Color.YELLOW);
			table.setSelectionBackground(Color.red);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar

			//setLayout(null);
			scrollPane.setBounds(10, 100, 600, 600);
			//add( scrollPane );
			//setSize(600,400);
			//setVisible(true);
			rpnl.add(scrollPane);
		}
		catch(Exception ex){ex.printStackTrace();}
		b=1;
	}
	
	
	void fillresultamount()
	   {
		ResultSet rs;
		   try {
			   //if(b==1)
				 //  rpnl.remove(scrollPane2);
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","rana");
			   //String sql = "Select * from school where snmae=?";
			    pst = con.prepareStatement("Select * from distributions where amount>=?");
			    pst.setString(1,tamount.getText());
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
			   table.setBackground(Color.YELLOW);
			   table.setSelectionBackground(Color.red);
			   
			   //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			 table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			 scrollPane.setBounds(0, 100, 600, 600);
			   //add( scrollPane );
			   rpnl.add(scrollPane);
			   //rpnl.add(table);
			   repaint();
			  
	   }
	  catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
		   a=1;
	   }
	
	
	void fetchschool() throws Exception
	{
		cschool.removeAll();
		cschool.addItem("Select");
		
		pst=con.prepareStatement("select distinct sname from distributions");
		ResultSet rs=pst.executeQuery();
		while(rs.next()==true)
		{
			String s=rs.getString("sname");
			cschool.addItem(s+"");
		}
		
	}
}


public class SchoolSearch 
{
	public static void main(String[] args) 
	{
		new Ssearch();
	}

}
