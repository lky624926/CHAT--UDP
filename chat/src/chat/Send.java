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
	/*�������ڷ�����������
	 * ʹ��UDPЭ��
	 * �̳���Runable����ʵ�ֶ��߳�
	 */
	//str��ʾ���Ͷ������������IP��ַ
	public static String str=null;
	static byte[] buf = new byte[1024];
//	public static String str="AUTOBVT-Q60SUFE";
//	static byte[] buf= {56};
	//�÷������ڽ��մ���������ȡ��׼��Ҫ���͵�����
		public static void send(String str) {
			//������ת��byte��
			buf=str.getBytes();
			ChatFrame.a=0;
			//���������߳�
			new Thread(new Send()).start();
		}
//		����Runable��run����
	public void run() {
		//����ds�׽���
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
				
//�������ݱ���
				DatagramPacket dp = null;
				try {
					dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(str), 5300);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
								}
				//��������
				try {
					ds.send(dp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					SendBug.sendbug(0);
				}
				
//			}
		
//�ر��׽���
		ds.close();

	}
}