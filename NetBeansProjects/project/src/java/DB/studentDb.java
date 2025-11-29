package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.student;

public class studentDb {

    // Method to establish a connection to the MySQL database
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL Driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    // Method to save a new student record to the database
    public static int save(student e) {
        int status = 0;
        try {
            Connection con = studentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO profile (name, mobile, email, course, gender, dob) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, e.getName());
            ps.setString(2, e.getMobile());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCourse());
            ps.setString(5, e.getGender());
            ps.setDate(6, java.sql.Date.valueOf(e.getDob())); // Assuming dob is in the format yyyy-mm-dd

            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // Method to update an existing student record in the database
    public static int update(student e) {
        int status = 0;
        try {
            Connection con = studentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE profile SET name=?, mobile=?, email=?, course=?, gender=?, dob=? WHERE id=?");
            ps.setString(1, e.getName());
            ps.setString(2, e.getMobile());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCourse());
            ps.setString(5, e.getGender());
            ps.setDate(6, java.sql.Date.valueOf(e.getDob())); // Assuming dob is in the format yyyy-mm-dd
            ps.setInt(7, e.getId());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // Method to delete a student record from the database
    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = studentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM profile WHERE id=?");
            ps.setInt(1, id);

            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // Method to retrieve a student record by ID
    public static student getStudentById(int id) {
        student e = new student();
        try {
            Connection con = studentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM profile WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setMobile(rs.getString("mobile"));
                e.setEmail(rs.getString("email"));
                e.setCourse(rs.getString("course"));
                e.setGender(rs.getString("gender"));
                e.setDob(rs.getDate("dob").toLocalDate()); // Assuming dob is stored in the format yyyy-mm-dd
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    // Method to retrieve all student records
    public static List<student> getAllStudents() {
        List<student> list = new ArrayList<>();
        try {
            Connection con = studentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM profile");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                student e = new student();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setMobile(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCourse(rs.getString(5));
                e.setGender(rs.getString(6));
                Date dobDate = rs.getDate(7);
    if (dobDate != null) {
        e.setDob(dobDate.toLocalDate());
    } else {
        e.setDob(null);  // or handle null as needed in your application
    }
    list.add(e);
        }
        System.out.println("Total students fetched: " + list.size()); // Debug: total count
        con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
