<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="" %>--%>
<%--<%@include file="" %>--%>

<%--
    include指令：包含指令，在JSP中完成静态包含，很少用了
    taglib指令：引入标签库的指令。这个到JSTL标签库的时候在学习
    page指令：目前重点学习的一个指令

    指令的用法：
        <%@指令名 属性名=属性值 属性名=属性值 属性名=属性值%>
--%>


<%--<%@page session="false/true"%> true表示启动JSP的内置对象session，表示启动session对象如果没有session对象会创建
                                    如果没有设置，默认为true；--%>

<%--<%@page contentType="text/json" pageEncoding="UTF-8"%> 设置响应的内容类型和响应的字符集--%>

<%--<%@page import="java.util.List,java.io.Serializable"%> 导包--%>

<%--<%@page errorPage="/error.jsp" %> 当前页面出现异常之后，跳转到error；这个用来指定出错之后的跳转位置--%>


<%--
    JSP的九大内置对象：
        jakarta.servlet.jsp.PageContext pageContext 页面作用域
        jakarta.servlet.http.HttpServletRequest request 请求作用域
        jakarta.servlet.http.HttpSession session 会话作用域
        jakarta.servlet.ServletContext application 应用作用域
            pageContext < request < session < application
            以上四个作用域都有：setAttribute、getAttribute、removeAttribute方法
            以上作用域的使用原则：尽可能使用小的域

        java.lang.Throwable.exception
        jakarta.servlet.ServletConfig config
        java.lang.Object page （其实是this，当前的servlet对象）

        jakarta.servlet.jsp.jspWriter out 负责输出
        jakarta.servlet.http.HttpServletResponse response 负责响应
--%>