package util;

public class Calculate{
    public static double getDiscount(double unitPrice, double discountRate){
        double discountResult = unitPrice * discountRate;
        return discountResult;
    }

    public static double getTotalAmount(int quantity, double price){
        double totalPrice = quantity * price;
        return totalPrice;
    }
}
