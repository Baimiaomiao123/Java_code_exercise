package ObjectMethod;

/*
    finalize()方法
        1.这个方法是protected修饰，在Object类中这个方法的源代码是
            protected vod finalize() throws Throwable{ }


        2.finalize()方法只有一个方法体，里面没有代码，而且这个方法是protected修饰的

        3.这个方法不需要程序员手动调用，JVM的垃圾回收器负责调用
          不像equals，toString方法需要写代码进行调用
          finalize（）只需要重写，重写完自动会有程序来调用

        4.finalize()方法的执行时机：
            当一个java对象即将被垃圾回收器回收的时候，垃圾回收器负责调用

        5.finalize()方法实际上是SUN公司为java程序员准备的一个时机，垃圾销毁时期
          如果希望在对象销毁时机执行一段代码的话，这段代码要写到finalize()方法当中

        6.静态代码块：
          static {
            ...
          }

          静态代码块在类加载时刻执行，并且只执行一次，这是一个SUN准备的类加载时机

          finalize()方法同样也为程序员准备的一个时机，即垃圾回收时机

        7.作用：记录对象被释放的时间点

        8.JDK9及以上已被遗弃

 */

public class ObjectMethodTest06 {

    public static void main(String[] args) {

        /*

        //创建对象
        Person p = new Person();
        p = null;

         */

        //因为已被遗弃，不会轻易启动垃圾回收器
        //多造一点垃圾,就可以运行
        for (int i = 0; i < 10000000; i++) {
            Person p = new Person();
            p = null;
        }


    }
}

class Person {

    //重写finalize()方法
    //Person类型的对象被垃圾回收器回收的时候，垃圾回收器负责调用：p.finalize();
    //finalize()方法在java8以上已经被删除
    /*
    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + "即将被销毁");
    }
     */
}
