<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>添加员工页面</title>
</head>
<body>
    <!--
        1. WHY 使用 form 标签呢 ?
        可以更快速的开发出表单页面, 而且可以更方便的进行表单值的回显
        2. 注意:
        可以通过 modelAttribute 属性指定绑定的模型属性, 若没有指定该属性，则默认从 request 域对象中读取
        command 的表单 bean如果该属性值也不存在，则会发生错误。此处的对应的是employee
    -->

    <form:form action="${pageContext.request.contextPath}/emp" method="POST" modelAttribute="employee">
        LastName:<form:input path="lastName"/>



        <span class="text-info">Email:</span> <form:input path="email"/>
        <br>
        <span class="text-info">Gender:</span> <form:radiobuttons path="gender" items="${requestScope.genders}"/>
        <br>
        <span class="text-info">Department:</span>
        <form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id" />
        <br>
        <br>
        <input type="submit" value="提交创建新员工!" class="text-success"/>
    </form:form>
</body>
</html>
