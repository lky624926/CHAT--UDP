package frame;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import bug.SendBug;
import chat.Rece;
import chat.Send;

public class FrameDemo {
	/*该类实现了输入IP地址界面呢
	 * 
	 */

	public static void framedemo() {
		/*创建fr，tf，but，l组件，并将后三者加入了fr中
		 * 并实现了各组件的初始化
		 * 
		 */
Frame fr=new Frame("my QQ");
fr.setSize(500,350);
fr.setLocation(500, 200);
fr.setLayout(new FlowLayout());
fr.setVisible(true);
TextField tf=new TextField(35);
Button but=new Button("确定");
Label l=new Label("请输入对方的主机名或IP地址");
fr.add(l);
fr.add(tf);
fr.add(but);
//为tf添加键盘监听，摁enter时，将tf内容传给str
tf.addKeyListener(new KeyAdapter() {

	@Override
	public void keyReleased(KeyEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
//			检测主机名是否正确
		{for(int i=1;i==1;i++)
		{try {
			InetAddress ia=InetAddress.getByName(tf.getText());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			SendBug.sendbug(1);
			break;
		}
		Send.str=tf.getText();
		fr.dispose();
		ChatFrame.chatframe();
//    new Thread(new Send()).start();
		new Thread(new Rece()).start();
		}}
//		为何不能这样写，不懂？？？？？？？？？？？？？
/*			{try {
				InetAddress ia=InetAddress.getByName(Send.str);
				Send.str=tf.getText();
				//打开聊天界面
				ChatFrame.chatframe();
//		new Thread(new Send()).start();
				//启动接收线程
				new Thread(new Rece()).start();
				//关闭输入IP地址界面
				fr.dispose();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				SendBug.sendbug(1);
				tf.setText("");
			}
		}*/
	}});
//给but添加鼠标监听事件，作用同上
but.addMouseListener(new MouseAdapter(){

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if((e.getButton()==MouseEvent.BUTTON1))
/*			为何报错后后面的代码还会执行，不懂????????????
			{try {
					InetAddress ia=InetAddress.getByName(tf.getText());
				Send.str=tf.getText();
				fr.dispose();
				ChatFrame.chatframe();
//		    new Thread(new Send()).start();
				new Thread(new Rece()).start();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				SendBug.sendbug(1);
				tf.setText("");
			}
		   }
	}
	
});*/
			{for(int i=1;i==1;i++)
			{try {
				InetAddress ia=InetAddress.getByName(tf.getText());
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				SendBug.sendbug(1);
				break;
			}
			Send.str=tf.getText();
			fr.dispose();
			ChatFrame.chatframe();
//	    new Thread(new Send()).start();
			new Thread(new Rece()).start();
			}}
	}});
//添加窗体监听事件，点关闭按钮时系统结束
fr.addWindowListener(new WindowAdapter() {

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}});
	}

}
