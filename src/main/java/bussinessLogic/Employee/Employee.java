package bussinessLogic.Employee;

import utility.Calculate;

import java.util.Objects;

public class Employee {
  protected String EmployeeID;
  protected String EmployeeName;
  protected double grossSalary;
  protected double tax = 0.1;

  public Employee(String id, String name, double grossSalary)throws Exception{
    if (id.isBlank()){
      throw new Exception("ID cannot be blank.");
    }
    if (name.isBlank()){
      throw new Exception("Name cannot be blank.");
    }
    if (grossSalary < 0){
      throw new Exception("Salary must be greater than zero.");
    }
    this.EmployeeID = id;
    this.EmployeeName = name;
    this.grossSalary = grossSalary;

  }

  public String getEmployeeID() { return this.EmployeeID; }

  public String getEmployeeName() { return this.EmployeeName; }

  public void setEmployeeName(String newName) { this.EmployeeName = newName; }

  public double getGrossSalary() { return this.grossSalary; }

  public void setGrossSalary(double newGrossSalary) {
    this.grossSalary = newGrossSalary;
  }

  public double calculateNetIncome(){
    double netSalary = grossSalary - Calculate.deductTax(grossSalary, tax);
    return netSalary;
  }

  public boolean equals(Object anotherObject) {
    if (this == anotherObject) {
      return true;
    }
    if (anotherObject == null || !(anotherObject instanceof Employee)) {
      return false;
    } else {
      Employee employee = (Employee)anotherObject;
      return EmployeeID == employee.EmployeeID;
    }
  }

  public int hashCode() { return Objects.hash(EmployeeID); }

  public String toString() {
    return EmployeeName + " 's gross salary is " + grossSalary +
        " SEK per month.";
  }
}
