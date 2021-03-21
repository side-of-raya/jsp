<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Man list</title>
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
<br>
<h2 align="center">Man list</h2>
<br>
<table align="center">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Age</td>
    </tr>
<c:forEach items="${men}" var="man">
            <tr>
                <td>${man.getId()}</td>
                <td>${man.getName()}</td>
                <td>${man.getAge()}</td>
                <td>
                    <form action = "manUpdate.jsp">
                        <input type="submit" value="Редактировать">
                        <input type="hidden" name="id" value="${man.getId()}">
                        <input type="hidden" name="name" value="${man.getName()}">
                        <input type="hidden" name="age" value="${man.getAge()}">
                    </form>
                </td>
                <td>
                    <form action="manDelete.jsp">
                        <input type="hidden" name="id" value="${man.getId()}">
                        <input type="hidden" name="name" value="${man.getName()}">
                        <input type="submit" value="Удалить">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

<table align="center">
    <tr><td>
<form action = "index.jsp">
    <input type="submit" value="Назад">
</form></td>
    <td>
        <form action="manCreate.jsp">
            <input type="submit" value="Create man">
        </form>
    </td><td></td><td></td><td></td><td></td>
    </tr>
</table>
</body>
</html>
