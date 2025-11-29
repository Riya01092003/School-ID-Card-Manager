package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/AddFriendServlet")
public class AddFriendServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html");
    try (PrintWriter out = response.getWriter()) {
        String carname = request.getParameter("carname");
        String  modelname= request.getParameter("modelname");
        String  brand= request.getParameter("brand"); // New field
        String color = request.getParameter("color"); // New field

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO friends (carname, modelname ,brand , color) VALUES (?, ?,?,?)")) {

            pstmt.setString(1, carname);
            pstmt.setString(2, modelname);
            pstmt.setString(3, brand); // Set phone
            pstmt.setString(4, color);
            pstmt.executeUpdate();

            out.println("Friend added successfully!");
        } catch (SQLException e) {
            out.println("Error adding friend: " + e.getMessage());
        }
        out.println("<a href='index.html'>Add Another Friend</a>");
    }
}

}