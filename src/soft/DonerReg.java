package soft;

import soft.ConnectToMysql;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import org.w3c.dom.CDATASection;

class Dr extends JFrame
{
	Connection con;
	PreparedStatement pst;
	JScrollPane pn;
	JPanel tpnl,bpnl;
	JLabel type,name,address,city,mobile,email,tmobileerr,temailerr;
	JTextField tname,tcity,tmobile,temail;
	JTextArea taddress;
	JComboBox ttype;
	JButton newb,save,search,update,cancel,close;
	Dr()
	{
		con=ConnectToMysql.getConnection();
		tpnl=new JPanel();
		bpnl=new JPanel();
		
		type=new JLabel("Type");
		name=new JLabel("Name");
		address=new JLabel("Address");
		city=new JLabel("City");
		mobile=new JLabel("Mobile");
		email=new JLabel("E-Mail");
		tmobileerr=new JLabel();
		temailerr=new JLabel();
		
		String[] s={"Select","Individual","Firm","Society","Bank","Trust","Others"};
		ttype=new JComboBox(s);
		tname=new JTextField();
		//tname.setForeground(Color.red);
		tcity=new JTextField();
		tmobile=new JTextField();
		temail=new JTextField();
		taddress=new JTextArea();
		
		pn=new JScrollPane(taddress);
		pn.setBounds(100, 85, 200, 60);
		tpnl.add(pn);
		
		newb=new JButton();
		save=new JButton();
		search=new JButton();
		update=new JButton();
		cancel=new JButton();
		close=new JButton();
		
		
		tpnl.setLayout(null);
		tpnl.setBorder(BorderFactory.createLineBorder(Color.black));
		bpnl.setLayout(null);
		bpnl.setBorder(BorderFactory.createLineBorder(Color.black));
		tpnl.setBounds(10,50,405,290);
		bpnl.setBounds(10, 360, 405, 100);
		add(tpnl);
		add(bpnl);
		
		type.setBounds(15, 5, 50, 20);
		name.setBounds(15, 45, 50, 30);
		address.setBounds(15, 85, 50, 60);
		city.setBounds(15, 155, 50, 30);
		mobile.setBounds(15, 195, 50, 30);
		email.setBounds(15, 235, 50, 30);
		
		ttype.setBounds(100, 5, 200, 20);
		tname.setBounds(100, 45, 200, 30);
		taddress.setBounds(100, 85, 200, 60);
		tcity.setBounds(100, 155, 200, 30);
		tmobile.setBounds(100, 195, 200, 30);
		tmobileerr.setBounds(315, 195, 200, 30);
		temail.setBounds(100, 235, 200, 30);
		temailerr.setBounds(315, 235, 200, 30);
		
		
		
		tpnl.add(tmobileerr);
		tpnl.add(temailerr);
		tpnl.add(type);
		tpnl.add(name);
		tpnl.add(address);
		tpnl.add(city);
		tpnl.add(mobile);
		tpnl.add(email);
		
		tpnl.add(ttype);
		tpnl.add(tname);
		//tpnl.add(taddress);
		tpnl.add(tcity);
		tpnl.add(tmobile);
		tpnl.add(temail);
		
		
		
		
		//--------------?>>>>>>>
		
		newb=new JButton("New");
		save=new JButton("Save");
		search=new JButton("Search");
		update=new JButton("Update");
		cancel=new JButton("Cancel");
		close=new JButton("Close");
		
		newb.setBounds(25, 10, 90, 30);
		save.setBounds(152, 10, 90, 30);
		search.setBounds(280, 10, 90, 30);
		update.setBounds(25, 50, 90, 30);
		cancel.setBounds(152, 50, 90, 30);
		close.setBounds(280, 50, 90, 30);
		
		bpnl.add(newb);
		bpnl.add(save);
		bpnl.add(search);
		bpnl.add(update);
		bpnl.add(cancel);
		bpnl.add(close);
		
	
		
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		
		setLayout(null);
		setVisible(true);
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(440,500);
		
		tmobile.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
				
				String mobile="^[789]\\d{9}$";
				boolean b=tmobile.getText().matches(mobile);
				if(b)
					{
					tmobileerr.setText("");
					}
				else
					tmobileerr.setText("InvalidNO.");
			}
			public void focusGained(FocusEvent arg0) {
				/*String mobile="^[789]\\d{9}$";
				boolean b=tmobile.getText().matches(mobile);
				if(b)
					{
					tmobileerr.setText("");
					}
				else
					tmobileerr.setText("InvalidNO.");*/

			}
		});
		
		temail.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
			String EMAIL= 
						"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
								+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			boolean a=temail.getText().matches(EMAIL);
			if(a)
			{
				temailerr.setText("");
			}
			else
				temailerr.setText("Invalid Email");
			}
			public void focusGained(FocusEvent arg0) {
				
					}
		});
		
		
		newb.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ttype.setSelectedIndex(0);
				tname.setText("");
				taddress.setText("");
				tcity.setText("");
				tmobile.setText("");
				temail.setText("");
				
			}
		});
		
		save.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					save();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
			}
		});
		
		search.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					search();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		update.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					update();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		cancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					delete();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		close.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(1);
			}
		});
		
	}
	
	void delete() throws Exception
	{
		String d=JOptionPane.showInputDialog("Enter DID");
		pst=con.prepareStatement("delete from doners where did=?");
		pst.setString(1, d);
		int x=pst.executeUpdate();
		if(x==1)
			JOptionPane.showMessageDialog(null, "Deleted");
		else
			JOptionPane.showMessageDialog(null, "Invlaid DID");
		pst.close();
		
	}
	
	void update() throws Exception
	{
		String d=JOptionPane.showInputDialog("Enter DID");
		pst=con.prepareStatement("update doners set type=?,name=?,address=?,city=?,mobile=?,email=? where did=?");
		pst.setString(1, ttype.getSelectedItem().toString());
		pst.setString(2, tname.getText());
		pst.setString(3, taddress.getText());
		pst.setString(4, tcity.getText());
		pst.setString(5, tmobile.getText());
		pst.setString(6, temail.getText());
		pst.setString(7, d);
		int x=pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "Updated");
		pst.close();
		
	}
	
	void save() throws Exception
	{
		
		pst=con.prepareStatement("insert into doners(type,name,address,city,mobile,email)values(?,?,?,?,?,?)");
		pst.setString(1, ttype.getSelectedItem().toString());
		pst.setString(2, tname.getText());
		pst.setString(3, taddress.getText());
		pst.setString(4, tcity.getText());
		pst.setString(5, tmobile.getText());
		pst.setString(6, temail.getText());
		int x=pst.executeUpdate();
		pst=con.prepareStatement("select max(did) as maxi from doners");
		ResultSet y=pst.executeQuery();
		int i = 0;
		while(y.next()==true)
		{
			i=y.getInt("maxi");
		}
		
		
		JOptionPane.showMessageDialog(null, "Saved \n did:"+i);
		pst.close();
	}
	
	void search() throws Exception
	{
		String d=JOptionPane.showInputDialog("Enter DID");
		pst=con.prepareStatement("select * from doners where did=?");
		pst.setString(1, d);
		ResultSet rs=pst.executeQuery();
		if(rs.next()==true)
		{
			ttype.setSelectedItem(rs.getString("type"));
			tname.setText(rs.getString("name"));
			taddress.setText(rs.getString("address"));
			tcity.setText(rs.getString("city"));
			tmobile.setText(rs.getString("mobile"));
			temail.setText(rs.getString("email"));
		}
		
	}
	
	
}


public class DonerReg 
{
	public static void main(String[] args) 
	{
		new Dr();
	}

}
