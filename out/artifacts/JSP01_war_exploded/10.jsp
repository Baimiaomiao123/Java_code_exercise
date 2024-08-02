<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="bean.User" %>

<%
    User user = new User();
    user.setUsername("zhangsan");

    request.setAttribute("abc",user);

    //如果存的name里面有.
    request.setAttribute("abc.def","hello jsp");
%>

<%--使用EL表达式取出，并且输出到浏览器--%>
${abc} <br>

<%--两种写法取username，注意[]里面一定要写""--%>
${abc.username} <br>
${abc["username"]} <br>

<%--存的name里面有.，那么取出来的时候一定要用[]的形式--%>
${requestScope["abc.def"]} <br>


