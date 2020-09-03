package accessDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AccessDirectoryTest {
	public static void main(String[] args) throws IOException {
		Path source = Paths.get("myPath");
		Path target = Paths.get("copy");
		
		Files.walk(source).forEach(p -> {
			try {
				Path q = target.resolve(source.relativize(p));
				System.out.println(q);
				if (Files.isDirectory(p)) {
					Files.createDirectory(q);
				} else {
					Files.copy(p, q);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	}
}
