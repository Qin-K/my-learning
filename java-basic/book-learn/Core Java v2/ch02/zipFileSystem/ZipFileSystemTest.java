package zipFileSystem;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 遍历zip文件中所有文件
 * @author Qin-Kai
 *
 */
public class ZipFileSystemTest {

	public static void main(String[] args) throws IOException {
		FileSystem fs = FileSystems.newFileSystem(Paths.get("Test.zip"), null);
		Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>() {
			public FileVisitResult visitFile(Path File, BasicFileAttributes attrs) {
				System.out.println(File);
				return FileVisitResult.CONTINUE;
			}
		});
	}

}
