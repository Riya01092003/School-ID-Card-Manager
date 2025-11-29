package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.student;
import DB.studentDb;
import java.util.*;

public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<student> list = studentDb.getAllStudents();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset='ISO-8859-1'>");
        out.print("<title>Registration Page</title>");
        out.print("<style>");

        // CSS Styling for Single-Screen Layout
        out.print("body {");
        out.print("  font-family: Arial, sans-serif;");
        out.print("  background-image: url('https://png.pngtree.com/background/20210714/original/pngtree-original-design-business-office-management-system-background-banner-picture-image_1191085.jpg');"); // Replace with your background image path
        out.print("  background-size: cover;");
        out.print("  background-position: center;");
        out.print("  margin: 0;");
        out.print("  padding: 0;");
        out.print("  display: flex;");
        out.print("  justify-content: center;");
        out.print("  align-items: center;");
        out.print("  height: 100vh;");
        out.print("}");

        // Flexbox container
        out.print(".container {");
        out.print("  display: flex;");
        out.print("  background-color: rgba(255, 255, 255, 0.85);");
        out.print("  padding: 10px;");
        out.print("  border-radius: 8px;");
        out.print("  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);");
        out.print("  max-width: 1000px;");
        out.print("  width: 95%;");
        out.print("  height: 90vh;");
        out.print("}");

        // Left and right columns
        out.print(".left-column, .right-column {");
        out.print("  flex: 1;");
        out.print("  padding: 10px;");
        out.print("  overflow-y: auto;");
        out.print("  max-height: 100%;");
        out.print("}");

        out.print(".left-column { border-right: 2px solid #cccccc; }");

        out.print("h1 {");
        out.print("  font-size: 20px;");
        out.print("  color: #333;");
        out.print("  text-align: center;");
        out.print("  border-bottom: 1px solid #007bff;");
        out.print("  padding-bottom: 5px;");
        out.print("  margin-bottom: 10px;");
        out.print("}");

        // Form styling
        out.print("form {");
        out.print("  background-color: #f9f9f9;");
        out.print("  padding: 10px;");
        out.print("  border-radius: 5px;");
        out.print("  box-shadow: 0 1px 5px rgba(0, 0, 0, 0.1);");
        out.print("}");

        // Table styling with fixed column widths
        out.print("table { width: 100%; border-collapse: collapse; }");
        out.print("table th, table td { padding: 5px; text-align: left; border: 1px solid #ddd; font-size: 12px; }");
        out.print("table th { background-color: #007bff; color: white; width: 100px; }"); // Column width reduced
        out.print("table td { font-size: 12px; }");
        out.print("table tr:nth-child(even) { background-color: #f2f2f2; }");

        out.print("input[type='text'], input[type='email'], input[type='date'], select {");
        out.print("  width: 100%;");
        out.print("  padding: 5px;");
        out.print("  margin: 5px 0 5px 0;");
        out.print("  border-radius: 4px;");
        out.print("  border: 1px solid #ccc;");
        out.print("  font-size: 12px;");
        out.print("  box-sizing: border-box;");
        out.print("}");

        out.print("input[type='submit'] {");
        out.print("  background-color: #28a745;");
        out.print("  color: white;");
        out.print("  padding: 8px 15px;");
        out.print("  border: none;");
        out.print("  font-size: 12px;");
        out.print("  cursor: pointer;");
        out.print("  border-radius: 4px;");
        out.print("  transition: background-color 0.3s;");
        out.print("}");

        out.print("input[type='submit']:hover { background-color: #218838; }");

        out.print("a { color: #007bff; text-decoration: none; font-size: 12px; }");
        out.print("a:hover { color: #0056b3; }");

        out.print("</style>");
        out.print("</head>");
        out.print("<body>");

        out.print("<div class='container'>");

        // Left Column - Order Details Form
        out.print("<div class='left-column'>");
        out.print("<h1>Registration</h1>");
        out.print("<form action='saveServlet' method='post'>");
        out.print("<table>");
        out.print("<tr><td>Guest Name:</td><td><input type='text' name='name' required /></td></tr>");
        out.print("<tr><td>Price:</td><td><input type='text' name='mobile' required /></td></tr>");
        out.print("<tr><td>Customer Email:</td><td><input type='email' name='email' required /></td></tr>");
        out.print("<tr><td>Meal:</td><td><select name='course' style='width:100%'>");
        out.print("<option>IceCream</option><option>Chai</option><option>Chhole Bhature</option><option>Cold Coffee</option><option>Samose</option>");
        out.print("</select></td></tr>");
        
        // Restaurant radio buttons
        out.print("<tr><td>Restaurant:</td><td>");
        out.print("<label><input type='radio' name='gender' value='Samadariya' required /> SharkIn</label>");
        out.print("<label><input type='radio' name='gender' value='SharkIn' required /> Samdariya Gold</label>");
        out.print("<label><input type='radio' name='gender' value='Chhappan Bhog' required />Chhappan Bhog</label>");
        out.print("</td></tr>");
        
        out.print("<tr><td>Check-in Date:</td><td><input type='date' name='dob' required /></td></tr>");
        out.print("<tr><td colspan='2' style='text-align: center;'><input type='submit' value='Save' /></td></tr>");
        out.print("</table>");
        out.print("</form>");
         out.println("<p><a href='logServlet'>Logout</a></p>");
        out.print("</div>");

        // Right Column - Students List
        out.print("<div class='right-column'>");
        out.print("<h1>Order Details</h1>");
        out.print("<table>");
        out.print("<tr><th>Id</th><th>Guest Name</th><th>Price</th><th>Email</th><th>Meal</th><th>Restaurant</th><th>Check-in Date</th><th>Edit</th><th>Delete</th></tr>");
        
        for (student e : list) {
            out.print("<tr>");
            out.print("<td>" + e.getId() + "</td>");
            out.print("<td>" + e.getName() + "</td>");
            out.print("<td>" + e.getMobile() + "</td>");
            out.print("<td>" + e.getEmail() + "</td>");
            out.print("<td>" + e.getCourse() + "</td>");
            out.print("<td>" + e.getGender() + "</td>");
            out.print("<td>" + e.getDob() + "</td>");
            out.print("<td><a href='EditServlet?id=" + e.getId() + "'>edit</a></td>");
            out.print("<td><a href='DeleteServlet?id=" + e.getId() + "'>delete</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
        out.print("</div>");
    out.println("<p><a href='logServlet'>Logout</a></p>");
        out.print("</div>");  // End container
       
        out.print("</body>");
        out.print("</html>");

        out.close();
    }
}