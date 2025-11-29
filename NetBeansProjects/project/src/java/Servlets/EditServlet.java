package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.student;
import DB.studentDb;

public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Update Student Details</h1>");
        
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        student e = studentDb.getStudentById(id);

        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        
        // Hidden field for student ID
        out.print("<tr><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
        
        // Name field
        out.print("<tr><td>Guest Name:</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
        
        // Mobile field
        out.print("<tr><td>Price:</td><td><input type='text' name='mobile' value='" + e.getMobile() + "'/></td></tr>");
        
        // Email field
        out.print("<tr><td>Customer Email:</td><td><input type='email' name='email' value='" + e.getEmail() + "'/></td></tr>");
        
        // Course field with dropdown
        out.print("<tr><td>Meal:</td><td>");
        out.print("<select name='course' style='width:150px'>");
        out.print("<option" + (e.getCourse().equals("IceCream") ? " selected" : "") + ">IceCream</option>");
        out.print("<option" + (e.getCourse().equals("Chai") ? " selected" : "") + ">Chai</option>");
        out.print("<option" + (e.getCourse().equals("Chhole Bhature") ? " selected" : "") + ">Chhole Bhature</option>");
        out.print("<option" + (e.getCourse().equals("Cold coffee") ? " selected" : "") + ">Cold coffee</option>");
        out.print("<option" + (e.getCourse().equals("Samose") ? " selected" : "") + ">Samose</option>");
        out.print("</select>");
        out.print("</td></tr>");
        
        // Gender field with radio buttons
        out.print("<tr><td>Restaurant:</td><td>");
        out.print("<input type='radio' name='gender' value='SharkIn'" + (e.getGender().equals("Samadariya") ? " checked" : "") + "> Samadariya ");
        out.print("<input type='radio' name='gender' value='Samdariya'" + (e.getGender().equals("SharkIn") ? " checked" : "") + "> SharkIn ");
        
        out.print("</td></tr>");
        
        // Date of Birth field
        out.print("<tr><td>Check in Date :</td><td><input type='date' name='dob' value='" + e.getDob() + "'/></td></tr>");
        
        // Submit button
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        
        out.print("</table>");
        out.println("<p><a href='logServlet'>Logout</a></p>");
        out.print("</form>");
        out.close();
    }
}