package soft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

class Cs extends JFrame
{
	Connection con;
	PreparedStatement pst;
	JPanel pnl;
	JLabel cs,amount,copy,pen,pencil,shoes,uniform,eat,bag,cycle,wbottle,tiffin,erasor,stat,others,count;
	JTextField tamount,tcopy,tpen,tpencil,tshoes,tuniform,teat,tbag,tcycle,twbottle,ttiffin,terasor,tstat,tothers,tcount;
	JButton ok;
	
	Cs()
	{
		con=ConnectToMysql.getConnection();
		pnl=new JPanel();
		pnl.setBounds(10,10, 300, 620);
		
		amount=new JLabel("Amount :");
		copy=new JLabel("Copy :");
		pen=new JLabel("Pen :");
		pencil=new JLabel("Pencil :");
		shoes=new JLabel("Shoes :");
		uniform=new JLabel("Uniform :");
		eat=new JLabel("Eatables :");
		bag=new JLabel("Bag :");
		cycle=new JLabel("Cycle :");
		wbottle=new JLabel("Water Bottle :");
		tiffin=new JLabel("Tiffin :");
		erasor=new JLabel("Erasor :");
		stat=new JLabel("Stationary :");
		others=new JLabel("Others :");
		count=new JLabel("Counting :");
		
		
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
		 tothers=new JTextField();
		 
		 tamount.setEnabled(false);
		 tcopy.setEnabled(false);
		 tpen.setEnabled(false);
		 tpencil.setEnabled(false);
		 tshoes.setEnabled(false);
		 tuniform.setEnabled(false);
		 teat.setEnabled(false);
		 tbag.setEnabled(false);
		 tcycle.setEnabled(false);
		 twbottle.setEnabled(false);
		 ttiffin.setEnabled(false);
		 terasor.setEnabled(false);
		 tcount.setEnabled(false);
		 tstat.setEnabled(false);
		 tothers.setEnabled(false);
		 
		 
		 amount.setBounds(15, 10, 70, 30);
		 copy.setBounds(15, 50, 70, 30);
		 pen.setBounds(15, 90, 70, 30);
		 pencil.setBounds(15, 130, 70, 30);
		 shoes.setBounds(15, 170, 70, 30);
		 uniform.setBounds(15, 210, 70, 30);
		 eat.setBounds(15, 250, 70, 30);
		 bag.setBounds(15, 290, 70, 30);
		 cycle.setBounds(15, 330, 70, 30);
		 wbottle.setBounds(15, 370, 70, 30);
		 tiffin.setBounds(15, 410, 70, 30);
		 erasor.setBounds(15, 450, 70, 30);
		 stat.setBounds(15, 490, 70, 30);
		 others.setBounds(15, 530, 70, 30);
		 count.setBounds(15, 570, 70, 30);
		 
		 tamount.setBounds(95, 10, 170, 30);
		 tcopy.setBounds(95, 50, 170, 30);
		 tpen.setBounds(95, 90, 170, 30);
		 tpencil.setBounds(95, 130, 170, 30);
		 tshoes.setBounds(95, 170, 170, 30);
		 tuniform.setBounds(95, 210, 170, 30);
		 teat.setBounds(95, 250, 170, 30);
		 tbag.setBounds(95, 290, 170, 30);
		 tcycle.setBounds(95, 330, 170, 30);
		 twbottle.setBounds(95, 370, 170, 30);
		 ttiffin.setBounds(95, 410, 170, 30);
		 terasor.setBounds(95, 450, 170, 30);
		 tstat.setBounds(95, 490, 170, 30);
		 tothers.setBounds(95, 530, 170, 30);
		 tcount.setBounds(95, 570, 170, 30);
		
		 
		 pnl.add(amount);
		pnl.add(tamount);
		pnl.add(copy);
		pnl.add(pen);
		pnl.add(pencil);
		pnl.add(tcopy);
		pnl.add(tpen);
		pnl.add(tpencil);
		pnl.add(shoes);
		pnl.add(uniform);
		pnl.add(eat);
		pnl.add(tshoes);
		pnl.add(tuniform);
		pnl.add(teat);
		pnl.add(bag);
		pnl.add(cycle);
		pnl.add(wbottle);
		pnl.add(tbag);
		pnl.add(tcycle);
		pnl.add(twbottle);
		pnl.add(tiffin);
		pnl.add(erasor);
		pnl.add(stat);
		pnl.add(ttiffin);
		pnl.add(terasor);
		pnl.add(tstat);
		pnl.add(others);
		pnl.add(count);
		pnl.add(tothers);
		pnl.add(tcount);
		
		try {
			fetch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		
		
		pnl.setLayout(null);
		setLayout(null);
		add(pnl);
		setVisible(true);
		setSize(400,700);
		
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	void fetch() throws Exception
	{
		pst=con.prepareStatement("select * from stock");
		ResultSet rs=pst.executeQuery();
		while(rs.next()==true)
		{
			tamount.setText(rs.getString("amount"));
			tcopy.setText(rs.getString("copy"));
			tpen.setText(rs.getString("pen"));
			tpencil.setText(rs.getString("pencil"));
			tshoes.setText(rs.getString("shoes"));
			tuniform.setText(rs.getString("uniform"));
			teat.setText(rs.getString("eatables"));
			tbag.setText(rs.getString("bag"));
			tcycle.setText(rs.getString("cycle"));
			twbottle.setText(rs.getString("water_bottle"));
			ttiffin.setText(rs.getString("tiffin"));
			terasor.setText(rs.getString("erasor"));
			tstat.setText(rs.getString("stationary"));
			tothers.setText(rs.getString("others"));
			tcount.setText(rs.getString("count"));
			
		}
		pst.close();
	}
}


public class CurStock 
{
	public static void main(String[] args) 
	{
		new Cs();
	}

}
