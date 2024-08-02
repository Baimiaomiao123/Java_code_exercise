package IOStream;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = -1952500434087928459L;
    //java虚拟机看到Serializable接口之后，会自动生成一个序列化版本号
    //如果没有手动写出来，java虚拟机会默认提供这个序列化版本号
    //建议将序列化版本号手动写出来，不建议自动生成
    //    private static final long serialVersionUID = 111111L;

    private int no;
    private String name;

    //过了很久，Student这个类源代码改动了
    //源代码改动之后，需要重新编译，编译之后生成了全新的字节码文件
    //并且class文件再次运行的时候，java虚拟机生成的序列化版本号也会发生相应的改变（如果没有手动给一个序列化版本号）
    private int age;
    private boolean sex;

    public Student(){

    }

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
