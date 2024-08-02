<%@page contentType="text/html;charset=UTF-8" %>
<%--
<%!
   System.out.print();
%>
--%>

<%--<%!%>写入的java会放在类体中,不建议使用，因为在service方法外面写静态变量和实例变量会有线程安全问题
    JSP就是Servlet，Servlet是单例的，多线程并发的环境下，静态变量和实例变量一旦修改会有线程安全问题
--%>
<%!
    private String name = "jackson";
    static {
        System.out.println("静态代码块执行了");
    }

    public static void m1(){
        System.out.println("m1 method execute!");
    }
%>


<%
    System.out.println(i);
%>

<%!
    public static int i = 0;
%>
