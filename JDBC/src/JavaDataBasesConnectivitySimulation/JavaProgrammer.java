package JavaDataBasesConnectivitySimulation;

import java.util.ResourceBundle;

/*
    java程序员角色
    不需要关心具体是哪个品牌的数据库，只需要面向JDBC接口写代码
    面向接口编程，面向抽象编程，不要面向具体编程
 */
public class JavaProgrammer {
    public static void main(String[] args) throws Exception {
//        JDBC mySQL = new MySQL();
//        mySQL.getConnection();

        JDBC Oracle = new Oracle();
        Oracle.getConnection();

        JDBC sqlServer = new sqlServer();
        sqlServer.getConnection();


        //创建对象可以通过反射机制
        ResourceBundle bundle = ResourceBundle.getBundle("JavaDataBasesConnectivitySimulation/JDBC");
        String className = bundle.getString("db");
        System.out.println(className);

        Class c = Class.forName(className);
        //JDBC是MySQL的父类，所以可以强转
        JDBC jdbc = (JDBC) c.newInstance();
        jdbc.getConnection();



    }
}
