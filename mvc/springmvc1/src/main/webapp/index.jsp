<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

    <title>Hello, Spring mvc!</title>
</head>
<body>
    <h1 class="text-center text-primary">Hello, Spring mvc!</h1>
    <a href="mvc" class="arrow-button key-text text-input">hello spring mvc!</a>
    <br>
    <a href="requestmap/gettime" class="arrow-button ">点我获取时间！</a>
    <br>
    <a href="requestmap/hello?name=zhangsan" class="arrow-button ">你好张三!</a>
    <br>

    <!-- post请求, 需要使用表单来草走-->
    <form action="/requestmap/hellopost" method="post">
        username: <input type="text" name="username" value="Tom"/>
        <br>
        email: <input type="text" name="email" value="tom@atguigu.com"/>
        <br>
        age: <input type="text" name="age" value="12"/>
        <br>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
