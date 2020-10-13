package com.qin_kai.java.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author qin kai
 * @Date 2020/10/13
 */
public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(7000));
        Scanner sc = new Scanner(System.in);
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept(); // 阻塞
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            executorService.submit(() -> {
                try {
                    while (socketChannel.read(readBuffer) > 0) {
                        byte[] buf = new byte[readBuffer.position()];
                        readBuffer.flip();
                        readBuffer.get(buf);
                        System.out.println("收到消息：" + new String(buf, "gb2312"));
                        readBuffer.clear();
                        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                        writeBuffer.put(sc.nextLine().getBytes("gb2312"));
                        writeBuffer.flip();
                        socketChannel.write(writeBuffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
