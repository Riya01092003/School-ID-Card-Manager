/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
public class student {
    private int id;
    private String name, email, mobile, course;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    // Add these fields
private String gender;
private LocalDate dob;

// Gender getters and setters
public String getGender() {
    return gender;
}

public void setGender(String gender) {
    this.gender = gender;
}

// DOB getters and setters
public LocalDate getDob() {
    return dob;
}

public void setDob(LocalDate dob) {
    this.dob = dob;
}

}
