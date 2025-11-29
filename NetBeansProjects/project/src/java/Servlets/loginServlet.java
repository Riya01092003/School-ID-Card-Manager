// LoginServlet.java
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded credentials for admin - replace with database verification if necessary
        String adminUsername = "riya";
        String adminPassword = "riya";

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            // Create session and set logged-in attribute
            HttpSession session = request.getSession();
            session.setAttribute("admin", "true");
            try (PrintWriter out = response.getWriter()) {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Admin Dashboard</title>");
    out.println("<link href='https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;700&family=Roboto:wght@300;400&display=swap' rel='stylesheet'>");
    out.println("<style>");
    out.println("  body {");
    out.println("    background: url('https://tse1.mm.bing.net/th?id=OIP.lhmGSPzrUasutwy-fXhHKwHaE0&pid=Api&P=0&h=180') no-repeat center center fixed;");
    out.println("    background-size: cover;");
    out.println("    color: #333;");
    out.println("    font-family: 'Playfair Display', serif;");
    out.println("    display: flex;");
    out.println("    justify-content: center;");
    out.println("    align-items: center;");
    out.println("    height: 100vh;");
    out.println("    margin: 0;");
    out.println("  }");
    out.println("  .overlay {");  // Overlay to darken background for text readability
    out.println("    position: absolute;");
    out.println("    top: 0;");
    out.println("    left: 0;");
    out.println("    right: 0;");
    out.println("    bottom: 0;");
    out.println("    background-color: rgba(0, 0, 0, 0.5);");  // Semi-transparent overlay
    out.println("    z-index: 1;");
    out.println("  }");
    out.println("  .container {");
    out.println("    position: relative;");
    out.println("    z-index: 2;");
    out.println("    background-color: #ffffff;");
    out.println("    padding: 30px;");
    out.println("    border-radius: 10px;");
    out.println("    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);");
    out.println("    max-width: 450px;");
    out.println("    text-align: center;");
    out.println("  }");
    out.println("  h2 {");
    out.println("    font-family: 'Playfair Display', serif;");
    out.println("    font-size: 1.8em;");
    out.println("    color: #6b4f4f;");
    out.println("    margin-bottom: 20px;");
    out.println("  }");
    out.println("  a {");
    out.println("    color: #b45f04;");
    out.println("    text-decoration: none;");
    out.println("    font-family: 'Roboto', sans-serif;");
    out.println("    font-weight: bold;");
    out.println("  }");
    out.println("  a:hover {");
    out.println("    color: #ff9000;");
    out.println("  }");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='overlay'></div>");
    out.println("<div class='container'>");
    out.println("<h2>Welcome to Admin Dashboard</h2>");
    out.println("<p><a href='ViewServlet'>Customer Registration</a></p>");
    out.println("<p><a href='logServlet'>Logout</a></p>");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
}



            //dashboard
           // response.sendRedirect("dashboard.jsp"); // Redirect to admin dashboard
        } else {
            response.getWriter().println("Invalid username or password");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }
}
