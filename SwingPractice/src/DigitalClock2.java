package practice;
import java.applet.Applet;
import java.awt.*;
import java.util.*;

import java.text.*;

public class DigitalClock2 extends Applet implements Runnable {
	
	int timeInterval = 1000;
	public void start() { setSize(330, 200); new Thread(this).start();}
	public void run() {
		while(true) {
			try {
				repaint(); Thread.sleep(timeInterval);
			} catch(Exception e) {}
		}
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