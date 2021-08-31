package halfClose;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 半关闭，一端可以终止其输出，同时仍旧可以接受来自另一端的输入
 * @author Qin-Kai
 *
 */
public class HalfCloseTest {
	public static void main(String[] args) throws UncheckedIOException, IOException {
		try (Socket s = new Socket("192.168.92.1", 8080);
			Scanner in = new Scanner(s.getInputStream(), "UTF-8")){
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println("我只能够接受数据不能够发送输入");
			// s.shutdownOutput();
			while (in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
		}
	}
}
