package bug;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import frame.FrameDemo;


public class SendBug {
	//���������ڱ���ʱ����ʹ����
	private static String[] bug= {"����ʧ�ܣ�����·���","�Ҳ�����IP��ַ�������������������","�׽��ִ���ʧ��","���ݱ�������ʧ��","����ʧ��","��������̫�࣬��ֶ������","�Ҳ�������IP��ַ","�������ݲ���Ϊ��"}; 
	
   public static void sendbug(int i) {
	Frame fr = null;
	Dialog dl=new Dialog(fr,"����");
	   Label l=new Label(bug[i]);
	   
	   Button but=new Button("ȷ��");
	   dl.setBounds(500,200,500, 200);
	   dl.setLayout(new FlowLayout());
//	 fr.add(l);
//	 fr.add(but);
	 dl.add(l);
	 dl.add(but);
	 dl.setVisible(true);
	 /*fr.setSize(500,350);
	 fr.setLocation(500, 200);
	 fr.setLayout(new FlowLayout());
	 fr.setVisible(true);*/
	 //���������رոô���
	   but.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if((e.getButton()==MouseEvent.BUTTON1))
				dl.dispose();
		}
		   
	   });
	   but.addKeyListener(new KeyAdapter() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			
				dl.dispose();
				
		}
		   
	   });
	   //������������ڹرոô���
	   dl.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dl.dispose();
			}});
	  
 }
}
