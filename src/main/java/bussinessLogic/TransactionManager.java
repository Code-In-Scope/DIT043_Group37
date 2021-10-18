package bussinessLogic;

import java.util.ArrayList;

public class TransactionManager {

    private final ArrayList<Transaction> transactionList;
    private int totalSoldItems;
    private int totalTransactions;
    private double totalProfit;


    public TransactionManager(){
        transactionList = new ArrayList<>();
        totalSoldItems = 0;
        totalTransactions = 0;
        totalProfit = 0;
    }

    public int getTotalTransactions(){
        return this.totalTransactions;
    }

    public int getTotalSoldItems(){
        return this.totalSoldItems;
    }

    public double getTotalProfit(){
        return this.totalProfit;
    }

    public void registerTransaction(String itemID, int amountOfItem, double totalPrice, String itemInfo ){
        Transaction newTransaction = new Transaction(itemID, amountOfItem, totalPrice, itemInfo);
        transactionList.add(newTransaction);
        totalTransactions++;
        totalSoldItems += amountOfItem;
        totalProfit += totalPrice;
    }

    //Total transaction of specific item
    public int totalNumberOfTransaction(String itemID){
        int itemTransactions = 0;
        for (int i = 0; i < transactionList.size(); i++){
            Transaction currentTransaction = transactionList.get(i);
            if (currentTransaction.getItemID().equals(itemID)){
                itemTransactions++;
            }
        }
        return itemTransactions;
    }
    //Count sold units for specific item
    public int getTotalSoldUnits(String itemID){
        int itemSold = 0;
        for (int i = 0; i < transactionList.size(); i++ ){
            Transaction currentTransaction = transactionList.get(i);
            if (currentTransaction.getItemID().equals(itemID)){
                itemSold += currentTransaction.getAmountOfItem();
            }
        }
        return itemSold;
    }
    //Sum all transactions of specific item
    public double getTotalProfitOfItem(String itemID){
        double itemProfit = 0.0;
        for (int i = 0; i < transactionList.size(); i++){
            Transaction currentTransaction = transactionList.get(i);
            if (currentTransaction.getItemID().equals(itemID)){
                itemProfit += currentTransaction.getTotalPrice();
            }
        }
        return itemProfit;
    }
    //Concatenate printing information such as printing message, item info and all transactions for that item
    public String printItemTransaction(String itemID){
        String s = System.lineSeparator();
        String printTransaction = "Transactions for item: ";
        int index = getIndexOfTransaction(itemID);
        String itemInfo = transactionList.get(index).getItemInfo();
        if (totalNumberOfTransaction(itemID) == 0){
            printTransaction = printTransaction + itemInfo + s +
                    "No transactions have been registered for item " + itemID + " yet";
        }else {
            String allTransactions = collectItemTransactions(itemID);
            printTransaction = printTransaction + itemInfo + s + allTransactions;
        }
        return printTransaction;
    }
    //Taking index of transaction in transaction list to grab item info
    public int getIndexOfTransaction(String itemID){
        int index = 0;
        for (int i = 0; i < transactionList.size(); i++){
            Transaction currentTransaction = transactionList.get(i);
            if (currentTransaction.getItemID() == itemID){
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
            if (currentTransaction.getItemID().equals(itemID) ){
                itemTransactions = itemTransactions + currentTransaction + s;
                System.out.println( itemTransactions.toString());
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
        String printTransactions = "All purchases made:" + s +
                "Total profit: " + totalProfit + " SEK" + s +
                "Total items sold: " + totalSoldItems + " units" + s +
                "Total purchases made: " + totalTransactions + "transactions" + s +
                "------------------------------------";
        if (!getAllTransactions().isEmpty()){
            printTransactions += getAllTransactions();
        }
        return printTransactions;
    }

    public String getMostProfitableItem(){
        double mostProfitableItem;
        for (int i = 0; i < transactionList.size(); i++){
            Transaction currentTransaction = transactionList.get(i);
            if (currentTransaction.getSumPurchase() < transactionList.get(i+1).getSumPurchase()){

            }
        }
        return"";
    }

}
