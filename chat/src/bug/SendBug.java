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
	//该类用于在报错时提醒使用者
	private static String[] bug= {"发送失败，请从新发送","找不到该IP地址或主机名，请从新输入","套接字创建失败","数据报包创建失败","接收失败","输入字数太多，请分多次输入","找不到主机IP地址","发送内容不能为空"}; 
	
   public static void sendbug(int i) {
	Frame fr = null;
	Dialog dl=new Dialog(fr,"错误");
	   Label l=new Label(bug[i]);
	   
	   Button but=new Button("确定");
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
	 //鼠标监听，关闭该窗体
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
	   //窗体监听，用于关闭该窗体
	   dl.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dl.dispose();
			}});
	  
 }
}
