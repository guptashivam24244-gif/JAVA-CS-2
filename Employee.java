// 3. Employee Salary Management //
class Employee {
    private String employeeId;
    private String name;
    private double basicSalary;

    public Employee(String employeeId, String name, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public double calculateGrossSalary() {
        double hra = 0.20 * basicSalary;
        double da = 0.10 * basicSalary;
        double bonus = 0.0;

        if (basicSalary > 50000) {
            bonus = 0.05 * basicSalary;
        }

        return basicSalary + hra + da + bonus;
    }

    public void displaySalaryDetails() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Basic Salary: Rs. " + basicSalary);
        System.out.println("Gross Salary: Rs. " + calculateGrossSalary());
    }

    public static Employee getHigherPaidEmployee(Employee e1, Employee e2) {
        if (e1.calculateGrossSalary() >= e2.calculateGrossSalary()) {
            return e1;
        } else {
            return e2;
        }
    }

    public String getName() {
        return name;
    }
}

 class employeeMain {
    public static void main(String[] args) {
        
        Employee emp1 = new Employee("123", "Amit Sharma", 45000);
        Employee emp2 = new Employee("456", "Priya Patel", 60000);
        Employee emp3 = new Employee("789", "Rohan Das", 55000);

        System.out.println(" Employee Salary Details: ");
        emp1.displaySalaryDetails();
        emp2.displaySalaryDetails();
        emp3.displaySalaryDetails();

        System.out.println(" Comparing Salaries: ");
        Employee highest = Employee.getHigherPaidEmployee(emp1, emp2);
        System.out.println("Between " + emp1.getName() + " and " + emp2.getName() + ", the higher paid employee is: " + highest.getName());
    }
}
