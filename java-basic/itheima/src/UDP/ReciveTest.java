package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * DatagramSocket基于UDP接收数据
 * @author Qin-Kai
 *
 */
public class ReciveTest {
	public static void main(String[] args) throws IOException {
		// 创建DatagramSocket
		DatagramSocket reciveSocket = new DatagramSocket(8888);
		
		// 创建用于接受的DatagramPacket
		byte[] bys = new byte[1024];
		DatagramPacket p = new DatagramPacket(bys, bys.length);
		// 接收数据
		reciveSocket.receive(p);
		// 解析数据
		String recive = new String(p.getData());
		InetAddress address = p.getAddress();
		// 输出打印数据
		System.out.println("sender ---> " + address.getHostAddress());
		System.out.println(recive);
	}
}
