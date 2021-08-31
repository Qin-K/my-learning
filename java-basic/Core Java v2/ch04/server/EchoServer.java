package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 一个简单的服务器程序 
 * @author Qin-Kai
 *
 */
public class EchoServer {

	public static void main(String[] args) throws IOException {
		// 建立server Socket
		try (ServerSocket s = new ServerSocket(8189)){
			// 等待客户客户端连接
			try (Socket incoming = s.accept()){
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				
				try (Scanner in = new Scanner(inStream, "gb2312")){
					PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "gb2312"), true);
					
					out.println("Hello! Enter BYE to exit.");
					
					// 打印客户端输入
					boolean done = false;
					while (!done && in.hasNext()) {
						String line = in.nextLine();
						out.println("Echo: " + line);
						if (line.trim().equals("BYE")) done = true;
					}
				}
			
			}
		}
			
	}

}
