package Package;
/*
    封装的步骤：
    1.所有属性私有化，使用private关键字进行修饰
    2.对外提供简单的操作入口
        对外提供两个公开的方法，分别是set方法和get方法
        想修改age属性，调用set方法
        想读取age属性，调用get方法
    3.get和set方法的命名规范
        public void set/get+属性名首字母大写（形参）{
        }

 */
public class UserTest {
    public static void main(String[] args) {
        //创建user对象
        User user = new User();

        //修改
        user.setAge(-1);
        user.setAge(100);

        //读取
        System.out.println(user.getAge());

    }
}
