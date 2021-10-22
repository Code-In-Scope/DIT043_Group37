package bussinessLogic.Item;

import utility.Calculate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import utility.Utilities;
class SortByTotalProfit implements Comparator<ItemRegistration>{
   public int compare(ItemRegistration a, ItemRegistration b)
   {
       if(b.getTotalProfit() > a.getTotalProfit())
       {
           return 1;
       }
       else if(b.getTotalProfit()< a.getTotalProfit())
       {
           return -1;
       }
       else
       {
           return 0;
       }
   }
}

public class TransactionManager {

    private final ArrayList<Transaction> transactionList;
    private int totalSoldItems;
    private int totalTransactions;
    private double totalProfit;
    private final ArrayList<ItemRegistration> registrationList;

    public TransactionManager(){
        this.transactionList = new ArrayList<>();
        this.totalSoldItems = 0;
        this.totalTransactions = 0;
        this.totalProfit = 0.00;
        this.registrationList = new ArrayList<>();
    }

    public int getTotalTransactions(){
        return this.totalTransactions;
    }

    public int getTotalSoldItems(){
        return this.totalSoldItems;
    }

    public double getTotalProfit(){
        return Calculate.truncateDouble(this.totalProfit, 2);
    }

    public void registerTransaction(String itemID, int amountOfItem, double totalPrice, String itemInfo ){
        this.transactionList.add(new Transaction(itemID, amountOfItem, totalPrice, itemInfo));
        this.totalTransactions++;
        this.totalSoldItems = this.totalSoldItems + amountOfItem;
        this.totalProfit = this.totalProfit + totalPrice;
        updateItemRegister(itemID,amountOfItem,totalPrice,itemInfo);
    }

    public boolean containRegistration(String itemId){
        return getRegistrationIndex(itemId) == -1;
    }

    public int getRegistrationIndex(String itemID){
        for (int i = 0; i < registrationList.size(); i++){
            ItemRegistration current = registrationList.get(i);
            if (current.checkItemID(itemID)){
                return  i ;
            }
        }
        return -1;
    }

    public void updateItemRegister(String itemID, int amount, double price, String itemInfo){
        if (containRegistration(itemID) && getRegistrationIndex(itemID) >= 0){
            int index = getRegistrationIndex(itemID);
            registrationList.get(index).addProfit(price);
            registrationList.get(index).addSoldUnit(amount);
        }else {
            registrationList.add(new ItemRegistration(itemID, amount, price, itemInfo));
        }
    }

    //Total transaction of specific item
    public int totalNumberOfTransaction(String itemID){
        int itemTransactions = 0;
        for (Transaction currentTransaction : transactionList) {
            if (currentTransaction.checkItemID(itemID)) {
                itemTransactions = itemTransactions + 1;
            }
        }
        return itemTransactions;
    }
    //Count sold units for specific item
    public int getTotalSoldUnits(String itemID){
        int itemSold = 0;
        for (int i = 0; i < transactionList.size(); i++ ){
            Transaction currentTransaction = transactionList.get(i);
            if (currentTransaction.checkItemID(itemID)){
                itemSold += currentTransaction.getAmountOfItem();
            }
        }
        return itemSold;
    }
    //Sum all transactions of specific item
    public double getTotalProfitOfItem(String itemID){
        double itemProfit = 0.00;
        for (Transaction currentTransaction : transactionList) {
            if (currentTransaction.checkItemID(itemID)) {
                itemProfit += currentTransaction.getTotalPrice();
            }
        }
        itemProfit = Calculate.truncateDouble(itemProfit,2);
        return itemProfit;
    }
    //Concatenate printing information such as printing message, item info and all transactions for that item
    public String printItemTransaction(String itemID, String itemInfo){
        String s = System.lineSeparator();
        String printTransaction = "Transactions for item: ";

        if (totalNumberOfTransaction(itemID) == 0){

            printTransaction = printTransaction + itemInfo + s +
                    "No transactions have been registered for item " + itemID + " yet.";
        }else {
            int index = getIndexOfTransaction(itemID);
            String info = transactionList.get(index).getItemInfo();
            String allTransactions = collectItemTransactions(itemID);
            printTransaction = printTransaction + info + s + allTransactions;
        }
        return printTransaction;
    }
    //Taking index of transaction in transaction list to grab item info
    public int getIndexOfTransaction(String itemID){
        int index = 0;
        for (int i = 0; i < transactionList.size(); i++) {
            Transaction currentTransaction = transactionList.get(i);
            if (currentTransaction.checkItemID(itemID)) {
                index = i;
            }
        }
        return index;
    }
    //Collecting all transactions for specific item
    public String collectItemTransactions(String itemID){
        String itemTransactions = "";
        String s = System.lineSeparator();
        for (int i = 0; i < transactionList.size(); i++ ){
            Transaction currentTransaction = transactionList.get(i);
            if (currentTransaction.checkItemID(itemID) ){
                itemTransactions = itemTransactions + currentTransaction + s;
            }
        }
        return itemTransactions;
    }
    //Getting all transaction history for printing
    public String getAllTransactions(){
        String s = System.lineSeparator();
        String transactions = "";
        for (Transaction currentTransaction: transactionList){
            transactions += currentTransaction + s;
        }
        return transactions;
    }
    //Concatenate all transactions & other information to print
    public String printAllTransactions(){
        String s = System.lineSeparator();
        String line = "------------------------------------" + s;
        String printTransactions = "All purchases made: " + s +
                "Total profit: " + Utilities.formatDouble(getTotalProfit()) + " SEK" + s +
                "Total items sold: " + totalSoldItems + " units" + s +
                "Total purchases made: " + totalTransactions + " transactions" + s +
                line;
        printTransactions += getAllTransactions() + line;
        return printTransactions;
    }
    //Getting all items that have higher sum of profits
    public String getMostProfitableItem(){
        StringBuilder stringBuilder = new StringBuilder();
        String s = System.lineSeparator();
        stringBuilder.append("Most profitable items: "+ s);
        List<ItemRegistration> mostProfitableRegisteredItems = new ArrayList<>();
        if(!registrationList.isEmpty())
        {
            mostProfitableRegisteredItems.addAll(registrationList);
            mostProfitableRegisteredItems.sort(new SortByTotalProfit());
            double highestProfit = mostProfitableRegisteredItems.get(0).getTotalProfit();
            String itemInfo = mostProfitableRegisteredItems.get(0).getItemInfo();
            stringBuilder.append("Total profit: "+ highestProfit + " SEK" + s + itemInfo);
        }
        return stringBuilder.toString();
    }
}
