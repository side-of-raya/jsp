<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create man</title>
    <style>
        input{
            color: aliceblue;
            background: black;
            width: 200px;
            height: 40px;
        }
        td{
            width: 200px;
            height: 40px;
            font-size: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<table>
    <form action="men" method="post">
        <input type="hidden" name="action" value="create">
            <tr>
                <td>Man's name</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Man's age</td>
                <td><input type="text" name="age"  /></td>
            </tr>
            <tr>
            <td><input type="submit" value="Submit"/></td></tr>
    </form>
    <tr><td>
        <form action = "index.jsp">
            <input type="submit" value="Cancel">
        </form>
    </td><td></td></tr>
</table>
</body>
</html>
