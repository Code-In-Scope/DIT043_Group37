package bussinessLogic.Employee;

import utility.Calculate;
import utility.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Director extends Manager {

    private final String department;
    private final double additionalSalary = 5000;
    private double grossSalary;
    private double netSalary;
    private final List<String> validDepartment;

    public Director(String id, String name, double grossSalary, String degree, String department) throws Exception {
        super(id, name, grossSalary, degree);
        validDepartment = new ArrayList<>(Arrays.asList("Business", "Human Resources", "Technical"));
        if (!validDepartment.contains(degree)) {
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }
        this.department = department;
        calculateIncome();

    }

    public void calculateIncome() {
        double mediumTax = 0.2;
        double highTax = 0.4;
        double highSalary = 50000;
        double lowSalary = 30000;

        grossSalary = super.getGrossSalary() + additionalSalary;

        if (grossSalary < lowSalary) {
            netSalary = grossSalary - Calculate.deductTax(grossSalary, this.tax);
        } else if (grossSalary < highSalary) {
            netSalary = grossSalary - Calculate.deductTax(grossSalary, mediumTax);
        } else {
            double minimumSalary = lowSalary - Calculate.deductTax(lowSalary, mediumTax);
            double exceedSalary = grossSalary - lowSalary;
            double exceedingSalary = exceedSalary - Calculate.deductTax(exceedSalary, highTax);

            netSalary = minimumSalary + exceedingSalary;
        }
    }

    public String setGrossSalary(double newGrossSalary) throws Exception {
        String message = super.setGrossSalary(newGrossSalary);
        calculateIncome();
        return message;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getNetIncome() {
        return netSalary;
    }

    public String toString() {
        return super.toString() + department;
    }
}
