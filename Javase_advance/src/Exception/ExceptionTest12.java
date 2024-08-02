package Exception;

public class ExceptionTest12 {
    public static void main(String[] args) {
        /*
            有system.exit则不会执行finally语句，直接退出JVM
         */
        try{
            System.out.println("try...");
            //退出JVM
            System.exit(0);
        } finally {
            System.out.println("finally...");
        }

    }
}
