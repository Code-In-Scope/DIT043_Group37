package bussinessLogic.Employee;

import utility.Calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Director extends Manager {

    private String department;
    private List<String> validDepartment;
    private final double ADDITIONAL_SALARY = 5000;

    public Director(String id, String name, double grossSalary, String degree, String department) throws Exception {
        super(id, name, grossSalary, degree);
        validDepartment = new ArrayList<>(Arrays.asList("Business", "Human Resources", "Technical"));
        checkDepartment(department);
        this.department = department;
    }

    public void checkDepartment(String department) throws Exception {
        if (!validDepartment.contains(department)) {
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }
    }

    public double getGrossSalary() {
        return super.getGrossSalary() + ADDITIONAL_SALARY;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String updateDepartment) throws Exception {
        checkDepartment(updateDepartment);
        this.department = updateDepartment;
    }

    public double getNetIncome() {
        double netIncome;
        double mediumTax = 0.2;
        double highTax = 0.4;
        double highSalary = 50000;
        double lowSalary = 30000;

        netIncome = getGrossSalary();

        if (netIncome < lowSalary) {
            netIncome = netIncome - Calculate.deductTax(netIncome, getTax());
        } else if (netIncome <= highSalary) {
            netIncome = netIncome - Calculate.deductTax(netIncome, mediumTax);
        } else {
            double exceedSalary = netIncome - lowSalary;
            netIncome = netIncome - Calculate.deductTax(lowSalary, mediumTax)
                    - Calculate.deductTax(exceedSalary, highTax);
        }
        return netIncome;
    }

    public String toString() {
        return super.toString() + " Dept: " + department;
    }
}
