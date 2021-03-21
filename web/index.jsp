<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Сервлеты и JSP-страницы</title>
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
<div align="center">
  <br>
  <h2 align="center">Выберите таблицу</h2>
  <br>
  <form action="men" method="get">
    <input type="submit" value="Men list">
  </form>
  <form action="pets" method="get">
    <input type="submit" value="Pet list">
  </form>
</div>
</body>
</html>
