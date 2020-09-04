package ch14;

import java.io.*;

public class WriteAFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter writer = new FileWriter("Foo.txt");
			writer.write("hello I'm FileWriter");
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
