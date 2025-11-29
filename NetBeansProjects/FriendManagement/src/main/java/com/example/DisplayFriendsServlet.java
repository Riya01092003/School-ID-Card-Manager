package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DisplayFriendsServlet")
public class DisplayFriendsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Friend> friendsList = new ArrayList<>();
        try (
                Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM friends")) {

            while (rs.next()) {
                friendsList.add(new Friend(rs.getInt("id"), rs.getString("carname"), rs.getString("modelname"),rs.getString("brand"), rs.getString("color")));
            }
        } catch (SQLException e) {
        }

        request.setAttribute("friendsList", friendsList);
        request.getRequestDispatcher("friends.jsp").forward(request, response);
    }
}