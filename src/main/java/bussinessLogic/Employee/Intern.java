package bussinessLogic.Employee;

public class Intern extends Employee{

    private int GPA;
    private final double reward = 1000;

    public Intern(String id, String name, double grossSalary, int GPA) throws InvalidDataException{
        super(id, name, grossSalary);
        this.GPA = GPA;
    }

    public double calculateNetIncome(){
        double netSalary = 0;
        if (GPA <= 5){
            netSalary = 0;
        }else if (GPA < 8){
            netSalary = this.grossSalary;
        }else if (GPA < 11){
            netSalary = this.grossSalary + reward;
        }
        return netSalary;
    }

    public String toString(){
        return this.EmployeeName + "'s gross salary is " + this.grossSalary + " SEK per month. GPA: " + GPA;
    }
}
