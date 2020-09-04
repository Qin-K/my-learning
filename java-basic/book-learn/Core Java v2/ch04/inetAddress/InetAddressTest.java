package inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取主机的因特网地址
 * @author Qin-Kai
 *
 */
public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		if (args.length > 0) {
			String host = args[0];
			InetAddress[] address = InetAddress.getAllByName(host);
			for (InetAddress a : address) {
				System.out.println(a);
			}
		} else {
			InetAddress localHostAddress = InetAddress.getLocalHost();
			System.out.println(localHostAddress);
		}
	}

}
