package facade;

import bussinessLogic.Item;
import util.Calculate;

import java.util.HashMap;
import java.util.List;

public class Facade {

    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.
    private HashMap<String,Item> itemList;

    public Facade(){

        itemList = new HashMap<String,Item>();
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
        double buyResult = 0.0;
        if (!containsItem(itemID)){
            buyResult = -1.0;
        }else {
            double itemPrice = itemList.get(itemID).getUnitPrice();
            if (amount<=4){
                 buyResult = Calculate.getTotalAmount(amount,itemPrice);
            }else {
                int normalAmount = 4;
                int extraAmount = amount - normalAmount;
                double discountRate = 0.7;
                double discountPrice = Calculate.getDiscount(itemPrice,discountRate);

                buyResult = Calculate.getTotalAmount(normalAmount,itemPrice);
                buyResult = buyResult + Calculate.getTotalAmount(extraAmount, discountPrice) ;
            }
        }
        return buyResult ;
    }

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
        return "";
    }

    public String reviewItem(String itemID, int reviewGrade) {
        return "";
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
        return "";
    }

    public String updateItemPrice(String itemID, double newPrice) {
        return "";
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