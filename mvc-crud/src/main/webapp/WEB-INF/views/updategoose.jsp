<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!-- 讓el表達式起作用 -->
<%@page isELIgnored="false" %>
<!-- 引入jsp标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>hello monkey</title>
    </head>
    <body>

        <p>更新鹅</p>
        <br>
        <br>
        <br>
        <form action="/goose/update" method="post">
            <!-- 方法的轉化 put轉換為post -->
            <input type="hidden" name="_method" value="PUT">
            <!-- 把id設置為隱藏域， 不去修改它 -->
            <input name="id" type="hidden" value="${oldgoose.id}">
            <span>name:     </span><input type="text" name="name" value="${oldgoose.name}"><br>
            <span>quality:   </span><input type="text" name="quality" value="${oldgoose.quality}"><br>
            <input type="submit" value="提交更新一隻鵝">

        </form>

        <br>
        <br>
        <br>


    </body>

</html>