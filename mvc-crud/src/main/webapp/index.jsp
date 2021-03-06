<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <title> 首页啊, Crud </title>
</head>
<body>
    <h2 class="text-primary">H首页啊, Crud !</h2>
    <a href="emps" class="text-info">List all emps!</a>
    <br>
    <a href="${pageContext.request.contextPath}/testredirect" class="text-danger">我是为了测试重定向而从在的!</a>

    <br>
    <a href="${pageContext.request.contextPath}/girl/all" class="text-success">管理所有的姑娘</a>


    <br>
    <a href="${pageContext.request.contextPath}/student/all" class="text-info">管理所有的学生, HHa哈哈</a>
    <br>
    <a href="${pageContext.request.contextPath}/animal/all" class="text-primary">饲养员</a>

    <br>
    <br>
    <!-- 上传文件 -->
    <br>
    <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
        <input class="btn-info" type="file" name="file"><input class="btn-primary" type="submit" value="submit">
    </form>

    <!-- 返回json数据-->
    <br>
    <a href="${pageContext.request.contextPath}/monkeyjson/2" class="text-primary">返回json数据</a>

    <br>
    <br>
    <br>
    <a href="/monkey/all">review all monkeys!</a>
    <br>
    <br>
    <br>
    <!-- 首頁鏈接 -->
    <a href="/goose/all" class="text-success">查看鹅!</a>

    <br>
    <!-- 我的url是/testexception, 在需要些URL的地方, 写好完整的URL, 但是在controller之中, 不用写后面的参数 -->
    <a href="/testexception?i=10" class="text-danger">算术运算!</a>

    <br>
    <br>
    <!-- 定制响应错误的信息 -->
    <a href="/userexception?i=4" class="text-danger">定制响应错误的信息</a>

    <br>
    <br>
    <!-- 定制响应错误的信息 -->
    <a href="/userexception2?i=4" class="text-danger">在方法上, 定制响应错误的信息</a>

    <br>
    <br>
    <!-- 定制响应错误的信息 -->
    <a href="/testsimpleexception?i=3" class="text-danger">simpleMappingException来定制映射页面</a>
</body>
</html>
