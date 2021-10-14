package bussinessLogic;

public class Transaction {
    private final String itemID;
    private final String itemInfo;
    private final int amountOfItem;
    private final Double totalPrice;

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
        String printTransaction = itemID + ": "+ amountOfItem + " item(s). " + totalPrice + " SEK";
        return printTransaction;
    }
}
