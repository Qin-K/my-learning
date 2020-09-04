package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Qin Kai
 * @date 2019-11-10
 */
public class TCPServer {

    private static class MyThread extends Thread {

        private Socket socket;

        public MyThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                byte[] buff = new byte[1024];
                int len = is.read(buff);
                String s = new String(buff, 0, len);
                System.out.println(s);
                os.write(String.valueOf(s.length()).getBytes());
                is.close();
                os.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(65000);
            while (true) {
                Socket socket = ss.accept();
                new MyThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
