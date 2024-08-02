package com.baimiaomiao.javassist.test;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class JavassistTest {

    @Test
    public void testGenerateAccountDaoImpl() throws Exception {
        //获取类池
        ClassPool pool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = pool.makeClass("com.baimiaomiao.bank.dao.impl.AccountDaoImpl");
        //制造接口
        CtClass ctInterface = pool.makeInterface("com.baimiaomiao.javassist.test.AccountDaoTest");
        //实现接口
        ctClass.addInterface(ctInterface);
        //实现接口中所有的方法
        //获取接口中所有的方法
        Method[] methods = AccountDaoTest.class.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            //method是接口中的抽象方法
            //把method抽象方法给实现了
            try {
                //public void delete(){System.out.println("delete!")};
                //public int update(String actno,Double balance){};
                StringBuilder methodCode = new StringBuilder();
                methodCode.append("public "); //追加修饰符列表
                methodCode.append(method.getReturnType().getName()); //追加返回值类型
                methodCode.append(" ");
                methodCode.append(method.getName()); //追加方法名
                methodCode.append("(");
                //拼接参数
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    methodCode.append(parameterType.getName());
                    methodCode.append(" ");
                    methodCode.append("args" + i);
                    if (i != parameterTypes.length - 1) {
                        methodCode.append(",");
                    }
                }
                methodCode.append("){System.out.println(11111);");
                //动态添加return语句
                String returnTypeSimpleName = method.getReturnType().getSimpleName();
                if ("void".equals(returnTypeSimpleName)) {
                    
                } else if ("int".equals(returnTypeSimpleName)) {
                    methodCode.append(" return 1;");
                } else if ("String".equals(returnTypeSimpleName)){
                    methodCode.append(" return \"hello\";");
                }
                methodCode.append("}");
                System.out.println(methodCode);
                CtMethod ctMethod = CtMethod.make(methodCode.toString(),ctClass);
                ctClass.addMethod(ctMethod);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        //在内存中生成class，加载到JVM中
        Class<?> clazz = ctClass.toClass();
        //创建对象
        AccountDaoTest accountDaoTest = (AccountDaoTest) clazz.newInstance();
        //调用方法
        accountDaoTest.insert("aaaa");
        accountDaoTest.delete();
        accountDaoTest.update("aaaa",1000.0);
        accountDaoTest.selectByActno("aaaa");

    }

    @Test
    public void testGenerateImpl() throws Exception {
        //获取类池
        ClassPool pool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = pool.makeClass("com.baimiaomiao.bank.dao.impl.AccountDaoImpl");
        //制造接口
        CtClass ctInterface = pool.makeInterface("com.baimiaomiao.javassist.test.AccountDaoTest");
        //添加接口到类中
        ctClass.addInterface(ctInterface);
        //实现接口中的方法
        //制造方法并将方法添加到类中
        String methodCode = "public void delete(){System.out.println(\"delete!\");}";
        CtMethod ctMethod = CtMethod.make(methodCode,ctClass);
        //将方法添加到类中
        ctClass.addMethod(ctMethod);
        //在内存中生成类，同时将生成的类加载到JVM中
        Class<?> clazz = ctClass.toClass();
        AccountDaoTest accountDaoTest = (AccountDaoTest) clazz.newInstance();
        accountDaoTest.delete();
    }

    @Test
    public void testGenerateFirstClass() throws Exception {
        //获取类池，这个类池就是用来生成class的
        ClassPool pool = ClassPool.getDefault();
        //制造类（需要告诉javassist类名是啥）
        CtClass ctClass = pool.makeClass("com.baimiaomiao.bank.dao.impl.AccountDaoImpl");
        //制造方法
        String methodCode = "public void insert(){System.out.println(123);}";
        CtMethod ctMethod = CtMethod.make(methodCode, ctClass);
        //将方法添加到类中
        ctClass.addMethod(ctMethod);


        //在内存中生成Class
        ctClass.toClass();
        //类加载到JVM中（AccountDaoImpl类的字节码）
        Class<?> clazz = Class.forName("com.baimiaomiao.bank.dao.impl.AccountDaoImpl");
        //创建对象
        Object obj = clazz.newInstance();
        //获取AccountDaoImpl中的insert方法
        Method insert = clazz.getDeclaredMethod("insert");
        //调用方法
        insert.invoke(obj);
    }
}
