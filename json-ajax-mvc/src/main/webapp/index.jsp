<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>测试ajax!</title>
        <!-- jquery的路径问题，需要导入，注意点， 路径问题！-->
        <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"/>
    </head>
    <body>
        <h2>Hello World!</h2>
        <script type="text/javascript">
            <%--
                实现的思路， 但是我们是要使用jquery提供的ajax来实现
                // 1.获取文本的值
                $("txtName").val();
                // 2.发送给服务器
                "${pageContext.request.contextPath}/ajax/a1";
                // 3.接收服务器返回的数据
            --%>

            function ajaxMethod01() {
                $.ajax({
                    url: "${pageContext.request.contextPath}/ajax/a1",
                    data: {'name': $("#txtName").val()},
                    success: function (data, status) {
                        console.log(data, status);
                        window.alert("data")
                    }
                });
            }
        </script>
        <!-- onblur 失去焦点，产生事件 -->
        <span > 请输入姓名： </span>
        <input type="text" id="txtName" onblur="ajaxMethod01()">
    </body>
</html>
