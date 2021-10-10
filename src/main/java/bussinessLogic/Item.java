package bussinessLogic;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Item {
    private String itemID;
    private String itemName;
    private double unitPrice;

    public Item(String itemID, String itemName, double unitPrice){
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }

    public String getItemName(){
        return itemName;
    }
    public double getUnitPrice(){ return unitPrice;
    }
    public void setItemName(String name){
        this.itemName = name;
    }
    public void setUnitPrice(float price){
        this.unitPrice = price;
    }

    public String ToString(){
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        String printItem = this.itemID + ": " + this.itemName + ". " + decimalFormat.format(this.unitPrice) + " SEK";
        return printItem ;
    }

}
