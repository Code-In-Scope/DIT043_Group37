package bussinessLogic;

import java.util.ArrayList;

public class TransactionManager {

    private final ArrayList<Transaction> transactionList;
    private int soldUnit = 0;
    private int totalTransaction = 0;


    public TransactionManager(){
        transactionList = new ArrayList<>();
    }

    public void registerTransaction(String itemID, int amountOfItem, double totalPrice, String itemInfo ){
        Transaction newTransaction = new Transaction(itemID, amountOfItem, totalPrice, itemInfo);
        transactionList.add(newTransaction);
        totalTransaction++;
        soldUnit += amountOfItem;
    }

    public int totalNumberOfTransaction(String itemID){
        int totalTransaction = 0;
        for (int i = 0; i < transactionList.size(); i++ ){
            Transaction currentTransaction = transactionList.get(i);
            if (currentTransaction.getItemID() == itemID){
                totalTransaction++;
            }
        }
        return totalTransaction;
    }
    //Concatenate printing information such as printing message, item info and all transactions for that item
    public String printItemTransaction(String itemID){
        String s = System.lineSeparator();
        String printTransaction = "Transactions for item: ";
        int index = getIndexOfTransaction(itemID);
        String itemInfo = transactionList.get(index).getItemInfo();
        String allTransactions = collectItemTransactions(itemID);
        printTransaction = printTransaction + itemInfo + s + allTransactions;

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

    public void unitSold( String itemID){

    }
}
