package IOStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
    1、序列化于反序列化
        序列化——serialize，java对象存储到文件中，将java对象的状态保存下来（ObjectOutputStream）
        反序列化——deserialze，将硬盘上的数据重新恢复到内存当中，恢复成java对象（ObjectInputStream）

    2、参与序列化和反序列化的对象必须实现Serializable接口

    3、注意，通过源代码发现，Serializable接口只是一个标志接口
        public interface Serializable {
        }
        这个接口当中什么代码也没有
        那么它起到一个什么作用呢？
            起到一个标志/标识的作用，java虚拟机看到这个类实现了这个接口，会对这个类实现特殊待遇
            Serializable接口是给java虚拟机参考的，java虚拟机看到这个接口之后，会为这个类自动
            生成一个序列版本号

    4、序列化版本号有什么用？
        java.io.InvalidClassException:
        IOStream.Student; local class incompatible:
            stream classdesc serialVersionUID = 7033235688332150828（十年后）,
            local class serialVersionUID = -1806571319161210189（十年前）
        java语言中是采用什么机制来区分类的？
            第一：首先通过类名进行比对，如果类名不一样，肯定不是同一类
            第二：如果类名一样，再怎么进行类的区别？——考序列化版本号进行区分

        例如：
        一个人编写了一个类：com.bjpowernode.java.bean.Student implements Serializable
        另一个人编写了一个类：com.bjpowernode.java.bean.Student implements Serializable
        不同的人编写了同一个类，但这两个类确实不是同一个类，这个时候序列化版本就起上作用了
        对于java虚拟机来说，java虚拟机是可以区分开这两个类的，因为这两个类都实现了Serializable接口，
        都有默认的序列化版本号，他们的序列化版本号不一样。所以区分开了

        请思考？
            这种自动生成序列化版本号有什么缺陷？ ————一旦代码确定之后，不能进行后续的修改
            因为只要修改，必然会重新编译，此时会生成全新的序列化版本号，这个时候java虚拟机
            会认为这是一个全新的类（但是实际上还是原来的类，只不过修改了一下里面的属性或者方法）
            直接反序列化就会报错：java.io.InvalidClassException

        最终结论：
            凡是一个类实现了Serializable接口，建议给该类提供一个限定不变的序列化版本号
            这样，以后这个类即使代码修改了，但是版本号不变，java虚拟机会认为是同一个类


 */
public class ObjectOutputStreamTest01 {
    public static void main(String[] args) {
        Student s = new Student(111,"zhangsan");


        try {
            //序列化
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("javase_advance/src/IOStream/File/students"));
            //序列化对象
            oos.writeObject(s);


            //刷新
            oos.flush();

            //关闭
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
