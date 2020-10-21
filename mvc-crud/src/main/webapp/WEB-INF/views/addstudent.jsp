<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <title>使用Spring form来添加一个学生</title>
    </head>
    <body>
        <h2 class="text-danger">使用Spring form来添加一个学生</h2>
        <form:form action="addstudent" method="post" modelAttribute="student" >
            <span class="text-info">id:  </span><form:input path="id"/><br>
            <span class="text-info">姓名: </span><form:input path="name"/><br>
            <span class="text-info">年龄: </span><form:input path="age"/><br>
            <span class="text-info">性别: </span><form:input path="gender"/><br>
            <span class="text-info">班级: </span><form:input path="classId"/><br>
            <span class="text-info">年级: </span><form:input path="gradeName"/><br>
            <span class="text-info">邮件: </span><form:input path="email"/><br>
            <span class="text-success">手机号码: </span><form:input path="phoneNumber"/><br>
            <%--<span class="text-success">生日: <form:input path="birth"/><br>--%>
            <span class="text-success">生日: <form:input path="birthStr"/><br>
            <input type="submit" value="提交啊!">
        </form:form>
    </body>
</html>
