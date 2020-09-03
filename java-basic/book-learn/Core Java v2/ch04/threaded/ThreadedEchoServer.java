package threaded;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 实现多个客户端连接的服务器
 * @author Qin-Kai
 *
 */
public class ThreadedEchoServer {

	public static void main(String[] args) throws IOException {
		try (ServerSocket s = new ServerSocket(8189)){
			int i = 1; // 统计客户端是第几个连接
			
			while (true) {
				Socket incoming = s.accept();
				System.out.println("Spawning " + i);
				Runnable r = new ThreadedEchoHandler(incoming);
				Thread t = new Thread(r);
				t.start();
				i++;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class ThreadedEchoHandler implements Runnable {
	private Socket incoming;
	
	public ThreadedEchoHandler(Socket incomingSocket) {
		incoming = incomingSocket;
	}
	
	public void run() {
		try (InputStream instream = incoming.getInputStream();
			 OutputStream outstream = incoming.getOutputStream()){
			Scanner in = new Scanner(instream, "UTF-8");
			PrintWriter out = new PrintWriter(new OutputStreamWriter(outstream, "UTF-8"), true/* autoFlush*/);
			out.println("Hello! Enter BYE to exit.");
			boolean done = false;
			while (!done && in.hasNextLine()) {
				String line = in.nextLine();
				out.println("Echo: " + line);
				if (line.trim().equals("BYE"))
					done = true;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
