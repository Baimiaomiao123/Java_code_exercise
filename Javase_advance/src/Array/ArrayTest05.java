package Array;

/*
    使用String[] args来模拟登陆界面
 */
public class ArrayTest05 {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("使用该系统时，参数中包括用户名和密码信息，例如：zhangsan 123");
            return;
        }

        String username = args[0];
        String password = args[1];

        //即使username和password出现空指针异常，下面的判断语句也不会报错
        if ("baimiaomiao".equals(username) && "123".equals(password)){
            System.out.println("恭喜你，"+ username +"登陆成功");
            System.out.println("欢迎使用该系统");
        }else{
            System.out.println("登陆失败");
        }
    }
}
