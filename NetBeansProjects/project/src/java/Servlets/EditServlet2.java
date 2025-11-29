package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.student;
import DB.studentDb;

public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String gender = request.getParameter("gender");

        // Convert dob from String to LocalDate
        LocalDate dob = null;
        try {
            dob = LocalDate.parse(request.getParameter("dob"));
        } catch (Exception e) {
            out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        student e = new student();
        e.setId(id);
        e.setName(name);
        e.setMobile(mobile);
        e.setEmail(email);
        e.setCourse(course);
        e.setGender(gender);
        e.setDob(dob);

        int status = studentDb.update(e);
        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("Sorry! unable to update record");
        }

        out.close();
    }
}
