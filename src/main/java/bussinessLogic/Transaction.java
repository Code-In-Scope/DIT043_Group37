package bussinessLogic;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Transaction {
    private String itemID;
    private String itemInfo;
    private int amountOfItem;
    private Double totalPrice;
    private DecimalFormat decimalFormat;

    public Transaction (String itemID, int amountOfItem, Double totalPrice, String itemInfo){
        this.itemID = itemID;
        this.amountOfItem = amountOfItem;
        this.totalPrice = totalPrice;
        this.itemInfo = itemInfo;
        this.decimalFormat = new DecimalFormat(".00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
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
        String printTransaction = itemID + ": "+ amountOfItem + " item(s). " + decimalFormat.format(totalPrice)  + " SEK";
        return printTransaction;
    }

    public boolean checkItemID(String itemID){
        return this.itemID.equals(itemID);
    }
}
