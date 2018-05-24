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
	 * �������ڽ�����������
	 * ʹ��UDPЭ��
	 * �̳���Runable����ʵ�ֶ��߳�
	 */
	public void run() {
		
		  DatagramSocket ds = null;
		try {
			//����ָ���˿ڵ��׽���
			ds = new DatagramSocket(5300);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			SendBug.sendbug(2);
		}
		//��ͣ��ѭ����������
		while(true) {
	        byte[] buf=new byte[1024];
	        //�������ݱ���
	        DatagramPacket dp=new DatagramPacket(buf,buf.length);
	        
	        try {
	        	//�������ݱ���
				ds.receive(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				SendBug.sendbug(4);
			}
//	        String ip=dp.getAddress().getHostAddress();
	        //��ȡ���ݱ���������
	        String text=new String(dp.getData(),0,dp.getLength());
//	        try {
//				if(!(InetAddress.getByName(Send.str).equals(InetAddress.getLocalHost())))
	        //�����ݱ����������ø÷�����ʾ���������
				ChatFrame.settf(text);
//			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	        }
		}
//	        ds.close();
}
