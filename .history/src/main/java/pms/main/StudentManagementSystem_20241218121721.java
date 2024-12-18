package pms.main;




import java.util.InputMismatchException;
import java.util.Scanner;



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
         System.out.println("9: Exit program.");
         System.out.print("Enter your selection: ");
         
         int sel = console.nextInt();
     
         switch (sel) {
             case 1:
                 System.out.println("Add student");
                 System.out.print("Enter student name: ");
                 String name = console.next();
                 System.out.print("Enter student age: ");
                 int age = console.nextInt();
                 System.out.print("Enter student grade: ");
                 String grade = console.next();
     
                 Student st = new Student(age, name, grade);
                 boolean ans = sm.insertStudent(st);
                 if (ans) {
                     System.out.println("Record inserted successfully!");
                 } else {
                     System.out.println("Something went wrong. Please, try again.");
                 }
                 break;
     
             case 2:
                 System.out.println("View all students");
                 sm.showAllStudents();
                 break;
     
             case 3:
                 System.out.println("Update student details");
                 System.out.println("\n 1: Update name"
                                    + "\n 2: Update age"
                                    + "\n 3: Update grade");
                 System.out.print("Enter your choice: ");
                 int choice = console.nextInt();
     
                 System.out.print("Enter student ID to update: ");
                 int id = console.nextInt();
     
                 boolean updateSuccess = false;
                 if (choice == 1) {
                     System.out.print("Enter new name: ");
                     String newName = console.next();
                     updateSuccess = sm.update(id, newName,choice,  new Student());
                 } else if (choice == 2) {
                     System.out.print("Enter new age: ");
                     int newAge = console.nextInt();
                     updateSuccess = sm.update(id, String.valueOf(newAge),choice, new Student());
                 } else if (choice == 3) {
                     System.out.print("Enter new grade: ");
                     String newGrade = console.next();
                     updateSuccess = sm.update(id, newGrade, choice, new Student());
                 }
     
                 if (updateSuccess) {
                     System.out.println("Update successful!");
                 } else {
                     System.out.println("Something went wrong. Please, try again.");
                 }
                 break;
     
             case 4:
                 System.out.println("Delete a student");
                 System.out.print("Enter the ID to delete: ");
                 id = console.nextInt();
                 boolean deleteSuccess = sm.delete(id);
     
                 if (deleteSuccess) {
                     System.out.println("The record deleted successfully!");
                 } else {
                     System.out.println("Something went wrong. Please, try again.");
                 }
                 break;
     
             case 5:
                 System.out.println("Search for a student");
                 System.out.print("Enter the ID: ");
                 id = console.nextInt();
                 boolean found = sm.searchForStudent(id);
     
                 if (!found) {
                     System.out.println("Student with this ID is not available in our system.");
                 }
                 break;
     
             case 9:
                 System.out.println("Thank you for using Student Management Application!");
                 System.exit(0);
                 break;
     
             default:
                 System.out.println("Invalid selection. Please try again.");
                  break;
                }
         }
    }
}

   