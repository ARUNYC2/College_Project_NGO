package soft;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class OP extends JFrame
{
	ImageIcon idr,isr,id,idis,ist,idt,iback,iclose;
	JButton dr,sr,d,dis,st,dt,back,close;
	JLabel opt;
	JPanel pnl,pnl1,pnl2;
	OP()
	{
		idr=new ImageIcon();
		isr=new ImageIcon();
		id=new ImageIcon();
		idis=new ImageIcon();
		ist=new ImageIcon();
		idt=new ImageIcon();
		iback=new ImageIcon();
		iclose=new ImageIcon();
		
		dr=new JButton();
		sr=new JButton();
		d=new JButton();
		dis=new JButton();
		st=new JButton();
		dt=new JButton();
		back=new JButton();
		close=new JButton();
		
		opt=new JLabel();
		
		pnl=new JPanel();
		pnl1=new JPanel();
		pnl2=new JPanel();
		
		
	}
}

public class Operation
{
	public static void main(String[] args) 
	{
		new OP();
	}
}
