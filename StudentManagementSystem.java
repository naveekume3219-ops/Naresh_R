import java.util.*;

class Student {
    String name;
    int roll;
    String grade;

    Student(String name, int roll, String grade) {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return roll + "   " + name + "   " + grade;
    }
}

class StudentManager {

    ArrayList<Student> list = new ArrayList<>();

    void addStudent(Student s) {
        list.add(s);
        System.out.println("✔ Student Added Successfully!");
    }

    void removeStudent(int roll) {
        Student s = searchStudent(roll);
        if (s != null) {
            list.remove(s);
            System.out.println("✔ Student Removed Successfully!");
        } else {
            System.out.println("❌ Student Not Found!");
        }
    }

    Student searchStudent(int roll) {
        for (Student s : list) {
            if (s.roll == roll) return s;
        }
        return null;
    }

    void displayAll() {
        if (list.isEmpty()) {
            System.out.println("No Students Found!");
        } else {
            System.out.println("ROLL   NAME   GRADE");
            System.out.println("---------------------");
            for (Student s : list) {
                System.out.println(s);
            }
        }
    }

    void editStudent(int roll, String newName, String newGrade) {
        Student s = searchStudent(roll);
        if (s != null) {
            s.name = newName;
            s.grade = newGrade;
            System.out.println("✔ Student Updated!");
        } else {
            System.out.println("❌ Student Not Found!");
        }
    }
}

class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    sm.addStudent(new Student(name, roll, grade));
                    break;

                case 2:
                    System.out.print("Enter Roll Number to Edit: ");
                    int r1 = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Grade: ");
                    String newGrade = sc.nextLine();

                    sm.editStudent(r1, newName, newGrade);
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Remove: ");
                    int r2 = sc.nextInt();
                    sm.removeStudent(r2);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Search: ");
                    int r3 = sc.nextInt();

                    Student found = sm.searchStudent(r3);

                    if (found != null)
                        System.out.println("FOUND → " + found);
                    else
                        System.out.println("❌ Student Not Found!");
                    break;

                case 5:
                    sm.displayAll();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("❌ Invalid Choice!");
            }
        }
    }
}

