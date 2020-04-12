<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login Page</title>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <script>
            function userMethod() {
                $.ajax({
                    url: "${pageContext.request.contextPath}/ajax/a3",
                    data: {"name": $("#name").val()},
                    success: function (data) {
                        if (data.toString() == 'OK') { // 信息核对成功
                            $('#userInfo').css("color", "green")
                        } else {
                            $('#userInfo').css("color", "red");
                        }
                        $('#userInfo').html(data)
                    }
                })
            }

            function pwdMethod() {
                $.ajax({
                    url: "${pageContext.request.contextPath}/ajax/a3",
                    data: {"name": $("#pwd").val()},
                    success: function (data) {
                        if (data.toString() == 'OK') { // 信息核对成功
                            $('#pwdInfo').css("color", "green")
                        } else {
                            $('#pwdInfo').css("color", "red");
                        }
                        $('#pwdInfo').html(data)
                    }
                })
            }

        </script>
        <p>
            用户名:
            <input type="text" id="name" onblur="userMethod()">
            <span id="userInfo"></span>
        </p>
        <p>
            <span>密 码: </span>
            <input type="text" id="pwd" onblur="pwdMethod()">
            <span id="pwdInfo"></span>
        </p>


    </body>
</html>
