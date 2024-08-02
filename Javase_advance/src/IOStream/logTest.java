package IOStream;

public class logTest {
    public static void main(String[] args) {
        //测试工具是否好用
        logger.log("调用了System类的gc()方法，建议启动垃圾回收");
        logger.log("调用了UserService的doSome()方法");
        logger.log("用户尝试进行登陆，验证失败");
    }
}
