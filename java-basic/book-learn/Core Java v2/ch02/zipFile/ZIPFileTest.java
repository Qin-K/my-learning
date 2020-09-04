package zipFile;
import java.io.*;
import java.util.zip.*;


public class ZIPFileTest {

	public static void main(String[] args) throws IOException {
		// 写入zip
		FileOutputStream fout = new FileOutputStream("test.zip");
		ZipOutputStream zout = new ZipOutputStream(fout);
		for (int i = 1; i <= 10; i++) {
			ZipEntry ze = new ZipEntry(i + ".txt");
			zout.putNextEntry(ze); // 写出新文件
			zout.write(i);
			zout.closeEntry();
		}
		zout.close();
		
		// 读入zip
		ZipInputStream zin = new ZipInputStream(new FileInputStream("test.zip"));
		ZipEntry entry;
		while ((entry = zin.getNextEntry()) != null) {
			int i = zin.read();
			zin.closeEntry();
			System.out.println(i);
		}
		zin.close();
	}

}
