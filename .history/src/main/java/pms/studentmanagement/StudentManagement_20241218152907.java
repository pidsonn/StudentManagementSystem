package pms.studentmanagement;

import java.util.ArrayList;
import java.util.Arrays;

import pms.student.Student;

public class StudentManagement implements DAO {

    @Override
    public boolean insertStudent(Student s) {
        boolean flag = false;

        try {
            Connection con = DBConnection.createConnection();
            String query = "INSERT INTO student (name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);

            // Set the values for the parameters
            pst.setString(1, s.getName());
            pst.setInt(2, s.getAge());
            pst.setString(3, s.getGrade());

            pst.executeUpdate(); // Execute the query
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

            pst.setInt(1, id); // Set the ID parameter
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                flag = true;
            }
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
                System.out.println("Id: " + rs.getInt(1) +
                                   "\nName: " + rs.getString(2) +
                                   "\nAge: " + rs.getInt(3) +
                                   "\nGrade: " + rs.getString(4));
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

        switch (choice) {
            case 1: // Update name
                query = "UPDATE student SET name = ? WHERE id = ?";
                break;
            case 2: // Update age
                query = "UPDATE student SET age = ? WHERE id = ?";
                break;
            case 3: // Update grade
                query = "UPDATE student SET grade = ? WHERE id = ?";
                break;
            default:
                System.out.println("Invalid choice!");
                return false;
        }

        PreparedStatement pst = con.prepareStatement(query);

        // Set the parameter value based on choice
        if (choice == 1) {
            pst.setString(1, update); // Use the `update` parameter directly for name
        } else if (choice == 2) {
            pst.setInt(1, Integer.parseInt(update)); // Convert `update` to int for age
        } else if (choice == 3) {
            pst.setString(1, update); // Use the `update` parameter directly for grade
        }

        pst.setInt(2, id); // Set the ID
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Update successful!");
            flag = true;
        } else {
            System.out.println("No record found with the given ID.");
        }

    } catch (NumberFormatException nfe) {
        System.out.println("Invalid input for age. It must be a number.");
        nfe.printStackTrace();
    } catch (SQLException sqle) {
        System.out.println("Database error. Please check your query and connection.");
        sqle.printStackTrace();
    } catch (Exception e) {
        System.out.println("Something went wrong. Please try again.");
        e.printStackTrace();
    }

    return flag;
}

    @Override
    public boolean searchForStudent(int id) {
        boolean flag = false;

        try {
            Connection con = DBConnection.createConnection();
            String query = "SELECT * FROM student WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Id: " + rs.getInt(1) +
                                   "\nName: " + rs.getString(2) +
                                   "\nAge: " + rs.getInt(3) +
                                   "\nGrade: " + rs.getString(4));
                System.out.println("-------------------------------");
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
