
import javax.swing.*;
import java.awt.event.*;

public class Sw2ButtonLabel extends JFrame{
    JLabel label;
    ImageIcon iicon[];
    String bunActCmd[] = {"Yes", "No"};
    JButton btn[];

    class MyButtonWorker implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JButton jb = (JButton) e.getSource();
            System.out.println(jb.getActionCommand());
        }
    }

    Sw2ButtonLabel(){
        super("제목");
        iicon = new ImageIcon[3];
        iicon[0] = new ImageIcon("reset.jpg");
        label = new JLabel(iicon[0]);
        getContentPane().add(label, "Center");
        // a listener
        MyButtonWorker blisner = new MyButtonWorker();
        System.out.println(blisner);
        // 2 button
        JPanel pan = new JPanel();
        btn = new JButton[2];

        iicon[1] = new ImageIcon("yes.png");
        iicon[2] = new ImageIcon("no.png");
        btn[0] = new JButton("Yes",iicon[1]);
        btn[1] = new JButton("No",iicon[2]);
        btn[0].addActionListener(blisner);
        btn[1].addActionListener(blisner);

        pan.add(btn[0]);
        pan.add(btn[1]);

        getContentPane().add(pan, "South");
        // render it all
        setVisible(true);
        pack();
        this.setMinimumSize(getMinimumSize());
    }
    // listener
    public static void main(String[] args){
        new Sw2ButtonLabel();
    }
}
