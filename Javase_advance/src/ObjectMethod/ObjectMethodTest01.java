package ObjectMethod;

//总结+toString()方法

/*
    JDK类库的根类：Object
    1.这个老祖宗类中的方法需要先研究一下没因为这些方法都是所有子类通用的，
      任何一个类默认继承Object。就算没有直接继承，最终也会间接继承

    2.Object类当中有哪些常用方法？
      我们去哪里找这些方法？
        第一种：去源代码当中
        第二种：去查阅java的类库的帮助文档

      目前为止，只需要这几个方法即可
        protected Object clone()    负责对象克隆
        int hashCode()              获取对象哈希值
        boolean equals(Object obj)  判断两个对象是否相等
        String toString()           将对象转换成字符串形式
        protected void finalize()   垃圾回收器负责调用方法

    3.toString()方法
        以后所有类的toString()方法是需要重写的
        重写规则，越简单越明了就好

        System.out.println(引用);这里会自动调用引用的toString()方法【即System.out.println().toString()】

        String类是SUN写的，toString方法已经重写了

    4.equals()方法
        以后所有类的equals()方法都需要重写
        因为Object中的equals方法比较的是两个对象的内存地址（而我们应该比较内容，所以需要重写）

        重写规则：根据自身需求，主要是看什么和什么相等时两个对象相等

        基本数据类型比较实用：==
        对象和对象的比较：equals()方法

        String类是SUN编写的，所以String类的equals方法重写了
        所以判断两个字符串是否相等可以，最好不用调用==，而直接调用equals方法
*/

/*
    关于Object的toString方法：
        1.源代码上的toString()方法的默认实现是：
            类名@对象的内存地址转换为十六进制的形式

        2.toString()方法的目的和作用是什么？
            目的/作用：通过调用这个方法，可以将一个java对象转换成字符串表现形式

        3.起始SUN公司开发Java语言的时候，建议所有的子类重写此方法
        toString()方法应该是一个简洁的、详实的、易阅读的

 */
public class ObjectMethodTest01 {

    public static void main(String[] args) {
        Mytime t1 = new Mytime(1970,1,1);
        String s1 =t1.toString();

        //重写toString方法之前
        //ObjectTest.Mytime@5a39699c
        //重写toString方法之后
        //1970年1月1日

        System.out.println(s1);

        //注意：输出引用的时候，会自动调用该引用的toString方法
        System.out.println(t1.toString());
        System.out.println(t1);
    }
}

class Mytime{
    private int year;
    private int month;
    private int day;

    public Mytime(){
    }

    public Mytime(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    //重写toString方法
    public String toString(){
        return this.year + "年" +this.month + "月" + this.day + "日";
    }
}