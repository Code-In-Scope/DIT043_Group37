package utility;

import bussinessLogic.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
	public static List<String> retrieveItemIDs(List<Item> reviewedList) {
		List<String> list = new ArrayList<>();
		for (Item item : reviewedList) {
			list.add(item.getItemID());
		}
		return list;

	}

	public static String printList(List<?> list) {
		StringBuilder result = new StringBuilder();
		String s = System.lineSeparator();

		for (int i = 0; i < list.size(); i++) {
			result.append(list.get(i) + s);
		}
		return result.toString();
	}
}
