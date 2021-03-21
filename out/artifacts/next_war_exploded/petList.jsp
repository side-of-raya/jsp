<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Pet list</title>
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
        }
    </style>
</head>
<body>
<br>
<h2 align="center">Pet list</h2><br>
<table align="center">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Age</td>
        <td>Master ID</td>
        <td>Master name</td>
    </tr>
    <c:forEach var = "pet" items="${petList}">
        <tr>
            <td>${pet.getId()}</td>
            <td>${pet.getName()}</td>
            <td>${pet.getAge()}</td>
            <td>${pet.getMasterID()}</td>
            <td>${pet.getMasterName()}</td>
        </tr>
    </c:forEach>
<tr>
<td><br>
<form action = "index.jsp">
    <input type="submit" value="Назад">
</form></td> <td></td><td></td><td>
</td><td></td></tr></table>
</body>
</html>
