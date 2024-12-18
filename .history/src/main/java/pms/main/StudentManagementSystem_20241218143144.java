package pms.main;

import java.util.InputMismatchException;



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
         System.out.println("6: Sort students(by Name or Grade.");
         System.out.println("7: Save records to file.");
         System.out.println("8: Load records from file.");
         System.out.println("9: Exit program.");
         System.out.print("Enter your selection: ");

       try{
         
         int sel = console.nextInt();
     
         switch (sel) {
            
             case 6:
                  System.out.println("Sort students by:");
                  System.out.println("1: name");
                  System.out.println("2: Grade");
                  System.out.print("Enter you choice:");
                  int sortChoice = console.nextInt();

                  if(sortChoice ==1){
                    sm.sortByName();
                  }
                  else if(sortChoice ==2){
                    sm.sortByGrade();
                  }
                  else{
                    System.out.println("Invalid choice");
                  }
                  break;

                  case 7:
                    System.out.print("Enter the file Name to save:");
                    String saveFile = console.next();
                    sm.saveToFile(saveFile);
                    break;

                  case 8:
                    System.out.print("Enter the file name to load:");
                    String loadFile = console.next();
                    StudentManagement.loadFromFile(loadFile);
                    break;


                  case 9:
                      System.out.println("Thank you for using the Student Management application!");
                      console.close();
                      System.exit(0);
                      break;
                    
                 default:
                      System.out.println("Invalid selection. Please choose a valid option");
                     break;
                }
        }
                

                 catch(InputMismatchException e){
                    System.out.println("Invalid input. Please enter a valid numeric ID");
                   console.nextLine();  // Clear invalid input
                   }
                }
            
        
                

             
     
             
     
             
         
    }
}


   
   