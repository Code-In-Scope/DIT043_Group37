package bussinessLogic.Employee;

import utility.Calculate;

public class Manager extends Employee{

    private String degree;

    public Manager(String id, String name, double salary, String degree){
        super(id, name, salary);
        this.degree = degree;
    }

    public double calculateBonus(){
        double bonus = 0.0;
        if (degree == "BSc"){
            bonus = super.grossSalary * 0.1;
        }else if (degree == "MSc"){
            bonus = super.grossSalary * 0.2;
        }else{
            bonus = super.grossSalary * 0.35;
        }
        return bonus;
    }

    public double calculateNetIncome(){
        double netSalary;
        double salary = getGrossSalary() + calculateBonus();
        netSalary = salary - Calculate.deductTax(salary, this.tax);
        return netSalary;
    }

    public String toString(){
        return degree + " " + getEmployeeName() + "'s grossSalary is " + getGrossSalary() + " SEK per month.";
    }


}
