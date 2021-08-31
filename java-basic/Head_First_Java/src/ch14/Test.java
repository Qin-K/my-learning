package ch14;
import java.io.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileReader fileReader = new FileReader("MyText.txt");
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
