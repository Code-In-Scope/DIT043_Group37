package utility;

import bussinessLogic.Item.Item;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Utilities
{
	public static List<String> retrieveItemIDs(List<Item> reviewedList)
	{
		List<String> list = new ArrayList<>();
		for (Item item : reviewedList) {
			list.add(item.getItemID());
		}
		return list;

	}
	
	public static String formatDouble(double value)
	{
		DecimalFormat decimalFormat = new DecimalFormat(".00");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		return decimalFormat.format(value);

	}
}
