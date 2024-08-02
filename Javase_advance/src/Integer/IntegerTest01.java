package Integer;

/*
    java为8中基本数据类型又对应准备了8种包装类型。8种包装类型属于引用数据类型，父类是Object类
    为什么需要提供8种包装类数据类型呢？
        因为8种基本数据类型不够用
        所以SUN又提供对应的8种包装类型
 */
public class IntegerTest01 {

    //入口
    public static void main(String[] args) {
        //需求：调用doSome()方法需要传一个数字进去
        //但是数字属于基本数据类型，而doSome()方法参数的类型是Object
        //可见doSome()方法无法接收基本数据类型的数字，这就可以传一个数字对应的包装类进去
        //即将基本数据类型包装成对象（类），然后再传入参数
        doSome(new Myint(100));
    }

    public static void doSome(Object obj){
        System.out.println(obj);
    }
}

