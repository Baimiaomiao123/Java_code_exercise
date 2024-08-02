package ObjectMethod;

//equals()方法

/*
    关于Object类中的equals方法：
        1.equals方法的源代码
            public boolean equals(Object obj){
                return(this == obj);
            }
            以上这个方法是Object类的默认实现

        2.SUN公司设计equals方法的目的
            以后编程的过程当中，都要通过equals方法判断两个对象是否相等

        3.需要研究一下Object类给的这个默认的equals方法够不够用
            在Object类中的equals方法当中，默认采用的是"=="判断两个java对象是否相等
            而==判断两个java的内存地址是否相等

        4.判断两个java对象是否相等，不能使用"=="，因为"=="比较的是两个对象的内存地址
 */

public class ObjectMethodTest02 {

    public static void main(String[] args) {

        //判断两个基本数据类型是否相等直接使用"=="即可
        int a = 100;
        int b = 100;
        System.out.println(a == b); //==是判断a中保存的值是否和b中保存的值相等,true;

        //判断两个对象是否相等，应该使用equals方法
        Time t1 = new Time(1988,1,1);
        Time t2 = new Time(1988,1,1);
//        System.out.println(t1.equals(t2));   //false;重写之前实际上比较的是t1保存的变量地址和t2保存的变量地址，不能比较t1和t2的内容是否相等

        //重写方法后
        System.out.println(t1.equals(t2)); //true;因为重写之后对比的是两个对象的年月日是否相等
        Time t3 = new Time(1998,1,2);
        System.out.println(t1.equals(t3)); //false

        //程序有bug吗？
        Time t4 = null;
        System.out.println(t1.equals(t4)); //false；没有bug，但是效率低，见后面改良的方法




    }
}

class Time {
    private int year;
    private int month;
    private int day;

    public Time() {
    }

    public Time(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //重写Object类的equals方法
    /*
    @Override
    public boolean equals(Object obj) {
        //判断两个对象当中的年月日是否相等

        //重写第一个日期的年月日
        int year1 = this.year;
        int month1 = this.month;
        int day1 = this.day;

        //重写第二个日期的年月日
        if(obj instanceof Time){
            Time t3 = (Time) obj;
            int year2 = t3.year;
            int month2 = t3.month;
            int day2 = t3.day;

            //两个对比
            if (year1 == year2 && month1 == month2 && day1 == day2){
                return true;
            }
        }
        //程序能够执行到此处表示日期不相等
        return false;
    }

     */


    //改良equals方法
    public boolean equals(Object obj) {
        //判断两个对象当中的年月日是否相等

        //如果obj是一个空指针，则没必要比较了
        if (obj == null){
            return false;
        }

        //如果obj不是一个Time类，没必要比较了
        if (!(obj instanceof Time)){
            return false;
        }

        //如果obj和this保存的内存地址一样，没有必要比较了
        if (this == obj){
            return true;
        }

        //执行到此处说明obj不是null，是Time类型
        //开始转换比较
        Time t = (Time) obj;
        if(t.year == this.year && t.month ==this.month && t.day == this.day){
            return true;
        }

        return false;
    }
}