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
				<th class="text-primary">ID</th>
				<th class="text-danger">Last Name</th>
				<th class="text-info">Email</th>
				<th class="text-info">Gender</th>
				<th class="text-info">Department</th>
				<th class="text-info">Birthday</th>
				<th class="text-success">Salary</th>
				<th class="text-primary">Edit</th>
				<th class="text-primary">Delete</th>
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
					<td><a href="">Edit</a> </td>
					<td><a href="">Delete</a> </td>
				</tr>

			</c:forEach>
		</table>
	</c:if>
	
</body>
</html>