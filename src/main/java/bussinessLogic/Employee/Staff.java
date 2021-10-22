package bussinessLogic.Employee;

import java.util.ArrayList;

public class Staff {

    ArrayList<Employee> employeeList;

    public Staff(){
        employeeList = new ArrayList<>();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        Employee newEmployee = new Employee(employeeID,employeeName, grossSalary);
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        Employee newEmployee = new Manager(employeeID,employeeName, grossSalary, degree);
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        Employee newEmployee = new Director(employeeID,employeeName, grossSalary, degree, dept);
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        Employee newEmployee = new Intern(employeeID,employeeName, grossSalary, gpa);
        return "Employee " + employeeID + " was registered successfully.";
    }



}
