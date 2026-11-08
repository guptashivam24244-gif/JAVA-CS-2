// 8. Course Registration Using ArrayList and HashMap // 
import java.util.*;

class Course {
    String code;
    String name;
    int capacity;

    Course(String c, String n, int cap) {
        code = c;
        name = n;
        capacity = cap;
    }
}

class CourseStudent {
    String id;
    String name;

    CourseStudent(String i, String n) {
        id = i;
        name = n;
    }
}

class CourseMain {
    public static void main(String[] args) {

        HashMap<String, Course> courses = new HashMap<>();

        HashMap<String, ArrayList<CourseStudent>> registrations =
            new HashMap<>();

        Course c1 = new Course("C101", "Java", 2);
        Course c2 = new Course("C102", "Python", 3);

        courses.put(c1.code, c1);
        courses.put(c2.code, c2);

        registrations.put("C101", new ArrayList<>());
        registrations.put("C102", new ArrayList<>());

        CourseStudent s1 = new CourseStudent("101", "Aamir");
        CourseStudent s2 = new CourseStudent("102", "Sara");
        CourseStudent s3 = new CourseStudent("103", "Rahul");

        registerStudent("C101", s1, courses, registrations);
        registerStudent("C101", s2, courses, registrations);
        registerStudent("C101", s1, courses, registrations);
        registerStudent("C101", s3, courses, registrations);

        registerStudent("C102", s1, courses, registrations);

        displayStudents("C101", courses, registrations);
        displayStudents("C102", courses, registrations);
    }

    static void registerStudent(String code, CourseStudent s,
        HashMap<String, Course> courses,
        HashMap<String, ArrayList<CourseStudent>> registrations) {

        if (!courses.containsKey(code)) {
            System.out.println("Course not found.");
            return;
        }

        ArrayList<CourseStudent> list = registrations.get(code);

        for (CourseStudent st : list) {
            if (st.id.equals(s.id)) {
                System.out.println("Student already registered.");
                return;
            }
        }

        if (list.size() >= courses.get(code).capacity) {
            System.out.println("Course is full.");
            return;
        }

        list.add(s);
        System.out.println(s.name + " registered successfully.");
    }

    static void displayStudents(String code,
        HashMap<String, Course> courses,
        HashMap<String, ArrayList<CourseStudent>> registrations) {

        if (!courses.containsKey(code)) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("\nCourse: " + courses.get(code).name);
        System.out.println("Registered Students:");

        for (CourseStudent s : registrations.get(code)) {
            System.out.println(s.id + " " + s.name);
        }
    }
}
