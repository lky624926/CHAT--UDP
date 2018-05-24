package chat;

import java.io.IOException;

import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import bug.SendBug;
import frame.ChatFrame;

import java.io.BufferedReader;

public class Send  implements Runnable {
	/*该类用于发送聊天内容
	 * 使用UDP协议
	 * 继承了Runable，可实现多线程
	 */
	//str表示发送对象的主机名或IP地址
	public static String str=null;
	static byte[] buf = new byte[1024];
//	public static String str="AUTOBVT-Q60SUFE";
//	static byte[] buf= {56};
	//该方法用于接收从聊天界面获取的准备要发送的内容
		public static void send(String str) {
			//将内容转成byte型
			buf=str.getBytes();
			ChatFrame.a=0;
			//启动发送线程
			new Thread(new Send()).start();
		}
//		覆盖Runable的run方法
	public void run() {
		//创建ds套接字
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			SendBug.sendbug(2);
		}
		
//			while (!(new String(buf).equals( new String(new byte[1024])))) {
//				if (buf.equals("over")) {
//					System.out.println("");
//				break;}
				
//创建数据报包
				DatagramPacket dp = null;
				try {
					dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(str), 5300);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
								}
				//发送数据
				try {
					ds.send(dp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					SendBug.sendbug(0);
				}
				
//			}
		
//关闭套接字
		ds.close();

	}
}