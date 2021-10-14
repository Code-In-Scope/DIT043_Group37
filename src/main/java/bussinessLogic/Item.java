package bussinessLogic;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class Item {
    private final String itemID;
    private String itemName;
    private double unitPrice;
    ArrayList<ReviewItem> reviewList;

    public Item(String itemID, String itemName, double unitPrice){
        this.itemID = itemID;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.reviewList = new ArrayList<>();
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

    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null || !(anotherObject instanceof Item)) {
            return false;
        } else {
            Item item = (Item) anotherObject;
            return itemID == item.itemID;
        }
    }

    public int hashCode(){
        return Objects.hash(itemID);
    }

    public String printItem(){
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        String printItem = this.itemID + ": " + this.itemName + ". " + decimalFormat.format(this.unitPrice) + " SEK";
        return printItem ;
    }






}
