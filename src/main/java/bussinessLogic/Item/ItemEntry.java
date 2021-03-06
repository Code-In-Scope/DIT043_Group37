package bussinessLogic.Item;

import utility.Calculate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class SortByMostReviews implements Comparator<Item> {
  public int compare(Item a, Item b) {
    return b.getNumberOfReviews() - a.getNumberOfReviews();
  }
}

class SortByMostGrades implements Comparator<Item> {
  public int compare(Item a, Item b) {
    return Double.compare(b.meanGrade(), a.meanGrade());
  }
}

public class ItemEntry {
  private ArrayList<Item> itemList;
  String s;
  String line;

  public ItemEntry() {
    itemList = new ArrayList<>();
    this.s = System.lineSeparator();
    this.line = "------------------------------------" + s;
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
    int normalAmount = 4;
    double discountRate = 0.7;
    int decimalPlace = 2;

    int index = itemIndexExists(itemID);
    if (index == -1) {
      buyResult = -1.0;
    } else {
      double itemPrice = itemList.get(index).getUnitPrice();
      if (amount <= normalAmount) {
        buyResult = Calculate.getTotalAmount(amount, itemPrice);
      } else {
        int extraAmount = amount - normalAmount;
        double discountPrice = Calculate.getDiscount(itemPrice, discountRate);

        buyResult = Calculate.getTotalAmount(normalAmount, itemPrice);
        buyResult = buyResult + Calculate.getTotalAmount(extraAmount, discountPrice);
      }
    }
    buyResult = Calculate.truncateDouble(buyResult, decimalPlace);
    return buyResult;
  }

  public String getItemInfo(String itemId) {
    int index = itemIndexExists(itemId);
    if (index == -1) {
      return "";
    }

    String itemInfo = itemList.get(index).toString();
    return itemInfo;
  }

