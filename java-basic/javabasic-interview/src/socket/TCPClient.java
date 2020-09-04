package socket;

import java.io.*;
import java.net.Socket;

/**
 * @author Qin Kai
 * @date 2019-11-10
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 65000);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            os.write("hello world".getBytes());
            byte[] buff = new byte[1024];
            int len = is.read(buff);
            System.out.println(new String(buff, 0, len));
            is.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
