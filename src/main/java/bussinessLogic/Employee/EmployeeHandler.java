package bussinessLogic.Employee;

enum EmployeeType {
    Regular,
    Manager,
    Intern,
    Director
}

public class EmployeeHandler {
    private Employee employee;
    private Manager manager;
    private Intern intern;
    private Director director;
    private EmployeeType type;


    public EmployeeHandler(String employeeID, String employeeName, double grossSalary) throws Exception
    {
        employee = new Employee(employeeID, employeeName, grossSalary);
        type = EmployeeType.Regular;
    }
    public EmployeeHandler(String employeeID, String employeeName, double grossSalary, String degree) throws Exception
    {
        manager = new Manager(employeeID, employeeName, grossSalary,degree);
        type = EmployeeType.Manager;
    }
    public EmployeeHandler(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception
    {
        intern = new Intern(employeeID, employeeName, grossSalary,gpa);
        type = EmployeeType.Intern;
    }
    public EmployeeHandler(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception
    {
        director = new Director(employeeID, employeeName, grossSalary, degree, dept);
        type = EmployeeType.Director;
    }

    @Override
    public String toString()
    {
        switch(type)
        {
        case Regular:
            return employee.toString();
        case Manager:
            return manager.toString();
        case Intern:
            return intern.toString();
        default:
            return director.toString();
        }
    }
    

}
