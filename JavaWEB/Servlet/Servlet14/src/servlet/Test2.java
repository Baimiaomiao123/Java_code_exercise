package servlet;

public class Test2 {
    //静态代码块，在类加载时执行，并且只执行一次
    //这个语法很简单，静态代码块有什么用？这是困扰大家的一个问题
    //静态代码块用的实际不多，但偶尔需要用以下，什么时候用呢？
    //要看具体的需求，是否需要在类加载时机取执行一段代码。如果有需求，就可以把这个代码写入静态代码块，到时候自然就执行了
    //静态代码块就是java语言为java程序员预留的一个特殊的时机。这个时机叫做：类加载时机
    static {
        System.out.println("class loading...");
    }

    //entrance
    public static void main(String[] args) {

    }
}
