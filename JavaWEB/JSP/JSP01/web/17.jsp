<%@page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Student" %>
<%@ page import="java.util.List" %>
<%--
    JSTL标签库：
        1、什么是JSTL标签库？
            Java Standard Tag Lib（java标准的标签库）
            JSTL标签库通常结合EL表达式一起使用。目的是让JSP中的java代码消失
            标签是写在JSP当中的，但实际上最终还是要执行对应的java程序（java程序在jar包当中）
        2、使用JSTL标签库的步骤
            第一步：引入JSTL标签库对应的jar包
                jakarta.servlet.jsp.jstl
                taglibs-standard-impl
                taglibs-standard-spec
                在IDEA中怎么引入？
                    在WEB-INF下面新建lib目录，然后将jar包拷贝到lib当中，然后将其"Add Lib.."
                    一定是要和mysql的数据驱动一样，都是放在WEB-INF/lib目录下
                    什么时候需要将jar放到WEB-INF/lib目录下？如果这个jar包在Tomcat中没有的
            第二步：在JSP中引入需要使用标签库。（使用taglibtaglibs-standard-compat-1.2.5.jar指令引入标签库）
                JSTL提供了很多种标签，你要引入哪个标签？？？<%@taglib prefix="" url=""%>
            第三步：在需要使用标签的位置使用即可。表面使用的是标签，实际上还是java程序
     JSTL的原理：
        uri后面的路径实际上指向了一个xxx.tld文件。
        tld文件实际上是一个xml配置文件。
        在tld文件中描述了"标签"和"java类"之间的关系、
        以上核心标签库对应的tld文件是：c.tld文件。
--%>

<%--引入标签库，这里引入的是核心标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--格式化标签库，专门负责格式化操作的--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--sql标签库--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%
    //创建List集合
    List<Student> stuList = new ArrayList<>();

    //创建Student对象
    Student s1 = new Student("110","王五");
    Student s2 = new Student("110","张三");
    Student s3 = new Student("110","李四");

    //添加到List集合
    stuList.add(s1);
    stuList.add(s2);
    stuList.add(s3);

    //将List集合存储到request域当中
    request.setAttribute("stuList",stuList);
%>
<%--需求：将List集合中的元素遍历。输出学生信息到浏览器--%>
<%--使用java代码--%>

<%
    //从域中获取List集合
    List<Student> stus = (List<Student>)request.getAttribute("stuList");

    //编写for循环遍历List集合
    for (Student stu:
    stus) {
%>
    id:<%=stu.getId()%>,name:<%=stu.getName()%>
<%
    }
%>

<hr>

<%--使用core标签集中的forEach标签，对List集合进行遍历--%>
<%--EL表达式只能从域中取数据--%>
<%--var后面的名字是随意的，var属性代表的是集合中的每一个元素--%>
<c:forEach items="${stuList}" var="s">
    id:${s.id},name:${s.name} <br>
</c:forEach>

