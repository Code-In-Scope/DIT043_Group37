package bussinessLogic;

import menu.Calculate;

import java.util.ArrayList;
import java.util.List;

public class FacadeWrapper
{
	private ArrayList<Item> itemList;
	private TransactionManager transactionManager;

	public FacadeWrapper()
	{
		itemList = new ArrayList<>();
		transactionManager = new TransactionManager();
	}

	public int itemIndexExists(String itemID)
	{
		for (int i = 0; i < this.itemList.size(); i++)
		{
			if (this.itemList.get(i).checkItemID(itemID))
			{
				return i;
			}
		}
		return -1;
	}

	public boolean containsItem(String itemID)
	{
		if (itemIndexExists(itemID) == -1)
		{
			return false;
		}
		return true;
	}

	public String createItem(String itemID, String itemName, double unitPrice)
	{
		String createResult;
		if (itemID.isBlank() || itemName.isBlank() || unitPrice <= 0.0)
		{
			createResult = "Invalid data for item.";
		}
		else if (containsItem(itemID))
		{
			createResult = "Enter unique itemID.";
		}
		else
		{
			itemList.add(new Item(itemID, itemName, unitPrice));
			createResult = "Item " + itemID + " was registered successfully.";
		}
		return createResult;
	}

	public String printItem(String itemID)
	{
		String printResult;
		int index = itemIndexExists(itemID);
		if (index == -1)
		{
			printResult = "Item " + itemID + " was not registered yet.";
		}
		else
		{
			printResult = itemList.get(index).toString();
		}
		return printResult;
	}

	public String removeItem(String itemID)
	{
		String removeResult;
		int index = itemIndexExists(itemID);
		if (index == -1)
		{
			removeResult = "Item " + itemID + " could not be removed.";
		}
		else
		{
			itemList.remove(index);
			removeResult = "Item " + itemID + " was successfully removed.";
		}
		return removeResult;
	}

	public double buyItem(String itemID, int amount)
	{
		double buyResult;
		int index = itemIndexExists(itemID);
		if (index == -1)
		{
			buyResult = -1.0;
		}
		else
		{
			double itemPrice = itemList.get(index).getUnitPrice();
			if (amount <= 4)
			{
				buyResult = Calculate.getTotalAmount(amount, itemPrice);
			}
			else
			{
				int normalAmount = 4;
				int extraAmount = amount - normalAmount;
				double discountRate = 0.7;
				int decimalPlace = 2;
				double discountPrice = Calculate.getDiscount(itemPrice, discountRate);

				buyResult = Calculate.getTotalAmount(normalAmount, itemPrice);
				buyResult = buyResult + Calculate.getTotalAmount(extraAmount, discountPrice);
				buyResult = Calculate.truncateDouble(buyResult, decimalPlace);
				transactionManager.registerTransaction(itemID, amount, buyResult, getItemInfo(itemID));
			}
		}
		return buyResult;
	}

	public String getItemInfo(String itemId){
		int index = itemIndexExists(itemId);
		String itemInfo = itemList.get(index).toString();
		return itemInfo;
	}

	public String reviewItem(String itemID, String reviewComment, int reviewGrade)
	{
		int index = itemIndexExists(itemID);
		if (index == -1)
		{
			return "Item " + itemID + " was not registered yet.";
		}
		else
		{
			return itemList.get(index).addReviewComment(reviewGrade, reviewComment);
		}
	}

	public String getItemCommentsPrinted(String itemID)
	{
		int index = itemIndexExists(itemID);
		if (index == -1)
		{
			return "Item " + itemID + " was not registered yet.";
		}
		else
		{
			return itemList.get(index).printAllReview();
		}
	}
	public List<String> getItemComments(String itemID)
	{
		int index = itemIndexExists(itemID);
		if (index == -1)
		{
			return null;
		}
		else
		{
			return itemList.get(index).retrieveComment();
		}
	}
	public double getItemMeanGrade(String itemID)
	{
		int index = itemIndexExists(itemID);
		if (index == -1)
		{
			return -1.0;
		}
		else
		{
			return itemList.get(index).meanGrade();
		}
	}

	public String updateItemName(String itemID, String newName)
	{
		int index = itemIndexExists( itemID);
		if (index != -1)
		{
			return itemList.get(index).setItemName(newName);
		}
		return "Item " + itemID + " was not registered yet.";
	}

	public String updateItemPrice(String itemID, double newPrice)
	{
		int index = itemIndexExists( itemID);
		if (index != -1)
		{
			return itemList.get(index).setUnitPrice(newPrice);
		}
		return "Item " + itemID + " was not registered yet.";
	}

	public String printAllItems()
	{
		StringBuilder output = new StringBuilder();
		String s = System.lineSeparator();
		output.append("All registered items:");
		output.append(s);
		if (itemList.isEmpty())
		{
			return "No items registered yet.";
		} else
		{
			for (Item item : itemList)
			{
				output.append(item);
				output.append(s);
			}
			return output.toString();
		}
	}
}

