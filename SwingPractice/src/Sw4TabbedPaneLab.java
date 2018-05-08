import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sw4TabbedPaneLab extends JFrame {
    public static void main(String argc[]) { new Sw4TabbedPaneLab();}
    Sw4TabbedPaneLab(){
        super("핵심 Java: TabbyPaneLab");
        JLabel cafe = new JLabel("핵심 Java 카페", SwingConstants.CENTER);
        getContentPane().add(cafe, "North");
        JTabbedPane tpane = new JTabbedPane(JTabbedPane.TOP);

        ImageIcon icon0 = new ImageIcon("icon-java.png");
        tpane.addTab("Java", null, new JLabel(icon0), "역시 JAVA... 공부하자!");

        ImageIcon icon1 = new ImageIcon("cappuccino.JPG");
        tpane.addTab("Cappuccino", null, new JLabel(icon1), "따사로움을 찾...");

        ImageIcon icon2= new ImageIcon("americano.JPG");
        tpane.addTab("Americano", null, new JLabel(icon2), "한잔의 여유를");

        ImageIcon icon3 = new ImageIcon("latte.jpg");
        tpane.addTab("Latte",  null, new JLabel(icon3), "함께하는 낭만을!");

        tpane.addTab("slider", null, new SimplySlider(JSlider.VERTICAL), "slider");

        JPanel pan = new JPanel(null);
        pan.setBackground(Color.WHITE);
        DrawingArea drawpan = new DrawingArea();
        pan.add(drawpan);

        tpane.addTab("my Space", null, pan, "마음을 채우라!");

        getContentPane().add(tpane, "Center");
        setSize(420, 350); setVisible(true);
    }
}
