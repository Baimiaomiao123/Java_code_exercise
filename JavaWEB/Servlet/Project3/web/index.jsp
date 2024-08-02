<%@page contentType="text/html;charset=UTF-8" %>
<%--访问jsp的时候不生成session对象--%>
<%--写上这个，内置对象就不能用了--%>
<%@page session="false"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎使用OA系统</title>
</head>
<body>
    <%--项目名不能写死！！！--%>
    <%--以下这样写代码，项目名写死了。这种设计显然是不好的--%>
<%--    <a href="/oa3/html/list.jsp">查看部门列表</a>--%>

<%--    <a href="<%=request.getContextPath()  %>/html/list.jsp">查看部门列表</a>--%>
<%--注意""里面不能加入空格，会导致路径错误报404错误，但是在<%=%>可以加，因为这个会被翻译为/oa--%>

    <%--  执行一个Servlet，查询数据库，收集数据  --%>
<%--    <a href="<%=request.getContextPath()%>/dept/list">查看部门列表</a>--%>

    <h1>LOGIN PAGE</h1>
    <hr>
    <%--  前端页面发送请求的时候，请求路径以"/"开始，带项目名  --%>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        username：<input type="text" name="username" /><br>
        password：<input type="text" name="password" /><br>
        <input type="checkbox" name="f" value="1"/>十天内免登陆<br>
        <input type="submit" value="login">
    </form>
</body>
</html>