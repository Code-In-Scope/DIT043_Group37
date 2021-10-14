package menu;

import facade.Facade;
import util.UserInput;

public class TransactionMenu {
    private static final String s = System.lineSeparator();
    private static final Facade facade = new Facade();


    private static void displayOptionMenu(){
        System.out.println("Transaction History options menu: " + s +
                "0. Return to Main Menu." + s +
                "1. Print total profit from all item purchases." + s +
                "2. Print total units sold from all item purchases" + s +
                "3. Print the total number of item transactions made." + s +
                "4. Print all transactions made." + s +
                "5. Print the total profit of a specific item." + s +
                "6. Print the number of units sold of a specific item." + s +
                "7. Print all transactions of a specific item." + s +
                "8. Print item with highest profit." + s );
    }

    public static void getTransactionOption(){
        displayOptionMenu();
        int userOption;
        do {
            userOption = UserInput.getInputInt("Type an option number: ");

            switch (userOption){
                case 0:
                    MainMenu.getMainMenuOption();
                    break;
                case 1:
                    printTotalProfit();
                    break;
                case 2:
                    printTotalSold();
                    break;
                case 3:
                    totalItemTransactions();
                    break;
                case 4:
                    printAllTransactions();
                    break;
                case 5:
                    printItemProfit();
                    break;
                case 6:
                    printItemSoldUnits();
                    break;
                case 7:
                    printItemTransaction();
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another option.");
            }
        }while (userOption != 0);
    }

    public static void printTotalProfit(){
        double profit = facade.getTotalProfit();
        System.out.println(profit);
    }

    public static void printTotalSold(){
        int totalSold = facade.getTotalUnitsSold();
        System.out.println(totalSold);
    }

    public static void totalItemTransactions(){
        String itemID = UserInput.getInputString("Enter item ID to print total number of transaction: ");
        int itemTransactions = facade.numberOfItemTransactions(itemID);
        System.out.println(itemTransactions);
    }
    public static void printItemTransaction(){
        String itemID = UserInput.getInputString("Enter item ID to print all transactions: ");
        String printTransaction = facade.printItemTransactions(itemID);
        System.out.println(printTransaction);
    }

    public static void printAllTransactions(){
        String allTransactions = facade.printAllTransactions();
        System.out.println(allTransactions);
    }

    public static void printItemProfit(){
        String itemID = UserInput.getInputString("Enter item ID to print item's total profit: ");
        double itemProfit = facade.getProfit(itemID);
        System.out.println(itemProfit);
    }

    public static void printItemSoldUnits(){
        String itemID = UserInput.getInputString("Enter item ID to print item's total sold units: ");
        int soldUnits = facade.getUnitsSolds(itemID);
        System.out.println(soldUnits);
    }

}
