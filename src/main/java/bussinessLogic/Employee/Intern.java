package bussinessLogic.Employee;

public class Intern extends Employee {

    private int GPA;
    private final double reward = 1000;

    public Intern(String id, String name, double grossSalary, int GPA) throws Exception {
        super(id, name, grossSalary);
        if (GPA < 0 || GPA > 11){
            throw new Exception( GPA + " outside range. Must be between 0-10.");
        }
        this.GPA = GPA;
    }

    public double getNetIncome() {
        double netIncome = getGrossSalary();
        if (GPA <= 5) {
            netIncome = 0;
        } else if (GPA < 8) {
            netIncome = super.getGrossSalary();
        } else if (GPA < 11) {
            netIncome = super.getGrossSalary() + reward;
        }
        return netIncome;
    }

    public String toString() {
        return super.toString() + GPA;
    }
}
