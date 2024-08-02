<%@ page contentType="text/html;charset=UTF-8"%>
<%-- <%%>为java脚本块，往里面写的东西会往jsp中的service添加，会被翻译成java代码 --%>
<%
    System.out.println("hello jsp");
%>

<%--JSP的专业注释，不会被翻译到java源代码中-->
<!--HTML的注释，这个注释不专业，仍然会被翻译到java源代码当中，在jsp中不要使用这种注释-->
<%--
    private int i; //报错原因：不符合java语法，因为service方法里不能使用private等访问权限修饰符修饰
--%>

<%--方法体中不能直接编写静态代码块，也不能直接写方法【因为方法不能套方法】--%>
<%--
    static {
        System.out.println("静态代码块执行");
    }
--%>

<%--
    public static void m(){
        System.out.println("m method execute!");
    }
--%>