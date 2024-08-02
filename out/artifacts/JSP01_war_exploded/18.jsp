<%@page contentType="text/html; charset=UTF-8" %>

<%--引入核心标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--核心标签库的if标签--%>
<%--test属性是必须的，test属性是支持EL表达式的，test属性只能是boolean属性--%>
<c:if test="${empty param.username}">
    <h1>用户名不能为空！</h1>
</c:if>

<%--没有else标签的话，可以搞两个if出来--%>
<%--if标签还有var属性，不是必须的--%>
<%--if标签还有scope属性，用来指定var的存储域，也不是必须的--%>
<c:if test="${not empty param.username}">
<h1>欢迎你${param.username}！</h1>
</c:if>

<hr>

<c:if test="${not empty param.username}" var="v" scope="request">
    <h1>欢迎你${param.username}！</h1>
</c:if>

<hr>

<%--通过EL表达式将request域中的v取出--%>
<%--v变量存储的test属性的值--%>
${v}