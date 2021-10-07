package bussinessLogic;

import facade.Facade;
import util.UserInput;

public class Item {
    private final String itemID;
    private String itemName;
    private double unitPrice;

    public Item(String itemID, String itemName, double unitPrice){
        this.itemID = itemID;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }

    public String getItemName(){
        return itemName;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    public void setItemName(String name){
        this.itemName = name;
    }
    public void setUnitPrice(double price){
        this.unitPrice = price;
    }

    public String ToString(){
        String printItem = this.itemID + ": " + this.itemName + ". " + this.unitPrice + "SEK.";
        return printItem ;
    }



}
