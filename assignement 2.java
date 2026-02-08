class Employee {
    double salary;

    Employee(double salary) {
        this.salary = salary;
    }

    void displaySalary(String type, double updatedSalary) {
        System.out.println(type + " Employee Salary Before Hike : " + salary);
        System.out.println(type + " Employee Salary After Hike  : " + updatedSalary);
        System.out.println();
    }
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(double salary) {
        super(salary);
    }

    void calculateSalary() {
        double newSalary = salary + (salary * 0.50);
        displaySalary("Full Time", newSalary);
    }
}

class InternEmployee extends Employee {

    InternEmployee(double salary) {
        super(salary);
    }

    void calculateSalary() {
        double newSalary = salary + (salary * 0.25);
        displaySalary("Intern", newSalary);
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {

        FullTimeEmployee fte = new FullTimeEmployee(40000);
        InternEmployee intern = new InternEmployee(20000);

        fte.calculateSalary();
        intern.calculateSalary();
    }
}
