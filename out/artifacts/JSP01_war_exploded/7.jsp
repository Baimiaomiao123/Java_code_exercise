<%@ page import="bean.User" %>
<%@ page import="bean.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //创建User对象
    User user = new User();
    user.setUsername("jackson");
    user.setPassword("1234");
    user.setAge(50);

    Address addr = new Address();
    addr.setNo("111");
    addr.setZipcode("404600");
    addr.setCity("重庆");

    user.setAddress(addr);

    request.setAttribute("userObj",user);
%>

<%--使用EL表达式取出User对象，并将其输出到浏览器--%>
<%--1、EL表达式会自动从某个范围中取数据 2、将其转换成字符产 3、将其输出到浏览器--%>
${userObj}

<br>
<%--输出user对象的属性--%>
<%--EL表达式底层调用的实际就是对象的get方法--%>
${userObj.username} <br>
${userObj.password} <br>
${userObj.age} <br>

<%--输出email--%>
${userObj.email} <br>

<%--输出user的城市、编号、邮编--%>
城市：${userObj.address.city} <br>
编号：${userObj.address.no} <br>
邮编：${userObj.address.zipcode} <br>