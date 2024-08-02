package com.baimiaomiao.mybatis.mapper;

import com.baimiaomiao.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface CarMapper {

    /**
     * 获取Car的总记录条数。
     * @return
     */
    Long selectTotal();

    /**
     * 查询所有的Car信息，但是启用了驼峰命名自动映射机制。
     * @return
     */
    List<Car> selectAllByMapUnderscoreToCamelCase();

    /**
     * 查询所有的Car信息，使用resultMap标签进行结果映射
     * @return
     */
    List<Car> selectAllByResultMap();

    /**
     * 查询所有的car，返回一个大map集合
     * map集合的key是每条记录的主键值，value是每条记录
     * @return
     */
    @MapKey("id")
    Map<Long,Map<String,Object>> selectAllRetMap();

    List<Map<String,Object>> selectAllRetListMap();

    /**
     * 根据id获取汽车信息，将汽车信息放到map集合中
     *      其中key是列名，value是值
     * @return
     */
    Map<String,Object> selectByIdRetMap(Long id);

    /**
     * 根据id查询car，这个结果一定是一条，不可能是多条，结果能用List集合接受吗？当然可以
     * @param id
     * @return
     */
    List<Car> selectById2(Long id);

    /**
     * 根据品牌进行模糊查询，模糊查询的结果可能有多个，但是只用一个pojo对象接受有问题吗？
     * @param brand
     * @return
     */
    Car selectByBrandLike(String brand);

    /**
     * 查询所有的Car信息
     * @return
     */
    List<Car> selectAll();

    /**
     * 根据id查询Car信息
     * @param id
     * @return
     */
    Car selectById(Long id);
}
