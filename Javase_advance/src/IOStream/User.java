package IOStream;

import java.io.Serializable;

public class User implements Serializable {
    private int No;

    //transient关键字表示游离的，不参与序列化
    private transient String name; //name不参与序列化，但是在反序列化的时候会new对象，不参加的序列化的属性会赋予默认值，如null

    public User() {
    }

    public User(int no, String name) {
        No = no;
        this.name = name;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "No=" + No +
                ", name='" + name + '\'' +
                '}';
    }
}
