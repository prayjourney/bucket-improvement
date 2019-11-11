<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
ß
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>添加一个姑娘</title>
</head>
<body>
<h2 class="text-danger">添加一个女孩</h2>
<form action="/girl/addgirl" method="post">
    <!-- form 之中必须要加上name属性, 这个name属性要和我们POJO之中的字段名称对应起来, 否则就会报错! -->
    <span class="text-info">姓名: </span><input type="text" name="name">
    <span class="text-info">年龄: </span><input type="text" name="age">
    <span class="text-success">罩杯: </span><input type="text" name="size">
    <input type="submit" value="提交啊!">
</form>

</body>
</html>
