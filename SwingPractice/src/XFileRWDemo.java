package practice;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;

public class XFileRWDemo extends JFrame implements ActionListener {
	JTextArea tarea; JButton loadbtn, savebtn; JFileChooser fchooser;
	
	public XFileRWDemo() { super("Lab.X File Reader/Writer");
	
		tarea = new JTextArea("", 10, 50);			// �ؽ�Ʈ���� ����
		JScrollPane spane = new JScrollPane(tarea);	// ��ũ���ҿ� ����
		getContentPane().add(spane,  "Center");		// �������ҿ� ��ũ���� ����
		
		loadbtn = new JButton("Load");				// Load�� ���� ��ư ����
		savebtn = new JButton("Save");
		loadbtn.addActionListener(this);			// �׼Ǹ����� �߰�
		savebtn.addActionListener(this);
		JPanel pan = new JPanel(); pan.add(loadbtn);// �гθ���� ��ư�� ����
		pan.add(savebtn);
		getContentPane().add(pan,  "South");		// �������ҿ� �г� ����
		
		// ����Ȯ���� ��������(txt, java ���ϸ� �а���)
		FileNameExtensionFilter fxfilter = new FileNameExtensionFilter("Text Files: txt, java", "txt", "java");
		fchooser = new JFileChooser();				// ���ϼ��ñ� ����
		fchooser.setFileFilter(fxfilter);			// ���ϼ��ñ⿡ ����Ȯ�������� ����
		
		setSize(500, 400); setVisible(true);
	}
	public static void main(String[] args) {
		new XFileRWDemo();
	}
	public void actionPerformed(ActionEvent e) {
		// �̺�Ʈ�� �ҽ��� load��ư�̶��
		if(e.getSource()== loadbtn) {
			int fc_result = fchooser.showOpenDialog(tarea);
			if(fc_result == JFileChooser.APPROVE_OPTION) {
				// ���ϼ��ñ�κ��� ������ ������ ������ ����
				File file = fchooser.getSelectedFile();
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					tarea.setText("");				// ȭ�� clear 
					String line;					// input buffer
					while((line = br.readLine()) != null) {
						tarea.append(line + "\n");
					}
					br.close();
				}catch(IOException ex) {}
				
				
			}
		}
		else if(e.getSource()== savebtn) {
			int fc_result = fchooser.showSaveDialog(tarea);
			if(fc_result == JFileChooser.APPROVE_OPTION) {
				File file = fchooser.getSelectedFile();
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					bw.write(tarea.getText());
					bw.flush();
					bw.close();
				}catch(IOException ex) {}
			}
		}
	}
}
