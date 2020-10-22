<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!-- 讓el表達式起作用 -->
<%@page isELIgnored="false" %>
<!-- 引入jsp标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>hello monkey</title>
    </head>
    <body>
        <%--https://jingyan.baidu.com/article/f0e83a257ccee422e5910101.html--%>
        <%--http://www.divcss5.com/wenji/w503.shtml --%>
        <p>添加猴子</p>
        <br>
        <br>
        <br>
        <form action="/monkey/add" method="post">
            <span>id:       </span><input type="text" name="id"> ${errorMsg.id}<br>
            <span>name:     </span><input type="text" name="name"> ${errorMsg.name}<br>
            <span>gender:   </span><input type="text" name="gender"> ${errorMsg.gender}<br>
            <!-- localdate 的轉換問題 -->
            <span>birthday: </span><input type="text" name="birthday"> ${errorMsg.birthday}<br>
            <!-- 國際化，使用 xx/add？language=zh_CN的方式 -->
            <input type="submit" value="<spring:message code="createmonkey"/>">


        </form>
        <!-- 國際化是要讓人看的， 所以，是需要在前台處理的 -->
        <!-- 國際化，使用 xx/add？language=zh_CN的方式 -->
        <a href=""><spring:message code="createmonkey"/></a>
        <br>
        <br>
        <br>


    </body>

</html>