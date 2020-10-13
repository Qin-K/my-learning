package com.qin_kai.java.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

/**
 * @author qin kai
 * @Date 2020/10/12
 */
public class BufferDemo {
    public static void main(String[] args) {
        // 一、buffer 初始化
        // 1.allocate
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        IntBuffer intBuffer = IntBuffer.allocate(1024);
        LongBuffer longBuffer = LongBuffer.allocate(1024);

        // 2.wrap
        byte[] byteArr = new byte[1024];
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArr);

        // 二、buffer 填充/写 put
        byte b = 10;
        // 10
        byteBuffer.put(b);
        byteBuffer.put(1, b);
        printPosition(byteBuffer); // 1 指定 index put，position = index
        printBuffer(byteBuffer); // 10 10
        byte[] data = {1, 2, 3};
        byteBuffer.put(data);
        printBuffer(byteBuffer); // 10 1 2 3
        byteBuffer.put(data, 1, 2);
        printBuffer(byteBuffer); // 10 1 2 3 2 3
        // 常用从 channel 中获取数据到 buf 中，返回 num 为获取到的数据大小
        // int num = channel.read(buf);
        // 三、buffer 读取 get
        // 从写转化为读 limit = position, position = 0
        byteBuffer.flip();
        // 从当前 position 读取
        b = byteBuffer.get();
        System.out.println(b); // 10
        b = byteBuffer.get(2);
        System.out.println(b); // 2
        byte[] buf = new byte[3];
        byteBuffer.get(buf);
        printBuffer(byteBuffer); // 10 1 2 3 2 3
        // 常用
        // buffer 中的数据转换为字符串
        // new String(buffer.array()).trim();
        // 将写入的数据传到 Channel
        // int num = channel.write(buffer);

        // mark() 临时保存 position 的值
        byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put((byte) 1);
        byteBuffer.mark(); // mark = position
        // reset() 将 position 恢复到 mark 值
        byteBuffer.put((byte) 2);
        byteBuffer.reset();
        printPosition(byteBuffer);

        // rewind() 重置 position mark
        byteBuffer.rewind();
        printPosition(byteBuffer); // 0

        // clear() 重置buffer 不清空数据
        byteBuffer.clear();
        printBuffer(byteBuffer);

        // compact() 处理还没有读的数据，position-limit 之间的数据
        // 将这部分数据移动到数组左边，position 指向移动后的右边
        // byteBuffer 1 2
        byteBuffer.position(2);
        byteBuffer.flip();
        byteBuffer.get();
        byteBuffer.compact();
        printBuffer(byteBuffer); // 2 2
        printPosition(byteBuffer); // 1
    }

    private static void printBuffer(ByteBuffer byteBuffer) {
        System.out.print("buffer: ");
        for (byte b : byteBuffer.array()) {
            if (b == 0) {
                System.out.println();
                return;
            }
            System.out.print(b + " ");
        }
    }
    private static void printPosition(ByteBuffer byteBuffer) {
        System.out.println("position: " + byteBuffer.position());
    }

}
