// 6.  Unique Student Registration Using HashSet  //
import java.util.HashSet;

class Student1 {
    int regNo;
    String name;

    Student1(int r, String n) {
        regNo = r;
        name = n;
    }

@Override
public boolean equals(Object obj) {
    Student1 s = (Student1) obj;
    return regNo == s.regNo;
}

    @Override
    public int hashCode() {
        return regNo;
    }

    void display() {
        System.out.println("Registration No: " + regNo);
        System.out.println("Name: " + name);
    }
}

 class StudentMain {
    public static void main(String[] args) {

        HashSet<Student1> students = new HashSet<>();

        Student1 s1 = new Student1(101, "Aamir");
        Student1 s2 = new Student1(101, "Aamir Khan");
        Student1 s3 = new Student1(102, "Sara");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println("Registered Students:");

        for (Student1 s : students) {
            s.display();
            System.out.println();
        }

        if (students.contains(s2)) {
            System.out.println("Student is already registered.");
        }
    }
}
