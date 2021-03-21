<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update man</title>
    <style>
        input{
            color: aliceblue;
            background: black;
            width: 200px;
            height: 40px;
        }
        td{
            width: 400px;
            height: 40px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<table>
<form action="men" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="action" value="update">
    <tr>
        <td>Name ${param.name} </td>
        <td><input type="text" name="name" /></td>
    </tr>
    <tr>
        <td>Age - ${param.age} </td>
        <td><input type="text" name="age" /></td>
    </tr>
        <tr>
            <td valign="middle">
                <input type="submit" value="Update">
            </td></tr></form>
<tr><td>
    <form action = "menList.jsp">
        <input type="submit" value="Cancel">
    </form></td><td></td></tr>
</table>
</body>
</html>
