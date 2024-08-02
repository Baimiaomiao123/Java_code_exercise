<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>部门列表页面</title>
    <%-- 设置整个网页的基础路径是 --%>
    <base href=${pageContext.request.contextPath}/">
</head>
<body>
  <h3>欢迎${username}登陆系统</h3>
  <a href="user/exit">[退出系统]</a>

  <script type="text/javascript">
    function del(dno){
      if(window.confirm('亲，删除了就不可恢复哦')){
        //注意：html的base标签可能对JS代码不起作用，所以JS代码最好前面写上
        document.location.href = "${pageContext.request.contextPath}/dept/delete?deptno=" + dno;
      }
    }
  </script>

  <h1 align='center'>部门列表页面</h1>
  <hr>
  <table border='1px' align='center' width='50%'>
    <tr align='center'>
      <th>序号</th>
      <th>部门编号</th>
      <th>部门名称</th>
      <th>操作</th>
    </tr>

    <c:forEach items="${deptList}" varStatus="deptStatus" var="dept">
      <tr align='center'>
        <td>${deptStatus.count}</td>
        <td>${dept.deptno}</td>
        <td>${dept.dname}</td>
        <td>
          <a href='javascript:void(0)' onclick='del(${dept.deptno})'>删除</a>
          <a href='${pageContext.request.contextPath}/dept/detail?flag=edit&deptno=${dept.deptno}'>修改</a>
          <a href='${pageContext.request.contextPath}/dept/detail?flag=detail&deptno=${dept.deptno}'>详情</a>
        </td>
      </tr>
    </c:forEach>


  </table>
  <hr>
  <a href='${pageContext.request.contextPath}/html_new/add.jsp'>新增部门</a>
</body>
</html>