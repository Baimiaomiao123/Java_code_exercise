package Exception;

public class ExceptionTest15 {
    public static void main(String[] args) {
        //创建异常对象（只创建了对象，并没有抛出异常信息）
        MyException e = new MyException("用户名不能为空");
        //打印异常信息
        System.out.println(e.getMessage());
        //打印异常栈桢
        e.printStackTrace();
    }
}
