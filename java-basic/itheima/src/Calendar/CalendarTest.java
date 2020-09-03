package Calendar;

import java.util.Calendar;

/**
 * Calendar 为操作日历字段提供了方法
 * @author Qin-Kai
 *
 */
public class CalendarTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		// 获取日期
		//  int get(int field) 
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)  + 1;// month 默认为0-11表示 
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year + "年" + month + "月" + day + "日");
		
		// 设置日期
		// void set(int field, int value) 将给定的日历字段设置为给定值。 
		c.set(Calendar.YEAR, 1998);
		year = c.get(Calendar.YEAR);
		System.out.println(year);
		
		// 修改日期
		// add(int field, int amount) 根据日历的规则，为给定的日历字段添加或减去指定的时间量。
		c.add(Calendar.YEAR, 1);
		year = c.get(Calendar.YEAR);
		System.out.println(year);
	}

}
