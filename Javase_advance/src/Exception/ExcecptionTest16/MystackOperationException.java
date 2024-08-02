package Exception.ExcecptionTest16;

/*
    栈操作异常类
        1.继承Exception类
        2.重写有参构造方法和无参构造方法
 */
public class MystackOperationException extends Exception{
    public MystackOperationException(){

    }

    public MystackOperationException(String s){
        super(s);
    }
}
