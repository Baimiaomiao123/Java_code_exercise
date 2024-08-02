package IOStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
    IO+Properties的联合应用
        非常好的设计理念：
            以后经常改变的数据，可以单独写到一个文件中，使用程序动态读取。
            将来只需要修改这个文件的内容，java代码不需要改动，不需要重新
            编译，服务器也不需要重启。就可以拿到动态的信息

    类似于以上机制的这种文件被称为配置文件
    并且当配置文件中的内容格式是：
        key1=value1
        key2=value2
    的时候，我们把这种文件称为属性配置文件

    java规范中有要求，属性配置文件以.properties结尾，但这不是必须的
    这种以.properties结尾的文件在java中被称为：属性配置文件
    其中Properties是专门存放属性配置文件内容的一个类
 */
public class IOPropertiesTest01 {
    public static void main(String[] args) {
        /*
         Properties是一个Map集合，key和value都是String类型
         想将userinfo文件中的数据加载到Properties对象当中
         */
        try {
            //新建一个输入流文件
            FileReader reader = new FileReader("javase_advance/src/IOStream/File/userinfo.properties");

            //新建一个Map集合
            Properties pro = new Properties();
            //调用Properties对象的load方法将文件中的数据加载到Map集合中
            pro.load(reader); //文件中的数据加载到Map集合中。其中等号左边为key，右边为value

            //通过key获取value
            System.out.println(pro.getProperty("username"));
            System.out.println(pro.getProperty("password"));
            System.out.println(pro.getProperty("data"));
            System.out.println(pro.getProperty("age"));

            //关闭流
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
