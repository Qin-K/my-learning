package Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FilesRead {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("myPath//test.txt");
		
		byte[] bytes = Files.readAllBytes(path);
		
		String content = new String(bytes, "UTF-8");
		System.out.println(content);
		
		// 将文件当做行序列读入 
		List<String> lines = Files.readAllLines(path);
		System.out.println(lines);
		
		// 向指定文件追加内容
		Files.write(path, content.getBytes("UTF-8"), StandardOpenOption.APPEND);
		
		Files.write(path, lines);
	}

}
