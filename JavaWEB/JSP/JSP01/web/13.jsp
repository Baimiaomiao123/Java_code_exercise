
<%--page指令中有一个指令：isELIgnored；如果为true表示忽略整个页面EL表达式，如果为false表示不忽略（默认）--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="true" %>

<%
  request.setAttribute("username","zhangsan");
%>


${username}

<%--如果忽略某一个EL表达式，在EL表达式之前加一个"\"即可--%>
\${username}



