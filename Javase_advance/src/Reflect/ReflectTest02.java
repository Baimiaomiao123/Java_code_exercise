package Reflect;

/*
    获取到Class，都干什么？
        通过Class的newInstance()来实例化对象
        注意：newInstance()方法内部实际上调用了无参数构造方法，必须保证无参构构造存在才可以。
 */
public class ReflectTest02 {
    public static void main(String[] args) {

        // 这是不使用反射机制，创建对象
        User user = new User();
        System.out.println(user);

        //下面这段代码是以反射机制的方式创建对象
        try {
            //通过反射机制，获取Class，通过Class来实例化对象
            Class c = Class.forName("Reflect.User");

            //newInstance() 这个方法会调用User这个类的无参数构造方法，完成对象的创建
            //重点：newInstance()调用的是无参构造，必须保证无参构造的存在
            Object obj = c.newInstance();

            System.out.println(obj); //Reflect.User@28a418fc
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
