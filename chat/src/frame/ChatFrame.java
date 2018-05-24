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
	/*该类实现了聊天界面
	 * 
	 */
	static int b=0;
	//该方法用于将接收到的数据显示在tf内
	public static void settf(String str) {
		tf.append(str);
	}
//创建fr，tf，tf1，but组件，并将后三者加入了fr中， 并实现了各组件的初始化
	static Frame fr=new Frame("my QQ");
	static TextArea tf=new TextArea("",30,50,TextArea.SCROLLBARS_VERTICAL_ONLY);
	static TextField tf1=new TextField(50);
	static Button but=new Button("发送");
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
		//检测键入内容是否过长
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
		//窗体监听，用于关闭系统
	fr.addWindowListener(new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}});
	//为tf1添加键盘监听，摁enter时显示聊天内容，并将该内容发送出去
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
//					设置发送格式
					text=("         "+tf1.getText()+"\n");
					if(text.length()>56)
						text=("         "+tf1.getText()+"\n").substring(0,57)+"\n"+("         "+tf1.getText()+"\n").substring(57);
//					该循环只执行一次，为了确保在输入过多时不会执行发送命令
					for(int i=1;i==1;i++) {
						if((InetAddress.getByName(Send.str).getHostName()+"\n"+text).getBytes().length>1024)
							{SendBug.sendbug(5);
						    break;}
//						输入为空时，不会发送
						if(tf1.getText().equals(""))
						{
							SendBug.sendbug(7);
							break;
						}
//					如果要发送到的IP地址并非本地主机，则将发送内容显示在tf中，否则只是发送，不显示
					if(!(InetAddress.getByName(Send.str).equals(InetAddress.getLocalHost())))
						tf.append(InetAddress.getByName(Send.str).getHostName() +"\n"+text);
					Send.send(InetAddress.getByName(Send.str).getHostName() +"\n"+text);
					a=1;
					//tf1清空
					tf1.setText("");
				}}
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				SendBug.sendbug(6);
			}
			
			
		}});
	//为but添加鼠标监听，作用同上
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
