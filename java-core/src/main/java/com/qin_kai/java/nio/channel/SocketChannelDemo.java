package com.qin_kai.java.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author qin kai
 * @date 2020/10/13
 */
public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("172.18.20.81", 8080));
        // SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("172.18.20.81", 8080));
        Scanner sc = new Scanner(System.in);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while ((socketChannel.read(byteBuffer)) > 0) { // 阻塞
            byte[] buf = new byte[byteBuffer.position()];
            byteBuffer.flip(); // 读
            byteBuffer.get(buf);
            System.out.println("收到消息: " + new String(buf, Charset.forName("gb2312")));
            byteBuffer.clear(); // 重新写
            ByteBuffer writeByteBuffer = ByteBuffer.allocate(1024);
            String input = sc.nextLine();
            writeByteBuffer.put(input.getBytes("gb2312"));
            writeByteBuffer.flip();
            socketChannel.write(writeByteBuffer);
        }
    }
}
