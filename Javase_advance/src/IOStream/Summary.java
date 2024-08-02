package IOStream;
/*
    1、IO流是什么？
       I：Input
       O：Output
       通过IO流可以完成硬盘文件的读和写

    2、IO流的分类
        有多种分类方式：
        一种是按照流的方向进行分类：
            以内存为参照物，往内存中去，叫做输入（Input），或者叫做读（Read）
            从内存中出来，叫做输出（Output），或者叫做写（Write）
        一种是按照读取数据方式不同进行分类：
            有的流是按照字节的方式读取数据，以此读取1个字节byte，等同于一次读取8个二进制位
            这种流是万能的，什么类型文件都可以读取，包括：文本，图片，声音，视频文件等
               假设文件file1.txt，采用字符流的话是这样读的
                    a中国b
                    第一次读："a"字符——正好读完
                    第二次读："中"字符的一半——在windows系统中占据2个字符，由于每次只读一个字节，所以只读一半
                    第三次读："中"字符的另一半——在windows系统中占据2个字符，读取剩下的另一半

            有的是按照字符的方式读取数据的，一次读取一个字符，这种流是为了方便读取普通文本文件而存在的
            这种流不能读取：图片，声音，视频等文件，只能读取文本文件，连word文件都无法读取
                假设文件file1.txt，采用字符流的话是这样读的
                    a中国b
                    第一次读："a"字符——在windows系统中占据1个字符（注意，在java系统文件中，a占两个字符）
                    第二次读："中"字符——在windows系统中占据2个字符
         综上所述：流的分类
            输入流、输出流
            字节流、字符流

     3、Java中的IO流都已经写好了，程序猿不需要关心，最主要还是掌握java中有哪些流，每个流的特点、方法有哪些？？
        Java中所有的流都是在：Java.io.*;下
        Java中主要还是研究：
            怎么new对象
            调用流对象的哪个方法是读，哪个方法是写
     4、java IO流有四大家族
        四大家族的首领：
            java.io.InputStream——字节输入流
            java.io.OutputStream——字节输出流
            java.io.Reader——字符输入流
            java.io.Writer——字符输出流

            四大家族的首领都是抽象类（abstract class）
                所有的流都实现了:
                    java.io.Closeable接口，都是可关闭的，都有close()方法
                    流毕竟是一个管道，这个是内存和硬盘之间的通道，用完之后一定要关闭
                    不然会耗费很多资源，切记用完之后一定要记得关闭
                所有的输出流都实现了：
                    java.io.Flushable接口，都是可刷新的，都有flush()方法
                    养成一个好习惯，输出流在最终输出之后，一定要记得flush()
                    刷新一下，这个刷新表示将通道/管道当中剩余未输出的数据强行
                    输出完（清空管道）刷新的作用就是清空管道
                    注意：如果没有flush()可能会导致丢失数据
        Stream为结尾的都是字节流，Reader/Writer为结尾的都是字符流

    5、java.io包下需要掌握的流有16个
        文件流专属：
            java.io.FileInputStream
            java.io.FileOutputStream
            java.io.FileReader
            java.io.FileWriter
        转换流：（将字节流转换成字符流）
            java.io.InputStreamReader
            java.io.OutputStreamWriter
        缓冲流专属：
            java.io.BufferInputStream
            java.io.BufferOutputStream
            java.io.BufferReader
            java.io.BufferWriter
        数据流专属：
            java.io.DataInputStream
            java.io.DataOutputStream
        标准输出流：
            java.io.ObjectInputStream
            java.io.ObjectOutputSteam
        对象流专属：
            java.io.PrintWriter
            java.io.PrintReader
 */
public class Summary {
}
