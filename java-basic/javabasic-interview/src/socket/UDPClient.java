package socket;

import java.io.IOException;
import java.net.*;

/**
 * @author Qin Kai
 * @date 2019-11-10
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        // 创建udp socket
        DatagramSocket socket = new DatagramSocket();
        // 发送的数据的byte数组
        byte[] send = "hello world".getBytes();
        // 发送的数据封装到packet中，设置服务器端的地址和端口
        DatagramPacket packet = new DatagramPacket(send,send.length);
        packet.setAddress(InetAddress.getByName("127.0.0.1"));
        packet.setPort(65001);
        // 发送数据包
        socket.send(packet);

        // 接受数据
        socket.receive(packet);
        String content = new String(packet.getData(), 0, packet.getLength());
        System.out.println(content);
    }
}
