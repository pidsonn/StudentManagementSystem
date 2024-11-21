package  pms.dao;


import pms.student.Student;

public interface DAO {
     public boolean insertStudent(Student s);
     public boolean delete(int id);
     public void showAllStudents();        
     public boolean update(int id, String update, int choice, Student s);
     public boolean searchForStudent(int id);
          
    
}