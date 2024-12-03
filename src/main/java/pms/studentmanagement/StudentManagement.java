package pms.studentmanagement;

import java.util.ArrayList;
import pms.student.Student;

public class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Student Records:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Find and delete a student by ID
    public boolean deleteStudent(int id) {
        boolean removed = false;
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                removed = true;
                break;
            }
        }
        return removed;
    }

    // Update a student's details
    public boolean updateStudent(int id, String newValue, int choice) {
        for (Student student : students) {
            if (student.getId() == id) {
                switch (choice) {
                    case 1: { // Update name
                        student.setName(newValue);
                        break;
                    }
                    case 2: { // Update age
                        try {
                            int newAge = Integer.parseInt(newValue);
                            student.setAge(newAge);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid age format. Please enter a number.");
                            return false;
                        }
                        break;
                    }
                    case 3: { // Update grade
                        student.setGrade(newValue);
                        break;
                    }
                    default: {
                        System.out.println("Invalid update choice.");
                        return false;
                    }
                }
                return true; // Update successful
            }
        }
        return false; // Student not found
    }

    // Search for a student by ID
    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Student not found
    }
}
