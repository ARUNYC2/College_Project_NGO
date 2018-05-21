package soft;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;


class Asu extends JFrame
{
	Connection con;
	PreparedStatement pst;
	ImageIcon img;
	JPanel pnl,bpnl;
	JLabel wlcm,name,pwd,confirm,mobile,tmobileerr,tconfirmerr;
	JTextField tname,tmobile;
	JPasswordField tpwd,tconfirm;
	JButton start;
	
	Asu()
	{
		con=ConnectToMysql.getConnection();
		pnl=new JPanel();
		bpnl=new JPanel();
		pnl.setVisible(true);
		bpnl.setVisible(true);
		pnl.setBounds(0,0,500,400);
		bpnl.setBounds(0,410,500,50);
		bpnl.setBackground(Color.red);
		pnl.setBackground(Color.orange);
		
		
		
		pnl.setBorder(BorderFactory.createLineBorder(Color.black));
		bpnl.setBorder(BorderFactory.createLineBorder(Color.black));
		
		img=new ImageIcon("cooltext125585513590774.png");
		wlcm=new JLabel(img);
		wlcm.setBounds(200, 20, 100, 70);
		pnl.add(wlcm);
		
		name=new JLabel("Name");
		name.setBounds(30, 100, 70, 30);
		pnl.add(name);
		
		tname=new JTextField();
		tname.setBounds(130, 100, 200, 30);
		pnl.add(tname);
		
		pwd=new JLabel("Password");
		pwd.setBounds(30, 180, 70, 30);
		pnl.add(pwd);
		
		tpwd=new JPasswordField();
		tpwd.setBounds(130, 180, 200, 30);
		pnl.add(tpwd);
		
		confirm=new JLabel("Confirm");
		confirm.setBounds(30, 260, 70, 30);
		pnl.add(confirm);
		
		tconfirm=new JPasswordField();
		tconfirm.setBounds(130, 260, 200, 30);
		pnl.add(tconfirm);
		
		tconfirmerr=new JLabel();
		tconfirmerr.setBounds(340, 260, 120, 30);
		pnl.add(tconfirmerr);
		
		
		
		mobile=new JLabel("Mobile");
		mobile.setBounds(30, 320, 70, 30);
		pnl.add(mobile);
		
		tmobile=new JTextField();
		tmobile.setBounds(130, 320, 200, 30);
		pnl.add(tmobile);
		
		tmobileerr=new JLabel();
		tmobileerr.setBounds(340, 320, 70, 30);
		pnl.add(tmobileerr);
		
		start=new JButton("Start");
		start.setBounds(200, 40, 100, 30);
		bpnl.add(start);
		start.addActionListener(new ActionListener() 
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
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		
		setBackground(Color.red);
		pnl.setLayout(null);
		setLayout(null);
		add(pnl);
		add(bpnl);
		setVisible(true);
		setSize(510,490);
		
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
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
		
		
		tconfirm.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
				
				String c=String.valueOf(tconfirm.getPassword());
				String p=String.valueOf(tpwd.getPassword());
				if(c.equals(p))
					{
					tconfirmerr.setText("");
					}
				else
					tconfirmerr.setText("pwd not match");
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
		
		
	}
	public void save() throws Exception
	{
		char p[]=tpwd.getPassword();
		String pp=String.valueOf(p);
		pst=con.prepareStatement("insert into admin(name,password,mobile) values(?,?,?)");
		
		pst.setString(1, tname.getText());
		pst.setString(2, pp);
		pst.setString(3, tmobile.getText());
		
		pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "congratulations...admin \n"+tname.getText());
		pst.close();
	}
}

public class AdminSignUp 
{
	public static void main(String[] args) 
	{
		new Asu();

	}

}
