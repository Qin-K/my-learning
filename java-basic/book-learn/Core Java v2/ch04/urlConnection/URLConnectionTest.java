package urlConnection;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;
/**
 * 获取URL的消息头和资源信息
 * @author Qin-Kai
 *
 */
public class URLConnectionTest {

	public static void main(String[] args) {
		try {
		String urlName;
		Scanner input = new Scanner(System.in);
		urlName = input.nextLine();
		URL url = new URL(urlName);
		URLConnection connection = url.openConnection();
		
		connection.connect();
		
		// 获取并打印反应头
		
		Map<String, List<String>> headers = connection.getHeaderFields();// 获取储存反应头
		for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
			String key = entry.getKey();
			for (String value : entry.getValue()) {
				System.out.println(key + ":" + value);
			}
		}
		// print convenience functions
		
		System.out.println("-------");
		System.out.println("getContentType: " + connection.getContentType());
		System.out.println("getContentLength: " + connection.getContentLength());
		System.out.println("getContentEncoding: " + connection.getContentEncoding());
		System.out.println("getDate: " + connection.getDate());
		System.out.println("getExpriation: " + connection.getExpiration());
		System.out.println("getLastModifed: " + connection.getLastModified());
		
		String encoding = connection.getContentEncoding();
		
		if (encoding == null) encoding = "UTF-8";
		try (Scanner in = new Scanner(connection.getInputStream(), encoding)){
			// 打印内容的前十行
			
			for (int n = 1; in.hasNextLine() && n <= 10; n++) {
				System.out.println(in.nextLine());
			}
			if (in.hasNextLine()) System.out.println("...");
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
