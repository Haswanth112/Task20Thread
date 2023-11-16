import java.util.*;
import java.util.stream.Collectors;

class Student {
    String id;
    String firstName;
    double cgpa;

    public Student(String id, String firstName, double cgpa) {
        this.id = id;
        this.firstName = firstName;
        this.cgpa = cgpa;
    }

    public double getCgpa() {
        return cgpa;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }
}
public class StudentSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split(" ");
            students.add(new Student(info[0], info[1], Double.parseDouble(info[2])));
        }
        students = students.stream()
                .sorted(Comparator
                        .comparing(Student::getCgpa).reversed()
                        .thenComparing(Student::getFirstName)
                        .thenComparing(Student::getId))
                .collect(Collectors.toList());
        students.forEach(h->System.out.println(h.firstName));
    }
}
