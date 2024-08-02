package JavaDataBasesConnectivitySimulation;

/*
    sqlServer的数据库厂家负责编写JDBC接口的实现类
 */
public class sqlServer implements JDBC{
    @Override
    public void getConnection() {
        //具体这里的代码怎么写，对于我们java程序员来说没关系
        //这段代码涉及到sqlServer底层数据库的实现原理
        System.out.println("连接sqlServer数据库成功！");
    }
}

//实现类被称为驱动。（sqlServer驱动）

//xxx.jar       当中有很多.class，都是对JDBC接口进行的实现