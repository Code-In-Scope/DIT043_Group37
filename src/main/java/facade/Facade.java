package facade;

import bussinessLogic.Item;
import bussinessLogic.ReviewItem;
import bussinessLogic.Transaction;
import util.Calculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Facade {

    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.
    private HashMap<String,Item> itemList;
    private HashMap<String, ReviewItem> reviewList;
    private HashMap<String, Transaction> transactionHistory;

    public Facade(){

        this.itemList = new HashMap<String,Item>();
       this.reviewList = new HashMap<>();
       this.transactionHistory = new HashMap<>();
    }

    public boolean containsItem(String itemID) {
        return itemList.containsKey(itemID);
    }

    public String createItem(String itemID, String itemName, double unitPrice){
        String createResult = "";
        if (itemID.isBlank() || itemName.isBlank() || unitPrice <= 0.0){
            createResult = "Invalid data for item";
        }else if (containsItem(itemID)){
            createResult = "Enter unique itemID.";
        }else {
           Item newItem = new Item(itemID,itemName,unitPrice);
           itemList.put(itemID, newItem);
           createResult = "Item " + itemID + " was registered successfully.";
        }
        return createResult;
    }

    public String printItem(String itemID) {
        String printResult = "";
        if (!containsItem(itemID)){
            printResult = "Item "+ itemID + " was not registered yet.";
        }else
            printResult = itemList.get(itemID).ToString();
        return printResult ;
    }

    public String removeItem(String itemID) {
        String removeResult = "";
        if (!containsItem(itemID)){
            removeResult = "Item " + itemID + " could not be removed.";
        }else {
            itemList.remove(itemID);
            removeResult = "Item " + itemID + " was successfully removed.";
        }
        return removeResult;
    }

    public double buyItem(String itemID, int amount) {
        double totalPrice = 0.0;
        int normalAmount = 4;
        double discountRate = 0.7;
        int truncateDecimal = 2;

        if (!containsItem(itemID)){
            totalPrice = -1.0;
        }else {
            double itemPrice = itemList.get(itemID).getUnitPrice();
            if (amount<=normalAmount){
                 totalPrice = Calculate.getTotalAmount(amount,itemPrice);
            }else {
                int extraAmount = amount - normalAmount;
                double discountPrice = Calculate.getDiscount(itemPrice,discountRate);

                totalPrice = Calculate.getTotalAmount(normalAmount,itemPrice);
                totalPrice = totalPrice + Calculate.getTotalAmount(extraAmount, discountPrice);
                totalPrice = Calculate.truncateDouble(totalPrice, truncateDecimal);
                registerTransaction(itemID, amount, totalPrice);
            }
        }
        return totalPrice ;
    }

    public void registerTransaction(String itemID, int amount, double totalPrice){
        Transaction newTransaction = new Transaction(itemID, amount, totalPrice);
        transactionHistory.put(itemID, newTransaction);
    }

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
        String reviewResult = "";
        if (!containsItem(itemID)){
            reviewResult = "Item " + itemID + " is not registered yet.";
        }else {
            if (reviewGrade < 1 || reviewGrade > 5){
                reviewResult = "Grade values must be between 1 and 5.";
            }else {
                ReviewItem newReview = new ReviewItem(reviewComment, reviewGrade);
                reviewList.put(itemID, newReview);
                reviewResult = "Your item review was registered successfully.";
            }
        }
        return reviewResult;
    }

    public String reviewItem(String itemID, int reviewGrade) {
        return reviewItem(itemID, "", reviewGrade);
    }

    public String getItemCommentsPrinted(String itemID) {
        return "";
    }

    public List<String> getItemComments(String itemID) {
        return null;
    }

    public double getItemMeanGrade(String itemID) {
        return -1.0;
    }

    public int getNumberOfReviews(String itemID) {
        return -1;
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        return "";
    }

    public String getPrintedReviews(String itemID) {
        return "";
    }

    public String printMostReviewedItems() {
        return "";
    }

    public List<String> getMostReviewedItems() {
        return null;
    }

    public List<String> getLeastReviewedItems() {
        return null;
    }

    public String printLeastReviewedItems() {
        return "";
    }

    public double getTotalProfit() {
        return -1.0;
    }

    public String printItemTransactions(String itemID) {
        return "";
    }

    public int getTotalUnitsSold() {
        return -1;
    }

    public int getTotalTransactions() {
        return -1;
    }

    public double getProfit(String itemID) {
        return -1.0;
    }

    public int getUnitsSolds(String itemID) {
        return -1;
    }

    public String printAllTransactions() {
        return "";
    }

    public String printWorseReviewedItems() {
        return "";
    }

    public String printBestReviewedItems() {
        return "";
    }

    public List<String> getWorseReviewedItems() {
        return null;
    }

    public List<String> getBestReviewedItems() {
        return null;
    }

    public String printAllReviews() {
        return "";
    }

    public String updateItemName(String itemID, String newName) {
        String updateResult;
        if(!containsItem(itemID)) {
            updateResult = "Item " + itemID + " was not registered yet.";
        }else if(newName.isBlank()) {
            updateResult = "Invalid data for item.";
        }
        else {
            itemList.get(itemID).setItemName(newName);
            updateResult = "Item " + itemID + " was updated successfully.";
        }
        return updateResult;
    }

    public String updateItemPrice(String itemID, double newPrice) {
        if(containsItem(itemID))
        {
            if(newPrice>0.0)
            {
                itemList.get(itemID).setUnitPrice(newPrice);
                return "Item " + itemID + " was updated successfully.";
            }
            else
            {
                return "Invalid data for item.";
            }
        }
        return "Item " + itemID + " was not registered yet.";
    }

    public String printAllItems() {
        /*String s = System.lineSeparator();
        String allItems = "All registered items:" + s ;
        for (String key : itemList.keySet()) {
            allItems = allItems + itemList.get(key).ToString() + s;
        }*/
        return "";
    }

    public String printMostProfitableItems() {
        return "";
    }
}