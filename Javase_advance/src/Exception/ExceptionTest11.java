package Exception;

public class ExceptionTest11 {
    public static void main(String[] args) {
        /*
            try到finnlay，没有catch可以吗？可以
            try不能单独使用
            try中即使有return，也会执行finally，因为以下代码先执行try，再执行finally，最后执行return
         */
        try{
            System.out.println("try..");
            return;
        } finally {
            System.out.println("finally..");
        }   //执行顺序，关键字：try——finally——return

       // System.out.println("Hello World"); 这里不能写语句，因为try中有return，直接结束main方法，后面的程序执行不了
    }
}
