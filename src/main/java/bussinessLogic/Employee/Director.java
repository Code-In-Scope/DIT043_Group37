package bussinessLogic.Employee;

import utility.Calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Director extends Manager {

    private final String department;
    private final double additionalSalary = 5000;
    private final List<String> validDepartment;

    public Director(String id, String name, double grossSalary, String degree, String department) throws Exception {
        super(id, name, grossSalary, degree);
        validDepartment = new ArrayList<>(Arrays.asList("Business", "Human Resources", "Technical"));
        if (!validDepartment.contains(degree)) {
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }
        this.department = department;
    }

    public double getNetIncome() {
        double netIncome;
        double mediumTax = 0.2;
        double highTax = 0.4;
        double highSalary = 50000;
        double lowSalary = 30000;

        netIncome = super.getGrossSalary() + additionalSalary;

        if (netIncome < lowSalary) {
            netIncome = netIncome - Calculate.deductTax(netIncome, this.tax);
        } else if (netIncome < highSalary) {
            netIncome = netIncome - Calculate.deductTax(netIncome, mediumTax);
        } else {
            double minimumSalary = lowSalary - Calculate.deductTax(lowSalary, mediumTax);
            double exceedSalary = netIncome - lowSalary;
            double exceedingSalary = exceedSalary - Calculate.deductTax(exceedSalary, highTax);

            netIncome = minimumSalary + exceedingSalary;
        }
        return netIncome;
    }

    public String toString() {
        return super.toString() + department;
    }
}
