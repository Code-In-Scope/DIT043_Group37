package menu;

import bussinessLogic.Employee.InvalidDataException;
import facade.Facade;
import utility.UserInput;

public class EmployeeMenu {
    private static String s = System.lineSeparator();
    private static final Facade facade = new Facade();

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
                "9. Print all employees sorted by gross salary." + s + s);
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
                    addRegularEmployee();
                    break;
                case 2:
                    addManagerEmployee();
                    break;
                case 3:
                    addDirectorEmployee();
                    break;
                case 4:
                    addInternEmployee();
                    break;
                case 5:
                    removeEmployee();
                    break;
                case 6:
                    printSpecificEmployee();
                    break;
                case 7:
                    printAllEmployee();
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

    public static void addRegularEmployee(){
        String employeeId = UserInput.getInputString("Enter employee's ID: ");
        String employeeName = UserInput.getInputString("Enter employee's name: ");
        double grossSalary = UserInput.getInputDouble("Enter employee's gross salary: ");
        try {
            String message = facade.createEmployee(employeeId, employeeName, grossSalary);
            System.out.println(message);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public static void addManagerEmployee(){
        String employeeId = UserInput.getInputString("Enter employee's ID: ");
        String employeeName = UserInput.getInputString("Enter employee's name: ");
        double grossSalary = UserInput.getInputDouble("Enter employee's gross salary: ");
        String degree = UserInput.getInputString("Enter employee's degree: ");
        try {
            String message = facade.createEmployee(employeeId, employeeName, grossSalary, degree);
            System.out.println(message);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public static void addDirectorEmployee(){
        String employeeId = UserInput.getInputString("Enter employee's ID: ");
        String employeeName = UserInput.getInputString("Enter employee's name: ");
        double grossSalary = UserInput.getInputDouble("Enter employee's gross salary: ");
        String degree = UserInput.getInputString("Enter employee's degree: ");
        String dept = UserInput.getInputString("Enter employee's department: ");
        try {
            String message = facade.createEmployee(employeeId, employeeName, grossSalary, degree, dept);
            System.out.println(message);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public static void addInternEmployee(){
        String employeeId = UserInput.getInputString("Enter employee's ID: ");
        String employeeName = UserInput.getInputString("Enter employee's name: ");
        double grossSalary = UserInput.getInputDouble("Enter employee's gross salary: ");
        String gpa = UserInput.getInputString("Enter employee's gpa: ");
        try {
            String message = facade.createEmployee(employeeId, employeeName, grossSalary, gpa);
            System.out.println(message);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public static void removeEmployee(){
        String employeeID = UserInput.getInputString("Enter employee's ID to remove: ");
        try {
            String message = facade.removeEmployee(employeeID);
            System.out.println(message);
        }catch (Exception e){
            System.out.println("Employee" + employeeID + " was not registered yet.");
        }
    }

    public static void printSpecificEmployee(){
        String employeeId = UserInput.getInputString("Enter employee's ID to print: ");
        try {
            String print = facade.printAllEmployees();
            System.out.println(print);
        }catch (Exception exception){
            System.out.println("Employee " + employeeId + " was not registered yet.");
        }
    }

    public static void printAllEmployee(){
        try {
            String print = facade.printAllEmployees();
            System.out.println(print);
        }catch (Exception exception){
            System.out.println("No employee has been registered yet.");
        }
    }

    public static void getNetSalary(){
        double netSalary;
        String employeeId = UserInput.getInputString("Enter employee's Id to get net salary: ");
        try {
            netSalary = facade.getNetSalary(employeeId);
            System.out.println(netSalary);
        }catch (Exception exception){
            System.out.println(exception);
        }
    }




}
