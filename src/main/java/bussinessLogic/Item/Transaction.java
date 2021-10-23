package bussinessLogic.Item;

import utility.Calculate;

public class Transaction {
    private String itemID;
    private String itemInfo;
    private int amountOfItem;
    private Double totalPrice;

    public Transaction (String itemID, int amountOfItem, Double totalPrice, String itemInfo){
        this.itemID = itemID;
        this.amountOfItem = amountOfItem;
        this.totalPrice = totalPrice;
        this.itemInfo = itemInfo;
    }

    public String getItemID(){
        return this.itemID;
    }

    public int getAmountOfItem(){
        return this.amountOfItem;
    }

    public double getTotalPrice(){
        return this.totalPrice;
    }

    public String getItemInfo(){
        return this.itemInfo;
    }

    public String toString(){
        String printTransaction = itemID + ": "+ amountOfItem + " item(s). " + Calculate.formatDouble(totalPrice)  + " SEK";
        return printTransaction;
    }

    public boolean checkItemID(String itemID){
        return this.itemID.equals(itemID);
    }
}
