package ch15;
import java.io.*;
import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatClientA {

	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleChatClientA chatClient = new SimpleChatClientA();
		chatClient.go();
	}
	public void go() {
		// 建立GUI
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel = new JPanel();
		
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		
		setUpNetworking();
		
		frame.setSize(400, 500);
		frame.setVisible(true);
	}
	
	public void setUpNetworking() {
		// 建立客户端连接服务器发送数据
		try {
			sock = new Socket("192.168.92.1", 8080);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public class SendButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			// TODO Auto-generated method stub
			try {
				writer.println(outgoing.getText());
				writer.flush();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}
}
