import java.awt.*;
import java.util.*;

import javax.swing.JFrame;

import java.text.*;

public class DigitalClock extends java.applet.Applet {
	Repainter rp;
	public void start() {
		Repainter rp = new Repainter(this, 1000);
		rp.start();
		setSize(330, 200);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame(" µðÁöÅÐ ½Ã°è ");
		
		DigitalClock dc = new DigitalClock();
		dc.start();
		f.getContentPane().add(dc, "Center");
		f.setSize(330, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat dateFormatter = DateFormat.getTimeInstance();
		
		g.setFont(new Font("±¼¸²", Font.BOLD, 36));
		g.drawString(dateFormatter.format(date), 30, 120);
		
		DateFormat date2Formatter = DateFormat.getDateInstance(DateFormat.FULL);
		
		g.setFont(new Font("±¼¸²", Font.BOLD, 24));
		g.drawString(date2Formatter.format(date), 30 , 70);
	}
}

class Repainter extends Thread{
	Component comp;
	int timeInterval;
	public Repainter (Component comp, long timeInterval) {
		this.comp = comp;
		this.timeInterval = (int) timeInterval;
	}
	public void run() {
		while(true) {
			try {
				comp.repaint();
				sleep(timeInterval);
			}
			catch(Exception e) {}
		}
	}
		
}