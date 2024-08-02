package Exception;
/*
    1.异常的继承结构是怎么样的？
        可以用UML图来描述以下继承结构
        画UML图有很多工具：如Rational Rose，StarUML

    2.什么是UML？有什么用？
        是一种统一建模语言，一种图标式语言（画图的）
        UML不是只有java中使用，只要是面向对象的编程语言，都有UML
        一般使用UML图的都是软件架构师或者系统分析师
        在UML图中可以描述类和类之间的关系，程序执行的流程，对象的状态等
        java软件开发当中，需要实现类看懂UML图

    3.Error的继承关系
        Object下有Throwable（可抛出的）
        Throwable下有两个分支：Error（不可处理，直接退出JVM）和Exception（可处理的）
        Exception下有两个分支
            Exception的直接子类：编译时异常。要求程序员在编写程序阶段，预先对这些异常进行处理，否则就要报错
            RuntimeException：运行时异常。在编写程序阶段可以不处理

    4.编译时异常和运行时异常，都是发生在运行阶段。编译阶段异常是不会发生的
        编译时异常因为什么而得名？
            因为编译时异常必须在编译阶段预先处理，如果不处理编译器就会报错，因此得名
            所有异常都是在运行阶段发生的，因为只有程序运行阶段才可以new对象
            因为异常的发生就是new对象

    5.编译异常（也称为受检异常【CheckException】/受控异常）发生概率高，运行异常（也被称为未受检异常【UnCheckException】/非受控异常）发生概率低
        对于一些发生概率较高的异常，需要在运行之前对其进行预处理
        对于一些发生概率较低的异常，不需要对其进行预处理，很多时候都是无效功
        假设java中没有对异常进行划分，没有分为：编译时异常和运行时异常，所有的异常都需要在编写程序阶段对其进行预处理，将是怎么样的效果？
            程序绝对安全，但是代码太冗长

    6.java中对异常的处理包括两种方式
        第一种：在方法声明的位置上，使用throws关键字进行异常上抛
        第二种：使用try..catch语句进行异常捕捉
        异常发生之后，如果抛给了上级，抛给了我的调用者，调用者需要对这个异常继续处理，那么调用者处理这个异常同样有两种处理方式
            第一种：异常上抛
            第二种：异常捕捉
    7.java中异常发生之后一直上抛，最终抛给力main方法，main方法抛给JVM，JVM检测到后直接终止程序

 */
public class ExceptionTest03 {

    public static void main(String[] args) {

        //java.lang.ArithmeticException这个异常抛给了main方法，main方法有抛给了JVM
        //JVM处理不了，直接终止程序
        System.out.println(100 / 0);
        System.out.println("Hello World");
    }

}
