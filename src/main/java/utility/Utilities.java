package utility;

import bussinessLogic.Item;

import java.util.ArrayList;
import java.util.List;

public class Utilities
{
	public static List<String> retrieveItemIDs(List<Item> reviewedList)
	{
		List<String> list = new ArrayList<>();
		for (Item item:reviewedList)
		{
			list.add(item.getItemID());
		}
		return list;

	}
}
