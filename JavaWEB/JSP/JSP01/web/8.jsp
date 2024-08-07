<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //四个域都存储了数据，并且name相同
    pageContext.setAttribute("data","pageContext");
    request.setAttribute("data","request");
    session.setAttribute("data","session");
    application.setAttribute("data","application");
%>

<%--在没有指定范围的前提下，EL表达式优先从小范围中取数据--%>
<%--pageContext < request < session < application--%>
${data} <br>

<%--在EL表达式中可以指定范围来读取数据--%>
<%--EL表达式有4个隐含的隐式的范围对象--%>
<%--pageScope requestScope sessionScope applicationScope--%>
<%--以下的是指定的范围--%>
${pageScope.data} <br>
${requestScope.data} <br>
${sessionScope.data} <br>
${applicationScope.data} <br>

<%--在实际开发中，因为向某个域中存储数据的时候，name都是不同的，所以xxxScope都是可以省略的，--%>


