package bussinessLogic;

public class Transaction {
    String itemID;
    int amountOfItem;
    Double totalPrice;

    public Transaction (String itemID, int amountOfItem, Double totalPrice){
        this.itemID = itemID;
        this.amountOfItem = amountOfItem;
        this.totalPrice = totalPrice;
    }

    public String toString(){
        String printTransaction = itemID + ": "+ amountOfItem + "item(s). " + totalPrice + " SEK";
        return printTransaction;
    }
}
