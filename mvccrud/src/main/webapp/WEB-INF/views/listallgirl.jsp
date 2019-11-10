<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>所有的姑娘</title>
</head>
<body>
    <c:if test="${allgirl.size() <= 0}">
        <h3 class="text-info">今晚没有姑娘了!</h3>
    </c:if>
    <c:if test="${allgirl.size() >0}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th class="text-info">姓名</th>
                <th class="text-info">年龄</th>
                <th class="text-primary">罩杯</th>
                <th class="text-gray">Add</th>
                <th class="text-gray">Update</th>
                <th class="text-gray">Delete</th>
            </tr>
            <c:forEach items="${allgirl}" var="girl">
                <tr>
                    <td class="text-info">${girl.name}</td>
                    <td class="text-info">${girl.age}</td>
                    <td class="text-primary">${girl.size}</td>
                    <th class="text-gray"><a href="">Add</a></th>
                    <th class="text-gray"><a href="">Update</a></th>
                    <th class="text-gray"><a href="">Delete</a></th>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</body>
</html>
