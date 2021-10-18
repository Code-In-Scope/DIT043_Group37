package utility;

public class Calculate{
    public static double getDiscount(double unitPrice, double discountRate){
        return unitPrice * discountRate;
    }

    public static double getTotalAmount(int quantity, double price){
        return quantity * price;
    }

    public static double truncateDouble(double number, int decimalPlace){
        number = number * Math.pow(10, decimalPlace);
        number = Math.floor(number);
        number = number / Math.pow(10, decimalPlace);
        return number;
    }
}
