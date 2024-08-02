package Reflect;

/**
    反射机制：
        1、反射机制有什么用？
            通过java语言中的反射机制可以操作字节码文件
            优点类似于黑客。（可以读和修改字节码文件）
            通过反射机制可以操作代码片段。（class文件）

        2、反射机制的相关类在哪个包下？
            java.lang.reflect.*

        3、反射机制的相关类有哪些？
            java.lang.Class ————代表整个字节码，代表一个类型
            java.lang.reflect.Method  —————代表字节码中的方法字节码，代表类中的方法
            java.lang.reflect.Constructor  ——————代表字节码中的构造方法字节码，代表类中的构造方法
            java.lang.reflect.Field  ——————代表字节码中的属性字节码，代表类中的成员变量（静态变量+实例变量）

            java.lang.Class:
                public class User{
                    //java.lang.reflect.Field
                    int no;

                    //java.lang.reflect.Constructor
                    public User(){

                    }

                    public User(int no){
                        this.no = no;
                    }

                    //java.lang.reflect.Method
                    public void setNo(int no){
                        this.no = no;
                    }

                    public int getNo(){
                        return no;
                    }
                }
        4、关于JDK中自带的类加载器
            4.1、什么是类加载器？
                专门负责加载类的命令/工具
                ClassLoader

            4.2、JDK中自带了3个类加载器
                启动类加载器:rt.jar
                扩展类加载器:ext/*.jar
                应用类加载器:classpath

            4.3、假设有这样一段代码：
                String s = "abc";

                代码在执行之前，会将所需要的类全部加载到JVM当中
                通过类加载器加载，看到以上代码类加载器会找String.class
                文件，找到就加载，那么是怎么进行加载的呢？
                    首先通过"启动类加载器"加载
                        注意：启动类加载器专门加载：Java/jdkx.x.xxx/jre/lib/rt.jar
                        rt.jar中都是JDK最核心的类库

                    如果通过"启动类加载器"加载不到的时候，
                    会通过"扩展类加载器"加载
                        注意：扩展类加载器专门加载：Java/jdkx.x.xxx/jre/lib/ext/*.jar

                    如果"扩展类加载器"没有加载到，那么
                    会通过"应用类加载器"加载
                        注意：应用类加载器专门加载：classpath中的jar包/类（class文件）

            4.4、java中为了保证类加载的安全，使用了双亲委派机制。
                优先从启动类加载器中加载，这个称为"父"
                "父"无法加载到，再从扩展类加载器中加载，
                这个称为"母"。双亲委派，如果都加载不到，
                才会考虑从应用类加载器中加载。直到加载
                到为止。


 */
public class Summary {
}