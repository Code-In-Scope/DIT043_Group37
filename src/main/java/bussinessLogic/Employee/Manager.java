package bussinessLogic.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.Calculate;

import utility.Utilities;

public class Manager extends Employee {

    private String degree;
    private double grossSalary;
    private double netSalary;
    private List<String> validDegrees = new ArrayList<>(Arrays.asList("BSc", "MSc", "PhD"));

    public Manager(String id, String name, double salary, String degree) throws Exception {
        super(id, name, salary);
        if (!validDegrees.contains(degree)) {
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }
        this.degree = degree;
        calculateIncome();
    }

    public double calculateBonus() {
        double bonus = 0.0;
        if (degree == "BSc") {
            bonus = super.getGrossSalary() * 0.1;
        } else if (degree == "MSc") {
            bonus = super.getGrossSalary() * 0.2;
        } else {
            bonus = super.getGrossSalary() * 0.35;
        }
        return bonus;
    }

    public void calculateIncome() {
        grossSalary = super.getGrossSalary() + calculateBonus();
        netSalary = grossSalary - Calculate.deductTax(grossSalary, tax);
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

    public String getDegree() {
        return degree;
    }

    public String toString() {
        return degree + " " + getEmployeeName() + "'s gross salary is " + Utilities.formatDouble(grossSalary)
                + " SEK per month.";
    }

}
