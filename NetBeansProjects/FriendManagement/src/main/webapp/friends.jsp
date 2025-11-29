<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Friends List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            color: #333;
            padding: 20px;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        table {
           width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); 
        }
        th, td {
            padding: 10px;
            text-align: left;
             border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
              font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        a {
            color: #4CAF50;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
         .action-links {
            font-size: 0.9em;}
    </style>
</head>
<body>
    <h2>Friends List</h2>
    <table border="1">
        <tr>
            <th>No</th>
            <th>Car Name</th>
            <th>Model Name</th>
            <th>Brand</th> 
            <th>Color</th>
            <th>Action</th>
        </tr>
        <c:forEach var="friend" items="${friendsList}">
            <tr>
                <td>${status.index + 1}</td>
                <td>${friend.id}</td>
                <td>${friend.carname}</td>
                <td>${friend.modelname}</td>
                <td>${friend.brand}</td> 
                <td>${friend.color}</td> 
                <td>
                    <a href="EditFriendServlet?id=${friend.id}">Edit</a> |
                    <a href="DeleteFriendServlet?id=${friend.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="index.jsp">Add Another Car</a>
</body>
</html>
