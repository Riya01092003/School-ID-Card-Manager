<%-- 
    Document   : resume
    Created on : 01-Dec-2024, 9:48:08 pm
    Author     : aayua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resume</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
        }
        .resume {
            width: 800px;
            margin: auto;
            border: 1px solid #ddd;
            padding: 20px;
            background-color: #f9f9f9;
        }
        .header, .section {
            margin-bottom: 20px;
        }
        .logout-btn {
            display: inline-block;
            margin: 20px auto;
            padding: 10px 20px;
            color: white;
            background-color: #ff3b3b;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            text-decoration: none;
            text-align: center;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        
        .section-title {
            font-weight: bold;
            text-transform: uppercase;
            background: #ccc;
            padding: 5px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table td, table th {
            border: 1px solid #ddd;
            padding: 8px;
        }
    </style>
</head>
<body>
    <div class="resume">
        <%
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                // Database connection
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ResumeDB", "root", "1234");

                String query = "SELECT * FROM resume1_data WHERE id = 1"; // Fetching resume data for a specific user
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);

                if (rs.next()) {
        %>
                    <div class="header">
                         <a href="index.html" class="logout-btn">Logout</a>

                         
                        <h2>BTECH CSE THIRD YEAR STUDENT</h2>
                        <p><strong><%= rs.getString("name") %></strong></p>
                        <p><%= rs.getString("email") %> | <%= rs.getString("phone") %></p>
                    </div>

                    <div class="section">
                        <div class="section-title">Career Objective</div>
                        <p><%= rs.getString("career_objective") %></p>
                    </div>

                    <div class="section">
                        <div class="section-title">Skills</div>
                        <p><%= rs.getString("skills") %></p>
                    </div>

                    <div class="section">
                        <div class="section-title">Education</div>
                        <table>
                            <tr>
                                <th>Degree/Course</th>
                                <th>Percentage/CGPA</th>
                                <th>Year of Passing</th>
                            </tr>
                            <tr>
                                <td><%= rs.getString("degree") %></td>
                                <td><%= rs.getFloat("percentage") %></td>
                                <td><%= rs.getString("year_of_passing") %></td>
                            </tr>
                        </table>
                    </div>

                    <div class="section">
                        <div class="section-title">Areas of Interests</div>
                        <p><%= rs.getString("area_of_interests") %></p>
                    </div>

                    <div class="section">
                        <div class="section-title">Hobbies</div>
                        <p><%= rs.getString("hobbies") %></p>
                    </div>

                    <div class="section">
                        <div class="section-title">Personal Details</div>
                        <p><strong>Address:</strong> <%= rs.getString("address") %></p>
                        <p><strong>Date of Birth:</strong> <%= rs.getDate("date_of_birth") %></p>
                        <p><strong>Gender:</strong> <%= rs.getString("gender") %></p>
                        <p><strong>Nationality:</strong> <%= rs.getString("nationality") %></p>
                        <p><strong>Marital Status:</strong> <%= rs.getString("marital_status") %></p>
                        <p><strong>Languages Known:</strong> <%= rs.getString("languages_known") %></p>
                    </div>

                    <div class="section">
                        <div class="section-title">Declaration</div>
                        <p>I hereby declare that all the details furnished here are true to the best of my knowledge and belief.</p>
                        <p><strong><%= rs.getString("name") %></strong></p>
                    </div>
        <%
                } else {
                    out.println("<p>No resume data found!</p>");
                }
            } catch (Exception e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (con != null) con.close();
                } catch (SQLException e) {
                    out.println("<p>Close connection error: " + e.getMessage() + "</p>");
                }
            }
        %>
                          
    </div>
</body>
</html>

