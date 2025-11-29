package com.example;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;

/*import com.example.Friend;*/


@WebServlet("/EditFriendServlet")
public class EditFriendServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
    if (idParam == null || idParam.isEmpty()) {
        throw new ServletException("Friend ID is missing");
    }
        int friendId = Integer.parseInt(request.getParameter("id"));
        Friend friend = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM friends WHERE id = ?")) {
            pstmt.setInt(1, friendId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                friend = new Friend(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
                                    rs.getString("phone"), rs.getString("course"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("friend", friend);
        request.getRequestDispatcher("editFriend.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("UPDATE friends SET name = ?, email = ?, phone = ?, course = ? WHERE id = ?")) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, course);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            response.sendRedirect("DisplayFriendsServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}