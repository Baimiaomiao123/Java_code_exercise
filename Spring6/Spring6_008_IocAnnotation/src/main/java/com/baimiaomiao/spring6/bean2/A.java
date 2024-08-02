package com.baimiaomiao.spring6.bean2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className A
 * @since 1.0
 */

@Component
public class A {
    public A(){
        System.out.println("A的无参数构造方法执行......");
    }
}

@Controller
class B{
    public B(){
        System.out.println("B的无参数构造方法执行......");
    }
}

@Service
class C{
    public C(){
        System.out.println("C的无参数构造方法执行......");
    }
}

@Repository
class D{
    public D(){
        System.out.println("D的无参数构造方法执行......");
    }
}

@Controller
class E{
    public E(){
        System.out.println("E的无参数构造方法执行......");
    }
}
