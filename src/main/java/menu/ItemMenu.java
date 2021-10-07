package menu;
import facade.Facade;
import util.UserInput;

public class ItemMenu {
    private static String s = System.lineSeparator();
    public static void displayOptionMenu(){
        System.out.print("Item options menu:"+ s +
                "0. Return to Main menu. " + s +
                "1. Create an Item." + s +
                "2. Remove an Item." + s +
                "3. Print all registered Items." + s +
                "4. Buy an Item." + s +
                "5. Update an item's name." + s +
                "6. Update an item's price." + s +
                "");
    }

    public static void getItemOptionMenu(){
        int userOption;
        int startingOption = 0;
        int endingOption = 6;
        displayOptionMenu();
        Facade facade = new Facade();
        do {
            userOption = UserInput.getInputInt("Type an option number: ");
            switch (userOption){
                case 0:
                    break;
                case 1:
                    System.out.println(facade.newItem());
                    MainMenu.getMainMenuOption();
                    break;
                case 2: break;
                case 3:
                    System.out.println(facade.printAllItems());
                    MainMenu.getMainMenuOption();
                    break;
                case 4: break;
                case 5: break;
                case 6: break;
                default:
                    System.out.println("Invalid menu option. Please type another option.");
            }
        }while (userOption < startingOption || userOption > endingOption);
    }
}
