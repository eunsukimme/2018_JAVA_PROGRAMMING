package practice;

import java.awt.*;

import javax.swing.JFrame;

public class ClockCrawler implements Runnable {
	DigitalClock dc;
	int x = 10, y = 40, dx = 10;
	ClockCrawler() {
		JFrame bben = new JFrame("Lab 9. ClockCrwler");
		dc = new DigitalClock();
		bben.getContentPane().add(dc,  "Center");
		dc.start();
		bben.setSize(330, 200);
		bben.setVisible(true);
		
	}
	public static void main(String[] ags) {
		ClockCrawler ccr = new ClockCrawler();
		/* Thread t = new Thread(ccr);
		t.start(); */
		for(int i = 0 ;i < 5 ; i++) {
			Thread t = new Thread(ccr);
			t.start();
		}
		
	}
	public void run() {
		int x = 5 + (int)(Math.random() * 275);
		int y = 5 + (int)(Math.random() * 160);
		int dx = (int)(7.5 + Math.random()*5);
		int n  = (int)(2 + Math.random() * 3);
		int t = 0;
		while(true){
			System.out.println("Crawl" +  ++t);
			Graphics g = dc.getGraphics();
			if(x >= dc.getWidth() - 20 || x <= 5)
				dx = -dx;
			x += dx;
			if(g != null) {
				g.setColor(Color.red);
				if(dx > 0)
					g.drawString("__*_", x, y);
				else
					g.drawString("_*__", x, y);
			}
			try { Thread.sleep(1000/n); } catch(Exception e) {}
		}
	}
}
