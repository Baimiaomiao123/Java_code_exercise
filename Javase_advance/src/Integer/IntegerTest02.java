package Integer;
/*
    8种基本数据类型对应的包装类型
    基本数据类型              包装类型
    -------------------------------
    byte                    java.lang.Byte(父类：Number)
    short                   java.lang.Short(父类：Number)
    int                     java.lang.Integer(父类：Number)
    long                    java.lang.Long(父类：Number)
    float                   java.lang.Float(父类：Number)
    double                  java.lang.Double(父类：Number)
    boolean                 java.lang.Boolean(父类：Object)
    char                    java.lang.Character(父类：Object)

    1.八种包装类中，以上以java.lang.Character为代表学习，其他模仿即可

    2.Number类的方法：
        Number是一个抽象类，无法实例化对象
        里面有很多抽象方法，用于拆箱（引用数据类型转换为基本数据类型）
 */
public class IntegerTest02 {

    public static void main(String[] args) {

        //123基本数据类型进行构造方法的包装，使基本数据类型转换引用数据类型
        //即基本数据类型转换为引用数据类型（装箱）
        Integer i = new Integer(123);

        //将引用数据类型转换为基本数据类型（拆箱）
        //xxxValue()方法
        float f = i.floatValue();
        System.out.println(f); //123.0
        int retValue = i.intValue();
        System.out.println(retValue);

    }
}
