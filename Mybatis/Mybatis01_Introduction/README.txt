开发我的第一个Mybatis程序

1.resource目录：
    放在这个目录当中的，一般是资源文件，配置文件。
    直接放到resources目录下的资源，等同于放到了类的根路径下。

2.开发步骤
    第一步：打包方式jar
    第二步：引入依赖
        -mybatis依赖
        -mysql驱动依赖
    第三步：编写mybatis核心配置文件：mybatis-config.xml
        注意：
            第一：这个文件名不是必须叫做mybatis-config，只是大家都采用这个
            第二：这个文件存放的位置也不是固定的，可以随意，但一般情况下，会放到类的根路径下
    第四步：编写XxxMapper.xml文件
        在这个配置文件中编写sql语句
        这个文件名也不是固定的，放的位置也不是固定的，这里给它命名为CarMapper.xml
        暂时放到类的根路径下
    第五步：在mybatis-conifg.xml文件中指定xxxMapper.xml文件的路径
        <mapper resource="CarMapper.xml" />
        注意：resource属性会自动从类的根路径下开始查找资源
    第六步：编写MyBatis程序（使用Mybatis类库，编写mybatis程序，连接到数据库，做增删改查就行）
        在MyBatis负责实行sql语句的对象叫做什么？
            SqlSession
            是一个Java程序和数据库之间的会话

        要想获取SqlSession对象，需要先获取SqlSessionFactory对象，通过sSqlSessionFactory工厂来生产SqlSession对象
        要想获取SqlSessionFactory对象，需要先获取SqlSessionFactoryBuilder对象的build方法来获取SqlSessionFactory对象

        mybatis的核心对象包括：
            SqlSessionFactoryBuilder
            SqlSessionFactory
            SqlSession

            SqlSessionFactoryBuilder --> SqlSessionFactory --> SqlSession
3.从XML中构建SqlSessionFactory
    通过官方的这句话，能想到什么？
        第一：在MyBatis中一定是有一个很重要的对象，这个对象是SqlSessionFactory对象/
        第二：sqlSessionFactory对象的创建需要XML

        XML是什么？
            是一个配置文件

4.mybatis中有两个主要的配置文件：
    其中一个是：mybatis-config.xml，这是核心配置文件。主要配置连接数据库的信息等（一个）
    另一个是：xxxMapper.xml。这个文件专门用来编写SQL语句的配置文件（一个表一个）
        t_user表，一般会对应一个UserMapper.xml
        t_student表，一般会定义一个StudentMapper.xml

5.关于第一个程序的小细节
    *mybatis中sql语句的结尾";"可以省略
    *Resources.getResourceAsStream
        小技巧：以后凡是遇到Resource这个单词，大部分情况，这种加载资源的方法就是从类路径/类的根路径下开始加载(开始查找)
        优点：采用这种方式，从类路径当中加载资源，项目的可移植性很强，项目可以从Mac移植到Linux中，代码不需要修改，因为这个资源文件一直在类路径当中
    *InputStream is = new FileInputStream("电脑中任意绝对路径");
        采用这种方式也可以
        缺点：可移植性太差，程序不够健壮，可能会移植到其他系统操作中导致了路径无效，从而需要改变资源路径，违背了OCP原则
    *mybatis核心配置文件的名字，不一定是:mybatis-config.xml，可以是其他名字
    *mybatis核心配置文件存放的路径，也不一定是类的根路径下，可以放到其他位置。但是为了移植性，最好放到类的根路径下
    *InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        系统类加载器有个方法叫做getResourceAsStream，它是从类的根路径下加载资源
        通过源代码分析发现：
        InputStream is = new FileInputStream底层代码就是它
    *CarMapper.xml文件的名字和路径是固定的吗？不是。
        名字需要在mybatis-config里面的mapper中配置，任意即可
        路径：可以使用根路径，也可以使用绝对路径（不建议，可移植性差），语法模式如下：
            <mapper url="file:///Users/miaopeng/Library/code/java/CarMapper.xml" />

6.关于mybatis的事物管理机制（深度剖析）
    *在mybatis-config.xml中，可以通过以下的配置进行mybatis的事务管理
        <transationcManager type="JDBC"/>
    *type属性的值包括两个
        JDBC(jdbc)
        MANAGER(managed)
        type后面的值，只有以上两个可选，不区分大小写
    *在mybatis中提供了两种事务管理机制：
        第一种：JDBC事务管理器
        第二种：MANAGER事务管理弃
    *JDBC事务管理器：
        mybatis框架自己管理事务，自己采用原声的jdbc代码去管理事务
            conn.setAutoCommit(false);开始事务
            ...业务代码...
            conn.commit(); 手动提交事务

        使用JDBC事务管理器的话，底层创建的事务管理器对象是JdbcTransaction对象。
        如果你编写的代码是下面的代码：
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            true表示没有开启事务，因为这种方法压根不会执行：conn.setAutoCommit(false)；
            在JDBC中如果没有执行conn.setAutoCommit(false)，默认的setAutoCommit就是true，就会自动提交事务
            而如果autoCommit是true，表示没有开启事务，表示只要执行一次DML语句，就会提交一次。
                所以：
                    如果openSession里面没有传参数，默认为false，表示开启事务（setAutoCommit——false），执行多次DML语句都不会提交，当遇到conn.commit()时才会一起提交
                    如果openSession里面有传参数，参数为true，表示不开始事务（setAutoCommit——true），执行一次DML语句就会提交一次

    *MANAGER事务管理器：
        mybatis不在负责事务的管理了。事务管理交给其他容器来负责，例如：spring.

        对于当前的单纯的mybatis的情况下，如果配置为MANAGED
        那么事务这块是没人管理的，事务压根没有开启的

        就是说明

    *JDBC中的事务：
        如果你没有在JDBC代码中执行：conn.setAutoCommit(false);的话，默认为autocommit为true
    *重点：以后注意：只要你的autoCommit是true，代表没有开始事务；只有是false的时候表示开启的false

7.关于mybatis集成日志文件，让我们测试起来更加方便

    *mybatis常见的集成的日志组件有哪些呢？
        SLF4J(沙拉风)
        LOG4J
        LOG4J2
        STDOUT_LOGGING
        ....

    *其中STDOUT_LOGGING是标准日志，mybatis已经实现了这种标准日志，mybatis框架本身已经实现了这种标准
    只要开启即可，怎么开启呢？在mybatis-config.xml文件中使用settings标签进行配置开启
            <settings>
                <setting name="logImpl" value="STDOUT_LOGGING"/>
            </settings>
            这标签应该出现在enviornments标签之前。（dtd文件规定）

    *集成logback日志框架：
        logback日志框架实现了slf4j标准，（沙拉风：日志门面，日志标准）
        第一步：引入logback的依赖
        第二步：引入logback必须的xml文件
            这个配置文件的名字必须叫做：logback.xml或logback-test.xml，不能是其他名字
            这个配置文件必须放到类的根路径下，不能是其他位置
