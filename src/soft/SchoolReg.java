package soft;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import soft.ConnectToMysql;



class Sr extends JFrame
{
	ImageIcon inew,isave;
	Connection con;
	PreparedStatement pst;
	JPanel tpnl,bpnl;
	JLabel name,address,city,head,mobile,req,str,tmobileerr;
	JTextField tname,tcity,thead,tmobile,tstr;
	JTextArea taddress,treq;
	JButton newb,save;
	Sr() throws Exception
	{
		con=ConnectToMysql.getConnection();
		tpnl=new JPanel();
		bpnl=new JPanel();
		
		inew=new ImageIcon("new.png");
		isave=new ImageIcon("save.png");
		
//		try {
//		    Image img = ImageIO.read(getClass().getResource("new.png"));
//		    newb.setIcon(new ImageIcon(img));
//		  } catch (IOException ex) {
//			  ex.getMessage();
//		  }
//		
		//BufferedImage buttonIcon = ImageIO.read(new File("/NGO/src/soft/new.png"));
		//newb = new JButton(new ImageIcon(buttonIcon));
		
		tmobileerr=new JLabel();
		name=new JLabel("School Name");
		address=new JLabel("Address");
		city=new JLabel("City");
		mobile=new JLabel("Mobile");
		head=new JLabel("Head");
		req=new JLabel("Requirements");
		str=new JLabel("Strength");
		
		tname=new JTextField();
		tcity=new JTextField();
		tmobile=new JTextField();
		thead=new JTextField();
		taddress=new JTextArea();
		treq=new JTextArea();
		tstr=new JTextField();
		
		
		name.setBounds(15, 5, 80, 30);
		address.setBounds(15, 45, 80, 60);
		city.setBounds(15, 115, 80, 30);
		head.setBounds(15, 155, 80, 30);
		mobile.setBounds(15, 195, 80, 30);
		req.setBounds(15, 235, 80, 50);
		str.setBounds(15, 295, 80, 30);
		tmobileerr.setBounds(315, 195, 70, 30);
		
		tname.setBounds(105, 5, 200, 30);
		taddress.setBounds(105, 45, 200, 60);
		tcity.setBounds(105, 115, 200, 30);
		thead.setBounds(105, 155, 200, 30);
		tmobile.setBounds(105, 195, 200, 30);
		treq.setBounds(105, 235, 200, 50);
		tstr.setBounds(105, 295, 200, 30);
		
		tpnl.add(head);
		tpnl.add(name);
		tpnl.add(address);
		tpnl.add(city);
		tpnl.add(mobile);
		tpnl.add(req);
		tpnl.add(str);
		tpnl.add(tmobileerr);
		
		tpnl.add(thead);
		tpnl.add(tname);
		tpnl.add(taddress);
		tpnl.add(tcity);
		tpnl.add(tmobile);
		tpnl.add(treq);
		tpnl.add(tstr);
		
		
		newb=new JButton(inew);
		save=new JButton(isave);
		
		newb.setBorder(BorderFactory.createEmptyBorder());
		newb.setContentAreaFilled(false);
		
		save.setBorder(BorderFactory.createEmptyBorder());
		save.setContentAreaFilled(false);
		
		newb.setBounds(35, 10, 90, 40);
		save.setBounds(280, 10, 90, 40);
		
		bpnl.add(newb);
		bpnl.add(save);
		
		
		
		tpnl.setLayout(null);
		tpnl.setBorder(BorderFactory.createLineBorder(Color.black));
		bpnl.setLayout(null);
		bpnl.setBorder(BorderFactory.createLineBorder(Color.black));
		tpnl.setBounds(10,50,405,350);
		bpnl.setBounds(10, 405, 405, 60);
		add(tpnl);
		add(bpnl);
		
		
		
		
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(440,520);
		
		tmobile.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
				
				String mobile="^[789]\\d{9}$";
				boolean b=tmobile.getText().matches(mobile);
				if(b)
					{
					tmobileerr.setText("");
					}
				else
					tmobileerr.setText("Invalid NO.");
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
		
		
		newb.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				thead.setText("");
				tname.setText("");
				taddress.setText("");
				tcity.setText("");
				tmobile.setText("");
				treq.setText("");
				tstr.setText("");
				
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
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	void save() throws Exception
	{
		pst=con.prepareStatement("insert into schools(sname,address,city,mobile,head,requirements,strength)values(?,?,?,?,?,?,?)");
		
		pst.setString(1, tname.getText());
		pst.setString(2, taddress.getText());
		pst.setString(3, tcity.getText());
		pst.setString(4, tmobile.getText());
		pst.setString(5, thead.getText());
		pst.setString(6, treq.getText());
		pst.setInt(7, Integer.parseInt(tstr.getText()));
		
		int x=pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "Saved");
		pst.close();
	}
}



public class SchoolReg 
{
	public static void main(String[] args) 
	{
		try {
			new Sr();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
