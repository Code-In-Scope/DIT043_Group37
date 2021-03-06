package menu;
import facade.Facade;
import utility.UserInput;

public class ItemMenu {
    private static final String s = System.lineSeparator();
    private static final Facade facade = new Facade();

    private static void displayOptionMenu(){
        System.out.print("Item options menu:"+ s +
                "0. Return to Main menu. " + s +
                "1. Create an Item." + s +
                "2. Remove an Item." + s +
                "3. Print all registered Items." + s +
                "4. Buy an Item." + s +
                "5. Update an item's name." + s +
                "6. Update an item's price." + s +
                "7. Print a specific item."+ s +s );
    }

    public static void getItemOption(){

        displayOptionMenu();

        int userOption;
        do {
            userOption = UserInput.getInputInt("Type an option number: ");

            switch (userOption){
                case 0:
                    MainMenu.getMainMenuOption();
                    break;
                case 1:
                    createNewItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    printAllItem();
                    break;
                case 4:
                    buyItem();
                    break;
                case 5:
                    updateItemName();
                    break;
                case 6:
                    updateItemPrice();
                    break;
                case 7:
                    printItem();
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another option.");
            }
        }while (userOption != 0);
    }

    public static void createNewItem() {
        String itemID = UserInput.getInputString("Type item's ID: ");
        String itemName = UserInput.getInputString("Type item's name: ");
        double unitPrice = UserInput.getInputDouble("Type unit price: ");
        String  message = facade.createItem(itemID, itemName, unitPrice);
        System.out.println(message);
    }

    public static void printItem(){
        String inputID = UserInput.getInputString("Enter item ID to print item.");
        String message = facade.printItem(inputID);
        System.out.println(message);
    }

    public static void removeItem(){
        String input = UserInput.getInputString("Enter item ID to remove item.");
        String message = facade.removeItem(input);
        System.out.println(message);
    }

    public static void buyItem(){
        String inputID = UserInput.getInputString("Enter item ID to buy an item.");
        int inputAmount = UserInput.getInputInt("Enter amount of the items to buy.");
        double totalPrice = facade.buyItem(inputID, inputAmount);
        System.out.println(totalPrice);
    }

    public static void updateItemName(){
        String inputID = UserInput.getInputString("Enter item ID to update the name of the item.");
        String itemName= UserInput.getInputString("Enter item name.");
        String message = facade.updateItemName(inputID,itemName);
        System.out.print(message);
    }

    public static void updateItemPrice(){
        String itemID = UserInput.getInputString("Enter item ID to update the price of the item. ");
        double itemPrice = UserInput.getInputDouble("Enter price of the item.");
        String message = facade.updateItemPrice(itemID,itemPrice);
        System.out.println(message);
    }

    public static void printAllItem(){
        String message = facade.printAllItems();
        System.out.println(message);
    }
}
