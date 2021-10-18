package menu;

import utility.UserInput;

public class EmployeeMenu {
    private static String s = System.lineSeparator();

    public static void displayMenu(){
        System.out.println("Employee options menu: " + s +
                "0. Return to Main Menu." + s +
                "1. Create an employee (Regular Employee)." + s +
                "2. Create an employee (Manager)." + s +
                "3. Create an employee (Director)." + s +
                "4. Create an employee (Intern)." + s +
                "5. Remove an employee." + s +
                "6. Print specific employee." + s +
                "7. Print all registered employees." + s +
                "8. Print the total expense with net salary." + s +
                "9. Print all employees sorted by gross salary." + s);
    }

    public static void getEmployeeMenuOption(){
        displayMenu();
        int userOption;
        do {
            userOption = UserInput.getInputInt("Type an option number: ");

            switch (userOption){
                case 0:
                    MainMenu.getMainMenuOption();
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Invalid menu option. Please type another option.");
            }
        }while (userOption != 0);
    }
}
