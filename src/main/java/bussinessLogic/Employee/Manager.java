package bussinessLogic.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.Calculate;

public class Manager extends Employee {

    private String degree;
    double bonus;
    private List<String> validDegrees;

    public Manager(String id, String name, double salary, String degree) throws Exception {
        super(id, name, salary);
        validDegrees = new ArrayList<>(Arrays.asList("BSc", "MSc", "PhD"));
        checkValidDegree(degree);
        this.degree = degree;
        this.bonus = calculateBonus();
    }

    public void checkValidDegree(String degree)throws Exception{
        if (!validDegrees.contains(degree)) {
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }
    }

    public double calculateBonus() {
        double salary = super.getGrossSalary();
        if (degree == "BSc") {
            bonus = salary * 0.10;
        } else if (degree == "MSc") {
            bonus = salary * 0.20;
        } else{
            bonus = salary * 0.35;
        }
        return bonus;
    }

    public double getGrossSalary(){
        return super.getGrossSalary() + this.bonus;
    }

    public double getNetIncome() {
        double netIncome;
        netIncome = super.getGrossSalary() + calculateBonus();
        netIncome = netIncome - Calculate.deductTax(netIncome, tax);
        return netIncome;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String updateDegree)throws Exception{
        checkValidDegree(updateDegree);
        this.degree = updateDegree;
    }

    public String toString() {
        return degree + " " + super.toString();
    }
}
