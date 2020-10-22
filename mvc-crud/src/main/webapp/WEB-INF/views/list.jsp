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
        <title>列出所有的员工咯!</title>

        <!--
        SpringMVC 处理静态资源:
        1. 为什么会有这样的问题: 优雅的 REST 风格的资源URL 不希望带 .html 或 .do 等后缀
           若将 DispatcherServlet 请求映射配置为 /, 则 Spring MVC 将捕获 WEB 容器的所有请求, 包括静态资源的请求,
           SpringMVC 会将他们当成一个普通请求处理, 因找不到对应处理器将导致错误。
        2. 解决: 在 SpringMVC 的配置文件中配置 <mvc:default-servlet-handler/>
    -->

        <!-- 这两种都可以找到这个文件, 但是在web页面上面没有弹窗, 也无法下载我们的js文件 -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <%--<script src="jquery-1.9.1.min.js" type="text/javascript"></script>--%>
        <script type="text/javascript">
            // $(function(){
            //     alert("hello boy!")
            // })
            $(".delete").click(function () {
                var href = $(this).attr(href);
                $("form").attr("action", href).submit();
                return false;
            })
        </script>
    <body>
        <!-- 判断有没有员工! -->
        <c:if test="${empty requestScope.employees}">
            <h4 class="text-danger">没有任何员工信息</h4>
        </c:if>
        <c:if test="${!empty requestScope.employees}">
            <table border="1" cellpadding="10" cellspacing="0">
                <!-- tr是一行, td是一个表格, th是表头的意思 -->
                <tr>
                    <th class="text-primary">ID</th>
                    <th class="text-danger">Last Name</th>
                    <th class="text-info">Email</th>
                    <th class="text-info">Gender</th>
                    <th class="text-info">Department</th>
                    <th class="text-info">Birthday</th>
                    <th class="text-success">Salary</th>
                    <th class="text-primary">Edit</th>
                    <th class="text-primary">Delete</th>
                    <th class="text-gray">Delete2[有问题]</th>
                </tr>
                <!-- 循环取值 -->
                <c:forEach items="${requestScope.employees}" var="emp">
                    <tr>
                        <td class="text-primary">${emp.id}</td>
                        <td class="text-danger">${emp.lastName}</td>
                        <td class="text-info">${emp.email}</td>
                        <td class="text-info">${emp.gender == 0 ? 'Female' :'Male'}</td>
                        <td class="text-info">${emp.department}</td>
                        <td class="text-info">${emp.birth}</td>
                        <td class="text-success">${emp.salary}</td>
                        <!-- 修改员工 -->
                        <td><a href="${pageContext.request.contextPath}/emp/${id}">Edit</a></td>
                        <!-- 删除的方法 -->
                        <td><a class="delete" href="${pageContext.request.contextPath}/emp/${emp.id}">Delete</a></td>
                            <%--<td><a class="delete" href="emp2/${emp.id}">Delete2</a></td>--%>
                            <%--"${pageContext.request.contextPath}/emp"--%>
                        <td><a class="delete" href="${pageContext.request.contextPath}/emp2/${emp.id}">Delete2</a></td>
                    </tr>

                </c:forEach>
            </table>
        </c:if>
        <br>
        <br>
        <a class="font-menu-button" href="${pageContext.request.contextPath}/emp">add new employee</a>


        <!-- 删除一个员工的操作, 这两种方式都是支持的! -->
        <form action="" method="post">
            <%--<input type="hidden" name="_method" value="GET">--%>
            <input type="hidden" name="_method" value="DELETE">
        </form>


    </body>
</html>