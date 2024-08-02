mybatis小技巧
1.#{}和${}的区别

#{}的执行结果：
[main] DEBUG c.b.m.m.CarMapper.selectByCarType - ==>  Preparing: select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType from t_car where car_type = ?
[main] DEBUG c.b.m.m.CarMapper.selectByCarType - ==> Parameters: 新能源(String)
[main] TRACE c.b.m.m.CarMapper.selectByCarType - <==    Columns: id, carNum, brand, guidePrice, produceTime, carType
[main] TRACE c.b.m.m.CarMapper.selectByCarType - <==        Row: 2, 1002, 奔驰E300L, 55.00, 2020-11-11, 新能源
[main] TRACE c.b.m.m.CarMapper.selectByCarType - <==        Row: 18, 1111, 比亚迪汗, 10.00, 2020-11-11, 新能源
[main] TRACE c.b.m.m.CarMapper.selectByCarType - <==        Row: 26, 8054, 凯美瑞, 3.00, 2000-01-10, 新能源
[main] TRACE c.b.m.m.CarMapper.selectByCarType - <==        Row: 43, 8054, 凯美瑞, 3.00, 2000-01-10, 新能源
[main] DEBUG c.b.m.m.CarMapper.selectByCarType - <==      Total: 4

${}的执行结果：
[main] DEBUG c.b.m.m.CarMapper.selectByCarType - ==>  Preparing: select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType from t_car where car_type = 新能源
[main] DEBUG c.b.m.m.CarMapper.selectByCarType - ==> Parameters:

org.apache.ibatis.exceptions.PersistenceException:
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column '新能源' in 'where clause'
### The error may exist in CarMapper.xml
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select             id,             car_num as carNum,             brand,             guide_price as guidePrice,             produce_time as produceTime,             car_type as carType         from             t_car         where             car_type = 新能源
### Cause: java.sql.SQLSyntaxErrorException: Unknown column '新能源' in 'where clause'

#{}和${}的区别：
    #{}：底层使用PrepareStatement，特点是先进行SQL语句的编译，然后给SQL语句的占位符?传值，可以避免SQL注入的风险
    ${}：底层使用Statement，特点是先进行SQL语句的拼接，然后再进行SQL语句进行编译，存在SQL注入的风险
    优先使用#{}，这是原则，避免SQL注入的风险


#{}的执行结果：
Preparing: select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType
            from t_car order by produce_time ?
Parameters: asc(String)

           预编译之后：select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType
                    from t_car order by produce_time 'asc'

${}的执行结果
Preparing: select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType
            from t_car order by produce_time asc
Parameters:
Columns: id, carNum, brand, guidePrice, produceTime, carType

结论：如果需要SQL语句的关键字放到SQL语句中，只能使用${}，因为#{}是以值的形式放到SQL语句中



2.向SQL语句中拼接表名，就需要使用${}
    现实业务中，可能存在分表存储数据的情况，因为一张表存的话，数据量太大，查询的效率就会降低
    可以将这些数据有规律的分表存储，这样在查询的时候效率就比较高。因为扫描的数据量变少了
    日志表：专门存储日志信息的，如果t_log只有一张表，这张表中每一天都会产生很多log，怎么解决这个问题》
        怎么解决问题？
        可以每天生成一个新表，每张表一当天的日期作为名称，例如：
            t_log_20220901
            t_log_20220902
            ......
        你想知道某一天的日志信息怎么办？
            假设想查20220901的日志信息，直接查20220901的表即可


3.批量删除：一次删除多条记录
    批量删除的SQL语句的两种写法：
        第一种or：delete from t_car where id = 1 or id = 2 or id =3;
        第二种int：delete from t_car where id in(1,2,3);

    应该采用${}的方式：
        delete from t_car where id in(${ids});



4.模糊查询：like
    需求：根据汽车品牌进行模糊查询
        select * from t_car where brand like '%奔驰%'
        select * from t_car where brand like '%比亚迪%'
    第一种方式：
        brand like '%${brand}%'
    第二种方式：concat函数，这个是mysql数据库当中的一个函数，专门进行字符串的拼接
        concat('%',#{brand},'%')
    第三种方式：【比较鸡肋】
        brand like concat('%','${brand}','%')
    第四种方式：
        "%"#{brand}"%"


5.关于mybatis的别名机制：
     <!--起别名-->
        <typeAliases>
            <!--
                type：指定给哪个类型起别名
                alias：指定别名（别名不区分大小写）
                alias这个属性是可以省略的，有默认的别名（类的简名，比如com.baimiaomiao.mybatis.pojo.Car -> car/Car/cAr[不区分大小写]）
            -->
            <!--<typeAlias type="com.baimiaomiao.mybatis.pojo.Car" alias="Car" />-->
            <!--<typeAlias type="com.baimiaomiao.mybatis.pojo.Log" alias="Log"/>-->

            <!--更省力的是直接传一个包名，这个包名下的所有类，自动取别名，然后不区分大小写-->
            <package name="com.baimiaomiao.mybatis.pojo"/>
        </typeAliases>


6.mybatis-config.xml文件中的mappers标签
     <mapper url="file:///Users/miaopeng/code/java/...." />
     <mapper class="全限定接口名，带有包名"/>
     <mapper resource="CarMapper.xml"/>

     mapper标签的属性可以有三个：
        resource:这种方式是从类的根路径下开始查找资源，采用这种方式的话，你的配置文件需要放到类路径当中才行
        url:这种方式是一种绝对路径的方式，这种方式不要求配置文件必须放到类路径当中，哪里都行，只要绝对路径写对即可（这种方式使用极少，移植性太差）
        class:这个位置提供的是mapper接口的全限定接口名，必须带有包名
            思考：mapper标签的作用是指定SqlMapper.xml文件的路径。指定接口名有什么用呢？
                <mapper class="com.baimiaomiao.mybatis.mapper.CarMapper"/>
                如果你class指定是：com.baimiaomiao.mybatis.mapper.CarMapper
                那么mybatis框架自动取com/baimiaomiao/mybatis/mapper目录下查找CarMapper.xml文件
            这也就是说：如果采用这种方式，必须保证CarMapper接口必须和CarMapper.xml文件在同一个文件夹下。

