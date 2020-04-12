<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>测试ajax!</title>
        <!-- jquery的路径问题，需要导入，注意点， 路径问题！暂时没有解决使用本地的文件，后续需要注意-->
        <%-- <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"/>--%>
        <%-- <script src="$/WEB-INF/static/js/jquery-3.4.1.js"/> --%>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
                // 所有的参数介绍
                // url: 待载入的页面的URL地址
                // data: 待发送key/value 参数
                // success: 载入成功时回调函数
                // success-data: 封装了服务器返回的数据
                // success-status: 状态码
                $.post({
                    // ajax默认是get请求
                    url: "${pageContext.request.contextPath}/ajax/a1",
                    data: {"name": $("#txtName").val()},
                    success: function (data, status) {
                        console.log(data, status);
                        window.alert("data")
                    }
                });
            }
        </script>

        <!-- onblur 失去焦点，产生事件 -->
        <span> 请输入姓名: </span>
        <input type="text" id="txtName" onblur="ajaxMethod01()"/>
    </body>
</html>
