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
        <%--https://jingyan.baidu.com/article/f0e83a257ccee422e5910101.html--%>
        <%--http://www.divcss5.com/wenji/w503.shtml --%>
        <p>所有的猴子 啊！</p>
        <br>
        <br>
        <br>
        <table class="monkey" border="1">
            <c:if test="${monkeys.size() ==0 }">
                沒有猴子
            </c:if>
            <th>id</th>
            <th>name</th>
            <th>gender</th>
            <th>birthday</th>
            <th>add</th>
            <th>update</th>
            <th>delete</th>
            <c:forEach var="monkey" items="${monkeys}">
                <tr>
                    <td>${monkey.id}</td>
                    <td>${monkey.name}</td>
                    <td>${monkey.gender}</td>
                    <td>${monkey.birthday}</td>
                    <td><a href="">add</a></td>
                    <td><a href="">update</a></td>
                    <td><a href="">delete</a></td>
                </tr>

            </c:forEach>

        </table>

        <br>
        <br>
        <br>
        <a href="/monkey/add">添加一個猴子</a>

    </body>

</html>
