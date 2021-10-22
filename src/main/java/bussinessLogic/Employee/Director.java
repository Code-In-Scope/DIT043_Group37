package bussinessLogic.Employee;

import utility.Calculate;

public class Director extends Manager {

    private String department;
    private final double additionalSalary = 5000;

    public Director(String id, String name, double grossSalary,String degree, String department) throws Exception{
        super(id, name, grossSalary, degree);
        this.department = department;
    }
    public double calculateNetIncome(){
        double netSalary;
        double mediumTax = 0.2;
        double highTax = 0.4;
        double highSalary = 50000;
        double lowSalary = 30000;

        double salary = getGrossSalary() + calculateBonus() + additionalSalary;

        if (salary < lowSalary){
            netSalary = salary - Calculate.deductTax(salary, this.tax);
        }else if (salary < highSalary){
            netSalary = salary - Calculate.deductTax(salary, mediumTax);
        }else {
            double minimumSalary = lowSalary - Calculate.deductTax(lowSalary, mediumTax);
            double exceedSalary = salary - lowSalary;
            double exceedingSalary = exceedSalary - Calculate.deductTax(exceedSalary, highTax);

            netSalary = minimumSalary + exceedingSalary;
        }
        return netSalary;
    }

    public String toString(){
        String print = super.toString();
        print = print + " Dept: " + department;
        return print;
    }
}

