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

    public double getGrossSalary() {
        double salary = 0;
        if (GPA <= 5) {
            salary = 0;
        } else if (GPA < 8) {
            salary = super.getGrossSalary();
        } else if (GPA < 11) {
            salary = super.getGrossSalary() + reward;
        }
        return salary;
    }

    public String toString() {
        return super.toString() + " GPA: " + GPA;
    }
}
