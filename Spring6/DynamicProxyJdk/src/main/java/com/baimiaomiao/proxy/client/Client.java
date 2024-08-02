package com.baimiaomiao.proxy.client;

import com.baimiaomiao.proxy.service.OrderService;
import com.baimiaomiao.proxy.service.OrderServiceImpl;
import com.baimiaomiao.proxy.service.TimerInvocationHandler;
import com.baimiaomiao.proxy.util.ProxyUtil;

import java.lang.reflect.Proxy;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Client
 * @since 1.0
 */


public class Client {
    //客户端程序
    public static void main(String[] args) {
        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理对象
        /*
            1.newProxyInstance()翻译为：新建代理对象
                也就是说通过调用这个方法可以创建代理对象
                本质上，这个方法的执行做了两件事：
                    第一件事：在内存中生成类一个代理类的字节码class
                    第二件事：new对象了。通过内存中生成的代理类这个代码，实例化了代理对象
            2.关于newProxyInstance()放啊的三个重要参数，每一个什么含义？有什么用？
                第一个参数：ClassLoader loader
                    类加载器。有什么用呢？
                        在内存当中生成的字节码也是class文件，要执行也得先加载到内存当中。加载类就需要类加载器，所以这里需要指定类加载器
                        并且JDK要求：目标类的类加载器必须和代理类的类加载器使用同一个

                第二个参数：Class<?>... interfaces
                    代理类和目标类实现同一个或同一些接口
                    在内存中生成代理类的时候，这个代理类是需要你告诉它实现哪些接口的

                第三个参数：InvocationHandler h
                    InvocationHandler 被翻译为：调用处理器。是一个接口
                    在调用处理器接口中编写的就是：增强代码
                    因为具体要增强什么代码，JDK动态代理技术它是猜不到的，没有那么神
                    既然是接口，就要写接口的实现类

                    自己还要动手写调用处理器接口的实现类，这个不会类爆炸吗？
                    因为这种调用处理器写一次就好。

                注意：代理对象实现的接口和目标对象一样，所以可以向下转型

         */

        /*OrderService proxyObject = (OrderService)Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                                    target.getClass().getInterfaces(),
                                                    new TimerInvocationHandler(target));*/

        //上面代码可以通过工具类封装，简洁代码
        OrderService proxyObject = (OrderService) ProxyUtil.newProxyInstance(target);

        //调用代理对象的代理方法
        //注意：调用代理对象的代理方法的时候，如果你要做增强的话，目标对象的目标方法得保证执行
        proxyObject.generate();
        proxyObject.modify();
        proxyObject.detail();
        String name =  proxyObject.getName();
        System.out.println(name);
    }
}
