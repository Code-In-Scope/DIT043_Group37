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

    public static double truncateDouble(double number, int decimalPlace){
        number = number * Math.pow(10,2);
        number = Math.floor(number);
        number = number / Math.pow(10, decimalPlace);
        return number;
    }
}
