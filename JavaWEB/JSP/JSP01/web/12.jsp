<%@ page import="bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String[] usernames = {"zhangsan","lisi","wangwu"};
  //向域中存储数据
  request.setAttribute("usernameArray",usernames);


  User user1 = new User();
  User user2 = new User();
  user1.setUsername("admin");
  user2.setUsername("zhaoliu");
  User[] users = {user1,user2};
  request.setAttribute("userArray",users);


  List<String> list = new ArrayList<>();
  list.add("abc");
  list.add("def");
  request.setAttribute("myList",list);

  Set<String> set = new HashSet<>();
  set.add("a");
  set.add("b");
  request.setAttribute("set",set);
%>

<%--使用EL表达式取出数组中的元素--%>
${usernameArray[0]} <br>
${usernameArray[1]} <br>
${usernameArray[2]} <br>

<%--数组的下标越界，取不出数据，在浏览器直接显示空白。不会出现数组下标越界--%>
${usernameArray[3]} <br>

${userArray[0].username} <br>
${userArray[1].username} <br>

<hr>

<%--取出List集合。list集合也是通过下标取数据--%>
${myList[0]} <br>
${myList[1]} <br>

<hr>
set集合：${set}
<%--无法获取：${set[0]}--%>

