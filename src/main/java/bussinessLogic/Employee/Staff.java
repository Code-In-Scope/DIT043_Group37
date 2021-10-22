package bussinessLogic.Employee;

import java.util.ArrayList;
import utility.Calculate;

public class Staff {

    ArrayList<Employee> employeeList;

    public Staff() {
        employeeList = new ArrayList<>();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        this.employeeList.add(new Employee(employeeID, employeeName, grossSalary));
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree)
            throws Exception {
        this.employeeList.add(new Manager(employeeID, employeeName, grossSalary, degree));
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept)
            throws Exception {
        this.employeeList.add(new Director(employeeID, employeeName, grossSalary, degree, dept));
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        this.employeeList.add(new Intern(employeeID, employeeName, grossSalary, gpa));
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        int index = employeeIDExists(empID);
        return employeeList.get(index).setEmployeeName(newName);
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        int index = employeeIDExists(empID);
        return employeeList.get(index).setGrossSalary(newSalary);
    }

    public int employeeIDExists(String employeeID) throws Exception {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).checkEmployeeId(employeeID)) {
                return i;
            }
        }
        throw new Exception("Employee " + employeeID + " was not registered yet.");
    }

    public String printEmployee(String employeeID) throws Exception {
        int index = employeeIDExists(employeeID);
        return employeeList.get(index).toString();
    }

    public double getNetSalary(String employeeID) throws Exception {
        int index = employeeIDExists(employeeID);
        double netIncome = employeeList.get(index).getNetIncome();
        return Calculate.truncateDouble(netIncome, 1);
    }
}
