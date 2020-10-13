package com.qin_kai.java.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author qin kai
 * @Date 2020/10/13
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        String path = "E:\\data.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        FileChannel fileInputChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuilder sb = new StringBuilder();
        // channel 读，对于 buffer 来说是写
        while (fileInputChannel.read(byteBuffer) != -1) {
            sb.append(new String(byteBuffer.array()));
        }
        System.out.println(sb.toString());
        // channel 写，对于 buffer 来说是读
        byteBuffer.clear();
        byteBuffer.put("123".getBytes());
        byteBuffer.flip(); // 切换为读的模式
        System.out.println(new String(byteBuffer.array()));
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        FileChannel fileOutputChannel = fileOutputStream.getChannel();
        fileOutputChannel.write(byteBuffer);
        fileOutputChannel.close();
        fileOutputStream.close();
        fileInputChannel.close();
        fileInputStream.close();
    }
}
