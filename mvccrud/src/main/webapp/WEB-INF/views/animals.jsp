<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Animals</title>

</head>
<body>
    <c:if test="${animals.size() <= 0}">
        <h3 class="text-info">没有动物!</h3>
    </c:if>
    <c:if test="${animals.size() >0}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th class="text-info">id</th>
                <th class="text-info">name</th>
                <th class="text-primary">birthday</th>
                <th class="text-primary">country</th>
                <th class="text-gray">Add</th>
                <th class="text-gray">Update</th>
                <th class="text-gray">Delete</th>
            </tr>
            <c:forEach items="${animals}" var="var">
                <tr>
                    <td class="text-info">${var.id}</td>
                    <td class="text-info">${var.name}</td>
                    <td class="text-primary">${var.birthday}</td>
                    <td class="text-primary">${var.country}</td>
                    <th class="text-gray"><a href="">Add</a></th>
                    <th class="text-gray"><a href="">Update</a></th>
                    <th class="text-gray"><a href="">Delete</a></th>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <a href="/animal/add" class="text-info">添加一个动物</a>

</body>
</html>