  public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
    int index = itemIndexExists(itemID);
    if (index == -1) {
      return "Item " + itemID + " not found.";
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
      return 0.0;
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

  public static String printList(List<?> list) {
    StringBuilder result = new StringBuilder();
    String s = System.lineSeparator();

    for (int i = 0; i < list.size(); i++) {
      result.append(list.get(i) + s);
    }
    return result.toString();
  }

  public String printAllItems() {
    StringBuilder stringGenerator = new StringBuilder();

    stringGenerator.append("All registered items:");
    stringGenerator.append(s);
    if (itemList.isEmpty()) {
      return "No items registered yet.";
    } else {
      stringGenerator.append(printList(itemList));
      return stringGenerator.toString();
    }
  }

  public String printSpecificItemReview(String itemID) {
    int index = itemIndexExists(itemID);
    if (index != -1) {
      return itemList.get(index).printAllReview();
    }
    return "Item " + itemID + " was not registered yet.";
  }

  public String printSpecificReview(String itemID, int reviewIndex) {
    int index = itemIndexExists(itemID);
    if (index != -1) {
      return itemList.get(index).printReview(reviewIndex);
    }
    return "Item " + itemID + " was not registered yet.";
  }

  public List<Item> getLeastReviewedItems() {
    List<Item> leastReviewedList = new ArrayList<>();

    int numberOfReviews;
    if (atLeastOneItemReviewed() && !itemList.isEmpty()) {
      // create a copy of the item references
      leastReviewedList.addAll(itemList);
      // remove the items which are not reviewed at least once
      leastReviewedList.removeIf(item -> (item.getNumberOfReviews() == 0));
      // sort the items based on least reviews
      leastReviewedList.sort(new SortByMostReviews().reversed());
      // take the lowest review
      numberOfReviews = leastReviewedList.get(0).getNumberOfReviews();
      // remove the reviews which are higher than the lowest review
      leastReviewedList.removeIf(item -> (item.getNumberOfReviews() > numberOfReviews));
    }

    return leastReviewedList;
  }

  public List<Item> getBestReviewedItems() {
    List<Item> bestReviewedList = new ArrayList<>();

    double meanGrade;
    if (atLeastOneItemReviewed() && !itemList.isEmpty()) {
      // create a copy of the item references
      bestReviewedList.addAll(itemList);
      // remove the items which are not reviewed at least once
      bestReviewedList.removeIf(item -> (item.meanGrade() == 0.0));
      // sort the items based on Most graded
      bestReviewedList.sort(new SortByMostGrades());
      // take the lowest review
      meanGrade = bestReviewedList.get(0).meanGrade();
      // remove the reviews which are lower than the best mean grade
      bestReviewedList.removeIf(item -> (item.meanGrade() < meanGrade));
    }

    return bestReviewedList;
  }

  public List<Item> getWorstReviewedItems() {
    List<Item> worstReviewedList = new ArrayList<>();
    double meanGrade;
    if (atLeastOneItemReviewed() && !itemList.isEmpty()) {
      // create a copy of the item references
      worstReviewedList.addAll(itemList);
      // remove the items which are not reviewed at least once
      worstReviewedList.removeIf(item -> (item.meanGrade() == 0.0));
      // sort the items based on worst graded
      worstReviewedList.sort(new SortByMostGrades().reversed());
      // take the lowest review
      meanGrade = worstReviewedList.get(0).meanGrade();
      // remove the reviews which are higher than the worst mean grade
      worstReviewedList.removeIf(item -> (item.meanGrade() > meanGrade));
    }

    return worstReviewedList;
  }

  public List<Item> getMostReviewedItems() {
    List<Item> mostReviewedList = new ArrayList<>();

    int numberOfReviews;
    if (atLeastOneItemReviewed() && !itemList.isEmpty()) {
      // create a copy of the item references
      mostReviewedList.addAll(itemList);
      // remove the items which are not reviewed at least once
      mostReviewedList.removeIf(item -> (item.getNumberOfReviews() == 0));
      // sort the items based on most reviews
      mostReviewedList.sort(new SortByMostReviews());
      // take the lowest review
      numberOfReviews = mostReviewedList.get(0).getNumberOfReviews();
      // remove the reviews which are lower than the highest review
      mostReviewedList.removeIf(item -> (item.getNumberOfReviews() < numberOfReviews));
    }

    return mostReviewedList;
  }

  public String printWorstReviewedItem() {
    StringBuilder stringGenerator = new StringBuilder();
    String output;
    double meanGrade;

    if (itemList.isEmpty()) {
      output = "No items registered yet.";
    } else if (atLeastOneItemReviewed()) {
      List<Item> worstReviewedItemList = getWorstReviewedItems();
      meanGrade = worstReviewedItemList.get(0).meanGrade();
      stringGenerator.append("Items with worst mean reviews:" + s + "Grade: " + meanGrade + s);
      stringGenerator.append(printList(worstReviewedItemList));
      output = stringGenerator.toString();
    } else {
      output = "No items were reviewed yet.";
    }
    return output;
  }

  public String printBestReviewedItems() {
    StringBuilder stringGenerator = new StringBuilder();
    String output;
    double meanGrade;

    if (itemList.isEmpty()) {
      output = "No items registered yet.";
    } else if (atLeastOneItemReviewed()) {
      List<Item> bestReviewedItemList = getBestReviewedItems();
      meanGrade = bestReviewedItemList.get(0).meanGrade();
      stringGenerator.append("Items with best mean reviews:" + s + "Grade: " + meanGrade + s);
      stringGenerator.append(printList(bestReviewedItemList));
      output = stringGenerator.toString();
    } else {
      output = "No items were reviewed yet.";
    }
    return output;
  }

  public String printLeastReviewedItem() {
    StringBuilder stringGenerator = new StringBuilder();
    String output;
    int numberOfReviews;

    if (itemList.isEmpty()) {
      output = "No items registered yet.";
    } else if (atLeastOneItemReviewed()) {
      List<Item> leastReviewedList = getLeastReviewedItems();
      numberOfReviews = leastReviewedList.get(0).getNumberOfReviews();
      stringGenerator.append("Least reviews: " + numberOfReviews + " review(s) each." + s);
      stringGenerator.append(printList(leastReviewedList));
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
      List<Item> mostReviewedList = getMostReviewedItems();
      numberOfReviews = mostReviewedList.get(0).getNumberOfReviews();
      stringGenerator.append("Most reviews: " + numberOfReviews + " review(s) each." + s);
      stringGenerator.append(printList(mostReviewedList));
      output = stringGenerator.toString();

    } else {
      output = "No items were reviewed yet.";
    }

    return output;
  }

  public String printAllReviews() {
    StringBuilder stringGenerator = new StringBuilder();
    stringGenerator.append("All registered reviews:" + s);
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
