<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>test param</title>
    </head>
    <body>
        <h2 class="text-success">test param page!看到此页面说明成功!</h2>
        <%--使用时候,还是要和header的具体属性相关联--%>
        <h2 class="text-success">Content-Type:${AcceptEncoding}</h2>
        <%--使用时候,还是要和cookie的具体属性相关联--%>
        <h2 class="text-success">JSESSIONID:${requestScope.cookieid}</h2>
        <!-- request和response的区别在何处?-->
        <h2 class="text-danger">设置session的JSESSIONID, requestScope.JSESSIONID= ${responseScope.cookieid123 }</h2>

    </body>
</html>
