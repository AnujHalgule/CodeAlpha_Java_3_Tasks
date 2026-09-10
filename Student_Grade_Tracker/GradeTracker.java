package grade_tracker;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<Student>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println();
            System.out.println("===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    showStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    System.out.println("Program closed.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    static void addStudent() {

        System.out.print("Enter student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        double[] marks = new double[subjects];

        for (int i = 0; i < subjects; i++) {

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextDouble();

            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Marks should be between 0 and 100.");
                System.out.print("Enter marks again: ");
                marks[i] = sc.nextDouble();
            }
        }

        Student s = new Student(id, name, marks);

        students.add(s);

        System.out.println("Student added successfully.");
    }

    static void showStudents() {

        if (students.size() == 0) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println();
        System.out.println("ID\tName\tAverage\tHighest\tLowest\tGrade");

        for (int i = 0; i < students.size(); i++) {

            Student s = students.get(i);

            System.out.printf(
                    "%d\t%s\t%.2f\t%.2f\t%.2f\t%s%n",
                    s.id,
                    s.name,
                    s.getAverage(),
                    s.getHighest(),
                    s.getLowest(),
                    s.getGrade()
            );
        }
    }

    static void searchStudent() {

        System.out.print("Enter student ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            Student s = students.get(i);

            if (s.id == id) {

                System.out.println();
                System.out.println("Student found!");
                System.out.println("Name: " + s.name);
                System.out.println("Average: " + s.getAverage());
                System.out.println("Highest: " + s.getHighest());
                System.out.println("Lowest: " + s.getLowest());
                System.out.println("Grade: " + s.getGrade());

                return;
            }
        }

        System.out.println("Student not found.");
    }
}
