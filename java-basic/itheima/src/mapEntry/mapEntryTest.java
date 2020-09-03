package mapEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 通过Map.entry内部类对map进行遍历
 * @author Qin-Kai
 *
 */
public class mapEntryTest {

	public static void main(String[] args) {
		// 创建map
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "一");
		map.put("2", "二");
		map.put("3", "三");
		
		// 获取所有entry对象
		Set<Map.Entry<String, String>> entrys = map.entrySet();
		// 通过每个entry遍历
		for (Map.Entry<String, String> entry : entrys) {
			String key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key + ":" + value);
		}
	}

}
