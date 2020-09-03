package xml.text;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathTest {
	public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read("src/xml/stus.xml");
			// 获取根元素 
			Element rootElement = document.getRootElement();
			
			Element nameElement = (Element) rootElement.selectSingleNode("//name");
			List<Element> elements = rootElement.selectNodes("//name");
			for (Element element : elements) {
				System.out.println(element.getText());
			}
			System.out.println(nameElement.getText());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
