package socket;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 * 链接到某个端口并打印所找到的信息
 * @author Qin-Kai
 *
 */
public class SocketTest {
	public static void main(String[] args) throws UncheckedIOException, IOException {
		try (Socket s = new Socket("time-a.nist.gov", 13);
			Scanner in = new Scanner(s.getInputStream(), "UTF-8")){

			while (in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
		}
	}
}
