import javax.swing.*;
import javax.swing.event.*; // for the event & listener of JSlider
import java.awt.*; // for BorderLayout
public class SimplySlider extends JPanel implements ChangeListener {
    public SimplySlider(int orient) {
        JSlider js = new JSlider(orient, 0, 100, 25);
        js.setMajorTickSpacing (50);
        js.setPaintTicks (true);
        js.addChangeListener(this);
        js.setMinorTickSpacing (10);
        js.setPaintLabels (true); // ��
        setLayout(new BorderLayout()); // <- default FlowLayout()
        add(js);
    }
    public void stateChanged(ChangeEvent e) {
        System.out.println(((JSlider)e.getSource()).getValue());
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame("�ٽ� Java: SimplySlider");
        jf.getContentPane().add (new SimplySlider(JSlider.VERTICAL));
        jf.getContentPane().add (new SimplySlider(JSlider.HORIZONTAL), "South");
        jf.setSize(300, 200);
        jf.setVisible(true);
    }
}