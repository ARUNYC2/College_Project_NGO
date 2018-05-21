package soft;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class Options extends JFrame
{
	JButton dr,sr,d,dis,st,dt,back,close,ss,ds;
	JLabel opt;
	JPanel pnl,pnl1,pnl2;
	Options()
		{

			
			pnl1=new JPanel();
			pnl1.setBounds(40,10,400,50);
			add(pnl1);
			pnl1.setBorder(BorderFactory.createBevelBorder(1));
		
			Font f=new Font("arial",Font.CENTER_BASELINE,30);
			
			pnl2=new JPanel();
			pnl2.setBounds(40,70,400,350);
			add(pnl2);
			pnl2.setBorder(BorderFactory.createBevelBorder(1));
			pnl2.setBackground(Color.lightGray);
			
			opt=new JLabel("Operations");
			opt.setBounds(100,10,300, 30);
			pnl1.add(opt);
			opt.setFont(f);
			pnl1.setBackground(Color.blue);
			
			dr=new JButton("Donar Registration");
			dr.setBounds(20,20,150,30);
			pnl2.add(dr);
					
			
			String ab="a";
			dr.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					
					new Dr();
				}
			});
			
			sr=new JButton("School Registration");
			sr.setBounds(200,20,150,30);
			pnl2.add(sr);
			sr.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					
					try {
						new Sr();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		});
			d=new JButton("Donation");
			d.setBounds(20,70,150,30);
			pnl2.add(d);
			d.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				new Gd();	
				}
			});
			dis=new JButton("Do Distribution");
			dis.setBounds(200,70,150,30);
			pnl2.add(dis);
		dis.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				new Dis();	
				}
			});
			
			st=new JButton("Stock Table");
			st.setBounds(20,120,150,30);
			pnl2.add(st);
			
		st.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				new Cs();	
				}
			});
			
			dt=new JButton("Distribution Table");
			dt.setBounds(200,120,150,30);
			pnl2.add(dt);
			
		dt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				new Dt();	
				}
			});
		
		ds=new JButton("Search Donation");
		ds.setBounds(20,170,150,30);
		pnl2.add(ds);
		
	ds.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			new Dsearch();	
			}
		});
	
	ss=new JButton("search schools");
	ss.setBounds(200,170,150,30);
	pnl2.add(ss);
	
ss.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		new Ssearch();	
		}
	});


			back=new JButton("Back");
			back.setBounds(20,220,150,30);
			pnl2.add(back);
			
			close=new JButton("Close");
			close.setBounds(200,220,150,30);
			pnl2.add(close);
			
			pnl=new JPanel();
			pnl.setBounds(10,0,450,450);
			add(pnl);
			
			pnl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pnl.setBackground(Color.white);
			pnl=new JPanel();
			pnl.setBounds(10,10,480,480);
			add(pnl);
			setBounds(0,0,500,500);
			pnl.setVisible(true);
			pnl.setLayout(null);
			pnl1.setVisible(true);
			pnl1.setLayout(null);
			pnl2.setVisible(true);
			pnl2.setLayout(null);
			
			setUndecorated(true);
			getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
			

			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLayout(null);
			setVisible(true);
		
			
		}
	
	}

public class Operations {
	public static void main(String[] args) {
		
		new Options();

	}

}
