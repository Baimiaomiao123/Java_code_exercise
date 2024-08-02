package Array;
/*
    main方法上面的"String[] args"有什么用？
        分析以下：谁负责调用main方法（JVM）
        JVM调用main方法的时候，会自动传String数组
 */
public class ArrayTest04 {

    public static void main(String[] args) {
        //JVM默认传递过来的这个对象长度——默认为0
        //通过测试得出args不是null，表示数组对象创建了，但是数组中没有任何数据
        System.out.println("JVM给传递出来的String数组参数，长度："+ args.length);

        //而通过修改RUN中eidt configuration的Program arguments即可修改
        //遍历数组（已修改）
        for (int i = 0; i <args.length ; i++) {
            System.out.println(args[i]);

        }
    }
}
