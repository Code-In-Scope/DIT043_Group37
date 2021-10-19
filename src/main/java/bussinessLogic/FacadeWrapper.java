package bussinessLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import utility.Calculate;

class SortByLeastReviews implements Comparator<Item> {
  // Used for sorting in ascending order of
  // name
  public int compare(Item a, Item b) {
    return a.getNumberOfReviews() - b.getNumberOfReviews();
  }
}

class SortByMostReviews implements Comparator<Item> {
  // Used for sorting in ascending order of
  // name
  public int compare(Item a, Item b) {
    return b.getNumberOfReviews() - a.getNumberOfReviews();
  }
}

public class FacadeWrapper {
  private ArrayList<Item> itemList;
  private final TransactionManager transactionManager;
  String s;
  String line;

  public FacadeWrapper() {
    itemList = new ArrayList<>();
    transactionManager = new TransactionManager();
    this.s = System.lineSeparator();
    this.line = s + "------------------------------------" + s;
  }

  public int itemIndexExists(String itemID) {
    for (int i = 0; i < this.itemList.size(); i++) {
      if (this.itemList.get(i).checkItemID(itemID)) {
        return i;
      }
    }
    return -1;
  }

  public boolean atLeastOneItemReviewed() {

    for (Item item : itemList) {
      if (item.isItemReviewed()) {
        return true;
      }
    }
    return false;
  }

  public boolean containsItem(String itemID) {
    if (itemIndexExists(itemID) == -1) {
      return false;
    }
    return true;
  }

  public String createItem(String itemID, String itemName, double unitPrice) {
    String createResult;
    if (itemID.isBlank() || itemName.isBlank() || unitPrice <= 0.0) {
      createResult = "Invalid data for item.";
    } else if (containsItem(itemID)) {
      createResult = "Enter unique itemID.";
    } else {
      itemList.add(new Item(itemID, itemName, unitPrice));
      createResult = "Item " + itemID + " was registered successfully.";
    }
    return createResult;
  }

  public String printItem(String itemID) {
    String printResult;
    int index = itemIndexExists(itemID);
    if (index == -1) {
      printResult = "Item " + itemID + " was not registered yet.";
    } else {
      printResult = itemList.get(index).toString();
    }
    return printResult;
  }

  public String removeItem(String itemID) {
    String removeResult;
    int index = itemIndexExists(itemID);
    if (index == -1) {
      removeResult = "Item " + itemID + " could not be removed.";
    } else {
      itemList.remove(index);
      removeResult = "Item " + itemID + " was successfully removed.";
    }
    return removeResult;
  }

  public double buyItem(String itemID, int amount) {
    double buyResult;
    int index = itemIndexExists(itemID);
    if (index == -1) {
      buyResult = -1.0;
    } else {
      double itemPrice = itemList.get(index).getUnitPrice();
      if (amount <= 4) {
        buyResult = Calculate.getTotalAmount(amount, itemPrice);
      } else {
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

  public String getItemInfo(String itemId) {
    int index = itemIndexExists(itemId);
    String itemInfo = itemList.get(index).toString();
    return itemInfo;
  }

  public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
    int index = itemIndexExists(itemID);
    if (index == -1) {
      return "Item " + itemID + " was not registered yet.";
    } else {
      return itemList.get(index).addReviewComment(reviewGrade, reviewComment);
    }
  }

  public String getItemCommentsPrinted(String itemID) {
    int index = itemIndexExists(itemID);
    if (index == -1) {
      return "Item " + itemID + " was not registered yet.";
    } else {
      return itemList.get(index).printAllReview();
    }
  }

  public List<String> getItemComments(String itemID) {
    int index = itemIndexExists(itemID);
    if (index == -1) {
      return null;
    } else {
      return itemList.get(index).retrieveComment();
    }
  }

  public double getItemMeanGrade(String itemID) {
    int index = itemIndexExists(itemID);
    if (index == -1) {
      return -1.0;
    } else {
      return itemList.get(index).meanGrade();
    }
  }

  public String updateItemName(String itemID, String newName) {
    int index = itemIndexExists(itemID);
    if (index != -1) {
      return itemList.get(index).setItemName(newName);
    }
    return "Item " + itemID + " was not registered yet.";
  }

  public String updateItemPrice(String itemID, double newPrice) {
    int index = itemIndexExists(itemID);
    if (index != -1) {
      return itemList.get(index).setUnitPrice(newPrice);
    }
    return "Item " + itemID + " was not registered yet.";
  }

  public String printAllItems() {
    StringBuilder stringGenerator = new StringBuilder();

    stringGenerator.append("All registered items:");
    stringGenerator.append(s);
    if (itemList.isEmpty()) {
      return "No items registered yet.";
    } else {
      for (Item item : itemList) {
        stringGenerator.append(item);
        stringGenerator.append(s);
      }
      return stringGenerator.toString();
    }
  }

  public String printSpecificItemReview(String itemID) {
    int index = itemIndexExists(itemID);

    return itemList.get(index).printAllReview();
  }

  public String printSpecificReview(String itemID, int reviewIndex) {
    int index = itemIndexExists(itemID);

    return itemList.get(index).printReview(reviewIndex);
  }

  public String printLeastReviewedItem() {
    StringBuilder stringGenerator = new StringBuilder();
    String output;
    int numberOfReviews;

    if (itemList.isEmpty()) {
      output = "No items registered yet.";
    } else if (atLeastOneItemReviewed()) {
      Collections.sort(itemList, new SortByMostReviews().reversed());
      int i;
      for (i = 0; i < itemList.size(); i++) {
        if (itemList.get(i).getNumberOfReviews() == -1) {
          continue;
        }
        break;

      }
      numberOfReviews = itemList.get(i).getNumberOfReviews();
      stringGenerator.append("Least reviews: " + numberOfReviews + " review(s) each." + s);
      for (int j = i; j < itemList.size(); j++) {
        if (itemList.get(j).getNumberOfReviews() != numberOfReviews) {
          break;
        }
        stringGenerator.append(itemList.get(j) + s);
      }
      output = stringGenerator.toString();

    } else {
      output = "No items were reviewed yet.";
    }

    return output;
  }

  public String printMostReviewedItems() {
    StringBuilder stringGenerator = new StringBuilder();
    String output;
    int numberOfReviews;

    if (itemList.isEmpty()) {
      output = "No items registered yet.";
    } else if (atLeastOneItemReviewed()) {

      Collections.sort(itemList, new SortByMostReviews());
      numberOfReviews = itemList.get(0).getNumberOfReviews();
      stringGenerator.append("Most reviews: " + numberOfReviews + " review(s) each." + s);
      for (Item item : itemList) {
        if (item.getNumberOfReviews() != numberOfReviews) {
          break;
        }
        stringGenerator.append(item + s);
      }
      output = stringGenerator.toString();

    } else {
      output = "No items were reviewed yet.";
    }

    return output;
  }

  public String printAllReviews() {
    StringBuilder stringGenerator = new StringBuilder();
    stringGenerator.append("All registered reviews:");
    stringGenerator.append(line);
    String output;
    if (itemList.isEmpty()) {
      output = "No items registered yet.";
    } else if (atLeastOneItemReviewed()) {
      for (Item item : itemList) {
        if (item.isItemReviewed()) {
          stringGenerator.append(item.printAllReview());
          stringGenerator.append(line);
        }
      }
      output = stringGenerator.toString();
    } else {
      output = "No items were reviewed yet.";
    }

    return output;
  }

  public int getNumberOfReviews(String itemID) {

    int index = itemIndexExists(itemID);

    return itemList.get(index).getNumberOfReviews();
  }
}
