package ch15;
import java.io.*;
import java.net.*;

public class DailyAdviceServer {

	String[] adviceList = {
			"Take smaller bites",
			"Go for the tight jeans.No they do NOT make you look fat.",
			"One word: inappropriate",
			"Just for today, be honest. Tell your boss what you *really* think",
			"You Might want to rethink that haircut."
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
	public void go() {
		try {
			ServerSocket serverSock = new ServerSocket(5000);
			
			while (true) {
				Socket sock = serverSock.accept();
				
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	private String getAdvice() {
		int random = (int)(Math.random()*adviceList.length);
		return adviceList[random];
	}

}
