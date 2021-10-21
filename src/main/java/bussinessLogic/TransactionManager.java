package bussinessLogic;

import utility.Calculate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class SortByTotalProfit implements Comparator<ItemRegister>{
   public int compare(ItemRegister a, ItemRegister b)
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

    private ArrayList<Transaction> transactionList;
    private int totalSoldItems;
    private int totalTransactions;
    private double totalProfit;
    private ArrayList<ItemRegister> registerItemList;

    public TransactionManager(){
        transactionList = new ArrayList<>();
        totalSoldItems = 0;
        totalTransactions = 0;
        totalProfit = 0.00;
        registerItemList = new ArrayList<>();
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
        //Transaction newTransaction = new Transaction(itemID, amountOfItem, totalPrice, itemInfo);
        transactionList.add(new Transaction(itemID, amountOfItem, totalPrice, itemInfo));
        totalTransactions++;
        addSoldItems(amountOfItem);
        addProfit(totalPrice);
    }


    private void addProfit(double price){
        this.totalProfit = this.totalProfit + price;
        this.totalProfit = Calculate.truncateDouble(totalProfit, 2);
    }

    private void addSoldItems(int purchasedAmount){
        this.totalSoldItems = this.totalSoldItems + purchasedAmount;
    }

    //Total transaction of specific item
    public int totalNumberOfTransaction(String itemID){
        int itemTransactions = 0;
        for (int i = 0; i < transactionList.size(); i++) {
            Transaction currentTransaction = transactionList.get(i);
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
        for (int i = 0; i < transactionList.size(); i++){
            Transaction currentTransaction = transactionList.get(i);
            if (currentTransaction.checkItemID(itemID)){
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
                "Total profit: " + totalProfit + " SEK" + s +
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
        List<ItemRegister> mostProfitableRegisteredItems =new ArrayList<>();
        if(!registerItemList.isEmpty())
        {
            mostProfitableRegisteredItems.addAll(registerItemList);
            mostProfitableRegisteredItems.sort(new SortByTotalProfit());
            double highestProfit = mostProfitableRegisteredItems.get(0).getTotalProfit();
            String itemInfo = mostProfitableRegisteredItems.get(0).getItemInfo();
            stringBuilder.append("Total profit: "+ highestProfit + " SEK" + s + itemInfo);
            for (ItemRegister item: mostProfitableRegisteredItems)
            {
                if(item.getTotalProfit() < highestProfit)
                {
                    break;
                }
                // add the output string here

            }
            return stringBuilder.toString();

        }
        return stringBuilder.toString();
    }

}
