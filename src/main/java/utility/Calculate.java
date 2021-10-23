package utility;

public class Calculate{

    public static double getDiscount(double unitPrice, double discountRate){
        return unitPrice * discountRate;
    }

    public static double getTotalAmount(int quantity, double price){
        return quantity * price;
    }

    public static double truncateDouble(double number, int decimalPlace){
        int truncateNum = (int)(number * Math.pow(10, decimalPlace));
        return (double) truncateNum / Math.pow(10, decimalPlace);
    }

    public static String formatDouble(double value) {
        String stringValue = String.valueOf(value);
        // If in case the string does not have sufficient values after decimal points
        stringValue += "00";
        int index = stringValue.lastIndexOf(".") + 3;
        return stringValue.substring(0, index);
    }

    public static double deductTax(double salary, double tax){
        return (salary * tax );
    }
}
