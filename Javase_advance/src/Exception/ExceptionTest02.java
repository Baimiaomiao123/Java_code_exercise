package Exception;
/*
    java语言中异常是以什么形式存在的呢？
        1.异常在java中以类的形式存在，每一个异常类都可以创建异常对象
        2.异常对应的现实生活中是怎么样的？
            异常类是模版，异常对象是实际个体

 */
public class ExceptionTest02 {

    public static void main(String[] args) {

        //通过"异常类"创建"异常对象"
        NumberFormatException nef = new NumberFormatException("数字格式化异常");
        System.out.println(nef);

        //通过"异常类"创建"异常对象"
        NullPointerException npe = new NullPointerException("空指针异常");
        System.out.println(npe);

    }
}
