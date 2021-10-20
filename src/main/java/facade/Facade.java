package facade;

import bussinessLogic.ItemEntry;
import java.util.List;
import java.util.Map;
import bussinessLogic.TransactionManager;

public class Facade {

	ItemEntry itemEntry;
	TransactionManager transactionManager;

	public Facade()
	{
		itemEntry = new ItemEntry();
		transactionManager = new TransactionManager();
	}

	public boolean containsItem(String itemID)
	{
		return itemEntry.containsItem(itemID);
	}

	public String createItem(String itemID, String itemName, double unitPrice) {
		return itemEntry.createItem(itemID, itemName, unitPrice);
	}

	public String printItem(String itemID)
	{
		return itemEntry.printItem(itemID);
	}

	public String removeItem(String itemID)
	{
		return itemEntry.removeItem(itemID);
	}

	public double buyItem(String itemID, int amount)
	{
        double totalPrice = itemEntry.buyItem(itemID, amount);
        String itemInfo = itemEntry.getItemInfo(itemID);
        transactionManager.registerTransaction(itemID, amount, totalPrice, itemInfo);
		return totalPrice;
	}

	public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
		return itemEntry.reviewItem(itemID, reviewComment, reviewGrade);
	}

	public String reviewItem(String itemID, int reviewGrade)
	{
		return reviewItem(itemID, null, reviewGrade);
	}

	public String getItemCommentsPrinted(String itemID)
	{
		return itemEntry.getItemCommentsPrinted(itemID);
	}

	public List<String> getItemComments(String itemID)
	{
		return itemEntry.getItemComments(itemID);
	}

	public double getItemMeanGrade(String itemID)
	{
		return itemEntry.getItemMeanGrade(itemID);
	}

  public int getNumberOfReviews(String itemID) {
    return itemEntry.getNumberOfReviews(itemID);
  }

  public String getPrintedItemReview(String itemID, int reviewNumber) {
    return itemEntry.printSpecificReview(itemID, reviewNumber);
  }

  public String getPrintedReviews(String itemID) {
    return itemEntry.printSpecificItemReview(itemID);
  }

  public String printMostReviewedItems() {
    return itemEntry.printMostReviewedItems();
  }

	public List<String> getMostReviewedItems()
	{
		return itemEntry.getMostReviewedItems();
	}

	public List<String> getLeastReviewedItems()
	{
		return null;
	}

  public String printLeastReviewedItems() {
    return itemEntry.printLeastReviewedItem();
  }

    public double getTotalProfit() {
        double totalProfit = transactionManager.getTotalProfit();
        return totalProfit;
    }

    public int numberOfItemTransactions(String itemID){
        int transactions = transactionManager.totalNumberOfTransaction(itemID);
        return transactions;
    }

    public String printItemTransactions(String itemID) {
        String transactions;
        if (!containsItem(itemID)){
            transactions = "Item " + itemID + " was not registered yet.";
        }else {
            transactions = transactionManager.printItemTransaction(itemID);
        }
        return transactions;
    }

    public int getTotalUnitsSold() {
        int soldItems = transactionManager.getTotalSoldItems();
        return soldItems;
    }

    public int getTotalTransactions() {
        int totalTransaction = transactionManager.getTotalTransactions();
        return totalTransaction;
    }

    public double getProfit(String itemID) {
        double profit;
        if (!containsItem(itemID)){
            profit = 0;
        }else {
            profit = transactionManager.getTotalProfitOfItem(itemID);
        }
        return profit;
    }

    public int getUnitsSolds(String itemID) {
        int soldUnits = transactionManager.getTotalSoldUnits(itemID);
        return soldUnits;
    }

    public String printAllTransactions() {
        String allTransactions = transactionManager.printAllTransactions();
        return allTransactions;
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
    return itemEntry.printAllReviews();
  }

	public String updateItemName(String itemID, String newName)
	{
		return itemEntry.updateItemName(itemID, newName);
	}

	public String updateItemPrice(String itemID, double newPrice)
	{
		return itemEntry.updateItemPrice(itemID, newPrice);
	}

	public String printAllItems()
	{
		return itemEntry.printAllItems();
	}

	public String printMostProfitableItems()
	{
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