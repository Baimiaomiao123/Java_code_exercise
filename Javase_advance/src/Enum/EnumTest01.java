package Enum;
/*
    分析以下程序，在设计方面有什么缺陷？
        以下代码可以编译，也可以运行
        设计缺陷就在返回值类型上，返回一个int不恰当
        既然最后的结果只是成功和失败，最好使用boolean类型，刚好反应正确和错误的状态
 */
public class EnumTest01 {

    public static void main(String[] args) {
//        System.out.println(10 / 0); //java.lang.ArithmeticException: / by zero
//        System.out.println(divide(10,2));
//        System.out.println(divide(10,0));

        System.out.println(divide(10,2)==true?"计算成功":"计算失败");
        System.out.println(divide(10,0)==true?"计算成功":"计算失败");
    }


    /**
     * 计算两个int类型数据的商，计算成功返回1，计算失败返回0
     * @param a int类型的数据
     * @param b int类型的数据
     * @return 返回1表示成功，返回0表示失败
     */
    /*
    //设计缺陷就在返回值类型上，返回一个int不恰当，应当返回一个boolean类型的数据
    public static int divide(int a,int b){

        try {
            int c = a / b;
            //程序执行到此处表示以上代码没有发生异常，表示执行成功
            return 1;
        }catch(Exception e){
            //执行失败到此处表示出现了异常
            return 0;
        }
    }
    */

    public static boolean divide(int a,int b){

        try {
            int c = a / b;
            //程序执行到此处表示以上代码没有发生异常，表示执行成功
            return true;
        }catch(Exception e){
            //执行失败到此处表示出现了异常
            return false;
        }
    }

    /*
        以上这个方法设计没有毛病，返回true,false两种情况
        但是如果出现三种、四种、五种情况且每一种情况都能数清楚，可以一枚一枚列举出来，那么布尔类型就无法满足需求
        此时就需要java的enum类型
     */
}
