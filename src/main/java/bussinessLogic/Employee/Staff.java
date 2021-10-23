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
        System.out.println(employeeList.get(0));
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

    public String printAllEmployees() throws Exception{
        if (employeeList.isEmpty()){
            throw new Exception("No employees registered yet.");
        }else {
            String s = System.lineSeparator();
            String print = "All registered employees:" + s;
            for (int i = 0; i < employeeList.size(); i++) {
                print = print + employeeList.get(i).toString() + s;
            }
            return print;
        }
    }

    public double getNetSalary(String employeeID) throws Exception {
        int index = employeeIDExists(employeeID);
        double netIncome = employeeList.get(index).getNetIncome();
        return Calculate.truncateDouble(netIncome, 2);
    }

    public double getTotalNetSalary() throws Exception{
        if (employeeList.isEmpty()){
            throw new Exception("No employees registered yet.");
        }else{
            double totalNetSalary = 0.0;
            for (Employee employee : employeeList){
                totalNetSalary = totalNetSalary + employee.getGrossSalary();
                Calculate.truncateDouble(totalNetSalary, 2);

            }
            return totalNetSalary;
        }
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        int index = employeeIDExists(empID);
        Manager temp = (Manager)employeeList.get(index);
            temp.setDegree(newDegree);
        return "Employee " + empID + " was updated successfully.";
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        int index = employeeIDExists(empID);
        Director temp = (Director)employeeList.get(index);
        temp.setDepartment(newDepartment);
        return "Employee " + empID + " was updated successfully.";
    }
}
