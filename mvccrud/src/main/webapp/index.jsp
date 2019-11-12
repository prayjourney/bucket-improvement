<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <title> 首页啊, Crud </title>
</head>
    <body>
        <h2 class="text-primary">H首页啊, Crud !</h2>
        <a href="emps" class="text-info">List all emps!</a>
        <br>
        <a href="${pageContext.request.contextPath}/testredirect" class="text-danger">我是为了测试重定向而从在的!</a>

        <br>
        <a href ="${pageContext.request.contextPath}/girl/all" class="text-success">管理所有的姑娘</a>


        <br>
        <a href ="${pageContext.request.contextPath}/student/all" class="text-info">管理所有的学生, HHa哈哈</a>
    </body>
</html>
