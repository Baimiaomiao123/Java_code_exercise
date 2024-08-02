<%@ page contentType="text/html;charset=UTF-8" language="java" %>\
<%@page import="jakarta.servlet.http.HttpServletRequest" %>

<%
  //JSP有九大内置对象
  //其中有四个域对象，其中最小的域是pageContext（页面上下文）
  //通过page可以获取什么？？？
%>

<%--从以下代码来看，pageContext.getRequest()方法是没用的，这是获取request对象
    而JSP中自带了内置对象request，直接用request内置对象就可以了
 --%>
<%=pageContext.getRequest()%> <br>
<%=request%> <br>

<hr>

<%--
    注意：在EL表达式当中没有request这个隐式对象
    requestScope——这个只代表请求范围，不等同于request对象
    在EL表达式当中有一个隐式对象：pageContext
    在EL表达式中的PageContext和JSP九大内置对象pageContext是同一个对象
--%>

<%--所以EL表达式中——可以写：pageContext.request来获取request对象--%>
<%=pageContext.getRequest()%> <br>
这段java代码对应的EL表达式：
${pageContext.request} <br>

<hr>

<%--获取应用的根--%>
<%=((HttpServletRequest)pageContext.getRequest()).getContextPath()%> <br>
<%=request.getContextPath()%>
这段代码对应的EL表达式：
${pageContext.request.contextPath} <br>