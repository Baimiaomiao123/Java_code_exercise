<%--解决中文乱码问题，表示响应的内容类型是text/html;采用的字符集为UTF-8--%>
<%@page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
    <title>my first jsp</title>
        <script type="text/javascript">
            function sayHello() {
                alert('你好 jsp!');
            }
        </script>
    </head>
    <body>
    <h1>my first jsp page!</h1><br>
    <input type="button" value="hello jsp" onclick="sayHello()"/>
    </body>
</html>