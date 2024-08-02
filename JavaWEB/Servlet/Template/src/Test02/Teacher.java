package Test02;

/**
 *  存在的问题：
 *      第一：算法没有得到重复的使用
 *      第二：代码没有得到复用
 */
public class Teacher extends Person{
    /**
     *  这方法描述老师的一天
     */
    public void doSome(){
        System.out.println("老师正在课堂上授课，教授学生知识");
    }
}
