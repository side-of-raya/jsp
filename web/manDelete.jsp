<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete man</title>
    <style>
        input{
            color: aliceblue;
            background: black;
            width: 200px;
            height: 40px;
        }
    </style>
</head>
<body>
Are you sure you want to delete name=${param.name}(id=${param.id})?
<tr>
<td><form action="men" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <input type="hidden" name="action" value="delete" />
    <input type="submit" value="Delete">
    </form>
</td>
<td>
    <form action = "index.jsp">
        <input type="submit" value="Back">
    </form>
</td></tr>
</body>
</html>
