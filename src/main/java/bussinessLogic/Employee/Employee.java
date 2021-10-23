package bussinessLogic.Employee;

import utility.Calculate;
import java.util.Objects;
import utility.Utilities;

public class Employee {
  private String employeeID;
  private String employeeName;
  private double grossSalary;
  private double tax = 0.1;
  private String updateMessage;

  public Employee(String id, String name, double grossSalary) throws Exception {
    checkID(id);
    checkName(name);
    checkSalary(grossSalary);

    this.employeeID = id;
    this.employeeName = name;
    this.grossSalary = Calculate.truncateDouble(grossSalary, 2);
    this.updateMessage = "Employee " + this.employeeID + " was updated successfully";
  }

  public void checkName(String employeeName) throws Exception {
    if (employeeName.isBlank()) {
      throw new Exception("Name cannot be blank.");
    }
  }

  public void checkID(String id) throws Exception {
    if (id.isBlank()) {
      throw new Exception("ID cannot be blank.");
    }
  }

  public void checkSalary(double salary) throws Exception {
    if (salary <= 0) {
      throw new Exception("Salary must be greater than zero.");
    }
  }

  public double getTax(){
    return this.tax;
  }

  public String getEmployeeID() {
    return this.employeeID;
  }

  public String getEmployeeName() {
    return this.employeeName;
  }

  public String setEmployeeName(String newName) throws Exception {
    checkName(newName);
    this.employeeName = newName;
    return updateMessage;
  }

  public double getGrossSalary() {
    return this.grossSalary;
  }

  public String setGrossSalary(double newGrossSalary) throws Exception {
    checkSalary(newGrossSalary);
    this.grossSalary = newGrossSalary;
    return updateMessage;
  }

  public double getNetIncome() {
    double netIncome = grossSalary - Calculate.deductTax(grossSalary, tax);
    netIncome = Calculate.truncateDouble(netIncome, 2);
    return netIncome;
  }

  public double getBaseSalary(){
    return this.grossSalary;
  }

  public boolean checkEmployeeId(String employeeID) {
    return (this.employeeID.equals(employeeID));
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

  public int hashCode() {
    return Objects.hash(employeeID);
  }

  public String toString() {
    return employeeName + "'s gross salary is " + Utilities.formatDouble(getGrossSalary()) + " SEK per month.";
  }
}
