<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
    </head>

    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>Theme</th>
            </tr>
            <c:forEach items="${list}" var="man" varStatus="status">
                <tr>
                    <td>${man.getName()}</td>
                    <td>${man.getAge()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>

</html>
