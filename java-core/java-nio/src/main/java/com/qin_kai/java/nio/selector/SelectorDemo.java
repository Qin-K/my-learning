package com.qin_kai.java.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * selector 方法
 *
 * select()
 * 调用此方法，会将上次 select 之后的准备好的 channel 对应的 SelectionKey 复制到 selected set 中。
 * 如果没有任何通道准备好，这个方法会阻塞，直到至少有一个通道准备好。
 *
 * selectNow()
 * 功能和 select 一样，区别在于如果没有准备好的通道，那么此方法会立即返回 0。
 *
 * select(long timeout)
 * 看了前面两个，这个应该很好理解了，如果没有通道准备好，此方法会等待一会
 *
 * wakeup()
 * 这个方法是用来唤醒等待在 select() 和 select(timeout) 上的线程的。如果 wakeup() 先被调用，
 * 此时没有线程在 select 上阻塞，那么之后的一个 select() 或 select(timeout) 会立即返回，而不会阻塞，当然，它只会作用一次。
 *
 * @author qin kai
 * @Date 2020/10/13
 */
public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("172.18.20.81", 8080));
        socketChannel.configureBlocking(false);
        // 第二个参数是监听的事件类型，通过二进制或可以来指定多个时间
        // SelectionKey.OP_READ(1 << 0)，SelectionKey.OP_WRITE(1 << 2)，electionKey.OP_CONNECT(1 << 3)，SelectionKey.OP_ACCEPT(1 << 4)
        socketChannel.register(selector, SelectionKey.OP_READ);
        while (true) {
            // 表示的含义应该是 selectedKeys 对应的集合，是否发生改变（有新得事件准备好）
//             int readyChannels = selector.select(); // 阻塞
            int readyChannels = selector.selectNow(); // 立即返回
            if (readyChannels == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey selectionKey : selectionKeys) {
                if (selectionKey.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                    System.out.println("a connection was accepted by a ServerSocketChannel.");
                }

                if (selectionKey.isConnectable()) {
                    // a connection was established with a remote server.
                    System.out.println("a connection was established with a remote server.");
                }

                if (selectionKey.isReadable()) {
                    // a channel is ready for reading
                    System.out.println("a channel is ready for reading");
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    socketChannel.read(byteBuffer);
                    byte[] buf = new byte[byteBuffer.position()];
                    byteBuffer.flip(); // 读
                    byteBuffer.get(buf);
                    System.out.println("收到消息: " + new String(buf, Charset.forName("gb2312")));
                    byteBuffer.clear(); // 重新写
                    ByteBuffer writeByteBuffer = ByteBuffer.allocate(1024);
                    writeByteBuffer.put("hello ".getBytes("gb2312"));
                    writeByteBuffer.flip();
                    socketChannel.write(writeByteBuffer);
                }

                if (selectionKey.isWritable()) {
                    // a channel is ready for writing
                    System.out.println("a channel is ready for writing");
                }
            }
            // 注意将 selectionKeys 清空
            selectionKeys.clear();
        }
    }
}
