package facade;

import bussinessLogic.Item;
import bussinessLogic.Transaction;
import bussinessLogic.TransactionManager;
import util.Calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Facade {

    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.
    private ArrayList<Item> itemList;
    TransactionManager transactionManager;

    public Facade(){

        itemList = new ArrayList<>();
        transactionManager = new TransactionManager();
    }

    public boolean containsItem(String itemID) {

        if(itemIndexExists(itemList,itemID)==-1)
        {
            return false;
        }
        return true;
    }

    public static int itemIndexExists(ArrayList<Item> itemList , String itemID)
    {
        for (int i=0;i< itemList.size();i++)
        {
            Item currentItem = itemList.get(i);
            if(currentItem.getItemID()==itemID)
                return i;
        }
        return -1;
    }

    public String getItemInfo(String itemID){
        String itemInfo = "";
        for (int i = 0; i < itemList.size(); i++){
            Item currentItem = itemList.get(i);
            if (currentItem.getItemID()==itemID){
                itemInfo = currentItem.printItem();
            }
        }
        return itemInfo;
    }

    public String createItem(String itemID, String itemName, double unitPrice){
        String createResult;
        if (itemID.isBlank() || itemName.isBlank() || unitPrice <= 0.0){
            createResult = "Invalid data for item.";
        }else if (containsItem(itemID)){
            createResult = "Enter unique itemID.";
        }else {
           Item newItem = new Item(itemID,itemName,unitPrice);
           itemList.add(newItem);
           createResult = "Item " + itemID + " was registered successfully.";
        }
        return createResult;
    }

    public String printItem(String itemID) {
        String printResult;
        int index = itemIndexExists(itemList,itemID);
        if (index == -1){
            printResult = "Item "+ itemID + " was not registered yet.";
        }else
            printResult = itemList.get(index).printItem();
        return printResult ;
    }

    public String removeItem(String itemID) {
        String removeResult;
        int index = itemIndexExists(itemList,itemID);
        if (index== -1){
            removeResult = "Item " + itemID + " could not be removed.";
        }else {
            itemList.remove(index);
            removeResult = "Item " + itemID + " was successfully removed.";
        }
        return removeResult;
    }

    public double buyItem(String itemID, int amount) {
        double totalPrice;
        int amountThreshold = 4;
        double discountRate = 0.7;
        int index = itemIndexExists(itemList,itemID);
        if (index == -1){
            totalPrice = -1.0;
        }else {
            double itemPrice = itemList.get(index).getUnitPrice();
            if (amount <= amountThreshold){
                 totalPrice = Calculate.getTotalAmount(amount,itemPrice);
            }else {
                int extraAmount = amount - amountThreshold;
                double discountPrice = Calculate.getDiscount(itemPrice,discountRate);

                totalPrice = Calculate.getTotalAmount(amountThreshold,itemPrice);
                totalPrice = totalPrice + Calculate.getTotalAmount(extraAmount, discountPrice);
                totalPrice = Calculate.toTruncate(totalPrice);
                transactionManager.registerTransaction(itemID, amount, totalPrice, getItemInfo(itemID));
            }
        }
        return totalPrice ;
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

        String transactions = transactionManager.printItemTransaction(itemID);
        return transactions;
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
        int index = itemIndexExists(itemList,itemID);
        if(index!=-1)
        {
            if(!newName.isBlank())
            {
                itemList.get(index).setItemName(newName);
                return "Item " + itemID + " was updated successfully.";
            }
            else
            {
                return "Invalid data for item.";
            }
        }
        return "Item " + itemID + " was not registered yet.";
    }

    public String updateItemPrice(String itemID, double newPrice) {
        int index = itemIndexExists(itemList,itemID);
        if(index!=-1)
        {
            if(newPrice>0.0)
            {
                itemList.get(index).setUnitPrice(newPrice);
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
        StringBuilder output = new StringBuilder();
        String s = System.lineSeparator();
        output.append( "All registered items:");
        output.append(s);
        if(itemList.isEmpty()) {
            return "No items registered yet.";
        }
        else{
            for (Item item:itemList) {
                output.append(item.printItem());
                output.append(s);
            }
            return output.toString();
        }
    }

    public String printMostProfitableItems() {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        return "";
    }

    public String printEmployee(String employeeID) throws Exception {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        return "";
    }

    public double getNetSalary(String employeeID) throws Exception {
        return -1.0;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        return "";
    }

    public String removeEmployee(String empID) throws Exception {
        return "";
    }

    public String printAllEmployees() throws Exception {
        return "";
    }

    public double getTotalNetSalary() throws Exception {
        return -1.0;
    }

    public String printSortedEmployees() throws Exception {
        return "";
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        return "";
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {
        return "";
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        return "";
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        return "";
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        return "";
    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        return null;
    }

    public String promoteToManager(String empID, String degree) throws Exception {
        return "";

    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        return "";
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        return "";
    }
}