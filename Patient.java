// 7.  Hospital Patient Queue Using PriorityQueue //
import java.util.*;

class Patient {
    int id;
    String name;
    int priority;
    int arrival;

    Patient(int i, String n, int p, int a) {
        id = i;
        name = n;
        priority = p;
        arrival = a;
    }

    void display() {
        System.out.println("Patient: " + name +
  " - Priority " + priority);
    }
}


class PatientMain {
    public static void main(String[] args) {

        PriorityQueue<Patient> queue = new PriorityQueue<>(
            new Comparator<Patient>() {
                public int compare(Patient p1, Patient p2) {

                    if (p1.priority != p2.priority) {
                        return p1.priority - p2.priority;
                    }

                    return p1.arrival - p2.arrival;
                }
            }
        );

        queue.add(new Patient(1, "Patient A", 1, 1));
        queue.add(new Patient(2, "Patient B", 2, 2));
        queue.add(new Patient(3, "Patient C", 1, 3));
        queue.add(new Patient(4, "Patient D", 3, 4));

        System.out.println("Patient Processing Order:");

        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            p.display();
        }
    }
}
