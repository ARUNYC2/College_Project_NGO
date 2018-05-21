package soft;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;


class Ali extends JFrame
{
	Connection con;
	PreparedStatement pst;
	JPanel pnl;
	JLabel wlcm,pwd;
	JButton start,chng,frgt;
	JPasswordField tpwd;
	Ali()
	{
		//con=ConnectToMysql.getConnection();
		pnl=new JPanel();
		pnl.setVisible(true);
		pnl.setSize(900,300);
		pnl.setBackground(Color.cyan);
		
		pnl.setBorder(BorderFactory.createLineBorder(Color.black));
		
		wlcm=new JLabel("Welcome");
		wlcm.setBounds(170, 20, 100, 70);
		pnl.add(wlcm);
		
		pwd=new JLabel("Password");
		pwd.setBounds(10, 100,70,30);
		pnl.add(pwd);
		
		tpwd=new JPasswordField();
		tpwd.setBounds(100, 100, 200, 30);
		pnl.add(tpwd);
		
		start=new JButton("Start");
		start.setBounds(150, 150, 100, 30);
		pnl.add(start);
	
		
		chng=new JButton("Change Password");
		chng.setBounds(20, 220, 140, 20);
		pnl.add(chng);
		
		frgt=new JButton("ForGot Password");
		frgt.setBounds(220, 220, 140, 20);
		pnl.add(frgt);
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		
		pnl.setLayout(null);
		setLayout(null);
		add(pnl);
		setVisible(true);
		setSize(400,300);
		
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		start.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					start();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		frgt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new Fp();
			}
		});
		
		chng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new Cp();
			}
		});
		
	}
	
	void start() throws Exception
	{
		pst=con.prepareStatement("select password from admin");
		ResultSet rs=pst.executeQuery();
		if(rs.next()==true)
		{
			String pwd=String.valueOf(tpwd.getPassword());
			String cpwd=rs.getString("password");
			if(pwd.equals(cpwd))
			{
				new Options();
			}
			else
				JOptionPane.showMessageDialog(null, "Wrong Password");
		}
	}
}


public class AdminLogIn 
{
	public static void main(String[] args) 
	{
		new Ali();
	}

}
