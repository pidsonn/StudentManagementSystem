package pms.studentmanagement;

import java.util.ArrayList;
import pms.student.Student;
import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;


public class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }
      //default constructor
    public StudentManagement(){
        this.students = new ArrayList<>();
    }
           //sorting by name
    public void sortByName(){
        Collections.sort(students, Comparator.comparing(Student::getName));
        System.out.println("students sorted by Name:");
        displayStudents();
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Student Records:");
        }
            for (Student student : students) {
                System.out.println(student);
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

    
            //sorting by grade
    public void sortByGrade(){
        Collections.sort(students, Comparator.comparing(Student::getGrade));
        System.out.println("students sorted by Grade");
        displayStudents();
    }
         //Save to file
    public void saveToFile(String fileName){
       try(BufferedWriter Writer = new BufferedWriter(new FileWriter(fileName))){
         for(Student student:students){
            Writer.write(student.getId()+","+student.getName()+","+student.getGrade());
            Writer.newLine();
         }
         System.out.println("Student records saved to" + fileName);
       }
       catch(IOException e){
         System.out.println("Error saving to file:" + e.getMessage());
       }

       
    }
       //load from file
    public void loadFromFile(String fileName){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
              // clear existing records before loading

            while((line = reader.readLine())!= null){
                String[]parts = line.split(",");
                if(parts.length == 4){
                
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String grade = parts[3];
            
                  students.add(new Student(id,name,age,grade));
                }
                  
            }
            System.out.println("Student records loaded from" + fileName);
            }
            catch(IOException e){
                System.out.println("Error loading from file:" + e.getMessage());
            }
    }
}

   

   
