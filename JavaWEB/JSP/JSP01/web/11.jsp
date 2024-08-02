<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Map<String,String> map = new HashMap<>();
  map.put("username","zhangsan");
  map.put("password","123");


  //将Map集合存储到request域当中
  request.setAttribute("userMap",map);

  Map<String,User> userMap2 = new HashMap<>();
  User user = new User();
  user.setUsername("zhangsan");
  userMap2.put("user",user);

  request.setAttribute("userMap2",userMap2);

%>

<%--使用EL表达式，将map中的数据取出，并输出到浏览器--%>
${userMap.username} <br>
${userMap.password} <br>
${userMap["username"]} <br>
${userMap["password"]} <br>

<%--使用EL表达式将Map集合中的user对象中的username取出来--%>
${userMap2.user.username} <br>
