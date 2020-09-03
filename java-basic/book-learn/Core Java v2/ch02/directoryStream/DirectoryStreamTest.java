package directoryStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
/**
 * 遍历F盘下的所有目录
 * @author Qin-Kai
 *
 */
public class DirectoryStreamTest {
	
	public static void main(String[] args) throws IOException {
		Files.walkFileTree(Paths.get("F:\\"), new SimpleFileVisitor<Path>(){
			public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) {
				System.out.println(path);
				return FileVisitResult.CONTINUE;
			}
			
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
				return FileVisitResult.CONTINUE;
			}
			public FileVisitResult visitFileFailed(Path path, IOException exc) {
				return FileVisitResult.SKIP_SUBTREE;
			}
		}
	);
	}

}
