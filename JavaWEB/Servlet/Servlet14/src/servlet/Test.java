package servlet;

/*
    以下代码就类似于过滤器的结构
        这个程序的问题：
            在编译阶段已经完全确定了调用关系。
            如果你想改变他们的调用顺序，必须修改以下java代码
            java代码需要重新编译、测试、发布，这是一个繁琐的工程，显然这种设计违背了OCP原则（开闭原则）——对扩展开放，对修改关闭

 */
public class Test {
    public static void main(String[] args) {
        System.out.println("main begin");
        m1();
        System.out.println("main over");
    }

    private static void m1(){
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 end");
    }

    private static void m2(){
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 end");
    }

    private static void m3(){
        System.out.println("m3 method execute!");
    }
}
