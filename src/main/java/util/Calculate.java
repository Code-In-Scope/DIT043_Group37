package util;

import bussinessLogic.Item;

import java.util.ArrayList;

public class Calculate{
    public static double getDiscount(double unitPrice, double discountRate){
        return unitPrice * discountRate;
    }

    public static double getTotalAmount(int quantity, double price){
        return quantity * price;
    }
    public static double toTruncate(double number)
    {
        return (Math.floor(number*100)/100);
    }
    public static int itemIndexExists(ArrayList<Item> itemList , String itemID)
    {
        for (int i=0;i< itemList.size();i++)
        {
            if(itemList.get(i).getItemID()==itemID)
                return i;
        }
        return -1;
    }
}
