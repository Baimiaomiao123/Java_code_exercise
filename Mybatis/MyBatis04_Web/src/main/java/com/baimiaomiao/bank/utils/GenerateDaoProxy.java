package com.baimiaomiao.bank.utils;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 工具类：可以动态生成DAO的实现类。（或者说可以动态生成DAO的代理类）
 * @author baimiaomiao
 * @version 1.0
 * @since 1.0
 */
public class GenerateDaoProxy {

    /**
     * 生成dao接口实现类，并且将实现类的对象创建出来并返回。
     * @param daoInterface dao接口
     * @return dao接口实现类的实例化对象
     */
    public static Object generate(SqlSession sqlSession, Class daoInterface){ //GenerateDaoProxy是mybatis框架开发者写的。
        //类池
        ClassPool classPool = ClassPool.getDefault();
        //制造类(com.baimiaomiao.bank.dao.AccountDao -> com.baimiaomiao.bank.dao.AccountDaoProxy)
        CtClass ctClass = classPool.makeClass(daoInterface + "Proxy"); //实际就是在内存中生成一个代理类
        //制造接口
        CtClass ctInterface = classPool.makeInterface(daoInterface.getName());
        //实现接口
        ctClass.addInterface(ctInterface);
        //实现接口中所有的方法
        Method[] methods = daoInterface.getDeclaredMethods();
        Arrays.stream(methods).forEach(method ->{
            //method是抽象方法
            //将method这个抽象方法进行实现
            try {
                StringBuilder methodCode = new StringBuilder();
                methodCode.append("public ");
                methodCode.append(method.getReturnType().getName());
                methodCode.append(" ");
                methodCode.append(method.getName());
                methodCode.append("(");
                //方法的形式参数列表
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    methodCode.append(parameterType.getName());
                    methodCode.append(" ");
                    methodCode.append("arg" + i);
                    if (i != parameterTypes.length - 1) {
                        methodCode.append(",");
                    }
                }
                methodCode.append(")");
                methodCode.append("{");
                //方法体中的代码
                methodCode.append("org.apache.ibatis.session.SqlSession sqlSession = com.baimiaomiao.bank.utils.SqlSessionUtil.openSession();");
                //需要知道是什么类型的sql语句
                //sql语句的id是框架使用者提供的，具有多变性，对于我框架的开发人员来说，我不知道
                //既然我框架开发者不知道sqlId，怎么办呢？mybatis框架者开发者于是就出台了一个规定：凡是使用GenerateDaoProxy机制的
                //sqlId都不能随便写，namespace必须是dao接口的全限定名称。id必须是dao接口中方法名
                String sqlId = daoInterface.getName() + "." + method.getName(); //规定！！！
                SqlCommandType sqlCommandType = sqlSession.getConfiguration().getMappedStatement(sqlId).getSqlCommandType();
                if (sqlCommandType == SqlCommandType.INSERT) {

                }
                if (sqlCommandType == SqlCommandType.DELETE) {

                }
                if (sqlCommandType == SqlCommandType.UPDATE) {
                    methodCode.append("return sqlSession.update(\"" + sqlId + "\", arg0);");
                }
                if (sqlCommandType == SqlCommandType.SELECT) {
                    methodCode.append("return (" + method.getReturnType().getName() + ")sqlSession.selectOne(\"" + sqlId + "\", arg0);");
                }


                methodCode.append("};");
                CtMethod ctMethod = CtMethod.make(methodCode.toString(), ctClass);
                ctClass.addMethod(ctMethod);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });


        //创建对象
        Object obj = null;
        try {
            Class<?> clazz = ctClass.toClass();
            obj = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
