package bussinessLogic.Employee;

import utility.Utilities;

public class Intern extends Employee {

    private int GPA;
    private final double reward = 1000;
    private double grossSalary;
    private double netSalary;

    public Intern(String id, String name, double grossSalary, int GPA) throws Exception {
        super(id, name, grossSalary);
        this.GPA = GPA;
        calculateIncome();
    }

    public void calculateIncome() {
        if (GPA <= 5) {
            grossSalary = 0;
        } else if (GPA < 8) {
            grossSalary = super.getGrossSalary();
        } else if (GPA < 11) {
            grossSalary = super.getGrossSalary() + reward;
        }
        netSalary = grossSalary;
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
        return getEmployeeName() + "'s gross salary is " + Utilities.formatDouble(getGrossSalary())
                + " SEK per month. GPA: " + GPA;
    }
}
