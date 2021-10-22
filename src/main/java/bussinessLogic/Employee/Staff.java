package bussinessLogic.Employee;

import java.util.ArrayList;

public class Staff {

    ArrayList<Employee> employeeList;

    public Staff(){
        employeeList = new ArrayList<>();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        this.employeeList.add(new Employee(employeeID,employeeName, grossSalary));
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        this.employeeList.add(new Manager(employeeID,employeeName, grossSalary, degree));
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        this.employeeList.add(new Director(employeeID,employeeName, grossSalary, degree, dept));
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        this.employeeList.add(new Intern(employeeID,employeeName, grossSalary, gpa));
        return "Employee " + employeeID + " was registered successfully.";
    }
}
