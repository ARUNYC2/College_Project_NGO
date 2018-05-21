package soft;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Principal;
import java.security.acl.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.*;

class Gd extends JFrame
{
	
	ButtonGroup grp;
	Connection con;
	PreparedStatement pst;
	JPanel idpnl,thingpnl,datepnl,bpnl;
	JLabel hint,did,name,mobile,amount,copy,pen,pencil,shoes,uniform,eat,bag,cycle,wbottle,tiffin,erasor,stat,others,count,date,mode;
	JTextField tname,tmobile,tamount,tcopy,tpen,tpencil,tshoes,tuniform,teat,tbag,tcycle,twbottle,ttiffin,terasor,tcount,tstat,tdate;
	JTextArea tothers;
	JButton newb,close,save,fetch;
	JRadioButton cash,cheque,dd;
	JComboBox m,y,d,cdid;
	Gd()
	{
		con=ConnectToMysql.getConnection();
		idpnl=new JPanel();
		thingpnl=new JPanel();
		datepnl=new JPanel();
		bpnl=new JPanel();
		
		idpnl.setBounds(10, 50, 450, 135);
		thingpnl.setBounds(10, 195, 450, 300);
		datepnl.setBounds(10, 505, 450, 50);
		bpnl.setBounds(10, 565, 450, 60);
		
		idpnl.setBorder(BorderFactory.createLineBorder(Color.black));
		thingpnl.setBorder(BorderFactory.createLineBorder(Color.black));
		datepnl.setBorder(BorderFactory.createLineBorder(Color.black));
		bpnl.setBorder(BorderFactory.createLineBorder(Color.black));
		
		idpnl.setLayout(null);
		thingpnl.setLayout(null);
		datepnl.setLayout(null);
		bpnl.setLayout(null);
		
		
		add(idpnl);
		add(thingpnl);
		add(datepnl);
		add(bpnl);
		
		y=new JComboBox();
		m=new JComboBox();
		d=new JComboBox();
		
		cash=new JRadioButton("Cash",true);
		cheque=new JRadioButton("Cheque");
		dd=new JRadioButton("DD");
		
		mode=new JLabel("Payment Mode");
		did=new JLabel("Doner ID");
		name=new JLabel("Name");
		mobile=new JLabel("Mobile no.");
		amount=new JLabel("Amount");
		copy=new JLabel("Copy");
		pen=new JLabel("Pen");
		pencil=new JLabel("Pencil");
		shoes=new JLabel("Shoes");
		uniform=new JLabel("Uniform");
		eat=new JLabel("Eatables");
		bag=new JLabel("Bag");
		cycle=new JLabel("Cycle");
		wbottle=new JLabel("Water Bottle");
		tiffin=new JLabel("Tiffin");
		erasor=new JLabel("Erasor");
		stat=new JLabel("Stationary");
		others=new JLabel("Others");
		count=new JLabel("Counting");
		date=new JLabel("Date");
		hint=new JLabel("(yyyy/mm/dd)");
		
		 cdid=new JComboBox();
		 tname=new JTextField();
		 tmobile=new JTextField();
		 tamount=new JTextField();
		 tcopy=new JTextField();
		 tpen=new JTextField();
		 tpencil=new JTextField();
		 tshoes=new JTextField();
		 tuniform=new JTextField();
		 teat=new JTextField();
		 tbag=new JTextField();
		 tcycle=new JTextField();
		 twbottle=new JTextField();
		 ttiffin=new JTextField();
		 terasor=new JTextField();
		 tcount=new JTextField();
		 tstat=new JTextField();
		 tdate=new JTextField();
		 tdate=new JTextField();
		 
		 tothers=new JTextArea();
		 
		// newb=new JButton();
		 //close=new JButton();
		 //save=new JButton();
		 fetch=new JButton("Fetch");
		
		 fetch.setBounds(370, 15, 70, 20);
		did.setBounds(10, 10, 100, 30);
		name.setBounds(10, 50, 100, 30);
		mobile.setBounds(10, 90, 100, 30);
		cdid.setBounds(100, 10, 250, 20);
		tname.setBounds(100, 50, 250, 30);
		tmobile.setBounds(100, 90, 250, 30);
		
		idpnl.add(fetch);
		idpnl.add(did);		
		idpnl.add(name);
		idpnl.add(mobile);
		idpnl.add(cdid);		
		idpnl.add(tname);
		idpnl.add(tmobile);
		
		//----------------->>>>>>>>>>>>>>>>>>..
		
		grp=new ButtonGroup();
		
		amount.setBounds(70, 10, 100, 30);
		tamount.setBounds(170, 10, 200, 30);
		mode.setBounds(10, 50, 100, 30);
		cash.setBounds(110, 50, 100, 30);
		cheque.setBounds(220, 50, 100, 30);
		dd.setBounds(330, 50, 100, 30);
		copy.setBounds(10, 90, 50, 30);
		tcopy.setBounds(80, 90, 60, 30);
		pen.setBounds(150, 90, 50, 30);
		tpen.setBounds(210, 90, 60, 30);
		pencil.setBounds(280, 90, 50, 30);
		tpencil.setBounds(340, 90, 60, 30);
		
		grp.add(cash);
		grp.add(cheque);
		grp.add(dd);
		
		thingpnl.add(amount);
		thingpnl.add(mode);
		thingpnl.add(cash);
		thingpnl.add(cheque);
		thingpnl.add(dd);
		thingpnl.add(tamount);
		

		copy.setBounds(10, 90, 50, 30);
		tcopy.setBounds(70, 90, 70, 30);
		pen.setBounds(150, 90, 50, 30);
		tpen.setBounds(200, 90, 70, 30);
		pencil.setBounds(280, 90, 80, 30);
		tpencil.setBounds(360, 90, 70, 30);
		thingpnl.add(copy);
		thingpnl.add(pen);
		thingpnl.add(pencil);
		thingpnl.add(tcopy);
		thingpnl.add(tpen);
		thingpnl.add(tpencil);

		shoes.setBounds(10, 130, 50, 30);
		tshoes.setBounds(70, 130, 70, 30);
		uniform.setBounds(150, 130, 50, 30);
		tuniform.setBounds(200, 130, 70, 30);
		eat.setBounds(280, 130, 80, 30);
		teat.setBounds(360, 130, 70, 30);
		thingpnl.add(shoes);
		thingpnl.add(uniform);
		thingpnl.add(eat);
		thingpnl.add(tshoes);
		thingpnl.add(tuniform);
		thingpnl.add(teat);
		
		bag.setBounds(10, 170, 50, 30);
		tbag.setBounds(70, 170, 70, 30);
		cycle.setBounds(150, 170, 50, 30);
		tcycle.setBounds(200, 170, 70, 30);
		wbottle.setBounds(280, 170, 80, 30);
		twbottle.setBounds(360, 170, 70, 30);
		thingpnl.add(bag);
		thingpnl.add(cycle);
		thingpnl.add(wbottle);
		thingpnl.add(tbag);
		thingpnl.add(tcycle);
		thingpnl.add(twbottle);
		
		tiffin.setBounds(10, 210, 50, 30);
		ttiffin.setBounds(70, 210, 70, 30);
		erasor.setBounds(150, 210, 50, 30);
		terasor.setBounds(200, 210, 70, 30);
		stat.setBounds(280, 210, 80, 30);
		tstat.setBounds(360, 210, 70, 30);
		thingpnl.add(tiffin);
		thingpnl.add(erasor);
		thingpnl.add(stat);
		thingpnl.add(ttiffin);
		thingpnl.add(terasor);
		thingpnl.add(tstat);
		
		others.setBounds(10, 250, 50, 30);
		tothers.setBounds(70, 250, 200, 30);
		count.setBounds(280, 250, 50, 30);
		tcount.setBounds(340, 250, 70, 30);
	
		thingpnl.add(others);
		thingpnl.add(count);
		thingpnl.add(tothers);
		thingpnl.add(tcount);
	
		
		
		
		newb=new JButton("New");
		save=new JButton("Save");
		close=new JButton("Close");
		
		newb.setBounds(35, 10, 100, 40);
		save.setBounds(175, 10, 100, 40);
		close.setBounds(315, 10, 100, 40);
		
		bpnl.add(newb);
		bpnl.add(save);
		bpnl.add(close);
		
		date.setBounds(10, 10, 50, 30);
		tdate.setBounds(80, 10, 200, 30);
		hint.setBounds(290, 10, 100, 30);
		datepnl.add(date);		
		datepnl.add(tdate);
		datepnl.add(hint);
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		
		
		repaint();
		setLayout(null);
		setVisible(true);
		setSize(500,670);
		
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 try {
			filldid();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		newb.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cdid.setSelectedIndex(1);
				tname.setText("");
				tmobile.setText("");
				tamount.setText("");
			
				tcopy.setText("");
				tpen.setText("");
				tpencil.setText("");
				tshoes.setText("");
				tuniform.setText("");
				teat.setText("");
				tbag.setText("");
				tcycle.setText("");
				twbottle.setText("");
				ttiffin.setText("");
				terasor.setText("");
				tstat.setText("");
				tothers.setText("");
				tdate.setText("");
				tcount.setText("");
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
		
		fetch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					try {
						fetch();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		
	}
	
	void filldid() throws Exception
	{
		cdid.removeAll();
		cdid.addItem("Select");
		
		pst=con.prepareStatement("select distinct did from doners");
		ResultSet rs=pst.executeQuery();
		while(rs.next()==true)
		{
			String s=rs.getString("did");
			cdid.addItem(s+"");
		}
	}
	
	void fetch() throws Exception
	{
		pst=con.prepareStatement("select * from doners where did=?");
		pst.setString(1, String.valueOf(cdid.getSelectedItem()));
		ResultSet r=pst.executeQuery();
		while(r.next()==true)
		{
			tname.setText(r.getString("name"));
			tmobile.setText(r.getString("mobile"));
		}
		pst.close();
	}
	
	void save() throws Exception
	{
		pst=con.prepareStatement("insert into donations(did,name,mobile,amount,mode,copy,pen,pencil,shoes,uniform,eatables,bag,cycle,water_bottle,tiffin,erasor,stationary,others,count,date)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pst.setString(1,String.valueOf(cdid.getSelectedItem()));
		pst.setString(2, tname.getText());
		pst.setString(3, tmobile.getText());
		pst.setInt(4, Integer.parseInt(tamount.getText()));
		if(cash.isSelected()==true)
			pst.setString(5,"cash");
		if(cheque.isSelected()==true)
			pst.setString(5,"cheque");
		if(dd.isSelected()==true)
			pst.setString(5,"dd");
		pst.setInt(6, Integer.parseInt(tcopy.getText()));
		pst.setInt(7, Integer.parseInt(tpen.getText()));
		pst.setInt(8, Integer.parseInt(tpencil.getText()));
		pst.setInt(9, Integer.parseInt(tshoes.getText()));
		pst.setInt(10, Integer.parseInt(tuniform.getText()));
		pst.setInt(11, Integer.parseInt(teat.getText()));
		pst.setInt(12, Integer.parseInt(tbag.getText()));
		pst.setInt(13, Integer.parseInt(tcycle.getText()));
		pst.setInt(14, Integer.parseInt(twbottle.getText()));
		pst.setInt(15, Integer.parseInt(ttiffin.getText()));
		pst.setInt(16, Integer.parseInt(terasor.getText()));
		pst.setInt(17, Integer.parseInt(tstat.getText()));
		pst.setString(18, tothers.getText());
		pst.setInt(19, Integer.parseInt(tcount.getText()));
		pst.setString(20, tdate.getText());
		
		
		int x=pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "saved");
		pst.close();
		
		
		pst=con.prepareStatement("update stock set amount=amount+?,copy=copy+?,pen=pen+?,pencil=pencil+?,shoes=shoes+?,uniform=uniform+?,eatables=eatables+?,bag=bag+?,cycle=cycle+?,water_bottle=water_bottle+?,tiffin=tiffin+?,erasor=erasor+?,stationary=stationary+?");
		
		pst.setInt(1, Integer.parseInt(tamount.getText()));
		pst.setInt(2, Integer.parseInt(tcopy.getText()));
		pst.setInt(3, Integer.parseInt(tpen.getText()));
		pst.setInt(4, Integer.parseInt(tpencil.getText()));
		pst.setInt(5, Integer.parseInt(tshoes.getText()));
		pst.setInt(6, Integer.parseInt(tuniform.getText()));
		pst.setInt(7, Integer.parseInt(teat.getText()));
		pst.setInt(8, Integer.parseInt(tbag.getText()));
		pst.setInt(9, Integer.parseInt(tcycle.getText()));
		pst.setInt(10, Integer.parseInt(twbottle.getText()));
		pst.setInt(11, Integer.parseInt(ttiffin.getText()));
		pst.setInt(12, Integer.parseInt(terasor.getText()));
		pst.setInt(13, Integer.parseInt(tstat.getText()));
		
		pst.executeUpdate();
		pst.close();
	}
}

public class GiveDonation 
{
	public static void main(String[] args) 
	{
		new Gd();
	}

}
