<%@ page import="bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--var用来指定循环中的变量，底层实际上会将var存储到page域中，所以这里才会使用EL表达式将其取出--%>
<%--begin——开始，end——结束，step——步长--%>
<c:forEach var="i" begin="1" end="10" step="1">
    ${i}&nbsp;&nbsp;
</c:forEach>

<hr>

<%
    //创建List集合
    List<Student> stuList = new ArrayList<>();

    //创建Student对象
    Student s1 = new Student("110","王五");
    Student s2 = new Student("110","张三");
    Student s3 = new Student("110","李四");

    //添加到List集合
    stuList.add(s1);
    stuList.add(s2);
    stuList.add(s3);

    //将List集合存储到request域当中
    request.setAttribute("stuList",stuList);
%>

<%--var="s"，这个s代表的是集合中每个Student对象--%>
<%--vatStatus这个属性表示var的状态对象。这里是一个java对象，这个java代表了var的状态--%>
<%--varStatus这个状态对象有count属性，可以直接使用--%>
<c:forEach items="${stuList}" var="s" varStatus="stuStatus">
    <%--  varStatus的count值从1开始，以1递增，主要用于编号/序号  --%>
    编号:${stuStatus.count},id:${s.id},name:${s.name} <br>
</c:forEach>

