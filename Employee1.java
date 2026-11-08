// 9. Employee Directory with Sorting //
import java.util.*;

class Employee1 {
    int id;
    String name;
    String department;
    double salary;

    Employee1(int i, String n, String d, double s) {
        id = i;
        name = n;
        department = d;
        salary = s;
    }

    void display() {
        System.out.println(id + " " + name + " " + department + " " + salary);
    }
}

class EmpMain {
    public static void main(String[] args) {

        ArrayList<Employee1> employees = new ArrayList<>();

        employees.add(new Employee1(1, "Aamir", "IT", 50000));
        employees.add(new Employee1(2, "Sara", "HR", 40000));
        employees.add(new Employee1(3, "Rahul", "IT", 60000));
        employees.add(new Employee1(4, "Neha", "Sales", 35000));
        employees.add(new Employee1(5, "Ravi", "HR", 70000));

        // Sort by salary in ascending order
        Collections.sort(employees, new Comparator<Employee1>() {
            public int compare(Employee1 e1, Employee1 e2) {
                return Double.compare(e1.salary, e2.salary);
            }
        });

        System.out.println("Employees by Salary:");

        for (Employee1 e : employees) {
            e.display();
        }

        // Sort by name alphabetically
        Collections.sort(employees, new Comparator<Employee1>() {
            public int compare(Employee1 e1, Employee1 e2) {
                return e1.name.compareTo(e2.name);
            }
        });

        System.out.println("\nEmployees by Name:");

        for (Employee1 e : employees) {
            e.display();
        }

        // Search employees by department
        String searchDept = "IT";

        System.out.println("\nEmployees in IT Department:");

        for (Employee1 e : employees) {
            if (e.department.equalsIgnoreCase(searchDept)) {
                e.display();
            }
        }

        // Display top three highest-paid employees
        Collections.sort(employees, new Comparator<Employee1>() {
            public int compare(Employee1 e1, Employee1 e2) {
                return Double.compare(e2.salary, e1.salary);
            }
        });

        System.out.println("\nTop Three Highest Paid Employees:");

        for (int i = 0; i < 3 && i < employees.size(); i++) {
            employees.get(i).display();
        }
    }
}
