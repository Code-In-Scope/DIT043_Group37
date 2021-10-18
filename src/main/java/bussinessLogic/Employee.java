package bussinessLogic;

import java.util.Objects;

public class Employee {
    private String employeeID;
    private String employeeName;
    private double employeeGrossSalary;

    public Employee(String id, String name, double grossSalary){
        this.employeeID = id;
        this.employeeName = name;
        this.employeeGrossSalary = grossSalary;
    }

    public String getEmployeeID(){
        return this.employeeID;
    }

    public String getEmployeeName(){
        return this.employeeName;
    }

    public void setEmployeeName(String newName){
        this.employeeName = newName;
    }

    public double getEmployeeGrossSalary(){
        return this.employeeGrossSalary;
    }

    public void setEmployeeGrossSalary(double newGrossSalary){
        this.employeeGrossSalary = newGrossSalary;
    }

    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null || !(anotherObject instanceof Employee)) {
            return false;
        } else {
            Employee employee = (Employee) anotherObject;
            return employeeID == employee.employeeID;
        }
    }

    public int hashCode(){
        return Objects.hash(employeeID);
    }

    public String toString(){
        return employeeName + " 's gross salary is " + employeeGrossSalary + " SEK per month.";
    }
}
