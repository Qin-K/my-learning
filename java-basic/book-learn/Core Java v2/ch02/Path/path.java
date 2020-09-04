package Path;
import java.nio.file.Path;
import java.nio.file.Paths;

public class path {

	public static void main(String[] args) {
		Path p = Paths.get("myPath");
		
		/*Path tempPath = p.resolveSibling("temp");
		System.out.println(tempPath = tempPath.toAbsolutePath());
		System.out.println(tempPath.getParent());*/
		
	}

}
