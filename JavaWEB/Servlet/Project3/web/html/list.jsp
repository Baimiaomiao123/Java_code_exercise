<%@ page import="java.util.List" %>
<%@ page import="oa.bean.Dept" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>部门列表页面</title>
</head>
<body>
  <%--显示一个登陆名字--%>
  <%--<%@page session="false"%>不能写，写了session内置对象就没有了！！--%>
  <h3>欢迎<%=session.getAttribute("username")%>登陆系统</h3>
  <a href="<%=request.getContextPath()%>/user/exit">[退出系统]</a>

  <script type="text/javascript">
    function del(dno){
      if(window.confirm('亲，删除了就不可恢复哦')){
        document.location.href = "<%=request.getContextPath()%>/dept/delete?deptno=" + dno;
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

    <%
      //从request域当中取出deptList
      List<Dept> deptList = (List<Dept>)request.getAttribute("deptList");
      //循环遍历
      int i = 0;
      for (Dept dept:
           deptList) {
        //在后台输出测试
        //System.out.println(dept.getDname());
        //把部门输出到浏览器
        //out.write(dept.getDname());


    %>
    <tr align='center'>
      <td><%=++i%></td>
      <td><%=dept.getDeptno()%></td>
      <td><%=dept.getDname()%></td>
      <td>
        <a href='javascript:void(0)' onclick='del(<%=dept.getDeptno()%>)'>删除</a>
        <a href='<%=request.getContextPath()%>/dept/detail?flag=edit&deptno=<%=dept.getDeptno()%>'>修改</a>
        <a href='<%=request.getContextPath()%>/dept/detail?flag=detail&deptno=<%=dept.getDeptno()%>'>详情</a>
      </td>
    </tr>
    <%
      }
    %>

  </table>
  <hr>
  <a href='<%=request.getContextPath()%>/html/add.jsp'>新增部门</a>
</body>
</html>