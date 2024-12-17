package pms.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import pms.student.Student;
import pms.studentmanagement.StudentManagement;

public class StudentManagementSystem {
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        System.out.println("STUDENT MANAGEMENT SYSTEM:");

        while (true) {
            System.out.println("\n MENU");
            System.out.println("1: Add new student.");
            System.out.println("2: View all students.");
            System.out.println("3: Update student details.");
            System.out.println("4: Delete a student.");
            System.out.println("5: Search for a student.");
            
            System.out.print("Enter your selection: ");

            try {
                int sel = console.nextInt();

                switch (sel) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        int id = console.nextInt();
                        System.out.print("Enter student name: ");
                        String name = console.next();
                        System.out.print("Enter student age: ");
                        int age = console.nextInt();
                        System.out.print("Enter student grade: ");
                        String grade = console.next();

                        sm.addStudent(new Student(id, name, age, grade));
                        break;

                    case 2:
                        sm.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter student ID to update: ");
                        id = console.nextInt();
                        System.out.println("\n1: Update name\n2: Update age\n3: Update grade");
                        System.out.print("Enter your choice: ");
                        int choice = console.nextInt();
                        System.out.print("Enter new value: ");
                        String newValue = console.next();

                        if (sm.updateStudent(id, newValue, choice)) {
                            System.out.println("Update successful!");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        id = console.nextInt();
                        if (sm.deleteStudent(id)) {
                            System.out.println("Student deleted successfully!");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter student ID to search: ");
                        id = console.nextInt();
                        Student foundStudent = sm.searchStudent(id);
                        if (foundStudent != null) {
                            System.out.println("Student found: " + foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 9:
                        System.out.println("Exiting the program. Goodbye!");
                        console.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid selection. Please choose a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
                console.nextLine(); // Clear invalid input
            }
        }
    }
}
