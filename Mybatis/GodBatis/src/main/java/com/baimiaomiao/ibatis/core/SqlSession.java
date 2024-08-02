package com.baimiaomiao.ibatis.core;


import java.lang.reflect.Method;
import java.sql.*;

/**
 * 专门负责执行SQL语句的会话对象
 * @author baimiaomiao
 * @version 1.0
 * @since 1.0
 */
public class SqlSession {
    private SqlSessionFactory factory;

    public SqlSession(SqlSessionFactory factory) {
        this.factory = factory;
    }

    /**
     * 执行insert语句，向数据库表当中插入记录
     * @param sqlId sql语句中的id
     * @param pojo  插入的数据
     * @return
     */
    public int insert(String sqlId, Object pojo) {
        int count = 0;
        try {
            //JDBC代码，执行insert语句，完成插入操作
            Connection connection = factory.getTransaction().getConnection();
            //拿到sqlMapper中的sql语句
            String godBatisSql = factory.getMappedStatementMap().get(sqlId).getSql();
            //转换成?占位符的sql语句
            String sql = godBatisSql.replaceAll("#\\{[a-zA-Z0-9]*}", "?");
            connection.prepareStatement(sql);
            PreparedStatement ps = connection.prepareStatement(sql);
            //给?占位符传值
            /*
                难度是什么？
                    第一：你不知道有多少个？
                    第二：你不知道将pojo对象中哪个属性赋值给哪个？
             */
            //这里统一写ps.setString(第几个问号，传什么值);所以数据库表中的字段都必须是String类型（比较失败的地方）
            //重点步骤！！！
            int fromIdex = 0;
            int index = 1; //问号的下标
            while (true) {
                int specialCharIndex = godBatisSql.indexOf("#", fromIdex);
                if (specialCharIndex < 0) {
                    break;
                }
                int rightBracketIndex = godBatisSql.indexOf("}", fromIdex);
                String propertyName = godBatisSql.substring(specialCharIndex + 2, rightBracketIndex).trim();
                fromIdex = rightBracketIndex + 1;
                //有属性名id，怎么获取id的属性值呢？调用getId()方法
                String getMethodName = "get" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                Method getMethod = pojo.getClass().getDeclaredMethod(getMethodName);
                Object propertyValue = getMethod.invoke(pojo);
                ps.setString(index, propertyValue.toString());
                index++;
            }
            count = ps.executeUpdate();
        }  catch(Exception e){

            e.printStackTrace();
        }
        return count;
        }

    /**
     * 执行查询语句，返回一个参数，该方法只适合返回一条记录的sql语句
     * @param sqlId
     * @param param
     * @return
     */
    public Object selectOne(String sqlId,Object param){
        Object obj = null;
        try {
            Connection connection = factory.getTransaction().getConnection();
            MappedStatement mappedStatement = factory.getMappedStatementMap().get(sqlId);
            //DQL查询语句
            String godBatisSql = mappedStatement.getSql();
            String sql = godBatisSql.replaceAll("#\\{[a-zA-Z0-9]*}", "?");
            PreparedStatement ps = connection.prepareStatement(sql);
            //给占位符传值（为简洁，假设只有一个值）
            ps.setString(1,param.toString());
            //查询返回结果集
            ResultSet rs = ps.executeQuery();
            //要封装的结果类型
            String resultType = mappedStatement.getResultType();

            //从结果集中取数据（只有一条）
            if(rs.next()){
                //获取resultType的Class
                Class<?> resultTypeClass = Class.forName(resultType);
                //调用无参数构造方法创造对象
                obj = resultTypeClass.newInstance();
                //给对象的属性赋值
                //给哪个属性赋哪个值？
                ResultSetMetaData rsmd= rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    //通过第n列获取第n列的属性名字（例如1->id,2->name,3-age）
                    String propertyName = rsmd.getColumnName(i + 1); //这里第一列应该是1不是0
                    //拼接方法名
                    String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                    //获取set方法
                    Method setMethod = resultTypeClass.getDeclaredMethod(setMethodName, String.class);
                    //调用set方法给对象obj属性赋值
                    setMethod.invoke(obj,rs.getString(propertyName));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return obj;
        }

        /**
         * 回滚事务
         */
        public void rollback () {
            factory.getTransaction().rollback();
        }

        /**
         * 提交事务
         */
        public void commit () {
            factory.getTransaction().commit();
        }


        /**
         * 关闭事务
         */
        public void close () {
            factory.getTransaction().close();
        }

}

