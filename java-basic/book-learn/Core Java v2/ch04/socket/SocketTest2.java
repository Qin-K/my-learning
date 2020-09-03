package socket;

import java.io.*;
import java.net.*;

/**
 * 链接到某个端口并写入
 * @author Qin-Kai
 *
 */
public class SocketTest2 {
	public static void main(String[] args) throws UncheckedIOException, IOException {
		try (Socket s = new Socket("192.168.92.1", 8080);
			OutputStream out = s.getOutputStream()){
				byte[] bytes = "hello".getBytes();
				out.write(bytes);
			}
		}
}

