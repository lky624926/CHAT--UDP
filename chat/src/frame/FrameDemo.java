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
	/*����ʵ��������IP��ַ������
	 * 
	 */

	public static void framedemo() {
		/*����fr��tf��but��l��������������߼�����fr��
		 * ��ʵ���˸�����ĳ�ʼ��
		 * 
		 */
Frame fr=new Frame("my QQ");
fr.setSize(500,350);
fr.setLocation(500, 200);
fr.setLayout(new FlowLayout());
fr.setVisible(true);
TextField tf=new TextField(35);
Button but=new Button("ȷ��");
Label l=new Label("������Է�����������IP��ַ");
fr.add(l);
fr.add(tf);
fr.add(but);
//Ϊtf��Ӽ��̼�������enterʱ����tf���ݴ���str
tf.addKeyListener(new KeyAdapter() {

	@Override
	public void keyReleased(KeyEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
//			����������Ƿ���ȷ
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
//		Ϊ�β�������д��������������������������������
/*			{try {
				InetAddress ia=InetAddress.getByName(Send.str);
				Send.str=tf.getText();
				//���������
				ChatFrame.chatframe();
//		new Thread(new Send()).start();
				//���������߳�
				new Thread(new Rece()).start();
				//�ر�����IP��ַ����
				fr.dispose();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				SendBug.sendbug(1);
				tf.setText("");
			}
		}*/
	}});
//��but����������¼�������ͬ��
but.addMouseListener(new MouseAdapter(){

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if((e.getButton()==MouseEvent.BUTTON1))
/*			Ϊ�α�������Ĵ��뻹��ִ�У�����????????????
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
//��Ӵ�������¼�����رհ�ťʱϵͳ����
fr.addWindowListener(new WindowAdapter() {

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}});
	}

}
