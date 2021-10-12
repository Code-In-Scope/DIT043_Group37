package bussinessLogic;

import util.Calculate;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Item {
    private String itemID;
    private String itemName;
    private double unitPrice;

    public Item(String itemID, String itemName, double unitPrice){
        this.itemID = itemID;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }
    public String getItemID() { return itemID; }
    public String getItemName(){
        return itemName;
    }
    public double getUnitPrice() { return unitPrice; }
    public void setItemName(String name){
        this.itemName = name;
    }
    public void setUnitPrice(double price){
        this.unitPrice = price;
    }

    public String printItem(){
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        String printItem = this.itemID + ": " + this.itemName + ". " + decimalFormat.format(this.unitPrice) + " SEK";
        return printItem ;
    }



}
