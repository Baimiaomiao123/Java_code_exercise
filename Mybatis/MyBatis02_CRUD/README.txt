使用mybatis完成CRUD

1.什么是CRUD？
    C：create增
    R：retrieve查（检索）
    U：update改
    D：Delete删

2.insert
        <insert id="insertCar">
            insert into t_car(id,car_num,brand,guide_price,produce_time,car_type)
            values(null,'1003','丰田霸道',30.00,'2000-10-11','燃油车');
        </insert>

    这样写的问题是？
        值 显然是写死到配置文件中
        这个在实际开发中是不存在的
        一定是前端form表单提交过来数据，然后将值传给sql语句

    例如：JDBC的代码是怎么写的？
        String sql = "insert into t_car(id,car_num,brand,guide_price,produce_time,car_type)
                    values(null,?,?,?,?);"
        ps.setString(1,xxx);
        ps.setString(2,xxx);
        ...

    在JDBC当中占位符采用的是？，在mybatis当中是什么呢？
        和?等效的写法是：#{}
        在mybatis当中不能使用？占位符，必须使用#{}来代替JDBC当中的?
        #{}和JDBC中的?是等效的

    java程序中使用Map可以给SQL语句的站位符传值：
        Map<String,Object> map = new HashMap<>();
        map.put("k1","1111");
        map.put("k2","比亚迪汗");
        map.put("k3",10.00);
        map.put("k4","2020-11-11");
        map.put("k5","新能源");

        int count = sqlSession.insert("insertCar",map);
        注意：#{这里写什么？写map集合的key，如果key不存在，获取的是null}

        一般map集合的key起名的时候需要见名知意

    java程序中使用POJO类给SQL语句传值：
        Car car = new Car(null,"3333","比亚迪秦",30.0,"2022-02-02","燃油车");
        注意：占位符#{}，打括号里面写：pojo类的属性名
            insert into t_car(id,car_num,brand,guide_price,produce_time,car_type)
                        values(#{id},#{carNum},#{brand},#{guidePrice},#{produceTime},#{catType});


        实际上并不是找的属性名，而是找的属性名对应的getXxxx方法
        通过这个测试得出一个结论：
            严格意义上来讲，如果使用POJO对象传递值的话，#{}这个大括号中到底写什么？
                写的是get方法的方法名去掉get，然后将剩下的单词首字母小写，然后放进去
                例如：gerUsername() --> #{username}
                例如：gerEmail() --> #{email}
                ......
        也就是说mybatis在底层给？传值的时候，先要获取值，怎么获取的？
            调用了pojo对象的get方法，例如：car.getCarNum(),car.getCarType(),car.getBrand()....

3.delete
    根据id删除数据

    实现：
        <delete id="deleteById">
            delete from t_car where id = #{id};
        </delete>
        sqlSession.delete("deleteById", 12);
        注意：如果占位符只有一个，那么#{}里面的东西可以随便写，但是最好见名知意

4.update
    根据id修改某条记录

    实现：
        <update id="updateById">
            update t_car set car_num=#{carNum},brand=#{brand},
                guide_price=#{guidePrice},produce_time=#{produceTime},car_type=#{catType} where id = #{id};
        </update>

        Car car = new Car(4L,"9999","凯美瑞",30.3,"2012-02-02","燃油车");
        sqlSession.update("updateById", car);

5.select（查一个，根据主键查询的话，返回的结果一定是一个）
    根据id查找某条记录

    实现：
        <select id="selectById" resultType="com.baimiaomiao.mybatis.bean.Car">
            select * from t_car where id = #{id};
        </select>

    需要特别注意的是：
        select标签中resultType属性，这个属性用来告诉mybatis，查询的结果封装成什么类型
        resultType通常写的是：全限定类名

    Car{id=1, carNum='null', brand='宝马520', guidePrice=null, produceTime='null', catType='null'}
    输出结果优点不对劲：
        id和brand属性有值
        其他属性为null

    carNum以及其他的这几个属性没有赋上值的原因是什么？
        select * from t_car where id = #{id}
        执行结果：
        +----+---------+-----------+-------------+--------------+-----------+
        | id | car_num | brand     | guide_price | produce_time | car_type  |
        +----+---------+-----------+-------------+--------------+-----------+
        |  1 | 1001    | 宝马520    |       10.00 | 2020-10-11   | 燃油车    |
        +----+---------+-----------+-------------+--------------+-----------+
        car_num,guide_price,produce_time,cat_type这是查询结果的列名
        这些列名不能和Car类的属性名对不上。

        那么这个问题怎么解决呢？
           select语句查询的时候，查询结果的列名是可以使用as关键字起别名
                   select
                       id,car_num as carNum,brand,guide_price as guidePrice,
                       produce_time as produceTime,car_type as carType
                   from
                       t_car
                   where
                       id = #{id}

6.select（查所有的）
    <select id="selectAllById" resultType="com.baimiaomiao.mybatis.bean.Car">
        select
            id,car_num as carNum,brand,guide_price as guidePrice,
            produce_time as produceTime,car_type as carType
        from
            t_car
    </select>

    List<Object> cars = sqlSession.selectList("selectAllById");

    注意：resultType还是指定要封装的结果集的类型的不是指定List类型，是指定List集合中元素的类型
    selectList方法：mybatis通过这个方法既可以得知你需要一个List集合，它会自动给你返回一个List集合

7.在sql mapper.xml文件中有个namespace，这个属性是用来指定命名空间的，用来防止id重复
    List<Car> cars = sqlSession.selectList("heimiaomiao.selectAllById"); //UserMapper.xml中namespace为heimiaomiao
    List<Car> cars = sqlSession.selectList("baimiaomiao.selectAllById"); //UserMapper.xml中namespace为baimiaomiao

    其实，之前写的都是不严谨的，为防止id冲突，完整的应该为namespace+id
