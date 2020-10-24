package com.qin_kai.java.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author qin kai
 * @date 2020/10/13
 */
public class DatagramChannelDemo {
    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.bind(new InetSocketAddress(9000));
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        while (true) {
            SocketAddress socketAddress = datagramChannel.receive(readBuffer);
            byte[] buf = new byte[readBuffer.position()];
            readBuffer.flip();
            readBuffer.get(buf);
            System.out.println("收到消息：" + new String(buf, "gb2312"));
            readBuffer.clear();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("hello".getBytes("gb2312"));
            byteBuffer.flip();
            datagramChannel.send(byteBuffer, socketAddress);
        }
    }
}
