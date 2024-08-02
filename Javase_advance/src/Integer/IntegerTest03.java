package Integer;
/*
    八种包装类的构造方法
 */
public class IntegerTest03 {

    public static void main(String[] args) {

        //java9后不建议使用该构造方法，已过时（直接用自动装箱或自动拆箱机制）
        //int ----> Integer
        Integer x = new Integer(100);
        System.out.println(x); //100

        //String ----> Integer
        Integer y = new Integer("123");
        System.out.println(y); //123

        //int ----> Double
        Double d = new Double(123);
        System.out.println(d); //123.0

        //String ----> Double
        Double e = new Double("123");
        System.out.println(e); //123.0

    }
}
