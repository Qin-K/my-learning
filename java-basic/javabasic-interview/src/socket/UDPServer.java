package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Qin Kai
 * @date 2019-11-10
 */
public class UDPServer {
    public static void main(String[] args) throws Exception {
        // 创建UDP Socket
        DatagramSocket socket = new DatagramSocket(65001);
        byte[] buff = new byte[1024];
        // 接受的packet
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        socket.receive(packet);
        // 解析客户端发来的数据
        byte[] data = packet.getData();
        String content = new String(data, 0, packet.getLength());
        System.out.println(content);

        // 返回数据给客户端，packet中包含客户端的地址和端口信息
        packet.setData(String.valueOf(content.length()).getBytes());
        socket.send(packet);
    }
}
