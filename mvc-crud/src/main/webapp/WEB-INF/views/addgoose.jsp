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
<p>添加鵝</p>
<br>
<br>
<br>
<form action="/goose/add" method="post">
    <span>id:       </span><input type="text" name="id"><br>
    <span>name:     </span><input type="text" name="name"><br>
    <span>quality:   </span><input type="text" name="quality"><br>
    <input type="submit" value="提交創建一隻鵝">

</form>

<br>
<br>
<br>


</body>

</html>
