package match;
import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.regex.*;

/**
 * 定位一个Web页面上的所有超文本引用，并打印他们。
 * @author Qin-Kai
 *
 */
public class HrefMatch {

	public static void main(String[] args) {
		try {
			String urlString;
			if (args.length > 0) urlString = args[0];
			else urlString = "http://www.qq.com";
			
			// 打开Reader for URL
			InputStreamReader in = new InputStreamReader(new URL(urlString).openStream(), StandardCharsets.UTF_8);
			
			// 读取内容到stringBuilder
			StringBuilder input = new StringBuilder();
			int ch;
			while ((ch = in.read()) != -1) {
				input.append((char)ch);
			}
			
			// 匹配所有的文本
			String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
			Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(input);
			
			while (matcher.find()) {
				String match = matcher.group();
				System.out.println(match);
			}
			
		} catch(IOException | PatternSyntaxException e) {
			e.printStackTrace();
		}
	}

}
