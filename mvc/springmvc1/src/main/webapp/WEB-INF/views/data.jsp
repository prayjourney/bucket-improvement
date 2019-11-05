<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>data</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <h2 class="text-warning">Model方式拿数据 : ${requestScope.hello}</h2>
    <h2 class="text-info">Map方式拿数据 : ${requestScope.你好}</h2>
    <h2 class="text-success">ModelMap方式拿数据 : ${what}</h2>
    <h2 class="text-danger">ModelAndView方式拿数据 : ${requestScope.ai}</h2>

</body>
</html>
