package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.student;
import DB.studentDb;

public class saveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String gender = request.getParameter("gender");  // capturing gender
        String dobString = request.getParameter("dob");  // capturing date of birth as string

        // Convert the dob string to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(dobString, formatter);

        student e = new student();
        e.setName(name);
        e.setMobile(mobile);
        e.setEmail(email);
        e.setCourse(course);
        e.setGender(gender);  // setting gender
        e.setDob(dob);  // setting LocalDate for dob

        int status = studentDb.save(e);
        if (status >0) {
           // out.print("<p>Record saved successfully!</p>");
           response.sendRedirect("ViewServlet");
           // request.getRequestDispatcher("ViewServlet.java").include(request, response);
        } else {
            out.println("Sorry! Unable to save record.");
            request.getRequestDispatcher("ViewServlet.html").include(request, response);
        }

        out.close();
    }
}
