<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <title>Animals 添加</title>

    </head>
    <body>
        <form action="${pageContext.request.contextPath}/animal/add" method="get">
            <spap>ID ：</spap><input type="text" name="id"/><br/>
            <span>姓名：</span><input type="text" name="name"/><br/>
            <spap>生日：</spap><input type="text" name="birthday"/><br/>
            <spap>国家：</spap><input type="text" name="country"/><br/>
            <input type="submit" value="提交创建新Animal!" class="text-success"/>
        </form>
    </body>
</html>
