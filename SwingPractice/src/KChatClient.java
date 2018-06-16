package Chat;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;


public class KChatClient extends JApplet implements Runnable, ActionListener {
      DataInputStream  is;		// stream
      DataOutputStream  os;		// stream
      JTextField  login, typein;		// for text input
      JTextArea  ta;			// for text output
//   Cvas cvas;			// for sketching
      JPanel portal, chatroom;		// two cards
      CardLayout cardm;		// card layout manager

      public void init()  {
	setGUIcards();
	setLayout(cardm = new CardLayout());
	add (portal, "card-login");			// card-1
	add (chatroom, "card-chat");			// card-2
	cardm.show (this.getContentPane(), "card-login");	// show the 1st card
      }
      void setGUIcards() {
	portal = new JPanel(new BorderLayout());		// card-1
	portal.add(new JLabel(new ImageIcon("Americano.jpg")), "Center");  // 1-1
	JPanel logpan = new JPanel();
	  login = new JTextField(20);
	  login.addActionListener(this);
	  logpan.add(new JLabel("이름 ")); logpan.add(login);  // 1-2.a, 1-2.b
	portal.add(logpan, "South");

	chatroom = new JPanel(new BorderLayout());  	// card-2
	typein = new JTextField();
	typein.addActionListener(this);
	chatroom.add(typein, "South");	// 2-2

	ta = new JTextArea(14, 25*1);
	ta.setBackground(new Color(220,255,255));
	ta.setEditable(false);
	ta.setLineWrap(true);
	JScrollPane spane = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	chatroom.add(spane, "Center");  // 2-1 (-> replace it with a dual interface)
	//- dual design here - 7+
      }

//+ class Cvas

      public static void main(String args[]) {
	KChatClient chatter = new KChatClient();
	chatter.init();
	chatter.start();
	JFrame f = new JFrame("Lab XI. CafeGaggle");
	f.getContentPane().add(chatter);
	f.pack(); f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      public void start() {
	System.out.println("* Thread starting *");
	(new Thread (this)).start();	// threading (서버 메시지를 받는)
      }

      public void run() {
	System.out.println("run: ... 카페 문 똑똑 ...");
	try {
		// 서버접속(create a Socket) & IO stream 두개 만들기
		Socket sock = new Socket("localhost", 2000);
		is = new DataInputStream(new BufferedInputStream(sock.getInputStream()));
		os = new DataOutputStream(new BufferedOutputStream(sock.getOutputStream()));
		execute();
	} catch (IOException e) { System.out.println("연결실패."); }
      }

      public void execute() {   // 서버에서 계속 오는 메시지를 받아서 출력한다.
          try {
		      while (true) {
			  // get msg from the server(thread) and display them -
		    	  String msg = is.readUTF();
		    	  ta.append(msg + "\n");
		      }
          } catch (IOException e) {} finally { System.out.println("stop"); }
      }

      String myname;
      public void actionPerformed (ActionEvent e) {
		Component c = (Component) e.getSource();
	
		// textfield 입력(이름, 채팅글)을 읽어서 서버로 보낸다.
		if ((JTextField) e.getSource() == login) {
		      myname = login.getText();
		      //System.out.println("login : " + myname + "인데요.");
		      try {
		    	  os.writeUTF(myname); os.flush();
		      } catch(IOException ioe) { System.out.println("Fail"); }
		      cardm.show(this.getContentPane(), "card-chat");
		      //ta.append(myname + " 입장!\n");
		      typein.requestFocus();
	//	      *focus* 
		}
		else {  //- 챗글 from typein -
			//ta.append(myname + ": "+ typein.getText() + " \n");
			
			try { os.writeUTF(typein.getText()); os.flush(); typein.setText(""); }
			catch(IOException ioe) {}
	    }
    } /* KChatClient */
}
