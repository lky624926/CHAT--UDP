package frame;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import bug.SendBug;
import chat.Send;

public class ChatFrame {
	/*����ʵ�����������
	 * 
	 */
	static int b=0;
	//�÷������ڽ����յ���������ʾ��tf��
	public static void settf(String str) {
		tf.append(str);
	}
//����fr��tf��tf1��but��������������߼�����fr�У� ��ʵ���˸�����ĳ�ʼ��
	static Frame fr=new Frame("my QQ");
	static TextArea tf=new TextArea("",30,50,TextArea.SCROLLBARS_VERTICAL_ONLY);
	static TextField tf1=new TextField(50);
	static Button but=new Button("����");
	static String text=null;
	public static int a=0;
	public static void chatframe() {
		tf.setEditable(false);
		fr.add(tf);
		fr.add(tf1);
		fr.add(but);
		fr.setVisible(true);
		fr.setLayout(new FlowLayout());
		fr.setBounds(500, 50, 600, 600);
		//�����������Ƿ����
	//loop:	for(int i=1;i==1;i++) {
		tf1.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				// TODO Auto-generated method stub
	/*			tf1.addKeyListener(new KeyAdapter() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
							break loop;
					}});*/
//		?		{if(b==0) {
				try {
					if((InetAddress.getByName(Send.str).getHostName() +"\n"+text).getBytes().length==1024)
						{SendBug.sendbug(5);}
				} catch (UnknownHostException e2) {
					// TODO Auto-generated catch block
				}
				
				}
//		?	}
//		?		}
		});
		//}
		//������������ڹر�ϵͳ
	fr.addWindowListener(new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}});
	//Ϊtf1��Ӽ��̼�������enterʱ��ʾ�������ݣ����������ݷ��ͳ�ȥ
	tf1.addKeyListener(new KeyAdapter() {
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		/*????	{if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
				{b=1;
				}else {
					b=0;
				}}*/
			
			try {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
//					���÷��͸�ʽ
					text=("         "+tf1.getText()+"\n");
					if(text.length()>56)
						text=("         "+tf1.getText()+"\n").substring(0,57)+"\n"+("         "+tf1.getText()+"\n").substring(57);
//					��ѭ��ִֻ��һ�Σ�Ϊ��ȷ�����������ʱ����ִ�з�������
					for(int i=1;i==1;i++) {
						if((InetAddress.getByName(Send.str).getHostName()+"\n"+text).getBytes().length>1024)
							{SendBug.sendbug(5);
						    break;}
//						����Ϊ��ʱ�����ᷢ��
						if(tf1.getText().equals(""))
						{
							SendBug.sendbug(7);
							break;
						}
//					���Ҫ���͵���IP��ַ���Ǳ����������򽫷���������ʾ��tf�У�����ֻ�Ƿ��ͣ�����ʾ
					if(!(InetAddress.getByName(Send.str).equals(InetAddress.getLocalHost())))
						tf.append(InetAddress.getByName(Send.str).getHostName() +"\n"+text);
					Send.send(InetAddress.getByName(Send.str).getHostName() +"\n"+text);
					a=1;
					//tf1���
					tf1.setText("");
				}}
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				SendBug.sendbug(6);
			}
			
			
		}});
	//Ϊbut���������������ͬ��
	but.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
			try {
				if(e.getButton()==MouseEvent.BUTTON1) {
					text=("         "+tf1.getText()+"\n");
					if(text.length()>56)
						text=("         "+tf1.getText()+"\n").substring(0,57)+"\n"+("         "+tf1.getText()+"\n").substring(57);
					for(int i=1;i==1;i++) {
						if((InetAddress.getByName(Send.str).getHostName() +"\n"+text).getBytes().length>1024)
							{SendBug.sendbug(5);
							break;
							}
						if(tf1.getText().equals(""))
						{
							SendBug.sendbug(7);
							break;
						}
					if(!(InetAddress.getByName(Send.str).equals(InetAddress.getLocalHost())))
						tf.append(InetAddress.getByName(Send.str).getHostName() +"\n"+text);
					Send.send(InetAddress.getByName(Send.str).getHostName() +"\n"+text);
					i=1;
					tf1.setText("");
				}}
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				SendBug.sendbug(6);
			}
		}});
}
}
