package Enum;

/*
    采用枚举的方法改进Test01的程序
    总结：
        1.枚举是一种引用数据类型
        2.枚举类型怎么定义，语法是什么？
            enum 枚举类型名{
                枚举值1,枚举值2,····
            }
        3.结果超过两种并且还是可以一枚一枚列举出来的，建议使用枚举类型
            例如，颜色、四季、星期等
 */
public class EnumTest02 {

    public static void main(String[] args) {
        System.out.println(divide(10,2)==Result.SUCCESS?"计算成功":"计算失败");
        System.out.println(divide(10,2)==Result.FAIL?"计算成功":"计算失败");
    }

    /**
     *
     * @param a int数据
     * @param b int数据
     * @return Result.SUCCESS表示成功，Result.FAIL表示失败
     */
    public static Result divide(int a,int b){

        try {
            int c = a / b;
            //程序执行到此处表示以上代码没有发生异常，表示执行成功
            return Result.SUCCESS;
        }catch(Exception e){
            //执行失败到此处表示出现了异常
            return Result.FAIL;
        }
    }

}

//枚举：一枚一枚可以列举出来的，才建议使用枚举类型
//枚举编译以后也就生成class文件
//枚举也是一种引用数据类型
//枚举中的每一个值可以看做是常量
enum Result{
    //SUCCESS 一个值（可以看作常量）
    //FAIL 一个值（可以看作常量）
    SUCCESS,FAIL
}