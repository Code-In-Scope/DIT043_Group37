package util;

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
}
