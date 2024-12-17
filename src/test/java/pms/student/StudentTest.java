package pms.student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testGetAge() {
        Student student = new Student(1, "Alice", 20, "A");
        assertEquals(20, student.getAge());
    }

    @Test
    void testGetGrade() {
        Student student = new Student(1, "Alice", 20, "A");
        assertEquals("A", student.getGrade());
    }

    @Test
    void testGetId() {
        Student student = new Student(0, null, 0, null);
        student.setId(100);
        assertEquals(100, student.getId());
    }

    @Test
    void testGetName() {
        Student student = new Student(1, "Alice", 20, "A");
        assertEquals("Alice", student.getName());
    }

    @Test
    void testSetAge() {
        Student student = new Student(0, null, 0, null);
        student.setAge(25);
        assertEquals(25, student.getAge());
    }

    @Test
    void testSetGrade() {
        Student student = new Student(0, null, 0, null);
        student.setGrade("B");
        assertEquals("B", student.getGrade());
    }

    @Test
    void testSetId() {
        Student student = new Student(0, null, 0, null);
        student.setId(10);
        assertEquals(10, student.getId());
    }

    @Test
    void testSetName() {
        Student student = new Student(0, null, 0, null);
        student.setName("Bob");
        assertEquals("Bob", student.getName());
    }

    @Test
    void testToString() {
        Student student = new Student(3,"Charlie",20, "C");
        student.setId(3);
        String expected = "ID:3, Name:Charlie,Age:20,Grade:C";
        assertEquals(expected, student.toString());
    }
}