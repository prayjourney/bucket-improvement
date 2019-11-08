<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>列出所有的员工咯!</title>
<body>
	<!-- 判断有没有员工! -->
	<c:if test="${empty requestScope.employees}">
		<h4 class="text-danger">没有任何员工信息</h4>
	</c:if>
	<c:if test="${!empty requestScope.employees}">
		<table border="1" cellpadding="10" cellspacing="0">
			<!-- tr是一行, td是一个表格, th是表头的意思 -->
			<tr>
				<th>ID</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Birthday</th>
				<th>Salary</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<!-- 循环取值 -->
			<c:forEach items="${requestScope.employees}" var="emp">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>
					<td>${emp.gender == 0 ? 'Female' :'Male'}</td>
					<td>${emp.department}</td>
					<td>${emp.birth}</td>
					<td>${emp.salary}</td>
					<td><a href="">Edit</a> </td>
					<td><a href="">Delete</a> </td>
				</tr>

			</c:forEach>
		</table>
	</c:if>
	
</body>
</html>