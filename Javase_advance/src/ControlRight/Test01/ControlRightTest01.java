package ControlRight.Test01;

/*
    访问控制权限
    1.访问控制权限都有哪些？
        private     私有的
        protected   受保护的
        public      公开
                    默认

    2.控制权限范围？
        private     私有的             只能在本类中使用
        protected   受保护的            只能在本类，同包，子类中访问下访问
        public      公开               在任何位置都可以访问
                    默认               只能在本类，同包下访问
        范围从大到小排序：public>protected>默认>private

    3.访问控制权限修饰符可以修饰？
        属性（4个）
        方法（4个）
        类（public和默认）
        接口（public和默认）
 */
public class ControlRightTest01 {

    public static void main(String[] args) {

        //创建user对象
        User user = new User();
        //访问user对象的属性
//        System.out.println(user.id);  该属性不行，因为id为private，只能在本类中访问
        System.out.println(user.age);
        System.out.println(user.name);
        System.out.println(user.weight);

    }
}
