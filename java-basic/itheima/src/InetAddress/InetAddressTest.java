package InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		// InetAddress address = InetAddress.getByName("Qin-Kai");
		InetAddress address = InetAddress.getByName("192.168.92.1");
		String hostAdress = address.getHostAddress();
		String hostName = address.getHostName();
		
		System.out.println(hostAdress);
		System.out.println(hostName);
		System.out.println(address);
	}
}
