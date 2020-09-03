package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 使用DatagramSocket基于UDP发送数据
 * @author Qin-Kai
 *
 */
public class SendTest {

	public static void main(String[] args) throws IOException {
		// 创建DatagramSocket
		DatagramSocket sendSocket = new DatagramSocket();
		// 打包发送的数据
		// DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
		String s = "hello udp, I'm coming!";
		byte[] buf = s.getBytes();
		int length = buf.length;
		InetAddress address = InetAddress.getByName("192.168.92.1");
		int port = 8888;
		// 创建DatagramPacket对象
		DatagramPacket p = new DatagramPacket(buf, length, address, port);
		// 发送数据
		// void send(DatagramPacket p)  
		sendSocket.send(p);
		// 关闭
		sendSocket.close();
	}

}
