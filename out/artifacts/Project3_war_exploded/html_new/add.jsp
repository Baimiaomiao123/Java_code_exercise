<%@page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增页面</title>
</head>
<body>
  <h3>欢迎，${username}</h3>
  <h1>新增部门</h1>
  <hr>
  <form action="${pageContext.request.contextPath}/dept/add" method="post">
    部门编号<input type="text" name="deptno"/><br>
    部门名称<input type="text" name="dname"/><br>
    部门位置<input type="text" name="loc"/><br>
    <input type="submit" value="保存"/>
  </form>
</body>
</html>