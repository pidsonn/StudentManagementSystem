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




public class StudentManagement  {
    private ArrayList<Student> students = new ArrayList<>();

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
        }
    }
          // Add other methods like Add,Update,delete etc




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

   

   