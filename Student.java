// 1. Student Result Management System //
 class Student {
    private int rollNo;
    private String name;
    private float marks1, marks2, marks3;
    private float total;
    private float percentage;
    private String grade;

    Student(int r, String n, float m1, float m2, float m3) {
        rollNo = r;
        name = n;
        marks1 = m1;
        marks2 = m2;
        marks3 = m3;

        System.out.println("Roll No: " + r);
        System.out.println("Student Name: " + n);
        System.out.println("Marks 1: " + m1);
        System.out.println("Marks 2: " + m2);
        System.out.println("Marks 3: " + m3);
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public float getMarks1() {
        return marks1;
    }

    public float getMarks2() {
        return marks2;
    }

    public float getMarks3() {
        return marks3;
    }

    public void result() {
        total = marks1 + marks2 + marks3;
        System.out.println("Total Marks: " + total + " / 300");

        percentage = (total / 300) * 100;
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 75) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else {
            grade = "D";
        }

        System.out.println("Grade: " + grade);
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Student Details:");

        Student s1 = new Student(13, "Aman", 76, 89, 78);
        s1.result();
    }
}
