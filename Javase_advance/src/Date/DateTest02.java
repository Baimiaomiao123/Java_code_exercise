package Date;
/*
    获取自1970年1月1日 00:00:00 000到当前系统时间的总毫秒数
    简单总结System类的相关属性和方法
    1.System.out [out是System类的静态变量]
    2.System.out.println() [println()方法不是System类的，是PrintStream类的方法]
    3.System.gc() 建议启用垃圾回收器
    4.System.currentTimeMillis() 获取时间戳
    5.System.exit(0) 退出JVM
 */
public class DateTest02 {

    public static void main(String[] args) {
        long nowTimeMillis = System.currentTimeMillis();
        System.out.println(nowTimeMillis);

        //需求：统计一个方法执行所耗费的时间
        //程序开始时间
        long begin = System.currentTimeMillis();
        //程序运行
        print();
        //程序结束时间
        long end = System.currentTimeMillis();
        System.out.println("耗费时长为"+(end - begin)+"毫秒");
        
    }

    public static void print(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("i = " + i);
        }
    }
}
