<%-- 
    Document   : login
    Created on : 01-Dec-2024, 8:31:08 pm
    Author     : aayua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <style>
            /* Body Styling */
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
                color: #333;
            }

            h1, h3 {
                text-align: center;
                margin-top: 50px;
                color: #4f4f4f;
            }

            .logout-btn {
            display: inline-block;
            margin: 20px auto;
            margin-left:1300px;
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
        
            form {
                text-align: center;
                margin-top: 20px;
            }

            button {
                background-color: #4f4f4f;
                color: white;
                font-size: 16px;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            button:hover {
                background-color: #6f6f6f;
            }

            /* Additional styles for responsiveness */
            @media (max-width: 600px) {
                h1, h3 {
                    font-size: 20px;
                }

                button {
                    font-size: 14px;
                }
            }
        </style>
    </head>
    <body>
                           <a href="index.html" class="logout-btn">Logout</a>

        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (password.equals("1234")) {
        %>
            <h3>welcome, <%=username%></h3>
            <form action="resume.jsp">
                <button>View Resume</button>
            </form>
        <%
            } else {%>
              <h1>Wrong password</h1>
             <%   response.sendRedirect("index.html"); %>
        
            
        <%
            }
        %>
    </body>
</html>
