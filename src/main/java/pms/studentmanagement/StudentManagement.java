package pms.studentmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pms.dao.DAO;
import pms.db.DBConnection;
import pms.student.Student;

public class StudentManagement implements DAO {

    @Override
    public boolean insertStudent(Student s) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();
            String query = "INSERT INTO student (sname, age, grade) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, s.getName());
            pst.setInt(2, s.getAge());
            pst.setString(3, s.getGrade());
            pst.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();
            String query = "DELETE FROM student WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void showAllStudents() {
        try {
            Connection con = DBConnection.createConnection();
            String query = "SELECT * FROM student";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Id: " + rs.getInt(1)
                        + "\nName: " + rs.getString(2)
                        + "\nAge: " + rs.getInt(3)
                        + "\nGrade: " + rs.getString(4));
                System.out.println("-------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(int id, String update, int choice, Student s) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();
            String query = "";
            if (choice == 1) { // Update name
                query = "UPDATE student SET sname = ? WHERE id = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, s.getName());
                pst.setInt(2, id);
                flag = pst.executeUpdate() > 0;
            } else if (choice == 2) { // Update age
                query = "UPDATE student SET age = ? WHERE id = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, s.getAge());
                pst.setInt(2, id);
                flag = pst.executeUpdate() > 0;
            } else if (choice == 3) { // Update grade
                query = "UPDATE student SET grade = ? WHERE id = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, s.getGrade());
                pst.setInt(2, id);
                flag = pst.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean showStudentById(int id) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();
            String query = "SELECT * FROM student WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Id: " + rs.getInt(1)
                        + "\nName: " + rs.getString(2)
                        + "\nAge: " + rs.getInt(3)
                        + "\nGrade: " + rs.getString(4));
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
