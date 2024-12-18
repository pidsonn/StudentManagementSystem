package pms.studentmanagement;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pms.student.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class StudentManagementTest {

    private StudentManagement studentManagement;
    private String testFile;

    @BeforeEach
    void setUp() throws IOException {
        // Initialize StudentManagement instance before each test
        studentManagement = new StudentManagement();

        // Create a temporary file for testing file-based operations
        testFile = new String("test-students.txt");

        // Write some sample data to the file
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("1,John Doe,20,A\n");
            writer.write("2,Jane Smith,22,B\n");
            writer.write("3,Emily Johnson,21,A\n");
        }

   }

   
    @Test
    void testLoadFromFile() {
        // Clear existing students
        studentManagement.clearStudents();

        // Load students from the file
        StudentManagement.loadFromFile(testFile);

        // Retrieve the list of students
        List<Student> students = studentManagement.getStudents();

        // Assertions to verify correct data loading
        assertEquals(3, students.size(), "Expected 3 students to be loaded from the file");
        assertEquals("John Doe", students.get(0).getName());
        assertEquals("B", students.get(1).getGrade());
        assertEquals(21, students.get(2).getAge());
    }

    
   
@Test
void testSaveToFile() {
     // Add sample data to student management 
     studentManagement.addStudent(new Student(1, "John Doe", 20, "A"));
     studentManagement.addStudent(new Student(2, "Jane Smith", 22, "B"));
     studentManagement.addStudent(new Student(3, "Emily Johnson", 21, "A"));

    // Create a file to save student data
    String saveFile = "test-save-students.txt";

    // Verify the students list before saving
    System.out.println("Students before saving: " + studentManagement.getStudents());

    // Save the students to the file
    studentManagement.saveToFile(saveFile);

    // Verify the file exists and contains data
    File file = new File(saveFile);
    assertTrue(file.exists(), "The file should be created");

    // Read back the file content
    StringBuilder content = new StringBuilder();
    try (Scanner reader = new Scanner(file)) {
        while (reader.hasNextLine()) {
            content.append(reader.nextLine()).append("\n");
        }
    } catch (IOException e) {
        fail("Failed to read the saved file: " + e.getMessage());
    }
    
    // Verify that the file contains expected data
    String expectedContent = "1,John Doe,20,A\n" +
                             "2,Jane Smith,22,B\n" +
                             "3,Emily Johnson,21,A\n";
    assertEquals(expectedContent.trim(), content.toString().trim(), "The saved file content should match the expected data");
}

    
    @Test
    void testSortByGrade() {
         // Ensure students are populated
    studentManagement.addStudent(new Student(1, "John Doe", 20, "A"));
    studentManagement.addStudent(new Student(2, "Jane Smith", 22, "B"));
    studentManagement.addStudent(new Student(3, "Emily Johnson", 21, "A"));

        // Sort students by grade
        studentManagement.sortByGrade();

        // Retrieve the sorted list of students
        List<Student> students = studentManagement.getStudents();

        // Assertions to verify sorting
        assertEquals("A", students.get(0).getGrade());
        assertEquals("A", students.get(1).getGrade());
        assertEquals("B", students.get(2).getGrade());
    }

    @Test
    void testSortByName() {
        // Ensure students are populated
    studentManagement.addStudent(new Student(1, "John Doe", 20, "A"));
    studentManagement.addStudent(new Student(2, "Jane Smith", 22, "B"));
    studentManagement.addStudent(new Student(3, "Emily Johnson", 21, "A"));

        // Sort students by name
        studentManagement.sortByName();

        // Retrieve the sorted list of students
        List<Student> students = studentManagement.getStudents();

        // Assertions to verify sorting
        assertEquals("Emily Johnson", students.get(0).getName());
        assertEquals("Jane Smith", students.get(1).getName());
        assertEquals("John Doe", students.get(2).getName());
    }
}
