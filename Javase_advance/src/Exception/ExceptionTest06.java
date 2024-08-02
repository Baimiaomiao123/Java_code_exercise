package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    处理异常的第一种方法：
        在方法声明的位置上使用throws关键字抛出，谁调用这个方法，就抛给谁，抛给调用者处理
        这种处理异常的态度：上报
    处理异常的第二种方法：
        直接使用Try..catch方法，直接
        这个异常不会上报，自己把这个异常处理了
        异常抛到此处不再网上抛了

    注意：
        只要异常没有捕捉，采用上报的方式，此方法的后续代码不会执行
        另外需要注意，try..catch捕捉后，此方法的后续代码会执行

    以后的开发中，处理编译时异常，应该上报还是捕捉？
        如果希望调用者处理，选择throws上报
        其他情况使用try..catch

 */
public class ExceptionTest06 {

    public static void main(String[] args) { //选其一
        System.out.println("main begin!");
        //一般不建议在main方法上使用throws，因为如果发生异常就会上报给JVM，知道导致程序终止
        //所以一般在main方法中使用try。catch方法
        try {
            m1();
        }catch (Exception e){
            System.out.println("文件找不到，可能被删除了");
        }
        System.out.println("main over!");
    }

    private static void m1() throws FileNotFoundException,IOException { //选其一
        System.out.println("m1 begin!");
        //同理
        m2();
        System.out.println("mi over!");
    }

    private static void m2() throws FileNotFoundException,IOException { //选其一，抛出的异常必须大于或等于其异常继承等级
        System.out.println("m2 begin!");
        //由于m3方法声明上有FileNotFoundException
        //m2如果不进行异常捕捉，那么就会传递给m2也会有FileNotFoundException，就需要进行异常上抛如IOException甚至Exception（其中包括了FileNotFoundException）
        m3();
        System.out.println("m2 over!");
    }

    private static void m3() throws FileNotFoundException {
        //调用SUN jdk中某个类的构造方法
        //这个类还没有接触过，后期IO流的时候就知道了
        //只是借助这个类学习异常处理
        //创建一个输入流对象，该流指向一个文件
        /*编译的时候报错的原因：
            第一：这里调用了一个构造方法：FileInputStream(String name)
            第二：这个构造方法的声明位置上有throws FileNotFoundException
            第三：通过这个类FileNotFoundException的结构关系可以看到，其父类是IOException，上一级的父类是Exception
            最终得知：FileNotFoundException是编译时异常

            错误原因：编译时异常需要程序员编写程序阶段必须对它进行处理，不处理的话编译器就会报错
            解决方法：在方法声明阶段进行异常上抛，添加throws FileInputStreams
         */
        new FileInputStream("//Users/miaopeng/code/java/code_exercise/javase_advance/src/Exception/ExceptionTest.txt");

    }
}
