package Reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IOPropertiesTest {
    public static void main(String[] args) {
//        String path = Thread.currentThread().getContextClassLoader()
//                        .getResource("Reflect/classinfo.properties").getPath();
        //又或者以流的方式进行获取
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("Reflect/classinfo.properties");

//        FileReader reader = null;
//        try {
//            reader = new FileReader(path);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Properties pro = new Properties();

        try {
//            pro.load(reader);
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
//            reader.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String className = pro.getProperty("className");
        System.out.println(className);
    }
}
