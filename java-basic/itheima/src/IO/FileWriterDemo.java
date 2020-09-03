package IO;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("d:\\a.txt");
		
		// 写一个字符串数据
		fw.write("IO流你好");
		// 数据没有直接写到文件，写到了内存缓存区，用flush刷新
		fw.flush();
		
		fw.close();
	}
}
