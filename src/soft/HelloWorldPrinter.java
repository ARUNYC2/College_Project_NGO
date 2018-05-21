package soft;
import java.awt.print.*;
import java.awt.*;
import javax.swing.*;

public class HelloWorldPrinter extends JFrame
    implements Printable {

  public int print(Graphics g, PageFormat pf, int page)
    {

    // We have only one page, and 'page'
    // is zero-based
    if (page > 0) {
         return NO_SUCH_PAGE;
    }

    // User (0,0) is typically outside the
    // imageable area, so we must translate
    // by the X and Y values in the PageFormat
    // to avoid clipping.
    Graphics2D g2d = (Graphics2D)g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());

    // Now we perform our rendering
    g.drawString("Hello world!", 100, 100);

    // tell the caller that this page is part
    // of the printed document
    return PAGE_EXISTS;
  }
  
  public static void main(String[] a){
	  PrinterJob pj = PrinterJob.getPrinterJob();
	    if(pj.printDialog()) {
	        try {
	        	pj.print();
	        }
	        catch (PrinterException exc) {
	            System.out.println(exc);
	         }
	     }
  }
}