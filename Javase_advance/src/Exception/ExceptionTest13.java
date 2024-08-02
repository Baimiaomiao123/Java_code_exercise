package Exception;

public class ExceptionTest13 {
    public static void main(String[] args) {
        System.out.println(m());
    }
    /*
    java语法规则：
        1.java中方法体中的代码，必须遵循自上而下顺序依次执行（更古不变的语法！）
        2.return语句一旦执行，方法必须结束（更古不变的语法！）
     */
    public static int m(){
        int i = 100;
        try{
            //这条方法再调用的时候先执行，后才执行i++
            return i;
        } finally {
            i++;
        }
    }
}
