package pms.studentmanagement;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Arrays;

>>>>>>> main
import pms.student.Student;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.IOException;

<<<<<<< HEAD
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
=======
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;




public class StudentManagement  {
    private static ArrayList<Student> students = new ArrayList<>();
    
                //default constructor
        public StudentManagement(){
            StudentManagement.students = new ArrayList<>();
        }
               //sorting by name
        public void sortByName(){
            Collections.sort(students, Comparator.comparing(Student::getName));
            System.out.println("students sorted by Name:");
            displayStudents();
    
        }
                //sorting by grade
        public void sortByGrade(){
            Collections.sort(students, Comparator.comparing(Student::getGrade));
            System.out.println("students sorted by Grade");
            displayStudents();
        }
             //Display All students
        public void displayStudents(){
            for(Student student: students){
                System.out.println(student);
                if(students.isEmpty()){
                    System.out.println("No student records to display.");
                }
            }
        }
              // Add other methods like Add,Update,delete etc
    
    
    
    
                //Save to file
        public void saveToFile(String saveFile){
           try(BufferedWriter Writer = new BufferedWriter(new FileWriter(saveFile))){
             for(Student student:students){
                Writer.write(student.getId()+","+student.getName()+","+student.getAge()+","+student.getGrade());
                Writer.newLine();
             }
             System.out.println("Student records saved to" + saveFile);
           }
           catch(IOException e){
            if(e.getMessage().contains("No such file or directory")){
                System.out.println("Error: The specified path doesn't exist. Please provide a valid file path.");
            }
            else{
                System.out.println("Error saving to file:" + e.getMessage());
    
            }
        }
             
    
           
        }
           //load from file
           public static List<Student> loadFromFile(String loadFile) {
            try (BufferedReader reader = new BufferedReader(new FileReader(loadFile))) {
                String line;
                students.clear(); // Clear old records
        
                System.out.println("Attempting to load from file: " + loadFile);
        
                while ((line = reader.readLine()) != null) {
                    System.out.println("Reading line: " + line);
        
                    String[] parts = line.split(",");
                    System.out.println("Parsed parts: " + Arrays.toString(parts));
        
                    if (parts.length == 4) {
                        try {
                            int id = Integer.parseInt(parts[0]);
                            String name = parts[1];
                            int age = Integer.parseInt(parts[2]);
                            String grade = parts[3];
        
                            students.add(new Student(id, name, age, grade));
                            System.out.println("Student added: " + id + ", " + name + ", " + age + ", " + grade);

                        } catch (NumberFormatException nfe) {
                            System.out.println("Invalid student record: " + line);
                            nfe.printStackTrace();
                        }
                    } else {
                        System.out.println("Skipping invalid line: " + line);
                    }
                }
                System.out.println("Student records loaded: " + students);
            } catch (IOException e) {
                System.out.println("Error loading from file: " + e.getMessage());
            }
            return students;
        }
        
    public void addStudent(Student student) {
        students.add(student);
    }
    
    
    public List<Student> getStudents() {
        // Return the list of students
        return students;
    }
    public void clearStudents(){
        // clear the students list
      students.clear();
    }
    
    
    
   
    
}

   
 
   
>>>>>>> main
