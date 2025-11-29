package com.example;

public class Friend {
    private final int id;
    private final String name;
    private final String email;
     private String phone = null; // New field
    private final String course; // New field

    public Friend(int id, String name, String email, String phone, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone; 
        this.course = course; // Set course
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { // New getter
        return phone;
    }

    public String getCourse() { // New getter
        return course;
    }
}