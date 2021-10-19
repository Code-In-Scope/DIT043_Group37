package bussinessLogic;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import utility.Calculate;

public class Item {
  private final String itemID;
  private String itemName;
  private double unitPrice;
  private String itemNotReviewed;
  private ArrayList<Review> reviewList;
  private DecimalFormat decimalFormat;

  public Item(String itemID, String itemName, double unitPrice) {
    this.reviewList = new ArrayList<>();
    this.itemID = itemID;
    this.itemName = itemName;
    this.unitPrice = unitPrice;
    this.itemNotReviewed = "Item " + this.itemName + " has not been reviewed yet.";
    this.decimalFormat = new DecimalFormat(".00");
    decimalFormat.setRoundingMode(RoundingMode.DOWN);
  }

  public String getItemID() {
    return itemID;
  }

  public String getItemName() {
    return itemName;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public String setItemName(String name) {
    if (!name.isBlank()) {
      this.itemName = name;
      return "Item " + this.itemID + " was updated successfully.";
    } else {
      return "Invalid data for item.";
    }
  }

  public String setUnitPrice(double price) {
    if (price > 0.0) {
      this.unitPrice = price;
      return "Item " + this.itemID + " was updated successfully.";
    } else {
      return "Invalid data for item.";
    }
  }

  public boolean checkItemID(String itemID) {
    return this.itemID.equals(itemID);
  }

  public String addReviewComment(int grade, String comment) {
    if (grade > 0 && grade <= 5) {
      reviewList.add(new Review(grade, comment));
      return "Your item review was registered successfully.";
    } else {
      return "Grade values must be between 1 and 5";
    }
  }

  public String printReview(int reviewIndex) {
    if (reviewList.isEmpty()) {
      return itemNotReviewed;
    } else if (reviewIndex > 0 && reviewIndex <= reviewList.size()) {
      return reviewList.get(reviewIndex - 1).toString();
    } else {
      return "Invalid review number. Choose between 1 and " + reviewList.size() + ".";
    }
  }

  public boolean isItemReviewed() {
    return !reviewList.isEmpty();
  }

  public int getNumberOfReviews() {
    if (isItemReviewed()) {
      return reviewList.size();
    } else {
      return -1;
    }
  }

  public String printAllReview() {
    StringBuilder result = new StringBuilder();
    result.append("Review(s) for " + this.itemID + ": " + this.itemName + ". " + decimalFormat.format(this.unitPrice)
        + " SEK" + "\n");
    if (reviewList.isEmpty()) {
      result.append(itemNotReviewed);

    } else {
      for (int i = 0; i < reviewList.size(); i++) {
        result.append(reviewList.get(i));
        result.append("\n");
      }
    }
    return result.toString();
  }

  public double meanGrade() {
    if (reviewList.isEmpty()) {
      return -1.0;

    } else {
      double temp = 0;

      for (Review review : reviewList) {
        temp += review.getGrade();
      }

      double mean = temp / reviewList.size();
      mean = Calculate.truncateDouble(mean, 1);
      return mean;
    }
  }

  public List<String> retrieveComment() {
    if (reviewList.isEmpty()) {
      return null;
    } else {
      List<String> writtenComments = new ArrayList<>();

      for (Review review : reviewList) {
        if (review.getComment() != "") {
          writtenComments.add(review.getComment());
        }
      }
      return writtenComments;
    }
  }

  public boolean equals(Object anotherObject) {
    if (this == anotherObject) {
      return true;
    }
    if (anotherObject == null || !(anotherObject instanceof Item)) {
      return false;
    } else {
      Item item = (Item) anotherObject;
      return itemID == item.itemID;
    }
  }

  public int hashCode() {
    return Objects.hash(itemID);
  }

  @Override
  public String toString() {

    String printItem = this.itemID + ": " + this.itemName + ". " + decimalFormat.format(this.unitPrice) + " SEK";
    return printItem;
  }
}
