package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    深入try..catch
        1.catch后面的小括号中的类型可以是该类型，也可以是该类型的父类型
        2.catch可以写多个，建议catch的时候一个一个处理，有利于程序的调试
        3.catch写的时候必须从小到大，否则报错
        4.JDK8及其之后，catch捕捉的错误可以通过｜连接
 */
public class ExceptionTest07 {

    //1.catch后面的小括号中的类型可以是该类型，也可以是该类型的父类型
    /*
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(" /Users/miaopeng/code/java/code_exercise/javase_advance/src/Exception/ExceptionTest.txt");
        } catch (IOException i) { //多态 IOException i = new FileNotFoundException();
            System.out.println("文件不存在");
        }

        System.out.println("Hello World!");
    }
     */

    //2.catch可以写多个，建议catch的时候一个一个处理，有利于程序的调试
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(" /Users/miaopeng/code/java/code_exercise/javase_advance/src/Exception/ExceptionTest.txt");
            fis.read();
        }catch (FileNotFoundException e){
            System.out.println("文件不存在");
        }catch (IOException i){
            System.out.println("文件读取报错");
        }catch (Exception ex){
            System.out.println("程序错误");
        }
    }

    //以下程序报错
    //3.catch写的时候必须从小到大，否则报错
    /*
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(" /Users/miaopeng/code/java/code_exercise/javase_advance/src/Exception/ExceptionTest.txt")
            fis.read();
        } catch (Exception ex) {

        } catch(FileNotFoundException e)
    }
    */

    //4.JDK8之后，catch捕捉的错误可以通过｜连接
    /*
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(" /Users/miaopeng/code/java/code_exercise/javase_advance/src/Exception/ExceptionTest.txt")
            System.out.println(100/0);
        }catch (FileNotFoundException | ArithmeticException e){
            System.out.println("文件不存在或者代数运算错误");
        }
    }
     */

}
