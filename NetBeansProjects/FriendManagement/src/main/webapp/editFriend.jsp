<!DOCTYPE html>
<html>
<head>
    <title>Edit Friend</title>
    <style>
        /* Page styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f4f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        /* Form container styling */
        .form-container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 320px;
            text-align: center;
        }

        /* Title styling */
        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        /* Input styling */
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Submit button styling */
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 10px 0;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        /* Submit button hover effect */
        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Link styling */
        a {
            display: inline-block;
            margin-top: 15px;
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Edit Friend</h2>
        <form action="EditFriendServlet" method="post">
            <input type="hidden" name="id" value="${friend.id}"/> <!-- Hidden field for ID -->
            Car Name: <input type="text" name="carname" value="${friend.carname}" required/><br/>
            Model Number: <input type="number" name="modelnumber" value="${friend.modelnumber}" required/><br/>
            Color: <input type="text" name="color" value="${friend.color}" required/><br/>
            Brand: <input type="text" name="brand" value="${friend.brand}" required/><br/>
            <input type="submit" value="Update Friend"/>
        </form>
        <br/>
        <a href="DisplayFriendsServlet">View Friends</a>
    </div>
</body>
</html>
