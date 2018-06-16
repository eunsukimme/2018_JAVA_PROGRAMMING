package practice;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;

public class XFileRWDemo extends JFrame implements ActionListener {
	JTextArea tarea; JButton loadbtn, savebtn; JFileChooser fchooser;
	
	public XFileRWDemo() { super("Lab.X File Reader/Writer");
	
		tarea = new JTextArea("", 10, 50);			// 텍스트영역 만듬
		JScrollPane spane = new JScrollPane(tarea);	// 스크롤팬에 붙임
		getContentPane().add(spane,  "Center");		// 콘텐츠팬에 스크롤팬 붙임
		
		loadbtn = new JButton("Load");				// Load라 적힌 버튼 만듬
		savebtn = new JButton("Save");
		loadbtn.addActionListener(this);			// 액션리스터 추가
		savebtn.addActionListener(this);
		JPanel pan = new JPanel(); pan.add(loadbtn);// 패널만들고 버튼을 붙임
		pan.add(savebtn);
		getContentPane().add(pan,  "South");		// 콘텐츠팬에 패널 붙임
		
		// 파일확장자 필터지정(txt, java 파일만 읽게함)
		FileNameExtensionFilter fxfilter = new FileNameExtensionFilter("Text Files: txt, java", "txt", "java");
		fchooser = new JFileChooser();				// 파일선택기 만듬
		fchooser.setFileFilter(fxfilter);			// 파일선택기에 파일확장자필터 지정
		
		setSize(500, 400); setVisible(true);
	}
	public static void main(String[] args) {
		new XFileRWDemo();
	}
	public void actionPerformed(ActionEvent e) {
		// 이벤트의 소스가 load버튼이라면
		if(e.getSource()== loadbtn) {
			int fc_result = fchooser.showOpenDialog(tarea);
			if(fc_result == JFileChooser.APPROVE_OPTION) {
				// 파일선택기로부터 지정된 파일을 선택한 파일
				File file = fchooser.getSelectedFile();
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					tarea.setText("");				// 화면 clear 
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
