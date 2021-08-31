package printWriterDemo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PrintWriterDemo {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter out = new PrintWriter("emplyee.txt", "UTF-8");
		String name = "Harry Hacker";
		double salary = 75000;
		out.print(name);
		out.print(' ');
		out.println(salary);
		out.close();
	}

}
