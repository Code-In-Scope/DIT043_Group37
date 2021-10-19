package facade;

import java.util.List;
import java.util.Map;

import bussinessLogic.FacadeWrapper;
import bussinessLogic.TransactionManager;

public class Facade {

  FacadeWrapper wrapper;
  TransactionManager transactionManager;

  public Facade() {
    wrapper = new FacadeWrapper();
    transactionManager = new TransactionManager();
  }

  public boolean containsItem(String itemID) {
    return wrapper.containsItem(itemID);
  }

  public String createItem(String itemID, String itemName, double unitPrice) {
    return wrapper.createItem(itemID, itemName, unitPrice);
  }

  public String printItem(String itemID) {
    return wrapper.printItem(itemID);
  }

  public String removeItem(String itemID) {
    return wrapper.removeItem(itemID);
  }

  public double buyItem(String itemID, int amount) {
    return wrapper.buyItem(itemID, amount);
  }

  public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
    return wrapper.reviewItem(itemID, reviewComment, reviewGrade);
  }

  public String reviewItem(String itemID, int reviewGrade) {
    return reviewItem(itemID, null, reviewGrade);
  }

  public String getItemCommentsPrinted(String itemID) {
    return wrapper.getItemCommentsPrinted(itemID);
  }

  public List<String> getItemComments(String itemID) {
    return wrapper.getItemComments(itemID);
  }

  public double getItemMeanGrade(String itemID) {
    return wrapper.getItemMeanGrade(itemID);
  }

  public int getNumberOfReviews(String itemID) {
    return wrapper.getNumberOfReviews(itemID);
  }

  public String getPrintedItemReview(String itemID, int reviewNumber) {
    return wrapper.printSpecificReview(itemID, reviewNumber);
  }

  public String getPrintedReviews(String itemID) {
    return wrapper.printSpecificItemReview(itemID);
  }

  public String printMostReviewedItems() {
    return wrapper.printMostReviewedItems();
  }

  public List<String> getMostReviewedItems() {
    return null;
  }

  public List<String> getLeastReviewedItems() {
    return null;
  }

  public String printLeastReviewedItems() {
    return wrapper.printLeastReviewedItem();
  }

  public double getTotalProfit() {
    double totalProfit = transactionManager.getTotalProfit();
    return totalProfit;
  }

  public int numberOfItemTransactions(String itemID) {
    int transactions = transactionManager.totalNumberOfTransaction(itemID);
    return transactions;
  }

  public String printItemTransactions(String itemID) {
    String transactions;
    if (!containsItem(itemID)) {
      transactions = "Item " + itemID + " was not registered yet.";
    } else {
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
    if (!containsItem(itemID)) {
      profit = 0;
    } else {
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
    return wrapper.printAllReviews();
  }

  public String updateItemName(String itemID, String newName) {
    return wrapper.updateItemName(itemID, newName);
  }

  public String updateItemPrice(String itemID, double newPrice) {
    return wrapper.updateItemPrice(itemID, newPrice);
  }

  public String printAllItems() {
    return wrapper.printAllItems();
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

  public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree)
      throws Exception {
    return "";
  }

  public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
    return "";
  }

  public double getNetSalary(String employeeID) throws Exception {
    return -1.0;
  }

  public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept)
      throws Exception {
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
