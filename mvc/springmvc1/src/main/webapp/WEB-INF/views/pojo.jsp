<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<head>
    <title>pojo</title>
</head>
<body>
    <!-- Spring MVC可以自动关联级联属性, POJO直接使用! -->
    <h1 class="text-input">学生姓名: ${student.name}</h1>
    <h1 class="text-input">学生ID : ${student.id}</h1>
    <h1 class="text-input">学生省份: ${student.address.name}</h1>
    <h1 class="text-input">学生省份面积: ${student.address.area}</h1>
</body>
</html>
