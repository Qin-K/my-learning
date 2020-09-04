package xml.text;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {
	public static void main(String[] args) {
		
		try {
			// 创建sax读取对象
			SAXReader reader = new SAXReader();
			
			// 指定解析的xml源
			Document document = reader.read(new File("src/xml/stus.xml"));
			
			// 得到元素, 得到根元素
			Element rootElement = document.getRootElement();
			
			// String name = rootElement.element("stu").element("name").getText();
			// 获取根元素下面的所有子元素, stu元素
			List<Element> elements = rootElement.elements();
			
			// 遍历打印所有数据
			for (Element element : elements) {
				String name = element.element("name").getText();
				int age = Integer.parseInt(element.element("age").getText());
				System.out.println("name:" + name + "  age:" + age);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
