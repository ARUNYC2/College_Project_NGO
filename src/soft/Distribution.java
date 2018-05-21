package soft;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

class Dis extends JFrame
{
	Connection con;
	PreparedStatement pst;
	JButton save;
	JPanel spnl,thingpnl;
	JLabel scname,copy,pen,pencil,shoes,uniform,eat,bag,cycle,wbottle,tiffin,erasor,stat,others,count,date,amount;
	JTextField tscname,tcopy,tpen,tpencil,tshoes,tuniform,teat,tbag,tcycle,twbottle,ttiffin,terasor,tstat,tothers,tcount,tamount;
	JComboBox sc,mm,dd,yy;

	
	
	
	Dis()
	{
		con=ConnectToMysql.getConnection();
		spnl=new JPanel();
		thingpnl=new JPanel();
		
		spnl.setBounds(10, 50, 450, 100);
		thingpnl.setBounds(10, 160, 450, 340);
		
		
		
		spnl.setLayout(null);
		thingpnl.setLayout(null);
		
		add(spnl);
		add(thingpnl);

		spnl.setBorder(BorderFactory.createLineBorder(Color.black));
		thingpnl.setBorder(BorderFactory.createLineBorder(Color.black));
		
		scname=new JLabel("Name of School");
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
		 tothers=new JTextField();
		 tstat=new JTextField();
		 
		 tamount.setText("0");
		 tcopy.setText("0");
		 tpen.setText("0");
		 tpencil.setText("0");
		 tshoes.setText("0");
		 tuniform.setText("0");
		 teat.setText("0");
		 tbag.setText("0");
		 tcycle.setText("0");
		 twbottle.setText("0");
		 ttiffin.setText("0");
		 terasor.setText("0");
		 tcount.setText("0");
		 tothers.setText("0");
		 tstat.setText("0");
		 
		 save=new JButton("Distribute");
		 
		 yy=new JComboBox();
		 mm=new JComboBox();
		 dd=new JComboBox();
		 sc=new JComboBox();
		 
		 scname.setBounds(50, 10, 120, 30);
		 spnl.add(scname);
		 sc.setBounds(180, 15, 250, 20);
		 spnl.add(sc);
		 date.setBounds(50, 50, 50, 30);
		 spnl.add(date);
		 mm.setBounds(200, 55, 50, 20);
		 yy.setBounds(110, 55, 70, 20);
		 dd.setBounds(270, 55, 50, 20);
		 spnl.add(mm);
		 spnl.add(yy);
		 spnl.add(dd);
		 
		 amount.setBounds(70, 10, 100, 30);
		tamount.setBounds(170, 10, 200, 30);
		copy.setBounds(10, 90, 50, 30);
		tcopy.setBounds(80, 90, 60, 30);
		pen.setBounds(150, 90, 50, 30);
		tpen.setBounds(210, 90, 60, 30);
		pencil.setBounds(280, 90, 50, 30);
		tpencil.setBounds(340, 90, 60, 30);
		
		thingpnl.add(amount);
		thingpnl.add(tamount);
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
		
		save.setBounds(170, 290, 100, 30);
		thingpnl.add(save);
		
		
		
	
		 
		 try {
			fillSchool();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		fillMonth();
		fillYear();
		fillDay();
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		
		
		repaint();
		setLayout(null);
		setVisible(true);
		setSize(500,550);
		
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		save.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try{
				stockdec();
					distri();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	void stockdec() throws Exception
	{
		pst=con.prepareStatement("update stock set amount=amount-?,copy=copy-?,pen=pen-?,pencil=pencil-?,shoes=shoes-?,uniform=uniform-?,eatables=eatables-?,bag=bag-?,cycle=cycle-?,water_bottle=water_bottle-?,tiffin=tiffin-?,erasor=erasor-?,stationary=stationary-?");
		
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
	
	void distri() throws Exception
	{
		pst=con.prepareStatement("insert into distributions(sname,date,amount,copy,pen,pencil,shoes,uniform,eatables,bag,cycle,water_bottle,tiffin,erasor,stationary,others,count)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		String s="";
		s+=yy.getSelectedItem();
		s+="/";
		s+=mm.getSelectedItem();
		s+="/";
		s+=dd.getSelectedItem();
		pst.setString(1, sc.getSelectedItem().toString());
		pst.setString(2, s);
		pst.setInt(3, Integer.parseInt(tamount.getText()));
		pst.setInt(4, Integer.parseInt(tcopy.getText()));
		pst.setInt(5, Integer.parseInt(tpen.getText()));
		pst.setInt(6, Integer.parseInt(tpencil.getText()));
		pst.setInt(7, Integer.parseInt(tshoes.getText()));
		pst.setInt(8, Integer.parseInt(tuniform.getText()));
		pst.setInt(9, Integer.parseInt(teat.getText()));
		pst.setInt(10, Integer.parseInt(tbag.getText()));
		pst.setInt(11, Integer.parseInt(tcycle.getText()));
		pst.setInt(12, Integer.parseInt(twbottle.getText()));
		pst.setInt(13, Integer.parseInt(ttiffin.getText()));
		pst.setInt(14, Integer.parseInt(terasor.getText()));
		pst.setInt(15, Integer.parseInt(tstat.getText()));
		pst.setString(16, tothers.getText());
		pst.setInt(17, Integer.parseInt(tcount.getText()));
		pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "distribution done");
		pst.close();
	}
	
	void fillSchool() throws Exception
	{
		sc.removeAll();
		sc.addItem("Select");
		
		pst=con.prepareStatement("select distinct sname from schools");
		ResultSet rs=pst.executeQuery();
		while(rs.next()==true)
		{
			String s=rs.getString("sname");
			sc.addItem(s+"");
		}
		
	}
	
	void fillMonth()
	{
		int i=1;
		mm.removeAll();
		mm.addItem("MM");
		while(i<=12)
		{
			String s=String.valueOf(i);
			mm.addItem(s+"");
			i++;
		}
	}
	
	void fillYear()
	{
		int i=1990;
		yy.removeAll();
		yy.addItem("YY");
		while(i<=2024)
		{
			String s=String.valueOf(i);
			yy.addItem(s+"");
			i++;
		}
	}
	
	void fillDay()
	{
		int i=1;
		dd.removeAll();
		dd.addItem("DD");
		while(i<=31)
		{
			String s=String.valueOf(i);
			dd.addItem(s+"");
			i++;
		}
	}
}



public class Distribution 
{
	public static void main(String[] args) 
	{
		new Dis();
	}

}
