package soft;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.Border;

class Cp extends JFrame{
	
	Connection con;
	PreparedStatement pst;
	JLabel cadm,npass,text;
	JTextField cadm1,npass1;
	JButton done,back;
	JPanel pnl,pnl1,pnl2;
	Cp()
	{
		con=ConnectToMysql.getConnection();
		pnl=new JPanel();
		pnl1=new JPanel();
		pnl2=new JPanel();
		
		pnl.setBounds(20,20,320,200);
		pnl1.setBounds(100,10,150,30);
		pnl2.setBounds(30, 50, 300, 150);
		
		pnl.setVisible(true);
		pnl1.setVisible(true);
		pnl2.setVisible(true);
		
		pnl.setLayout(null);
		pnl1.setLayout(null);
		pnl2.setLayout(null);
	
		pnl.setBorder(BorderFactory.createLineBorder(Color.black));
		pnl2.setBorder(BorderFactory.createLineBorder(Color.black));
		pnl1.setBorder(BorderFactory.createLineBorder(Color.black));
		add(pnl1);
		add(pnl2);
		
		pnl.setBackground(Color.BLUE);
		pnl1.setBackground(Color.red);
		pnl2.setBackground(Color.orange);
		
		
		text=new JLabel("Change PassWord");
		text.setBounds(20, 5, 150, 20);
		pnl1.add(text);
		
		cadm =new JLabel("AdminID");
		cadm.setBounds(20,20,100,20);
		pnl2.add(cadm);

		cadm1 = new JTextField();
		cadm1.setBounds(120,20,100,20);
		pnl2.add(cadm1);
		
		npass=new JLabel("New PassWord");
		npass.setBounds(20,60,100,20);
		pnl2.add(npass);

		npass1=new JTextField();
		npass1.setBounds(120,60,100,20);
		pnl2.add(npass1);
		
		done=new JButton("Change");
		done.setBounds(80, 100, 100, 20);
		pnl2.add(done);
	
		back=new JButton("Back");
		back.setBounds(95,120,70,20);
		pnl2.add(back);
		back.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				new Ali();
			}
		});
		done.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					pst=con.prepareStatement("Select name from admin where name=?");
					pst.setString(1,cadm1.getText());
					ResultSet rs=pst.executeQuery();
					if(rs.next()==true)
						{
							pst=con.prepareStatement("Update admin set password=? where name=? ");
							pst.setString(2, cadm1.getText());
							pst.setString(1,npass1.getText());
							int x=pst.executeUpdate();
							JOptionPane.showMessageDialog(null,"Password Updated");
						}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Admin Id");
					}
				}
				catch(Exception E)
				{
					E.getMessage();
					E.printStackTrace();
				}
				
			}
		});
		
		add(pnl);
		setBounds(0,0,400,400);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
public class chngpass {
	public static void main(String[] args) {
		new Cp();
	}

}

