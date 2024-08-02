package Reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
    研究一下文件路径的问题。
    怎么获取一个文件的绝对路径，以下讲解的这种方式是通用的。但前提是：文件需要在类路径下，才能用这种方式
 */
public class AboutPath {
    public static void main(String[] args) {

        //这种方式的缺点是：移植性差，在IDEA默认的当前路径是Project的根
        //这个代码假设离开了IDEA，换到了其他位置，可能当前路径就不是Project的根了，这时这个路径就无效了
        /*
        try {
            FileReader reader = new FileReader("javase_advance/src/Reflect/classinfo.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         */

        //接下来说一种比较通用的路径。即使代码换位置了，这样编写仍然是通用的
        //注意：使用以下这个通用方式的前提是：这个文件必须在类路径下
        //什么是类路径下？ 凡是在src下的都是类路径下。【记住它】
        //src是类的根路径
        /*
            解释：
                Thread.currentThread() 当前线程对象
                getContextClassLoader() 是线程对象的方法，可以获取到当前线程的类加载器对象
                getResource()【获取资源】 这是类加载器的对象的方法，当前线程的类加载器默认从类的根路径下加载资源(/src)

         */
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("Reflect/classinfo.properties").getPath(); //一定注意，从类的根路径下开始
        System.out.println(path);
    }
}
