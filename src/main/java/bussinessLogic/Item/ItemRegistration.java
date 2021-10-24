package bussinessLogic.Item;

public class ItemRegistration {
    private String itemID;
    private int soldUnits;
    private double totalProfit;
    private String itemInfo;

    public ItemRegistration(String itemID, int amount, double totalProfit, String itemInfo){
        this.itemID = itemID;
        this.soldUnits = amount;
        this.totalProfit = totalProfit;
        this.itemInfo = itemInfo;
    }

    public String getItemID(){
        return this.itemID;
    }

    public String getItemInfo(){
        return this.itemInfo;
    }

    public double getTotalProfit(){
        return this.totalProfit;
    }

    public void addProfit(double totalPrice){
        this.totalProfit = this.totalProfit + totalPrice;
    }

    public void addSoldUnit(int soldUnits){
        this.soldUnits = this.soldUnits + soldUnits;
    }

    public boolean checkItemID(String itemID){
        return this.itemID.equals(itemID);
    }

}
