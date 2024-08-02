package Set.Collection;
/*
    JDK5.0之后推出了一个新特性：增强for循环
 */
public class ForEachTest01 {
    public static void main(String[] args) {

        //int类型数组
        int[] arr = {1432,345,62,768};

        System.out.println("===========普通for循环===========");
        //遍历数组(普通for循环)
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //增强for循环
        /*
            语法机制：
                for(元素类型 变量名 : 数组或集合){
                    System.out.println(变量名)
                }
         */

        //foreach有一个缺点：没有下标，在需要使用下标的循环中，不建议使用foreach循环
        System.out.println("=========增强for循环==========");
        for(int data : arr){
            System.out.println(data);
        }
    }
}
