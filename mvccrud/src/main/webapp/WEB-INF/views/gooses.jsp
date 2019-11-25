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
        <p>所有的鵝 啊！</p>
        <br>
        <br>
        <br>
        <table class="goose" border="1">
            <c:if test="${gooses.size() ==0 }">
                沒有鹅!
            </c:if>
            <th>id</th>
            <th>name</th>
            <th>quality</th>
            <th>add</th>
            <th>update</th>
            <th>delete</th>
            <c:forEach var="goose" items="${gooses}">
                <tr>
                    <td>${goose.id}</td>
                    <td>${goose.name}</td>
                    <td>${goose.quality}</td>
                        <%--<td><a href="${pageContext.request.contextPath}/goose/add">add</a></td>--%>
                    <td><a href="${pageContext.request.contextPath}/goose/add">add</a></td>
                        <%--<td><a href="${pageContext.request.contextPath}/goose/update/${goose.id}">update</a></td>--%>
                    <td><a href="${pageContext.request.contextPath}/goose/update/${goose.id}">update</a></td>
                    <!-- 下面這種提供的是get方法，所以不行 -->
                        <%--<td><a href="${pageContext.request.contextPath}/goose/delete?id=${goose.id}">delete</a></td>--%>
                    <td>
                            <%--<form action="${pageContext.request.contextPath}/goose/delete/${goose.id}" method="post">--%>
                        <form action="${pageContext.request.contextPath}/goose/delete/${goose.id}" method="post">
                            <input type="hidden" name="_method" value="DELETE">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>

            </c:forEach>

        </table>

        <br>
        <br>
        <br>
        <a href="/goose/add">添加一隻鵝</a>
        <!-- 這種方式需要使用ajax, 來首先取到我們點擊行的id, 然後拼接id, 後面再去執行-->
        <a href="/goose/delete?id=1" class="delete">刪除一隻鵝</a>
        <!-- 這種方式需要使用ajax, 來首先取到我們點擊行的id, 然後拼接id, 後面再去執行-->
        <a href="/goose/update?id=2" class="update">更新一隻鵝</a>

    </body>

</html>