package Constructor.example02;

/**
 *      构造方法的作用：
 *          1.创建对象
 *          2.创建对象的同时，初始化实例变量的内存空间
 *
 *      成员变量之实例变量属于对象对象级别变量，这种变量必须先有对象才能有实例变量
 *      实例变量没有手动赋值的时候，系统默认赋值，那么这个系统默认复制是在什么时候完成的呢？
 *          是在构造方法执行过程中完成开辟的，系统在默认赋值的时候，也是在构造方法执行过程中完成的赋值
 *
 */
public class ConstructorTest02 {

    public static void main(String[] args) {

        //创建对象
        Account act1 = new Account();

        System.out.println("账号：" + act1.getActno());
        System.out.println("余额：" + act1.getBalance());
        System.out.println("=====================");

        Account act2 = new Account("100");

        System.out.println("账号：" + act2.getActno());
        System.out.println("余额：" + act2.getBalance());
        System.out.println("=====================");

        Account act3 = new Account(110.0);

        System.out.println("账号：" + act3.getActno());
        System.out.println("余额：" + act3.getBalance());
        System.out.println("=====================");

        Account act4 = new Account("111",111.0);

        System.out.println("账号：" + act4.getActno());
        System.out.println("余额：" + act4.getBalance());
        System.out.println("=====================");

    }
}
