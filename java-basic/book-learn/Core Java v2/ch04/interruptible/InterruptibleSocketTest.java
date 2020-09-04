package interruptible;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;


public class InterruptibleSocketTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new InterruptibleSocketFrame();
			frame.setTitle("InterruptibleSocketTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
	
}

class InterruptibleSocketFrame extends JFrame{
	private Scanner in;
	private JButton interruptibleButton;
	private JButton blockingButton;
	private JButton cancelButton;
	private JTextArea messages;
	private TestServer server;
	private Thread connectThread;
	
	public InterruptibleSocketFrame() {
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		final int TEXT_ROWS = 20;
		final int TEXT_COLUMNS = 60;
		messages = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		add(new JScrollPane(messages));
		
		interruptibleButton = new JButton("Interruptible");
		blockingButton = new JButton("Blocking");
		
		northPanel.add(interruptibleButton);
		northPanel.add(blockingButton);
		
		interruptibleButton.addActionListener(event -> {
			interruptibleButton.setEnabled(false);
			blockingButton.setEnabled(false);
			cancelButton.setEnabled(true);
			connectThread = new Thread(() -> {
				try {
					connectInterruptibly();
				} catch (IOException e) {
					messages.append("\nInterruptibleSocketTest.connectInterruptibly: " + e);
				}
			});
			
			connectThread.start();
		
		});
		
		blockingButton.addActionListener(event -> {
			interruptibleButton.setEnabled(false);
			blockingButton.setEnabled(false);
			cancelButton.setEnabled(true);
			connectThread = new Thread(() -> {
				try {
					connectBlocking();
				} catch(IOException e) {
					messages.append("\nInterruptibleSocketTest.connectBlocking: " + e);
				}
			});
			connectThread.start();
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setEnabled(false);
		northPanel.add(cancelButton);
		cancelButton.addActionListener(event -> {
			connectThread.interrupt();
			cancelButton.setEnabled(false);
		});
		
		server = new TestServer();
		new Thread(server).start();
		pack();
	}
	/**
	 * 用interruptible I/O连接TestServer 
	 * @throws IOException 
	 */
	public void connectInterruptibly() throws IOException {
		messages.append("Interruptible:\n");
		try(SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.92.1", 8189))){
			in = new Scanner(channel, "UTF-8");
			while (!Thread.currentThread().isInterrupted()) {
				messages.append("Reading ");
				if (in.hasNextLine()) {
					String line = in.nextLine();
					messages.append(line);
					messages.append("\n");
				}
			}
		} finally {
			EventQueue.invokeLater(() -> {
				messages.append("Channel closed\n");
				interruptibleButton.setEnabled(true);
				blockingButton.setEnabled(true);
			});
		}
	}
	/**
	 * 通过blocking连接Test Server
	 * @throws IOException 
	 */
	public void connectBlocking() throws IOException {
		messages.append("Blocking:\n");
		try (Socket sock = new Socket("192.168.92.1", 8189)){
			in = new Scanner(sock.getInputStream(), "UTF-8");
			while (!Thread.currentThread().isInterrupted()) {
				messages.append("Reading ");
				if (in.hasNextLine()) {
					String line = in.nextLine();
					messages.append(line);
					messages.append("\n");
				}
			}
		} finally {
			EventQueue.invokeLater(() -> {
				messages.append("Socket closed\n");
				interruptibleButton.setEnabled(true);
				blockingButton.setEnabled(true);
			});
		}
	}


	class TestServer implements Runnable{
	
		@Override
		public void run() {
			try (ServerSocket s = new ServerSocket(8189)){
				while (true) {
					Socket incoming = s.accept();
					Runnable r = new TestServerHandler(incoming);
					Thread t = new Thread(r);
					t.start();
				}
			} catch(IOException e) {
				messages.append("\nTestServer.run: " + e);
			}
		}
		
	}
	
	class TestServerHandler implements Runnable{
		private Socket incoming;
		private int counter;
		
		public TestServerHandler(Socket i) {
			incoming = i;
		}
		@Override
		public void run() {
			try {
				try {
					OutputStream outStream = incoming.getOutputStream();
					PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"), true);
					while (counter < 100) {
						counter++;
						if (counter <= 10) out.println(counter);
						Thread.sleep(100);
					}
				} finally {
					incoming.close();
					messages.append("Closing server\n");
				}
			} catch (Exception e) {
				messages.append("\nTestServerHandler.run: " + e);
			}
		}
		
		
	}
}