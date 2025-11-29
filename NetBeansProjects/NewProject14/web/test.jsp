<%--
    Document   : tableInput
    Created on : 14-Nov-2024, 9:02:34 am
    Author     : ayush
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Multiplication Table</title>
</head>
<body>

<%
    // Getting the number from the request parameter

    String numStr1 = request.getParameter("number1");
     String numStr2 = request.getParameter("number2");

    int num1=0;
    int num2=0;
    if (numStr1 != null && !numStr1.isEmpty() && numStr2 != null && !numStr2.isEmpty()) {
        try {
            num1 = Integer.parseInt(numStr1);
            num2 = Integer.parseInt(numStr2);
        } catch (NumberFormatException e) {
            out.print("please enter valid number");
        }
    }
%>

<h2>Enter a number to print the sum of two numbers:</h2>
<form method="get" action="">
    <input type="number" name="number1" value="<%= (num1 != 0) ? num1 : "" %>" required>
        <input type="number" name="number2" value="<%= (num2 != 0) ? num2 : "" %>" required>
    <input type="submit" value="RESULT">
</form>

    <h3>Addition of Two Numbers</h3>
    <td><%=num1+num2%> </td>

</body>
</html>