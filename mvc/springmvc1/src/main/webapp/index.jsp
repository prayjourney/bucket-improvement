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

    <br>
    <!-- 在URL之中, 算是前端给后端传值, 然后在后端的Controller之中, 我们使用 Model等,
         然后将其通过Spel, 显示在jsp页面上, 算是后端给前端的传值, 二者方向问题需要理清楚
         同样的, 我们前后端传值和获取值的时候, 都要有对象去接收, 按照如下两种情况去区分
         前端给后端:
             前端url: /hello/飞轮海, 那么"飞轮海"就是我们需要从前端传给后端的数据, 那么就要在后端有参数接住, 所以要
                      有 public String helloRest(String name) {// todo}, 这个name的入参的存在, 此处是rest风格的,
                      所以需要是public String helloRest(@PathVariable("name") String name) {// todo}
         后端给前端:
             我们的数据整合在Controller的方法之中, 如果单纯要后端给前端传一个数据, 此时我们不需要什么参数, 而只是需要把
             我们的数据封装在SpringMVC提供的模型之中, 如Model, ModelMap, ModelAndView, 比如, 下面的info就是我们创的一个值,
             这个没有在传参等地方有体现, 完全是后端创建的, map.addAttribute("info","你好呀, 我完全是后端传给前端的一个值");
             然后在前端的页面使用 <h2 class="text-input">info: \${info}</h2> , 这样, 前端就取到了后端的值
    -->
    <a href="/rest/hello/zgy">你好, zgy!</a>
    <br>
    <a href="/rest/hello2/z.g.y">你好, zgy!</a>
    <br>
    <a href="/some/param?name=zhangsan&age=22&gender=lv">点击试验, 参数全</a>
    <br>
    <a href="/some/param?&gender=lv">点击试验, 没有必要的参数</a>
    <br>
    <a href="/some/head">点击试验, 观察header</a>
    <br>
    <!-- Spring mvc可以级联复合的属性-->
    <form action="/mvc/pojo" method="post">
        <table>
            <tr>
                <th class="text-center text-success">属性1</th>
                <th class="text-center text-success">属性2</th>
                <th class="text-center text-success">属性3</th>
                <th class="text-center text-success">属性4</th>
            </tr>
            <tr>
                <td class="text-center text-success" >姓名: <input type="text" name="name" /></td>
                <td class="text-center text-success" >ID: <input type="text" name="id" /></td>
                <td class="text-center text-success" >地方名: <input type="text" name="address.name" /></td>
                <td class="text-center text-success" >地方面积: <input type="text" name="address.area" /></td>
                <td> <input class="text-primary" type="submit" value="点击提交"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
