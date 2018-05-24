package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import bug.SendBug;
import frame.ChatFrame;

public class Rece implements Runnable{
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * 该类用于接收聊天内容
	 * 使用UDP协议
	 * 继承了Runable，可实现多线程
	 */
	public void run() {
		
		  DatagramSocket ds = null;
		try {
			//创建指定端口的套接字
			ds = new DatagramSocket(5300);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			SendBug.sendbug(2);
		}
		//不停地循环接收数据
		while(true) {
	        byte[] buf=new byte[1024];
	        //创建数据报包
	        DatagramPacket dp=new DatagramPacket(buf,buf.length);
	        
	        try {
	        	//接收数据报包
				ds.receive(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				SendBug.sendbug(4);
			}
//	        String ip=dp.getAddress().getHostAddress();
	        //获取数据报包的内容
	        String text=new String(dp.getData(),0,dp.getLength());
//	        try {
//				if(!(InetAddress.getByName(Send.str).equals(InetAddress.getLocalHost())))
	        //将数据报包的内容用该方法显示到聊天界面
				ChatFrame.settf(text);
//			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	        }
		}
//	        ds.close();
}
