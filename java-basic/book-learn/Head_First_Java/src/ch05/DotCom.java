package ch05;
import java.util.ArrayList;
public class DotCom {
	private ArrayList<String> locationCells;
	private String name;
	void setLocationCells(ArrayList<String> locs) {
		// TODO Auto-generated method stub
		locationCells = locs;
	}
	void setName(String n) {
		name = n;
	}
	String checkYourself(String userInput) {
		// TODO Auto-generated method stub
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index);
			
			if (locationCells.isEmpty()) {
				result = "kill";
			} else {
				result = "hit";
			}
		}
		System.out.println(result);
		return result;
	}
}
