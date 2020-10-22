<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>ajax 的学习和测试</title>
        <style type="text/css">
            th {
                font-size: 20px;
                font-family: 方正粗黑宋简体;
                color: chocolate;
            }

            #content td {
                padding-left: 10px;
                border: 1px;
                border-color: chocolate;
                border-style: dotted;

            }

        </style>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script>
            function x() {
                window.alert("123");
                console.log("hello")
            }
        </script>
    </head>
    <body>
        <p>你好，全世界!</p>
        <!--ajax处理-->
        <script type="text/javascript">
            $(function () {
                $("#btn").click(function () {
                    // ajax的请求链接和回调处理函数
                    $.post("${pageContext.request.contextPath}/ajax/a2", function (data) {
                        // 回调处理函数的内容，主要是获取数据，然后写入
                        console.log(data);
                        var myHtml = "";
                        for (let i = 0; i < data.length; i++) {
                            myHtml += "<tr>" +
                                "<td>" + data[i].name + "</td>" +
                                "<td>" + data[i].age + "</td>" +
                                "<td>" + data[i].gender + "</td>" +
                                "</tr>";
                        }
                        // 写入数据到表格之中
                        $("#content").html(myHtml);
                    })
                })
            })
        </script>

        <input type="button" id="btn" value="获取数据">
        <table style="margin-left: 20px; padding-left: 1px; border: 1px; border-color: #FF00FF; border-style: dot-dash">
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <tbody id="content">

            </tbody>
        </table>
        <input type="button" id="btn2" value="获取数据2" onclick="x()"/>
    </body>
</html>
