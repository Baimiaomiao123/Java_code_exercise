<%@page contentType="text/html;charset=UTF-8" %>

<%--
    关于EL表达式的运算符
        1、算术运算符
            + - * / %
        2、关系运算符
            == != > >= > < <= eq lt gt
        3、逻辑运算符
            ! && || not and or
        4、条件运算符
            ? :
        5、取值运算符
            [] 和 .
        6、empty运算符
--%>

${10 + 20} <br>
<%--在EL表达式当中"+"运算符智能做求和运算，不会进行字符串拼接操作--%>
${10 + "20"} <br>

<%--会报错：ava.lang.NumberFormatException: For input string: "abc"--%>
<%-- + 两边不是数字的时候，一定会转成数字，转不成数字就会报错：NumberFormatException --%>
\${10 + "abc"} <br>
\${"abc" + "def"} <br>


<%-- 关系运算符 --%>
<%--EL表达式中的==调用了equals方法--%>
<%--EL表达式中的!=也会调用equals方法--%>

${"abc" == "abc"} <br>
${"abc"} == ${"abc"} <br>

<%
    Object obj = new Object();
    request.setAttribute("obj1",obj);
    request.setAttribute("obj2",obj);
%>
${obj1 == obj2} <br>

<%
    String s1 = new String("hehe");
    String s2 = new String("hehe");
    request.setAttribute("a",s1);
    request.setAttribute("b",s2);
%>
${a == b} <br>

<%
    Object o1 = new Object();
    Object o2 = new Object();
    request.setAttribute("o1",o1);
    request.setAttribute("o2",o2);
%>
${o1 == o2} <br>

<hr>
<%--条件运算符--%>
${empty param.username ? "对不起，用户名不能为空！" : "欢迎访问"}

<hr>
<%--empty运算符--%>
<%--判断是否为空，如果为空，结果是true；如果不为空，则是false--%>
${empty param.username} <br>
${!empty param.username} <br>
${not empty param.username} <br>

<%--结果是：false--%>
${empty param.password == null} <br>
${(empty param.password) == null} <br>
${empty (param.password == null)} <br>

${param.password == null} <br> <%----%>