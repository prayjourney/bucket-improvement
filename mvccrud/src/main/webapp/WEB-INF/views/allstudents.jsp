<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <title>使用Spring form来列举出所有的学生</title>
    </head>
    <body>
        <h2 class="text-danger">使用Spring form来列举出所有的学生</h2>
        <c:if test="${requestScope.students.size() <= 0}">
            <h3 class="text-info">没有一个学生了!</h3>
        </c:if>
        <c:if test="${students.size() >0}">
            <table border="1" cellpadding="10" cellspacing="0">
                <tr>
                    <th class="text-info">姓名</th>
                    <th class="text-info">年龄</th>
                    <th class="text-info">性别</th>
                    <th class="text-info">班级</th>
                    <th class="text-info">年级</th>
                    <th class="text-primary">邮件</th>
                    <th class="text-primary">手机号</th>
                    <th class="text-danger">生日</th>
                    <th class="text-gray">Add</th>
                    <th class="text-gray">Update</th>
                    <th class="text-gray">Delete</th>
                </tr>
                <c:forEach items="${students}" var="stu">
                    <tr>
                        <td class="text-info">${stu.name}</td>
                        <td class="text-info">${stu.age}</td>
                        <td class="text-info">${stu.gender}</td>
                        <td class="text-info">${stu.classId}</td>
                        <td class="text-info">${stu.gradeName}</td>
                        <td class="text-primary">${stu.email}</td>
                        <td class="text-primary">${stu.phoneNumber}</td>
                        <%--<td class="text-danger">${stu.birth}</td>--%>
                        <td class="text-danger">${stu.birthStr}</td>
                        <td><a href="/student/addstudent" class="btn btn-success">Add</a></td>
                        <td><a href="/student/deletestudent" class="btn btn-info">Update</a></td>
                        <td><a href="" class="btn btn-danger">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>


    </body>
    <a class="text-success" href="${pageContext.request.contextPath}/student/addstudent">添加一个学生</a>
    <!-- 如果此时, 选择的某一行的数据, 直接带着这个ModelAttribute, 那么久直接删除成功了!!! -->
    <form:form action="${pageContext.request.contextPath}/student/deletestudent" modelAttribute="student" method="post">
        <form:hidden path="id" id="_id"></form:hidden>
        用户名<form:input path="name"/>
        <input type="submit" value="ti">
    </form:form>
</html>
