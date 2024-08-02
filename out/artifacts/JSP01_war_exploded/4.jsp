<%@ page contentType="text/html;charset=UTF-8" %>


<%
  String name = "jack";

  //输出name到控制台
  System.out.println(name);

  ////输出name到浏览器
  //可以直接在符号中使用out对象吗
  //可以
  //out对象是JSP九大内置对象之一，可以直接拿来用，当让必须只能在service方法内
  out.write(name);
  out.write("<br>");
  //输出java变量，使用内置变量对象out
  int i = 100;
  out.print(i);
  out.write("<br>");
%>

<%--如果想要输出普通字符串，直接在外面写就行，没必要往java代码块中写--%>
zhangsan<br>
lisi<br>
wangwu<br>
<%--
  如果输出的内容里含有java代码
  这个时候可以使用以下的语法机制：
    <%=%> 注意：在=的后面编写要输出的内容
    最终翻译成java代码：out.print();
    注意：里面不能加分号
--%>
<%= 100 + 200%><br>  <%--out.print(100 + 200);--%>

<%="hello world"%><br> <%--out.print("hello world");--%>
hello world <%--out.write("hello world");--%>



<%
  int a = 100;
  int b = 200;
  int c = a + b;
%>
<%=c%>

<%
  String username = "rose";
%>
<%="登陆成功，欢迎" + username%>

<%--
  JSP基础语法总结：
    JSP中直接编写普通字符串
      翻译到service方法的out.write("这里");
    <% %>
      翻译到service方法体的内部，里面是一条一条的java语句
    <%! %>
      翻译到service方法之外（类体中）
    <%= %>
      翻译到service方法的内部，翻译为：out.print();
    <%@page contentType="text/html;charset=UTF-8"%>
      page指令，通过contentType属性用来设置响应的内容类型
--%>