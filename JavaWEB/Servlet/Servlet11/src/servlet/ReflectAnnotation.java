package servlet;

import jakarta.servlet.annotation.WebServlet;

public class ReflectAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
        //使用反射机制将类上面的注解进行解析
        //获取类Class对象
        Class<?> welcomeServletClass = Class.forName("servlet.WelcomeServlet");

        //获取这个类上面的注解对象
        //先判断这个类上面有没有这个注解对象，如果有，则获取这个注解对象
        //boolean annotationPresent = welcomeServletClass.isAnnotationPresent(WebServlet.class);
        //System.out.println(annotationPresent); //true

        if (welcomeServletClass.isAnnotationPresent(WebServlet.class)) {
            //获取这个类上面的注解对象
            WebServlet annotation = welcomeServletClass.getAnnotation(WebServlet.class);
            //获取注解的value属性
            String[] value = annotation.value();
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]); // /welcome
            }

        }
    }
}
